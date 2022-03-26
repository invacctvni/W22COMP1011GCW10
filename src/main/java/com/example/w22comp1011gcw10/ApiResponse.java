package com.example.w22comp1011gcw10;

import com.google.gson.annotations.SerializedName;

public class ApiResponse {
//    @SerializedName is the name that is shown in Json,
//    to allow you to name your var in java to whatever you want
    @SerializedName("Search")
    private Movie[] search;
    private String totalResults;

    @SerializedName("Response")
    private String response;

    public Movie[] getSearch() {
        return search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public String getResponse() {
        return response;
    }
}
