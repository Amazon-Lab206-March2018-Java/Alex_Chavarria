package com.avvarga.lookify.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.avvarga.lookify.models.Song;
import com.avvarga.lookify.services.SongsService;

@Controller
public class SongsController {
	
	private final SongsService sServ;
	public SongsController(SongsService sServ) {
		this.sServ = sServ;
	}
	
	@RequestMapping ("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping ("/dashboard")
	public String dashboard (@ModelAttribute ("song") Song Song, Model m) {
		m.addAttribute("songs", sServ.allSongs());
		return "dashboard.jsp";
	}
	
	@RequestMapping ("/songs/new")
	public String newSong (@ModelAttribute ("song") Song song) {
		return "new.jsp";
	}
	
	@PostMapping ("/songs/create")
	public String createSong (@Valid @ModelAttribute ("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";			
		} else {
			sServ.addSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping ("/songs/{id}")
	public String showSong (@PathVariable ("id") Long id, Model m) {
		m.addAttribute("song", sServ.showSong(id));
		return "details.jsp";
	}
	
	@RequestMapping ("/delete/{id}")
	public String deleteSong (@PathVariable ("id") Long id) {
		sServ.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping ("/search/topTen")
	public String topSongs (@ModelAttribute ("song") Song song, Model m) {
		m.addAttribute("songs", sServ.findTop10());
		return "top.jsp";
	}
	
	@RequestMapping ("/search")
	public String searchSongs (@RequestParam("artist") String artist) {
		return "redirect:/search/"+artist;
	}
	
	@RequestMapping ("/search/{artist}")
	public String findSongs (@PathVariable("artist") String artist, Model m) {
		m.addAttribute("songs", sServ.findByArtist(artist));
		return "search.jsp";
	}
}
