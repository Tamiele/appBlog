package it.epicode.appBlog.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class BlogPostController {
    @Autowired
    private BlogPostService postService;

    //chiamate sull' endpoint


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
    public ResponseEntity<BlogPost> createPost(@RequestBody BlogPost blogPost) {
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
