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
import org.wecancodeit.albumapp.models.Tag;
import org.wecancodeit.albumapp.repositories.ArtistRepository;
import org.wecancodeit.albumapp.repositories.TagRepository;

@RestController
@RequestMapping("/tags")
public class TagController {
	
	@Resource
	TagRepository tagRepo;
	@Resource
	ArtistRepository artistRepo;
	
	@GetMapping("")
	public Collection<Tag> getTags() {
		return (Collection<Tag>)tagRepo.findAll();
		
	}
	
	@PostMapping("/add")
	public Collection<Artist> addTags(@RequestBody String body) throws JSONException {
		JSONObject newTag = new JSONObject(body);
		String tagName = newTag.getString("tagTag");
		tagRepo.save(new Tag(tagName));
		return (Collection<Artist>) artistRepo.findAll();
	}

}
