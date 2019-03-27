package org.wecancodeit.albumapp.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.albumapp.models.Album;
import org.wecancodeit.albumapp.models.Artist;
import org.wecancodeit.albumapp.models.Song;
import org.wecancodeit.albumapp.models.Tag;
import org.wecancodeit.albumapp.repositories.AlbumRepository;
import org.wecancodeit.albumapp.repositories.ArtistRepository;
import org.wecancodeit.albumapp.repositories.SongRepository;
import org.wecancodeit.albumapp.repositories.TagRepository;

@RestController
@RequestMapping("/songs")
public class SongController {

	@Resource
	SongRepository songRepo;
	@Resource
	AlbumRepository albumRepo;
	@Resource
	ArtistRepository artistRepo;
	@Resource
	TagRepository tagRepo;

	@GetMapping("")
	public Collection<Song> getSongs() {
		return (Collection<Song>) songRepo.findAll();

	}

	@PostMapping("/add")
	public Collection<Artist> addSong(@RequestBody String body) throws JSONException {

		JSONObject newSong = new JSONObject(body);
		String songTitle = newSong.getString("songTitle");
		String duration = newSong.getString("duration");
		int songRating = Integer.parseInt(newSong.getString("songRating"));
		Album album = albumRepo.findByAlbumTitle(newSong.getString("album"));
		Tag tag = tagRepo.findByTagName(newSong.getString("songTag"));
		songRepo.save(new Song(songTitle, duration, songRating, album, tag));
		return (Collection<Artist>) artistRepo.findAll();
	}

}
