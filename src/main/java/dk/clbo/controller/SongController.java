package dk.clbo.controller;

import dk.clbo.model.Song;
import dk.clbo.repository.SongRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class SongController {

    SongRepository songRepository;

    public SongController(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    @GetMapping("/")
    public String index(Model model){
        for (Song r : songRepository.findAll()) {
            System.out.println(r.getSong_name());
        }

        Iterable<Song> songList = songRepository.findAll();
        model.addAttribute("songs", songList);

        return "SongPage";
    }



}
