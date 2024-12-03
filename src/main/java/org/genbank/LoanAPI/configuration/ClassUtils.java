package org.genbank.LoanAPI.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClassUtils {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
