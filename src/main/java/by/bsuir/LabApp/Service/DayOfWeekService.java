package by.bsuir.LabApp.Service;

public interface DayOfWeekService {

    void validateParameters(Integer year, Integer day);
    String getDay(Integer year, Integer day);
}
