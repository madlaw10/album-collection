package org.wecancodeit.albumapp.models;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.albumapp.models.Artist;
import org.wecancodeit.albumapp.models.Tag;
import org.wecancodeit.albumapp.repositories.ArtistRepository;
import org.wecancodeit.albumapp.repositories.TagRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ArtistTest {
	
	@Resource
	private TestEntityManager entityManager;
	
	@Resource 
	private ArtistRepository artistRepo;
	@Resource
	private TagRepository tagRepo;
	
	@Test
	public void shouldLoadArtistByName() {
		Tag tag = tagRepo.save(new Tag("tag"));
		Artist artist = artistRepo.save(new Artist("Artist Name", "artistImage", 1, tag));
		
		entityManager.persist(artist);
		entityManager.flush();
		entityManager.clear();
		
		Artist artistFromDatabase = artistRepo.findByArtistName("Artist Name");
		
		assertThat(artistFromDatabase.getArtistName(), is("Artist Name"));		
	}

}
