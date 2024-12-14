package com.springboot.testboard.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageDTO {
    private int page;          // 현재 페이지
    private int size;          // 페이지당 게시글 수
    private int totalPages;    // 전체 페이지 수
    private long totalElements; // 전체 게시글 수
    private boolean first;     // 첫 페이지 여부
    private boolean last;      // 마지막 페이지 여부
    
    public PageDTO(int page, int size, long totalElements) {
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = (int) Math.ceil((double) totalElements / size);
        this.first = page == 1;
        this.last = page == totalPages;
    }
    
    public int getStartPage() {
        return Math.max(1, page - 4);
    }
    
    public int getEndPage() {
        return Math.min(totalPages, page + 4);
    }
}
