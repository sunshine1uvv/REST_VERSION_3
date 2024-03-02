package by.bsuir.LabApp.Cache;

import by.bsuir.LabApp.Cache.impl.CacheImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CacheImplTest {

    Cache cache;

    @BeforeEach
    void setUp() {
        cache = new CacheImpl();
        cache.put(2024,1, "Понедельник");
        cache.put(2020, 38, "Пятница");
    }

    @Test
    void defaultTest1() {
        Assertions.assertEquals(cache.get(2024,1), "Понедельник");
    }

    @Test
    void defaultTest2() {
        Assertions.assertEquals(cache.get(2020,38),"Пятница");
    }

    @Test
    void containsKeyTest1() {
        Assertions.assertTrue(cache.containsKey(2024,1));
    }

    @Test
    void containsKeyTest2() {
        Assertions.assertFalse(cache.containsKey(2021,5));
    }
}
