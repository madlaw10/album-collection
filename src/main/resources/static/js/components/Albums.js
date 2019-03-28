import Songs from './Songs'
import AlbumComments from './AlbumComments'
import Tags from './Tags'

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
                        <li>${Tags(album.tags)}</li> 
                        <li class="albumCommentOn">Album Comments</li>
                        <li class="albumCommentOff hidden">Close Album Comments</li>
                      </ul>
                    </div>
                    <div class="modal-content--body songs">${Songs(album.songs)}
                          <section class="add-song">
                          <input class= "add-song__songTitle" type = "text" placeholder= "Song name">
                          <input class= "add-song__album hidden" type = "text" placeholder= "Album Name" value= "${album.albumId}">
                          <input class= "add-song__duration" type = "text" placeholder= "Song Duration">
                          <input class= "add-song__songRating" type = "text" placeholder= "Song Rating">
                          <input class= "add-song__tag" type= "text" placeholder= "Select Tag">
                                
                           
                         
                          <button class="add-song__submit">Submit</button>
                          </section>
                    
                    
                    
                    
                    
                    
                    </div>
                    <div class="modal-content--body albumComments hidden">${AlbumComments(album.albumComments)}</div>
                  </div>
                </div>
         
                
                </li>
            `;
    }).join('')}
    </ul>

  `;
}