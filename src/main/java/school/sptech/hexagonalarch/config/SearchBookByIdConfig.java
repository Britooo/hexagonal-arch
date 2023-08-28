package school.sptech.hexagonalarch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import school.sptech.hexagonalarch.adapters.out.SearchBookByIdAdapter;
import school.sptech.hexagonalarch.application.core.usecase.SearchBookByIdUseCase;

@Component
public class SearchBookByIdConfig {

    @Bean
    public SearchBookByIdUseCase searchBookByIdUseCase(
            SearchBookByIdAdapter searchBookByIdAdapter) {
        return new SearchBookByIdUseCase(searchBookByIdAdapter);
    }
}
