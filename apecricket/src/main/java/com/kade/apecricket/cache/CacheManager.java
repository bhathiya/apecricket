package com.kade.apecricket.cache;

import com.kade.apecricket.bean.Country;
import com.kade.apecricket.dao.CountryDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheManager {

    private static CountryDao countryDao = new CountryDao();
    private static Map<String, Integer> countryMap = null;

    public static Map<String, Integer> getCachedCountryMap() throws Exception {
        if (countryMap == null) {
            loadCountryMap();
        }
        return countryMap;
    }

    private static synchronized void loadCountryMap() throws Exception {
        Map<String, Integer> countryMap = new HashMap<String, Integer>();
        List<Country> countryList = countryDao.getCountries();
        for (Country country : countryList) {
            countryMap.put(country.getName(), country.getId());
        }
        CacheManager.countryMap = countryMap;
    }

    public static void clearCountryMap() {
        countryMap = null;
    }

}
