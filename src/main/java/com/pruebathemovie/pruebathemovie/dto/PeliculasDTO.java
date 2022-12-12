package com.pruebathemovie.pruebathemovie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PeliculasDTO {
    private String page;
    private List<PeliculasDescricion> results;
    private Integer total_pages;
    private Integer total_results;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<PeliculasDescricion> getResults() {
        return results;
    }

    public void setResults(List<PeliculasDescricion> results) {
        this.results = results;
    }
}
