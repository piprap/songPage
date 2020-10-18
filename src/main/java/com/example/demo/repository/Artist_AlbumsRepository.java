package com.example.demo.repository;

import com.example.demo.model.Artist_Albums;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Artist_AlbumsRepository extends CrudRepository<Artist_Albums, Long> {

}
