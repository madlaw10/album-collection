package org.wecancodeit.albumapp.models;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.albumapp.models.Album;
import org.wecancodeit.albumapp.models.AlbumComment;
import org.wecancodeit.albumapp.models.Artist;
import org.wecancodeit.albumapp.models.ArtistComment;
import org.wecancodeit.albumapp.models.Song;
import org.wecancodeit.albumapp.models.SongComment;
import org.wecancodeit.albumapp.models.Tag;
import org.wecancodeit.albumapp.repositories.AlbumRepository;
import org.wecancodeit.albumapp.repositories.ArtistRepository;
import org.wecancodeit.albumapp.repositories.CommentRepository;
import org.wecancodeit.albumapp.repositories.SongRepository;
import org.wecancodeit.albumapp.repositories.TagRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CommentTest {
	
	@Resource
	private TestEntityManager entityManager;
	
	@Resource
	private CommentRepository commentRepo;
	@Resource
	private SongRepository songRepo;
	@Resource 
	private AlbumRepository albumRepo;
	@Resource
	private ArtistRepository artistRepo;
	@Resource
	private TagRepository tagRepo;
	
	@Test
	public void shouldLoadArtistCommentByName() {
		Tag tag = tagRepo.save(new Tag("tag"));
		Artist artist = artistRepo.save(new Artist("Artist Name", "artistImage", 1, tag));
		ArtistComment artistComment = commentRepo.save(new ArtistComment("Artist Comment", artist));		
		
		entityManager.persist(artistComment);
		entityManager.flush();
		entityManager.clear();
		
		ArtistComment artistCommentFromDatabase = commentRepo.findByArtist(artist);
		
		assertThat(artistCommentFromDatabase.getCommentContent(), is("Artist Comment"));		
	}
	
	@Test
	public void shouldLoadAlbumCommentByName() {
		Tag tag = tagRepo.save(new Tag("tag"));
		Artist artist = artistRepo.save(new Artist("Artist Name", "artistImage", 1, tag));
		Album album = albumRepo.save(new Album("Album Title", "Album Cover", 1, artist, tag));
		AlbumComment albumComment = commentRepo.save(new AlbumComment("Album Comment", album));		
		
		entityManager.persist(albumComment);
		entityManager.flush();
		entityManager.clear();
		
		AlbumComment albumCommentFromDatabase = commentRepo.findByAlbum(album);
		
		assertThat(albumCommentFromDatabase.getCommentContent(), is("Album Comment"));		
	}
	
	@Test
	public void shouldLoadSongCommentByName() {
		Tag tag = tagRepo.save(new Tag("tag"));
		Artist artist = artistRepo.save(new Artist("Artist Name", "artistImage", 1, tag));
		Album album = albumRepo.save(new Album("Album Title", "Album Cover", 1, artist, tag));
		Song song = songRepo.save(new Song("Song Title", "Time", 1, album, tag));
		SongComment songComment = commentRepo.save(new SongComment("Song Comment", song));		
		
		entityManager.persist(songComment);
		entityManager.flush();
		entityManager.clear();
		
		SongComment songCommentFromDatabase = commentRepo.findBySong(song);
		
		assertThat(songCommentFromDatabase.getCommentContent(), is("Song Comment"));		
	}
}
