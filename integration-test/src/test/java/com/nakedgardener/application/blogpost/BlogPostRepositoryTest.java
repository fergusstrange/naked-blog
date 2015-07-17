package com.nakedgardener.application.blogpost;

import com.nakedgardener.application.configuration.IntegrationTestConfiguration;
import com.nakedgardener.application.configuration.MongoIntegrationTest;
import com.nakedgardener.application.domain.BlogPost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.nakedgardener.application.domain.BlogPostBuilder.blogPostBuilder;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IntegrationTestConfiguration.class)
@MongoIntegrationTest
public class BlogPostRepositoryTest {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Test
    public void shouldRetrieveBlogPostBySlug() throws Exception {
        BlogPost entity = blogPost();
        blogPostRepository.save(entity);

        BlogPost blogPostSlug = blogPostRepository.findByBlogPostSlug("slug-of-post");

        assertEquals(entity, blogPostSlug);
    }

    private BlogPost blogPost() {
        return blogPostBuilder()
                .id("anId")
                .title("title")
                .blogPostSlug("slug-of-post")
                .build();
    }
}