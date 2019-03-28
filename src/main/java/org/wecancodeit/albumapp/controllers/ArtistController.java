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
import org.wecancodeit.albumapp.models.Artist;
import org.wecancodeit.albumapp.models.ArtistComment;
import org.wecancodeit.albumapp.models.Tag;
import org.wecancodeit.albumapp.repositories.ArtistRepository;
import org.wecancodeit.albumapp.repositories.CommentRepository;
import org.wecancodeit.albumapp.repositories.TagRepository;

@RestController
@RequestMapping("/artists")
public class ArtistController {

	// Resources
	@Resource
	ArtistRepository artistRepo;
	@Resource
	TagRepository tagRepo;
	@Resource
	CommentRepository commentRepo;

	@GetMapping("")
	public Collection<Artist> getArtists() {
		return (Collection<Artist>) artistRepo.findAll();

	}

	@PostMapping("/add")
	public Collection<Artist> addArtist(@RequestBody String body) throws JSONException {
		JSONObject newArtist = new JSONObject(body);
		String artistName = newArtist.getString("artistName");
		String artistImage = newArtist.getString("artistImage");
		int artistRating = Integer.parseInt(newArtist.getString("artistRating"));
		Tag tag = tagRepo.findByTagName(newArtist.getString("artistTag"));
		artistRepo.save(new Artist(artistName, artistImage, artistRating, tag));
		return (Collection<Artist>) artistRepo.findAll();
	}
	
	@PostMapping("/comments/add")
	public Collection<Artist> addArtistComment(@RequestBody String body) throws JSONException {
		JSONObject newArtistComment = new JSONObject(body);
		String artistCommentBody = newArtistComment.getString("artistCommentBody");
		Artist artist = artistRepo.findByArtistName(newArtistComment.getString("artistCommentArtist"));
		commentRepo.save(new ArtistComment(artistCommentBody, artist));
		return (Collection<Artist>) artistRepo.findAll();
	}
}
