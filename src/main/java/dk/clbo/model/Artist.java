package dk.clbo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String artist_name;

    @ManyToMany
    Set<Album> albums;
}
