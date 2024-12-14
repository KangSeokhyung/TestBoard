package com.springboot.testboard.mapper;

import com.springboot.testboard.DTO.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDTO> getAllPosts();
    BoardDTO getPostById(Long id);
    List<BoardDTO> getPostsWithPaging(@Param("offset") int offset, @Param("size") int size);
    long getTotalCount();
    void createPost(BoardDTO post);
    void updatePost(BoardDTO post);
    void deletePost(Long id);
    void incrementViewCount(Long id);
}
