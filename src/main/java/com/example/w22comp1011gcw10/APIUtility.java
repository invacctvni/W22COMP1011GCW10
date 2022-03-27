package com.example.w22comp1011gcw10;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {

    /**
     * Google has made a nice set of libs to parse JSON objects and it's called ...
     * GSON.
     * This method will read file and parse out the JSON objects into java objects.
     */
     public static ApiResponse getMoviesFromJSONFile(String fileName)
     {
//        create a GSON object to parse the objects
            Gson gson = new Gson();
            ApiResponse response = null;


//         try with resources - anything inside () will 'auto close'
            try(
                    //open json file from hard-drive
                    FileReader fileReader = new FileReader(fileName);
                    JsonReader jsonReader = new JsonReader(fileReader);
                    ){
//                converting Json objects into ApiResponse object.
                response = gson.fromJson(jsonReader, ApiResponse.class);
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            return response;
          //
     }

    /**
     * This method will call the OMDB API and write to a file.
     */
    public static ApiResponse getMoviesFromOMDB(String searchTerm)
    {
        searchTerm = searchTerm.replace(" ", "%20");

        String uri = "https://www.omdbapi.com/?apikey=e3d02f7f&s=" +searchTerm;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

//        this will call the API and
//        write the result to the file "javaApiFetched.json"
        try {
            HttpResponse<Path> response = client.send(httpRequest, HttpResponse
                    .BodyHandlers
                    .ofFile(Paths.get("javaApiFetched.json")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return getMoviesFromJSONFile("javaApiFetched.json");

    }

    /**
     * This method will call the API and return the java objects without creating
     * a JSON file on the hard drive.
     */
    public static ApiResponse getMoviesFromOMDBQuick(String searchTerm) {

        searchTerm = searchTerm.replace(" ", "%20");

        String uri = "https://www.omdbapi.com/?apikey=e3d02f7f&s=" +searchTerm;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

//        this will call the API and
//        write the result to the file "javaApiFetched.json"
        try {
            HttpResponse<String> response = client.send(httpRequest, HttpResponse
                    .BodyHandlers
                    .ofString());

            Gson gson = new Gson();
            return gson.fromJson(response.body(),ApiResponse.class);


        } catch (Exception e) {
            e.printStackTrace();
        }
    //if nothing returned from json, return null.
        return null;
    }


}
