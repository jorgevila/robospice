package com.octo.android.robospice.command;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.SpiceService;
import com.octo.android.robospice.persistence.exception.CacheCreationException;
import com.octo.android.robospice.persistence.exception.CacheLoadingException;

import org.codehaus.jackson.type.TypeReference;

import java.util.Date;

public class GetDateOfDataInCacheCommand extends SpiceManager.SpiceManagerCommand<Date> {
    private Class<?> clazz;
    private Object cacheKey;
    private TypeReference<?> typeRef;

    public GetDateOfDataInCacheCommand(SpiceManager spiceManager, Class<?> clazz, Object cacheKey) {
        super(spiceManager);
        this.clazz = clazz;
        this.cacheKey = cacheKey;
    }
    
    public GetDateOfDataInCacheCommand(SpiceManager spiceManager, TypeReference<?> typeRef, Object cacheKey) {
        super(spiceManager);
        this.typeRef = typeRef;
        this.cacheKey = cacheKey;
    }

    @Override
    protected Date executeWhenBound(SpiceService spiceService) throws CacheCreationException {
        try {
            if (typeRef != null) {
                return spiceService.getDateOfDataInCache(typeRef, cacheKey);
            }
            return spiceService.getDateOfDataInCache(clazz, cacheKey);
        } catch (CacheLoadingException ex) {
            return null;
        }
    }
}
