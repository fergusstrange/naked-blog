package com.nakedgardener.cdc;

import com.nakedgardener.application.blogpost.BlogPostRepository;
import com.nakedgardener.application.domain.BlogPost;
import com.nakedgardener.web.Application;
import com.nakedgardener.web.blogpost.BlogPostController;
import com.reagroup.pact.provider.PactFile;
import com.reagroup.pact.provider.PactRunner;
import com.reagroup.pact.provider.ProviderState;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;

@ActiveProfiles("stubbed")
@RunWith(PactRunner.class)
@ContextConfiguration(classes = Application.class)
@PactFile("http://lianli:5555/pact/provider/naked-blog/consumer/naked-gardener/latest/json")
public class BlogPostBySlugCDCTest {

    @Autowired
    private BlogPostController blogPostController;

    @Autowired
    private BlogPostRepository blogPostRepository;

    @ProviderState("A blog post with slug la-la-la")
    public BlogPostController returnsValidRequestWithBody() throws Exception {
        Resource resource = new DefaultResourceLoader().getResource("http://lianli:5555/pacts/provider/naked-blog/consumer/naked-gardener/latest");
        resource.getInputStream();
        given(blogPostRepository.findByBlogPostSlug(anyString())).willReturn(new BlogPost(
                "55ac30b0936d190ae717e317",
                LocalDateTime.of(
                        2014,
                        2,
                        2,
                        1,
                        9
                ),
                "la-la-la",
                "A Test Blog",
                "Some content in the blog!"
        ));
        return blogPostController;
    }


}
