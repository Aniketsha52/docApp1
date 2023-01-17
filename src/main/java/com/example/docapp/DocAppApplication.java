package com.example.docapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class DocAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocAppApplication.class, args);
    }
    /**
     * Fetches a ModelMapper instance.
     *
     * @return ModelMapper
     */
    @Bean // Want a new obj every time
    @Scope("prototype")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}
