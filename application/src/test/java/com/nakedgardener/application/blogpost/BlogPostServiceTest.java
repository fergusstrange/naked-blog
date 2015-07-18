package com.nakedgardener.application.blogpost;

import com.nakedgardener.application.domain.BlogPost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RunWith(MockitoJUnitRunner.class)
public class BlogPostServiceTest {

    @Mock
    private BlogPostRepository blogPostRepository;

    @Mock
    private Logger logger;

    @InjectMocks
    private BlogPostService blogPostService;

    @Test
    public void shouldReturnValidResponseEntityWhenExistsInDatabase() throws Exception {
        given(blogPostRepository.findByBlogPostSlug("any-slug")).willReturn(new BlogPost());

        ResponseEntity<BlogPost> blogPostSlug = blogPostService.findByBlogPostSlug("any-slug");

        assertEquals(OK, blogPostSlug.getStatusCode());
    }

    @Test
    public void shouldReturnNotFoundWhenNotExistsInDB() throws Exception {
        ResponseEntity<BlogPost> blogPostSlug = blogPostService.findByBlogPostSlug("any-slug");

        assertEquals(NOT_FOUND, blogPostSlug.getStatusCode());
    }

    @Test
    public void shouldReturnInternalServerErrorShouldExceptionBeThrown() throws Exception {
        given(blogPostRepository.findByBlogPostSlug("any-slug")).willThrow(new RuntimeException());

        ResponseEntity<BlogPost> blogPostSlug = blogPostService.findByBlogPostSlug("any-slug");

        assertEquals(INTERNAL_SERVER_ERROR, blogPostSlug.getStatusCode());
    }

    @Test
    public void shouldWriteToErrorLog() throws Exception {
        RuntimeException runtimeException = new RuntimeException();
        given(blogPostRepository.findByBlogPostSlug("any-slug")).willThrow(runtimeException);

        blogPostService.findByBlogPostSlug("any-slug");

        verify(logger).error("Exception has been thrown by BlogPostService", runtimeException);
    }
}