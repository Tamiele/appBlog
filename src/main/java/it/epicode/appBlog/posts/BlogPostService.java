package it.epicode.appBlog.posts;

import it.epicode.appBlog.authors.Author;
import it.epicode.appBlog.authors.AuthorRepo;
import it.epicode.appBlog.authors.AuthorService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogPostService {


    private final BlogPostRepo postRepo;
    private final AuthorRepo authorRepo;



    //metodo per tutti i blogPost con paginazione e ordinamento
//    public Page<BlogPost> findAll(int page, int size, String sortBy) {
//        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
//        return postRepo.findAll(pageable);
//    }

    //altro tipo di paginazione
    public Page<BlogPost> findAll(Pageable pageable) {

        return postRepo.findAll(pageable);
    }

    //metodo per tutti i post
    public List<BlogPost> findAll() {

        return postRepo.findAll();
    }

    //metodo post per id
    public BlogPost findById(Long id) {
        if (!postRepo.existsById(id)) {
            throw new EntityNotFoundException("Post non trovato");
        } else {
            return postRepo.findById(id).get();
        }
    }

    //metoido per creare un post
    public BlogPost createPost(BlogPostDto blogPostDto) {
        BlogPost newPost = new BlogPost();
        Author author = authorRepo.findById(blogPostDto.getAuthorId()).get();
        BeanUtils.copyProperties(blogPostDto, newPost);
        newPost.setAuthor(author);
        return postRepo.save(newPost);
    }


    //metodo per modificare un post
    public BlogPost updatePost(Long id, BlogPost blogPostModificato) {

        BlogPost postModificato = findById(id);
        BeanUtils.copyProperties(blogPostModificato, postModificato);
        return postRepo.save(postModificato);

    }

    //metodo per eliminare un post
    public void deletePost(Long id) {
        postRepo.deleteById(id);
    }

}
