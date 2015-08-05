package com.nakedgardener.cdc;

import com.nakedgardener.application.domain.BlogPost;
import com.nakedgardener.application.repository.BlogPostRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.ArrayUtils.EMPTY_OBJECT_ARRAY;
import static org.apache.commons.lang3.reflect.MethodUtils.getMethodsListWithAnnotation;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
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

    @StubbedConfig
    public void shouldReturnTwoRecentPosts() {
        given(blogPostRepository.findByPostDateBefore(any(LocalDateTime.class), any(Pageable.class)))
                .willReturn(
                        asList(
                                blogPost("la-la-la"),
                                blogPost("na-na-na")
                        )
                );
    }

    private BlogPost blogPost(String slug) {
        return BlogPost.builder().blogPostSlug(slug).build();
    }
}
