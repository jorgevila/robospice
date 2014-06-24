package com.octo.android.robospice.command;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.SpiceService;

import org.codehaus.jackson.type.TypeReference;

public class RemoveDataFromCacheCommand extends SpiceManager.SpiceManagerCommand<Void> {
    private Class<?> clazz;
    private Object cacheKey;
    private TypeReference<?> typeRef;

    public <T> RemoveDataFromCacheCommand(SpiceManager spiceManager, Class<T> clazz, Object cacheKey) {
        super(spiceManager);
        this.clazz = clazz;
        this.cacheKey = cacheKey;
    }
    
    public <T> RemoveDataFromCacheCommand(SpiceManager spiceManager, TypeReference<T> typeRef, Object cacheKey) {
        super(spiceManager);
        this.typeRef = typeRef;
        this.cacheKey = cacheKey;
    }

    @Override
    protected Void executeWhenBound(SpiceService spiceService) {
        if (typeRef != null) {
            spiceService.removeDataFromCache(typeRef, cacheKey);
        } else {
            spiceService.removeDataFromCache(clazz, cacheKey);
        }
        return null;
    }
}
