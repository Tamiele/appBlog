package it.epicode.appBlog.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class BlogPostController {
    @Autowired
    private BlogPostService postService;


//    @GetMapping("/paged")
//    public ResponseEntity<Page<BlogPost>> getAllBlogPosts(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size,
//            @RequestParam(defaultValue = "id") String sortBy) {
//        return ResponseEntity.ok(postService.findAll(page, size, sortBy));
//    }

    //altro tipo di paginazione
    @GetMapping("/paged")
    public ResponseEntity<Page<BlogPost>> getAllBlogPosts(Pageable page) {
        return ResponseEntity.ok(postService.findAll(page));
    }


    //chimate get per la findAll sull' endpoint
    @GetMapping
    public ResponseEntity<List<BlogPost>> listAllPost() {
        return ResponseEntity.ok(postService.findAll());
    }

    //chimate get per la findById sull' endpoint
    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> listFindById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    //chiamata per creare un nuovo post
    @PostMapping
    public ResponseEntity<BlogPost> createPost(@RequestBody BlogPostDto blogPost) {
        return new ResponseEntity(postService.createPost(blogPost), HttpStatus.CREATED);
    }

    //metodo per aggiornare un Post
    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long id, @RequestBody BlogPost blogPostModificato) {
        return ResponseEntity.ok(postService.updatePost(id, blogPostModificato));
    }

    //metodo per eliminare un Post
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }


}
