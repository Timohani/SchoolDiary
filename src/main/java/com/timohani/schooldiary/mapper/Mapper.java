package com.timohani.schooldiary.mapper;

import org.springframework.stereotype.Component;

@Component
public interface Mapper<F, T> {

    T mapTo(F from);
}
