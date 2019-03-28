package org.wecancodeit.albumapp.models;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.albumapp.models.Tag;
import org.wecancodeit.albumapp.repositories.TagRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class TagTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private TagRepository tagRepo;

	@Test
	public void shouldLoadTagByName() {
		Tag tag = tagRepo.save(new Tag("Tag"));

		entityManager.persist(tag);
		entityManager.flush();
		entityManager.clear();

		Tag tagCommentFromDatabase = tagRepo.findByTagName("Tag");

		assertThat(tagCommentFromDatabase.getTagName(), is("Tag"));
	}

}