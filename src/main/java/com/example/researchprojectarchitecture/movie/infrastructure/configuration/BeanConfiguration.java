package com.example.researchprojectarchitecture.movie.infrastructure.configuration;

import com.example.researchprojectarchitecture.movie.core.MovieFacade;
import com.example.researchprojectarchitecture.movie.core.port.incoming.MovieService;
import com.example.researchprojectarchitecture.movie.core.port.outgoing.MovieRepository;
import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.MovieMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    MovieService movieService(final MovieRepository movieRepository) {
        return new MovieFacade(movieRepository);
    }

}
