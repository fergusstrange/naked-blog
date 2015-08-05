package com.nakedgardener.cdc;

import com.nakedgardener.application.domain.BlogPost;
import com.nakedgardener.application.repository.BlogPostRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static org.apache.commons.lang3.ArrayUtils.EMPTY_OBJECT_ARRAY;
import static org.apache.commons.lang3.reflect.MethodUtils.getMethodsListWithAnnotation;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@Configuration
@Profile("stubbed")
public class BlogPostRepositoryStub {

    private BlogPostRepository blogPostRepository = mock(BlogPostRepository.class);

    @Bean
    public BlogPostRepository blogPostRepository() {
        getMethodsListWithAnnotation(this.getClass(), StubbedConfig.class)
                .forEach(method -> {
                    try {
                        method.invoke(this, EMPTY_OBJECT_ARRAY);
                    }
                    catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
        return blogPostRepository;
    }

    @StubbedConfig
    public void shouldThrowError() {
        given(blogPostRepository.findByBlogPostSlug("make-an-error"))
                .willThrow(new RuntimeException());
    }

    @StubbedConfig
    public void shouldReturnBlogPost() {
        given(blogPostRepository.findByBlogPostSlug("la-la-la")).willReturn(
                BlogPost.builder()
                        .blogPostSlug("la-la-la")
                        .build()
        );
    }
}
