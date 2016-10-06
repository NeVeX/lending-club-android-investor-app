package com.prosper.platform.cache;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import com.prosper.platform.cache.exception.CacheException;
import com.prosper.platform.cache.model.CacheEntry;

/**
 * Created by mcunningham on 3/28/2016.
 * <br><br>
 * This interface defines the list of functions that are supported by the provided implementations.
 * <br> Currently, only Mem-Cache is supported, but as more support is added for other frameworks, this interface should remain the same.
 */
public interface PlatformCache {

    /**
     * Get the value for the given key.
     * @param key - The non NULL/Empty name of the Key which the data will be retrieved for.
     * @return - The value if found, otherwise NULL
     * @throws CacheException - Standard cache exception with information on what went wrong
     */
    <T extends Serializable> T get(String key) throws CacheException;

    /**
     * An extension of the {@link #get(String)}, that will safely try to get the cache value for the given key.
     * <br> Note, all exceptions are caught within this method.
     * @param key - The non NULL/Empty name of the Key which the data will be retrieved for.
     * @return - The cache value or NULL if none is found, or there was an exception
     */
    <T extends Serializable> T tryGet(String key);

    /**
     * An extension to the method {@link #get(String)}, this will also return metadata about the cache value.
     * @param key - The name of the Key which the data will be retrieved for. Cannot be NULL/Empty.
     * @return - The CacheValue response - contains the value plus any metadata. Will be NULL if no data is found.
     * @throws CacheException - Standard cache exception with information on what went wrong
     */
    <T extends Serializable> CacheEntry<T> getWithInformation(String key) throws CacheException;

    /**
     * Extension of the method {@link #getWithInformation(String)}, that will safely try to get the value for the given key.
     * @return - The found value in the cache, of NULL if there was a problem, or the key does not exist.
     */
    <T extends Serializable> CacheEntry<T> tryGetWithInformation(String key);

    /**
     * An extension to the method {@link #get(String)}, that will retrieve a collection of cache values for the given keys in one request.
     * @param keys - The Non NULL/Empty set of keys to search for in the cache.
     * @return - A map of keys to the data that is found in the cache.
     * @throws CacheException - Standard cache exception with information on what went wrong
     */
    <T extends Serializable> Map<String, T> get(Collection<String> keys) throws CacheException;

    /**
     * An extension of the method {@link #get(Collection)} that safely tries to obtain all the values of the given set of keys
     * @return - A map of keys to the data that is found in the cache, or NULL if there was a problem
     */
    <T extends Serializable> Map<String, T> tryGet(Collection<String> keys);

    /**
     * An extension to the {@link #getWithInformation(String)}, that will retrieve a collection of cache values,
     * with information for the given keys in one request.
     * @param keys - The Non NULL/Empty set of keys to search for in the cache.
     * @return - A map of keys to the cache data with information that is found in the cache.
     * @throws CacheException - Standard cache exception with information on what went wrong
     */
    <T extends Serializable> Map<String, CacheEntry<T>> getWithInformation(Collection<String> keys) throws CacheException;

    /**
     * An extension of the method {@link #getWithInformation(Collection)}, that safely tries to obtain the cache values with information
     * for the given collection of keys.
     * @return - A map of keys to the data that is found in the cache, or NULL if there was a problem
     */
    <T extends Serializable> Map<String, CacheEntry<T>> tryGetWithInformation(Collection<String> keys);

    /**
     * Given a non NULL/Empty key and a non NULL value, this will save the data into the cache.
     * @param key - The non NULL/Empty key to use for saving the value
     * @param value - The non NULL data
     * @return - boolean indicating if the save was successful or not
     * @throws CacheException - Standard cache exception with information on what went wrong
     */
    <T extends Serializable> boolean set(String key, T value) throws CacheException;

    /**
     * An extension on the method {@link #set(String, Serializable)} to safely set the given value for the given key.
     * @return - boolean indicating if the save was successful or not
     */
    <T extends Serializable> boolean trySet(String key, T value);

    /**
     * An extension for {@link #set(String, Serializable)}, that allows this request to set the timeToLiveSeconds.
     * @param key - The non NULL/Empty key to use for saving the value
     * @param value - The non NULL data
     * @param timeToLiveSeconds - The time in seconds before this data should be marked as expired/invalid
     * @return - Boolean indicating if the save was successful or not
     * @throws CacheException - Standard cache exception with information on what went wrong
     */
    <T extends Serializable> boolean set(String key, T value, int timeToLiveSeconds) throws CacheException;

