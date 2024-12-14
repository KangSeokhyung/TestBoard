package com.springboot.testboard.service;

import com.springboot.testboard.DTO.BoardDTO;
import com.springboot.testboard.DTO.PageDTO;
import com.springboot.testboard.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;
    
    public List<BoardDTO> getAllPosts() {
        log.debug("Getting all posts from database");
        return boardMapper.getAllPosts();
    }
    
    public List<BoardDTO> getPostsWithPaging(int page, int size) {
        log.debug("Getting posts for page {} with size {}", page, size);
        int offset = (page - 1) * size;
        return boardMapper.getPostsWithPaging(offset, size);
    }
    
    public PageDTO getPageInfo(int page, int size) {
        long total = boardMapper.getTotalCount();
        return new PageDTO(page, size, total);
    }
    
    public BoardDTO getPost(Long id) {
        log.debug("Getting post with id: {} and incrementing view count", id);
        boardMapper.incrementViewCount(id);
        return boardMapper.getPostById(id);
    }
    
    public void createPost(BoardDTO post) {
        log.debug("Creating new post: {}", post.getTitle());
        boardMapper.createPost(post);
    }
    
    public void updatePost(BoardDTO post) {
        log.debug("Updating post with id: {}", post.getId());
        boardMapper.updatePost(post);
    }
    
    public void deletePost(Long id) {
        log.debug("Deleting post with id: {}", id);
        boardMapper.deletePost(id);
    }
}
