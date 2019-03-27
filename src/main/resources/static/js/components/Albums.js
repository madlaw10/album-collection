import Songs from './Songs'
import AlbumComments from './AlbumComments'

export default function Albums(albums) {
    return `
      <ul id="albums" class="grid-list">
        ${albums.map(album => {
        return `
                <li id="album" class="album grid-list--item">
                  <div class="grid-item-container">
                    <img class="grid-image btn-album" src="${album.albumCover}" alt="Album Cover">
                    <h3  class="item-name">${album.albumTitle}</h3>
                    <img class="grid-image slide" src="../images/Record_Album_clip_art.svg">
                  </div>


                  <div class="hidden modal album-modal">
                  <div class="modal-content">
                    <div class="modal-content--header">
                      <img class="model--header-image" src="${album.albumCover}" alt="Album Cover">
                      <h2>${album.albumTitle}</h2>
                      <ul>
                        <li>Artist Rating: ${album.albumRating}/10</li>
                        <li>Songs: ${album.songs.length}</li>
                        <li class="albumCommentOn">Album Comments</li>
                        <li class="albumCommentOff hidden">Close Album Comments</li>
                      </ul>
                    </div>
                    <div class="modal-content--body songs">${Songs(album.songs)}</div>
                    <div class="modal-content--body albumComments hidden">${AlbumComments(album.albumComments)}</div>
                  </div>
                </div>
         
                
                </li>
            `;
    }).join('')}
    </ul>

    <section class="add-album">
    <input class= "add-album__albumTitle" type = "text" placeholder= "Album Title">
    <input class= "add-album__albumCover" type = "text" placeholder= "Album Image">
    <input class= "add-album__albumRating" type = "text" placeholder= "Album Rating (out of 10)">
    <input class= "add-album__artist" type = "text" placeholder= "Artist Name">
    <input class= "add-album__tag" type = "text" placeholder= "Tag">
    <button class="add-album__submit">Submit</button>
    </section>
  `;
}