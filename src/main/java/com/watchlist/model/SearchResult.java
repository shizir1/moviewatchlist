package com.watchlist.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResult {

    @JsonProperty("Search")
    private List<MovieSearchResult> msrList;

    @JsonProperty("totalResults")
    private String totalResults;

    @JsonProperty("Response")
    private String response;

    public SearchResult() {
    }

    public SearchResult(List<MovieSearchResult> msrList, String totalResults, String response) {
        this.msrList = msrList;
        this.totalResults = totalResults;
        this.response = response;
    }

    public List<MovieSearchResult> getMsrList() {
        return msrList;
    }

    public String getTotalResults() {
        return totalResults;
    }
}
