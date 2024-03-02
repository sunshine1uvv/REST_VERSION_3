package by.bsuir.LabApp.Cache;


import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class CacheKey {
    private final Integer year;
    private final Integer day;

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;
        CacheKey cacheKey = (CacheKey) obj;
        return year.equals(cacheKey.year) && day.equals(cacheKey.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year,day);
    }
}
