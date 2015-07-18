package com.nakedgardener.application.blogpost;

import com.nakedgardener.application.configuration.IntegrationTestConfiguration;
import com.nakedgardener.application.configuration.MongoIntegrationTest;
import com.nakedgardener.application.domain.BlogPost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static com.nakedgardener.application.domain.BlogPostBuilder.blogPostBuilder;
import static java.time.LocalDateTime.now;
import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.data.domain.Sort.Direction.DESC;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IntegrationTestConfiguration.class)
@MongoIntegrationTest
public class BlogPostRepositoryTest {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Test
    public void shouldRetrieveBlogPostBySlug() throws Exception {
        BlogPost entity = blogPost("anId", "cat-in-a-hat");
        blogPostRepository.save(entity);

        BlogPost blogPostSlug = blogPostRepository.findByBlogPostSlug("cat-in-a-hat");

        assertEquals(entity, blogPostSlug);
    }

    @Test
    public void shouldRetrieveBlogPostsBeforeNow() throws Exception {
        List<BlogPost> blogPosts = blogPosts(10);
        blogPostRepository.save(blogPosts);

        List<BlogPost> retrievedBlogPosts = blogPostRepository.findByPostDateBefore(now(), new PageRequest(0, 5, DESC, "postDate"));

        assertThat(retrievedBlogPosts).hasSize(5);
    }

    @Test
    public void shouldNotRetrievePostsAfterNow() throws Exception {
        BlogPost inTheFuture = blogPostBuilder()
                .title("in the future")
                .postDate(now().plusDays(10))
                .build();

        List<BlogPost> posts = blogPosts(4);
        posts.add(inTheFuture);

        blogPostRepository.save(posts);

        List<BlogPost> blogPosts = blogPostRepository.findByPostDateBefore(now(), new PageRequest(0, 5, DESC, "postDate"));

        assertThat(inTheFuture).isNotIn(blogPosts);
    }

    private List<BlogPost> blogPosts(double numPosts) {
        List<BlogPost> blogPosts = new ArrayList<>();
        for(int i = 0; i < numPosts; i++) {
            blogPosts.add(blogPost(null, "slug-of-post"));
        }
        return blogPosts;
    }

    private BlogPost blogPost(String id, String blogPostSlug) {
        return blogPostBuilder()
                .id(id)
                .title("title")
                .blogPostSlug(blogPostSlug)
                .post("Some content")
                .postDate(now().minusDays(1))
                .build();
    }
}