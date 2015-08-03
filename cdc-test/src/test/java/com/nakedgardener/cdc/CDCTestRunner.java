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
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;

@ActiveProfiles("stubbed")
@RunWith(PactRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@PactFile("url:http://lianli:8080/pacts/provider/naked-blog/consumer/naked-gardener/latest")
public class CDCTestRunner {

    @Autowired
    private BlogPostController blogPostController;

    @Autowired
    private BlogPostRepository blogPostRepository;

    @ProviderState("blog-post-by-slug")
    public BlogPostController myServiceForbidsARequestWithInvalidToken() throws Exception {
        given(blogPostRepository.findByBlogPostSlug(anyString())).willReturn(new BlogPost(
                "55ac30b0936d190ae717e317",
                LocalDateTime.of(
                        2014,
                        2,
                        2,
                        1,
                        9
                ),
                "slugy-slug-slug",
                "A Test Blog",
                "Some content in the blog!"
        ));
        return blogPostController;
    }
}
