package com.octo.android.robospice.command;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.SpiceService;
import com.octo.android.robospice.persistence.exception.CacheCreationException;
import com.octo.android.robospice.persistence.exception.CacheLoadingException;

import org.codehaus.jackson.type.TypeReference;

public class GetDataFromCacheCommand<T> extends SpiceManager.SpiceManagerCommand<T> {
    private Object cacheKey;
    private Class<T> clazz;
    private TypeReference<T> typeRef;

    public GetDataFromCacheCommand(SpiceManager spiceManager, Class<T> clazz, Object cacheKey) {
        super(spiceManager);
        this.clazz = clazz;
        this.cacheKey = cacheKey;
    }
    
    public GetDataFromCacheCommand(SpiceManager spiceManager, TypeReference<T> typeRef, Object cacheKey) {
        super(spiceManager);
        this.typeRef = typeRef;
        this.cacheKey = cacheKey;
    }

    @Override
    protected T executeWhenBound(SpiceService spiceService) throws CacheLoadingException, CacheCreationException {
        if (typeRef != null) {
            return spiceService.getDataFromCache(typeRef, cacheKey);
        }
            
        return spiceService.getDataFromCache(clazz, cacheKey);
    }
}
