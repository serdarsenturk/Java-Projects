package com.serdarsenturk;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "long_time_movie", schema = "Movies", catalog = "")
public class LongTimeMovieEntity extends MovieEntity{
    private Integer id;
    private Integer timeLenght;

    public LongTimeMovieEntity(){}

    public LongTimeMovieEntity(Integer id, String originalTitle, String title, String genre, Integer timeLenght){
        super(id, originalTitle, title, genre);
        this.timeLenght = timeLenght;
    }


    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MovieEntity getMovieEntity() {
        return movieEntity;
    }

    public void setMovieEntity(MovieEntity movieEntity) {
        this.movieEntity = movieEntity;
    }

    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private MovieEntity movieEntity;

    @Basic
    @Column(name = "timeLenght", nullable = true)
    public Integer getTimeLenght() {
        return timeLenght;
    }

    public void setTimeLenght(Integer timeLenght) {
        this.timeLenght = timeLenght;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LongTimeMovieEntity that = (LongTimeMovieEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(timeLenght, that.timeLenght);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timeLenght);
    }
}