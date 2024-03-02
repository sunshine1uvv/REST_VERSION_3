package by.bsuir.LabApp.Cache;


public interface Cache {

     void put(Integer year, Integer day, String line);

     String get(Integer year, Integer day);

     boolean containsKey(Integer year, Integer day);
}
