package com.nakedgardener.application.recentblogpost;

import com.nakedgardener.application.blogpost.BlogPostRepository;
import com.nakedgardener.application.configuration.IntegrationTestConfiguration;
import com.nakedgardener.application.configuration.MongoIntegrationTest;
import com.nakedgardener.application.domain.BlogPost;
import com.nakedgardener.application.domain.BlogPosts;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static com.nakedgardener.application.domain.BlogPostBuilder.blogPostBuilder;
import static java.time.LocalDateTime.now;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.fest.assertions.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IntegrationTestConfiguration.class)
@MongoIntegrationTest
public class RecentBlogPostServiceIntegrationTest {

    @Autowired
    private RecentBlogPostService recentBlogPostService;

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Test
    public void shouldReturnThreeRecentBlogPosts() throws Exception {
        List<BlogPost> blogPosts = blogPosts(3);

        blogPostRepository.save(blogPosts);

        ResponseEntity<BlogPosts> blogPostsResponseEntity = recentBlogPostService.recentBlogPosts(0, 5);

        assertThat(blogPostsResponseEntity.getStatusCode()).isEqualTo(OK);
        assertThat(blogPostsResponseEntity.getBody().getBlogPosts()).hasSize(3);
    }

    private List<BlogPost> blogPosts(int numPosts) {
        List<BlogPost> blogPosts = new ArrayList<>();
        for(int i=0; i < numPosts; i++) {
            blogPosts.add(blogPost());
        }
        return blogPosts;
    }

    private BlogPost blogPost() {
        return blogPostBuilder()
                .title(randomAlphanumeric(5))
                .post(randomAlphanumeric(25))
                .postDate(now().minusDays(3))
                .blogPostSlug(randomAlphanumeric(3))
                .build();
    }
}
