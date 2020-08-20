package com.serdarsenturk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class DummyMovieService implements IMovieService {

    public MovieEntity getById(int id) {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create("https://api.themoviedb.org/3/movie/550"))
                .header("Authorization", "")
                .header("content-type", "application/json;charset=utf-8")
                .build();

        //thenApply vs thenAccept
        //.join?
        // Asynchronous
        var movieDTO = client.sendAsync(req, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(response -> {

                    var objectMapper = new ObjectMapper()
                            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                            .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

                    try {
                        return objectMapper.readValue(response, MovieDTO.class);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                        return null;
                    }

                })
                .join();

        System.out.println("Movie id: " + movieDTO.getId());
        System.out.println("Movie original title: " + movieDTO.getOriginalTitle());
        System.out.println("Movie popularity: " + movieDTO.getPopularity());
        System.out.println("Movie title: " + movieDTO.getTitle());
        System.out.println("Movie runtime: " + movieDTO.getRuntime());
        System.out.println("Movie revenue: " + movieDTO.getRevenue());

        return new ShortMovieEntity(movieDTO.getId(), movieDTO.getOriginalTitle(), movieDTO.getTitle(), "Korku", movieDTO.getRuntime());
    }

    public void Create(MovieEntity movie) {
        System.out.println("X movie created");
    }
}