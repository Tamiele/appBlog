package it.epicode.appBlog.authors;

import it.epicode.appBlog.posts.BlogPost;
import jakarta.persistence.*;
import lombok.Data;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    private String nome;

    private String cognome;

    private String email;

    private Date dataDiNascita;

    private String avatar;



}