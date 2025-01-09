package it.epicode.appBlog.posts;

import lombok.Data;

@Data
public class BlogPostDto {

    private String titolo;


    private String contenuto;

    private int tempoDiLettura;

    private Long authorId;
}
