package com.octo.android.robospice.command;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.SpiceService;
import com.octo.android.robospice.persistence.exception.CacheCreationException;
import com.octo.android.robospice.persistence.exception.CacheLoadingException;
import com.octo.android.robospice.persistence.type.TypeReference;

import java.util.List;

public class GetAllCacheKeysCommand extends SpiceManager.SpiceManagerCommand<List<Object>> {
    private Class<?> clazz;
    private TypeReference<?> typeRef;

    public GetAllCacheKeysCommand(SpiceManager spiceManager, Class<?> clazz) {
        super(spiceManager);
        this.clazz = clazz;
    }
    
    public GetAllCacheKeysCommand(SpiceManager spiceManager, TypeReference<?> typeRef) {
        super(spiceManager);
        this.typeRef = typeRef;
    }

    @Override
    protected List<Object> executeWhenBound(SpiceService spiceService) throws CacheLoadingException, CacheCreationException {
        if (typeRef != null) {
            return spiceService.getAllCacheKeys(typeRef);
        }
            
        return spiceService.getAllCacheKeys(clazz);
    }
}
