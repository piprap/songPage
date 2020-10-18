package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artist_Albums {
    @Id
    private Long id;

    private Long artists_id;
    private Long albums_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArtists_id() {
        return artists_id;
    }

    public void setArtists_id(Long artists_id) {
        this.artists_id = artists_id;
    }

    public Long getAlbums_id() {
        return albums_id;
    }

    public void setAlbums_id(Long albums_id) {
        this.albums_id = albums_id;
    }

    @Override
    public String toString() {
        return "Artist_Albums{" +
                "artist_album_id=" + id +
                ", artists_id=" + artists_id +
                ", albums_id=" + albums_id +
                '}';
    }
}