    /**
     * An extension for {@link #set(String, Serializable, int)} that tries to safely set the given data for the given key with options.
     * @return - boolean indicating if the save was successful or not
     */
    <T extends Serializable> boolean trySet(String key, T value, int timeToLiveSeconds);

    /**
     * Given a non NULL/Empty key, non NULL data, this method will save the data for the key, for the given time to live, but it will only
     * set the data if the given update time is newer than what exists in the cache.
     * @param key - The non NULL/Empty key to use for saving the value
     * @param value - The non NULL data
     * @param timeToLiveSeconds - The time in seconds before this data should be marked as expired/invalid
     * @param lastKnownUpdateTime - The time in milliseconds that should be used to determine if this data should be set in the cache
     * @return - boolean flag indicating if the data was set or not
     * @throws CacheException - Standard cache exception with information on what went wrong
     */
    <T extends Serializable> boolean checkAndSet(String key, T value, int timeToLiveSeconds, long lastKnownUpdateTime) throws CacheException;

    /**
     * An extension of the method {@link #checkAndSet(String, Serializable, int, long)} that tries to safely set-and-check the given value
     * for the given key and options.
     * @return - boolean flag indicating if the data was set or not
     */
    <T extends Serializable> boolean tryCheckAndSet(String key, T value, int timeToLiveSeconds, long lastKnownUpdateTime);

    /**
     * For the given non NULL/Empty key, it will be removed from the cache
     * @param key - The non NULL/Empty key that will be removed from the cache
     * @return - boolean indicating if the delete was successful
     * @throws CacheException - Standard cache exception with information on what went wrong
     */
    boolean delete(String key) throws CacheException;

    /**
     * An extension of the method {@link #delete(String)} that safely tries to delete the given key from the cache.
     * @return - boolean indicating if the delete was successful
     */
    boolean tryDelete(String key);

    /**
     * An extension on the method {@link #delete(String)}, that does not wait for a confirmation on the delete request
     */
    void deleteWithoutConfirmation(String key) throws CacheException;

    /**
     * An extension of the method {@link #deleteWithoutConfirmation(String)}, that tries to safely delete the key from cache without waiting.
     */
    void tryDeleteWithoutConfirmation(String key);

    /**
     * Atomically increment the counter in the cache for the given non NULL/Empty key.
     * <br>If the key does not exist, the initial value is used to set it.
     * @param key - the key to use for incrementing the value
     * @param incrementValue - the amount to increment it by
     * @param initialValue - the value to set if the key does not exist in the cache
     * @param timeToLiveSeconds - the time to live in seconds for the <b>initial</b> value
     * @return - The current value of this counter in the cache
     * @throws CacheException - Standard cache exception with information on what went wrong
     */
    long incrementCounter(String key, long incrementValue, long initialValue, int timeToLiveSeconds) throws CacheException;

    /**
     * An extension of the method {@link #incrementCounter(String, long, long, int)}, that safely tries to increment the counter in the cache with
     * the given options.
     * <br>If there is any exception caught, the given initial value is returned.
     * @return - the current counter in the cache, or the initial value given if there was a problem
     */
    long tryIncrementCounter(String key, long incrementValue, long initialValue, int timeToLiveSeconds);

    /**
     * Returns the counter for the given non NULL/Empty key.
     * <br>If the counter is not found, the provided value will be used to set it.
     * @param key - the key to use for incrementing the value
     * @param initialValue - the value to set if the key does not exist in the cache
     * @return - The current value of this counter in the cache
     * @throws CacheException - Standard cache exception with information on what went wrong
     */
    long getCounter(String key, long initialValue) throws CacheException;

    /**
     * An extension of the method {@link #getCounter(String, long)} that safely tries to get the counter from the cache with options.
     * <br>If there is an exception, the given initial value is returned
     * @return - the counter in the cache, or the initial value given if there was a problem
     */
    long tryGetCounter(String key, long initialValue);

    /**
     * This method will return the Cache implementation that is in use. It is provided so that clients are not limited to functions not
     * provided in this interface.
     * <br><b>This component may return different Cache Providers between versions, so use this method with caution.</b>
     */
    Object getCacheProviderImpl();

    /**
     * Shutdown the Cache - cleans up it's resources
     */
    void shutdown();

}