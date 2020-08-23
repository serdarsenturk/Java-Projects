package com.serdarsenturk;

public class MovieDTO {
    private int id;
    private int popularity;
    private String originalTitle;
    private String title;
    private int runtime;
    private int revenue;
    private int episodeRunTime;
    private int numberOfEpisodes;
    private int numberOfSeasons;

    public int getEpisodeRunTime() {
        return this.episodeRunTime;
    }

    public int getNumberOfEpisodes() {
        return this.numberOfEpisodes;
    }

    public int getNumberOfSeasons() {
        return this.numberOfSeasons;
    }

    public int getId(){return this.id;}

    public int getPopularity(){
        return this.popularity;
    }

    public String getOriginalTitle(){
        return this.originalTitle;
    }

    public String getTitle(){
        return this.title;
    }

    public int getRuntime(){
        return this.runtime;
    }

    public int getRevenue(){
        return this.revenue;
    }

}
