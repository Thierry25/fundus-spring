package com.thierry.fundus.utils;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

@Component
public class Filtering {

    public MappingJacksonValue filter(Object toFilter, String filterName, String... params){
        var mapping = new MappingJacksonValue(toFilter);
        var filter = SimpleBeanPropertyFilter.filterOutAllExcept(params);
        var filters = new SimpleFilterProvider().addFilter(filterName, filter);
        mapping.setFilters(filters);
        return mapping;
    }
}
