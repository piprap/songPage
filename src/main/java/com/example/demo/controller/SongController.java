package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class SongController {

    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;
    @Autowired
    Artist_AlbumsRepository artist_albumsRepository;
    @Autowired
    DisplaySongsRepository displaySongsRepository;


    public SongController(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/SongPage")
    public String songPage(Model model){
        for (Song r : songRepository.findAll()) {
            System.out.println(r.getSong_name());
        }

        Iterable<Song> songList = songRepository.findAll();
        model.addAttribute("songs", songList);
        return "SongPage";
    }
    @GetMapping("/test")
    public String test(){
        System.out.println("testing1234");
        return "Index";
    }

    @GetMapping("/CreateArtist")
    public String createArtist(Model model){
        Artist obj = new Artist();
        model.addAttribute("Artist", obj);
        return "CreateArtist";
    }
    @PostMapping("/CreateArtist")
    public String createArtist(@ModelAttribute Artist a){
        artistRepository.save(a);
        return "Index";
    }

    @GetMapping("/CreateAlbum")
    public String createAlbum(Model model){
        Iterable<Artist> artistsList = artistRepository.findAll();
        model.addAttribute("Artists", artistsList);

        Album obj = new Album();
        model.addAttribute("Album", obj);

        return "CreateAlbum";
    }
    @PostMapping("/CreateAlbum")
    public String createAlbum(@ModelAttribute Album a, @ModelAttribute Artist_Albums a_a, @RequestParam("artist_id") Long artist_id){

        System.out.println(artist_id);
        albumRepository.save(a);

        artist_albumsRepository.findAll();

        System.out.println(a_a);

        a_a.setId(artist_albumsRepository.count()+1L);

        a_a.setAlbums_id(a.getId());
        a_a.setArtists_id(artist_id);

        System.out.println(a_a);
        artist_albumsRepository.save(a_a);


        return "Index";
    }

    @GetMapping("/ViewSongs")
    public String viewSongs(Model model){
        Iterable<Song> songIterable = songRepository.findAll();
        model.addAttribute("Songs", songIterable);

        Iterable<Album> albumIterable = albumRepository.findAll();
        model.addAttribute("Albums", albumIterable);

        Iterable<Artist> artistIterable = artistRepository.findAll();
        model.addAttribute("Artists", artistIterable);

        for (Song s: songIterable) {
            DisplaySongs obj = new DisplaySongs();
            obj.setSong_name(s.getSong_name());
            obj.setDuration(s.getDuration());


            Optional<Album> albObj;
            albObj = albumRepository.findById((s.getAlbum().getId()));

            obj.setAlbum_name(albObj.get().getAlbum_name());

            Optional<Artist_Albums> a_a_obj;
            a_a_obj = artist_albumsRepository.findById(albObj.get().getId());

            Optional<Artist> artObj;
            artObj = artistRepository.findById(a_a_obj.get().getArtists_id());

            obj.setArtist_name(artObj.get().getArtist_name());

            displaySongsRepository.save(obj);
        }
        Iterable<DisplaySongs> displaySongsIterable = displaySongsRepository.findAll();
        model.addAttribute("displaySongs", displaySongsIterable);

        return "ViewSongs";
    }

    @GetMapping("/CreateSong")
    public String createSong(Model model){
        Iterable<Album> obj = albumRepository.findAll();
        model.addAttribute("Albums", obj);

        return "CreateSong";
    }
    @PostMapping("/CreateSong")
    public String createSong(@ModelAttribute Song s, @RequestParam("album_id") Long id){
        //Optional<Album> albObj;
        Album albObj = new Album();
        albObj.setId(id);
        s.setAlbum(albObj);
        songRepository.save(s);

        return "Index";
    }

}

