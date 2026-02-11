package com.reynan.spring.rest_with_spring_boot_end_java_enrudio.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class ObjectMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
        List<D> destinationsObjects = new ArrayList<>();

        origin.stream().forEach(originObject -> destinationsObjects
                .add(mapper.map(originObject, destination)));

        return destinationsObjects;
    }

    public <T extends Comparable<T>> void print(T object) {

    }
}
