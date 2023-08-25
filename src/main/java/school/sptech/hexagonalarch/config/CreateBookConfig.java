package school.sptech.hexagonalarch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import school.sptech.hexagonalarch.adapters.out.CreateBookAdapter;
import school.sptech.hexagonalarch.application.core.usecase.CreateBookUseCase;

@Configuration
public class CreateBookConfig {

    @Bean
    public CreateBookUseCase createBookUseCase(
            CreateBookAdapter createBookAdapter
    ) {
        return new CreateBookUseCase(createBookAdapter);
    }
}
