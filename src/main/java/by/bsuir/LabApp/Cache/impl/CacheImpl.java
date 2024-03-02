package by.bsuir.LabApp.Cache.impl;

import by.bsuir.LabApp.Cache.CacheKey;
import by.bsuir.LabApp.Cache.Cache;
import by.bsuir.LabApp.Controller.DayOfWeekController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CacheImpl implements Cache {

    private Map<CacheKey, String> map = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(DayOfWeekController .class);

    @Override
    public void put(Integer year, Integer day, String line) {
        logger.info("*LOGGER* Method put() was called. Saving data in local cache");
        map.put(new CacheKey(year,day), line);
    }

    @Override
    public String get(Integer year, Integer day) {
        logger.info("*LOGGER* Method get() was called. Retrieving data from the cache");
        return map.get(new CacheKey(year,day));
    }

    @Override
    public boolean containsKey(Integer year, Integer day) {
        logger.info("*LOGGER* Method containsKey() was called. Cache check.");
        return map.containsKey(new CacheKey(year,day));
    }
}
