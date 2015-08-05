package com.nakedgardener.cdc;

import com.nakedgardener.application.repository.BlogPostRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static org.mockito.Mockito.mock;

@Configuration
@Profile("stubbed")
public class BlogPostRepositoryStub {

    @Bean
    public BlogPostRepository blogPostRepository() {
        return mock(BlogPostRepository.class);
    }
}
