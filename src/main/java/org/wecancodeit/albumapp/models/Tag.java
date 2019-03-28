package org.wecancodeit.albumapp.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tag {
	
	@Id
	@GeneratedValue
	private Long tagId;
	private String tagName;
	@ManyToMany(mappedBy="tags")
	@JsonIgnore
	private Collection<Artist> artists;
	@ManyToMany(mappedBy="tags")
	@JsonIgnore
	private Collection<Song> songs;
	@ManyToMany(mappedBy="tags")
	@JsonIgnore
	private Collection<Album> albums;
	
	public Tag() {}
	
	public Tag(String tagName) {
		this.tagName = tagName;
	}
	
	public Long getTagId() {
		return tagId;
	}
	public String getTagName() {
		return tagName;
	}
	
	public Collection<Artist> getArtists() {
		return artists;
	}

	public Collection<Song> getSongs() {
		return songs;
	}

	public Collection<Album> getAlbums() {
		return albums;
	}

	@Override
	public String toString() {
		return "tagName=" + tagName;
	}

}
