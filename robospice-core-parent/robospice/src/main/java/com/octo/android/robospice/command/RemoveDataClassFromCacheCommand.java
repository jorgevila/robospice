package com.octo.android.robospice.command;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.SpiceService;
import com.octo.android.robospice.persistence.type.TypeReference;

public class RemoveDataClassFromCacheCommand extends SpiceManager.SpiceManagerCommand<Void> {
    private Class<?> clazz;
    private TypeReference<?> typeRef;

    public <T> RemoveDataClassFromCacheCommand(SpiceManager spiceManager, Class<T> clazz) {
        super(spiceManager);
        this.clazz = clazz;
    }
    
    public <T> RemoveDataClassFromCacheCommand(SpiceManager spiceManager, TypeReference<T> typeRef) {
        super(spiceManager);
        this.typeRef = typeRef;
    }

    @Override
    protected Void executeWhenBound(SpiceService spiceService) {
        if (typeRef != null) {
            spiceService.removeAllDataFromCache(typeRef);
        } else {
            spiceService.removeAllDataFromCache(clazz);
        }
        return null;
    }
}
