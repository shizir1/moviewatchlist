package com.yahoofinance.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieSearchResult {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("imdbID")
    private String imdbId;

    @JsonProperty("Type")
    private String type;

    public String getImdbId() {
        return imdbId;
    }

    public MovieSearchResult() {
    }

    public MovieSearchResult(String title, String year, String imdbId, String type) {
        this.title = title;
        this.year = year;
        this.imdbId = imdbId;
        this.type = type;
    }

    @Override
    public String toString() {
        return "MovieSearchResult{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", imdbId='" + imdbId + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
