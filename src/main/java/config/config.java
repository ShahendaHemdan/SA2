package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class config {
    @Bean
    public ModelMapper ModelMapper() {
        return new ModelMapper();
    }
}
