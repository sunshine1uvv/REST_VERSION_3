package by.bsuir.LabApp.Service;

import by.bsuir.LabApp.Cache.Cache;
import by.bsuir.LabApp.Cache.impl.CacheImpl;
import by.bsuir.LabApp.Exceptions.NegativeNumberException;
import by.bsuir.LabApp.Exceptions.ZeroDayException;
import by.bsuir.LabApp.Service.impl.DayOfWeekServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DayOfWeekServiceImplTest {

    private DayOfWeekService service;
    @Mock
    private Cache cache;

    @BeforeEach
    void setUp() {
        service = new DayOfWeekServiceImpl(cache);
    }

    @Test
    void defaultTest() {
        Mockito.when(cache.containsKey(Mockito.anyInt(),Mockito.anyInt())).thenReturn(false);
        Assertions.assertEquals(service.getDay(2024, 1), "Понедельник");
    }

    @Test
    void Should_ThrowException_When_ArgumentsNoProvided() {
        Assertions.assertThrows(NullPointerException.class, ()->service.validateParameters(null, null));
    }

    @Test
    void Should_ThrowException_When_DayEqualsZero() {
        Assertions.assertThrows(ZeroDayException.class, ()->service.validateParameters(2024,0));
    }

    @Test
    void Should_ThrowException_When_ArgumentsAcceptNegativeValues() {
        Assertions.assertThrows(NegativeNumberException.class,()->service.validateParameters(-332,-218));
    }
}
