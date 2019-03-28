package org.wecancodeit.albumapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.albumapp.models.Album;
import org.wecancodeit.albumapp.models.AlbumComment;
import org.wecancodeit.albumapp.models.Artist;
import org.wecancodeit.albumapp.models.ArtistComment;
import org.wecancodeit.albumapp.models.Comment;
import org.wecancodeit.albumapp.models.Song;
import org.wecancodeit.albumapp.models.SongComment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

	ArtistComment findByArtist(Artist artist);

	AlbumComment findByAlbum(Album album);

	SongComment findBySong(Song song);

}
