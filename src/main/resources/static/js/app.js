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
  events.on(getAppContext(), 'click', ()=>{
    if(event.target.classList.contains('add-artist__submit')){
      const artistName = document.querySelector('.add-artist__artistName').value
      const artistImage = document.querySelector('.add-artist__artistImage').value
      const artistRating = document.querySelector('.add-artist__artistRating').value

      api.postRequest('/artists/add', {
        artistName:artistName,
        artistImage:artistImage,
        artistRating:artistRating
      }, (artists) => getAppContext().innerHTML= Artists(artists))
    }
    /*TOGGLE MODAL*/
    if(event.target.classList.contains('grid-image')){
     events.toggle(event.target.parentElement.parentElement.querySelector('.modal'))
    }
    if(event.target.classList.contains('modal')){
       events.toggle(event.target)}
  })

/*ALBUM MODAL ACTIONS:*/
  /*ADD AN ALBUM*/
  events.on(getAppContext(), 'click', ()=>{
    if(event.target.classList.contains('add-album__submit')){
      const albumTitle = document.querySelector('.add-album__albumTitle').value
      const albumCover = document.querySelector('.add-album__albumCover').value
      const albumRating = document.querySelector('.add-album__albumRating').value
      const artist = document.querySelector('.add-album__artist').value

      api.postRequest('/albums/add', {
        albumTitle:albumTitle,
        albumCover:albumCover,
        albumRating:albumRating,
        artist:artist
      }, (artists) => getAppContext().innerHTML= Artists(artists))
    }
  /*TOGGLE COMMENTS*/
    if(event.target.classList.contains('artistCommentOn')){
      events.hide(event.target)
      events.display(event.target.parentElement.querySelector('.artistCommentOff'))
      events.display(event.target.parentElement.parentElement.parentElement.querySelector('.comments'))
      events.hide(event.target.parentElement.parentElement.parentElement.querySelector('.albums'))
    }
    if(event.target.classList.contains('artistCommentOff')){
      events.hide(event.target)
      events.display(event.target.parentElement.querySelector('.artistCommentOn'))
      events.display(event.target.parentElement.parentElement.parentElement.querySelector('.albums'))
      events.hide(event.target.parentElement.parentElement.parentElement.querySelector('.comments'))
    }
  /*ADD AN ARTIST COMMENT*/
    if(event.target.classList.contains('add-artist-comment__submit')){
      const artistCommentBody = document.querySelector('.add-artist-comment__comment').value
      const artistCommentArtist = document.querySelector('.add-artist-comment__artist').value

      api.postRequest('/artists/comments/add', {
        artistCommentBody:artistCommentBody,
        artistCommentArtist:artistCommentArtist,
      }, (artists) => getAppContext().innerHTML= Artists(artists))
    }
  })

/*SONG DROP-DOWN ACTIONS:*/
  /*ADD A SONG*/
  events.on(getAppContext(), 'click', ()=>{
    if(event.target.classList.contains('add-song__submit')){
      const songTitle = document.querySelector('.add-song__songTitle').value
      const album = document.querySelector('.add-song__album').value
      const duration = document.querySelector('.add-song__duration').value
      const songRating = document.querySelector('.add-song__songRating').value

      api.postRequest('/songs/add', {
        songTitle:songTitle,
        album:album,
        duration:duration,
        songRating:songRating,
        }, (artists) => getAppContext().innerHTML= Artists(artists))
    }
  })
}

function getAppContext() {
  return document.querySelector("#app")
}


