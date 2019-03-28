import '../css/styling.css'

import events from './utils/events/event-action'
import api from './utils/api/api-action'
import Artists from './components/Artists'

main()

function main() {
  api.getRequest('/artists', artists => {
    getAppContext().innerHTML = Artists(artists);
  })
  /*ADD AN ARTIST*/
  events.on(getAppContext(), 'click', () => {
    if (event.target.classList.contains('add-artist__submit')) {
      const artistName = event.target.parentElement.querySelector('.add-artist__artistName').value
      const artistImage = event.target.parentElement.querySelector('.add-artist__artistImage').value
      const artistRating = event.target.parentElement.querySelector('.add-artist__artistRating').value
      const artistTag = event.target.parentElement.querySelector('.add-artist__tag').value

      api.postRequest('/artists/add', {
        artistName: artistName,
        artistImage: artistImage,
        artistRating: artistRating,
        artistTag: artistTag
      }, (artists) => getAppContext().innerHTML = Artists(artists))
    }
  /*ADD A TAG*/
    if (event.target.classList.contains('add-tag__submit')) {
      const tagTag = document.querySelector('.add-tag__tag').value

      api.postRequest('/tags/add', {
        tagTag: tagTag
      }, (artists) => getAppContext().innerHTML = Artists(artists))
    }
  /*TOGGLE ARTIST VIEW MODAL*/
    if (event.target.classList.contains('btn-artist')) {
    events.toggle(event.target.parentElement.parentElement.querySelector('.modal'))
    }
    if (event.target.classList.contains('modal')) {
      events.toggle(event.target)
    }
  })
  
  
  /*ALBUM MODAL ACTIONS:*/
  /*ADD AN ALBUM*/
  events.on(getAppContext(), 'click', () => {
    if (event.target.classList.contains('add-album__submit')) {
      const albumTitle = event.target.parentElement.querySelector('.add-album__albumTitle').value
      const albumCover = event.target.parentElement.querySelector('.add-album__albumCover').value
      const albumRating = event.target.parentElement.querySelector('.add-album__albumRating').value
      const artist = event.target.parentElement.querySelector('.add-album__artist').value
      const albumTag = event.target.parentElement.querySelector('.add-album__tag').value
      
      api.postRequest('/albums/add', {
        albumTitle: albumTitle,
        albumCover: albumCover,
        albumRating: albumRating,
        artist: artist,
        albumTag: albumTag
      }, (artists) => getAppContext().innerHTML = Artists(artists))
    }
    /*TOGGLE ARTIST COMMENTS*/
    if (event.target.classList.contains('artistCommentOn')) {
      events.hide(event.target)
      events.display(event.target.parentElement.querySelector('.artistCommentOff'))
      events.display(event.target.parentElement.parentElement.parentElement.querySelector('.comments'))
      events.hide(event.target.parentElement.parentElement.parentElement.querySelector('.albums'))
    }
    if (event.target.classList.contains('artistCommentOff')) {
      events.hide(event.target)
      events.display(event.target.parentElement.querySelector('.artistCommentOn'))
      events.display(event.target.parentElement.parentElement.parentElement.querySelector('.albums'))
      events.hide(event.target.parentElement.parentElement.parentElement.querySelector('.comments'))
    }
    /*ADD AN ARTIST COMMENT*/
    if (event.target.classList.contains('add-artist-comment__submit')) {
      const artistCommentBody = event.target.parentElement.querySelector('.add-artist-comment__comment').value
      const artistCommentArtist = event.target.parentElement.querySelector('.add-artist-comment__artist').value
      
      api.postRequest('/artists/comments/add', {
        artistCommentBody: artistCommentBody,
        artistCommentArtist: artistCommentArtist,
      }, (artists) => getAppContext().innerHTML = Artists(artists))
    }

    /*TOGGLE ALBUM VIEW MODAL*/
    if (event.target.classList.contains('btn-album')) {
      events.display(event.target.parentElement.parentElement.querySelector('.modal'))
      }
      if (event.target.classList.contains('album-modal')) {
        events.hide(event.target)
      }

/*TOGGLE ALBUM COMMENTS*/
if (event.target.classList.contains('albumCommentOn')) {
  events.hide(event.target)
  events.display(event.target.parentElement.querySelector('.albumCommentOff'))
  events.display(event.target.parentElement.parentElement.parentElement.querySelector('.albumComments'))
  events.hide(event.target.parentElement.parentElement.parentElement.querySelector('.songs'))
}
if (event.target.classList.contains('albumCommentOff')) {
  events.hide(event.target)
  events.display(event.target.parentElement.querySelector('.albumCommentOn'))
  events.display(event.target.parentElement.parentElement.parentElement.querySelector('.songs'))
  events.hide(event.target.parentElement.parentElement.parentElement.querySelector('.albumComments'))
}

/*ADD AN ALBUM COMMENT*/
if (event.target.classList.contains('add-album-comment__submit')) {
  const albumCommentBody = event.target.parentElement.querySelector('.add-album-comment__comment').value
  const albumCommentAlbum = event.target.parentElement.querySelector('.add-album-comment__album').value
  
  api.postRequest('/albums/comments/add', {
    albumCommentBody: albumCommentBody,
    albumCommentAlbum: albumCommentAlbum,
  }, (artists) => getAppContext().innerHTML = Artists(artists))
}

    })
  
  /*SONG DROP-DOWN ACTIONS:*/
  /*ADD A SONG*/
  events.on(getAppContext(), 'click', () => {
    if (event.target.classList.contains('add-song__submit')) {
      const songTitle = event.target.parentElement.querySelector('.add-song__songTitle').value
      const album = event.target.parentElement.querySelector('.add-song__album').value
      const duration = event.target.parentElement.querySelector('.add-song__duration').value
      const songRating = event.target.parentElement.querySelector('.add-song__songRating').value
      const songTag = event.target.parentElement.querySelector('.add-song__tag').value

      api.postRequest('/songs/add', {
        songTitle: songTitle,
        album: album,
        duration: duration,
        songRating: songRating,
        songTag: songTag
      }, (artists) => getAppContext().innerHTML = Artists(artists))
    }

    /*TOGGLE SONG COMMENTS*/
    if (event.target.classList.contains('song__title')) {
      events.toggle(event.target.parentElement.querySelector('.song__comment_list'))
      
    }

    /*ADD A SONG COMMENT*/
if (event.target.classList.contains('add-song-comment__submit')) {
  const songCommentBody = event.target.parentElement.querySelector('.add-song-comment__comment').value
  const songCommentSong = event.target.parentElement.querySelector('.add-song-comment__song').value
  
  api.postRequest('/songs/comments/add', {
    songCommentBody: songCommentBody,
    songCommentSong: songCommentSong,
  }, (artists) => getAppContext().innerHTML = Artists(artists))
}
  })
}

function getAppContext() {
  return document.querySelector("#app")
}


