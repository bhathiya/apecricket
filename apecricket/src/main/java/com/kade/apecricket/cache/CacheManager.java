package com.kade.apecricket.cache;

import com.kade.apecricket.bean.Country;
import com.kade.apecricket.dao.CountryDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheManager {

    private static CountryDao countryDao = new CountryDao();
    private static Map<Integer, String> countryMap = null;

    public static Map<Integer, String> getCachedCountryMap() throws Exception {
        if (countryMap == null) {
            loadCountryMap();
        }
        return countryMap;
    }

    private static synchronized void loadCountryMap() throws Exception {
        Map<Integer, String> countryMap = new HashMap<Integer, String>();
        List<Country> countryList = countryDao.getCountries();
        for (Country country : countryList) {
            countryMap.put(country.getId(), country.getName());
        }
        CacheManager.countryMap = countryMap;
    }

    public static void clearCountryMap() {
        countryMap = null;
    }

}
