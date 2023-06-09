package com.freecodingcamp.moviedb.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MongoCustomConverterConfig {

    @Bean
    public MongoCustomConversions mongoCustomConversions(){
        List<Converter<?,?>> converters = new ArrayList<>();
        converters.add(new DateClassConverter());
        return new MongoCustomConversions(converters);
    }
}
