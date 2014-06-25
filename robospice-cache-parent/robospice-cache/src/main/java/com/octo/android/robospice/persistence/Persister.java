package com.octo.android.robospice.persistence;


/**
 * This interface defines the common behavior of all elements inside the
 * CacheManager bus.
 * @author sni
 */
public interface Persister {

    /**
     * Whether or not this bus element can persist/unpersist objects of the
     * given type.
     * @param obj
     *            the type reference of objects we are looking forward to persist.
     * @return true if this bus element can persist/unpersist objects of the
     *         given type. False otherwise.
     */
    boolean canHandleClass(Class<?> clazz);
    
    /**
     * Whether or not this bus element can persist/unpersist objects of the
     * given type.
     * @param obj
     *            the type reference of objects we are looking forward to persist.
     * @return true if this bus element can persist/unpersist objects of the
     *         given type. False otherwise.
     */
    boolean canHandle(Object obj);
}
