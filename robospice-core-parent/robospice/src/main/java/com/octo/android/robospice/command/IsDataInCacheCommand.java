package com.octo.android.robospice.command;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.SpiceService;
import com.octo.android.robospice.persistence.exception.CacheCreationException;
import com.octo.android.robospice.persistence.exception.CacheSavingException;

import org.codehaus.jackson.type.TypeReference;

public class IsDataInCacheCommand extends SpiceManager.SpiceManagerCommand<Boolean> {
    private Class<?> clazz;
    private Object cacheKey;
    private long cacheExpiryDuration;
    private TypeReference<?> typeRef;

    public IsDataInCacheCommand(SpiceManager spiceManager, Class<?> clazz, Object cacheKey, long cacheExpiryDuration) {
        super(spiceManager);
        this.clazz = clazz;
        this.cacheExpiryDuration = cacheExpiryDuration;
        this.cacheKey = cacheKey;
    }
    
    public IsDataInCacheCommand(SpiceManager spiceManager, TypeReference<?> typeRef, Object cacheKey, long cacheExpiryDuration) {
        super(spiceManager);
        this.typeRef = typeRef;
        this.cacheExpiryDuration = cacheExpiryDuration;
        this.cacheKey = cacheKey;
    }

    @Override
    protected Boolean executeWhenBound(SpiceService spiceService) throws CacheSavingException, CacheCreationException {
        if (typeRef != null) {
            return spiceService.isDataInCache(typeRef, cacheKey, cacheExpiryDuration);
        }
        return spiceService.isDataInCache(clazz, cacheKey, cacheExpiryDuration);
    }
}
