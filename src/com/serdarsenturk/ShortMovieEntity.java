package com.serdarsenturk;

import org.hibernate.mapping.List;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="short_movie")
@PrimaryKeyJoinColumn(name="id")
public class ShortMovieEntity extends MovieEntity {
    private Integer runtime;

    public ShortMovieEntity(){}

    public ShortMovieEntity(Integer id, String originalTitle, String title, String genre, Integer runtime){
        super(id, originalTitle, title, genre);
        this.runtime = runtime;
    }

    @Column(name = "runtime", nullable = true)
    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

}