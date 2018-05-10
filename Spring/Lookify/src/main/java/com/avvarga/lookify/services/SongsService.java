package com.avvarga.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.avvarga.lookify.models.Song;
import com.avvarga.lookify.repositories.SongsRepository;

@Service
public class SongsService {
	
	private SongsRepository sRepo;
	public SongsService (SongsRepository sRepo) {
		this.sRepo = sRepo;
	}

	public List<Song> allSongs(){
		return sRepo.findAll();
	}
	public void addSong (Song song) {
		sRepo.save(song);
	}

	public Song showSong(Long id) {
		Optional<Song> oSong = sRepo.findById(id);
		return oSong.get();
	}

	public void deleteSong(Long id) {
		sRepo.deleteById(id);		
	}

	public List<Song> findTop10() {
		return sRepo.findTop10ByOrderByRatingDesc();
	}

	public List<Song> findByArtist(String artist) {
		return sRepo.findByArtistContaining(artist);
	}
}