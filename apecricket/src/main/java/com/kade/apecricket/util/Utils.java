package com.kade.apecricket.util;

import com.kade.apecricket.cache.CacheManager;

public class Utils {

    public static int getCountryId(String countryName) throws Exception {
        return CacheManager.getCachedCountryMap().get(countryName);
    }

}
