package com.nakedgardener.application.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Builder
public class BlogPost {

    @Id
    private String id;
    private LocalDateTime postDate;
    private String blogPostSlug;
    private String title;
    private String post;
}
