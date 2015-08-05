package com.nakedgardener.application.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
@JsonInclude(NON_NULL)
public class BlogPost {

    @Id
    private String id;
    private LocalDateTime postDate;
    private String blogPostSlug;
    private String title;
    private String post;

    public static BlogPost emptyBlogPost() {
        return builder().build();
    }
}
