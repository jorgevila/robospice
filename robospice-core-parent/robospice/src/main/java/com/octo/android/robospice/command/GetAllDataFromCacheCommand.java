package com.octo.android.robospice.command;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.SpiceService;
import com.octo.android.robospice.persistence.exception.CacheCreationException;
import com.octo.android.robospice.persistence.exception.CacheLoadingException;

import org.codehaus.jackson.type.TypeReference;

import java.util.List;

public class GetAllDataFromCacheCommand<T> extends SpiceManager.SpiceManagerCommand<List<T>> {
    private Class<T> clazz;
    private TypeReference<T> typeRef;

    public GetAllDataFromCacheCommand(SpiceManager spiceManager, Class<T> clazz) {
        super(spiceManager);
        this.clazz = clazz;
    }
    
    public GetAllDataFromCacheCommand(SpiceManager spiceManager, TypeReference<T> typeRef) {
        super(spiceManager);
        this.typeRef = typeRef;
    }

    @Override
    protected List<T> executeWhenBound(SpiceService spiceService) throws CacheLoadingException, CacheCreationException {
        if (typeRef != null) {
            return spiceService.loadAllDataFromCache(typeRef);
        }
        return spiceService.loadAllDataFromCache(clazz);
    }
}
