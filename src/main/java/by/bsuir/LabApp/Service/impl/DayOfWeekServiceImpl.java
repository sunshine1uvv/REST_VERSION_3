package by.bsuir.LabApp.Service.impl;

import by.bsuir.LabApp.Cache.Cache;
import by.bsuir.LabApp.Exceptions.NegativeNumberException;
import by.bsuir.LabApp.Exceptions.ZeroDayException;
import by.bsuir.LabApp.Service.DayOfWeekService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;

@Service
@RequiredArgsConstructor
public class DayOfWeekServiceImpl implements DayOfWeekService {
    private static final Logger logger = LoggerFactory.getLogger(DayOfWeekServiceImpl.class);
    private final Cache cache;

    @Override
    public void validateParameters(Integer year, Integer day) {
        logger.info("*LOGGER* Method validateParameters() was called.");
        if (year == null || day == null) {
            throw new NullPointerException("One or both of the parameters passed are null");
        }
        if (day == 0) {
            throw new ZeroDayException("Day cannot be 0");
        }
        if (day < 0 || year < 0) {
            throw new NegativeNumberException("Parameters shouldn't accept negative values");
        }
        logger.info("*LOGGER* Parameter validation was successful!");
    }

    @Override
    public String getDay(Integer year, Integer day) {
        if (cache.containsKey(year, day)) {
            return cache.get(year, day);
        }
        logger.info("*LOGGER* Method getDay() was called with params in service: year - " + year + " day - " + day);
        LocalDate date = LocalDate.ofYearDay(year, day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        Locale ruLocale = new Locale("ru", "RU");
        ResourceBundle rb = ResourceBundle.getBundle("days", ruLocale);
        String line = rb.getString(dayOfWeek.toString());
        cache.put(year, day, line);
        return line;
    }
}
