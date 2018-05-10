package com.avvarga.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.avvarga.lookify.models.Song;

@Repository
public interface SongsRepository extends CrudRepository<Song, Long> {
	List<Song> findAll();
	List<Song> findByArtistContaining(String artist);
	List<Song> findTop10ByOrderByRatingDesc();
}
