package com.springboot.testboard.controller;

import com.springboot.testboard.DTO.BoardDTO;
import com.springboot.testboard.DTO.PageDTO;
import com.springboot.testboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private static final int PAGE_SIZE = 10;
    
    @GetMapping
    public String listPosts(@RequestParam(defaultValue = "1") int page, Model model) {
        log.info("Fetching posts for page: {}", page);
        model.addAttribute("posts", boardService.getPostsWithPaging(page, PAGE_SIZE));
        model.addAttribute("pageInfo", boardService.getPageInfo(page, PAGE_SIZE));
        return "board/list";
    }
    
    @GetMapping("/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        log.info("Viewing post with id: {}", id);
        model.addAttribute("post", boardService.getPost(id));
        return "board/view";
    }
    
    @GetMapping("/write")
    public String writeForm() {
        log.info("Accessing write form");
        return "board/write";
    }
    
    @PostMapping("/write")
    public String writePost(BoardDTO post) {
        log.info("Creating new post with title: {}", post.getTitle());
        boardService.createPost(post);
        return "redirect:/board";
    }
    
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        log.info("Accessing edit form for post id: {}", id);
        model.addAttribute("post", boardService.getPost(id));
        return "board/edit";
    }
    
    @PostMapping("/edit/{id}")
    public String editPost(@PathVariable Long id, BoardDTO post) {
        log.info("Updating post with id: {}", id);
        post.setId(id);
        boardService.updatePost(post);
        return "redirect:/board/" + id;
    }
    
    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        log.info("Deleting post with id: {}", id);
        boardService.deletePost(id);
        return "redirect:/board";
    }
}
