package com.example.demo.repository;

import com.example.demo.model.DisplaySongs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisplaySongsRepository extends CrudRepository<DisplaySongs, Long> {
}
