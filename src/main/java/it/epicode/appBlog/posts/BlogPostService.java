package it.epicode.appBlog.posts;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogPostService {


    private final BlogPostRepo postRepo;

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
    public BlogPost createPost(BlogPost blogPost) {
        return postRepo.save(blogPost);
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
