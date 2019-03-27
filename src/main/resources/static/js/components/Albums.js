import Songs from './Songs'

export default function Albums(albums) {
    return `
      <ul id="albums" class="grid-list">
        ${albums.map(album => {
        return `
                <li id="album" class="album grid-list--item">
                  <div class="grid-item-container">
                    <img class="grid-image" src="${album.albumCover}" alt="Album Cover">
                    <h3  class="item-name">${album.albumTitle}</h3>
                    <img class="grid-image slide" src="../images/Record_Album_clip_art.svg">
                  </div>
                <ul class="songs hidden">
                    ${Songs(album.songs)}
                </ul>
                </li>
            `;
    }).join('')}
    </ul>

    <section class="add-albums">
    <input class= "add-album__albumTitle" type = "text" placeholder= "Album Title">
    <input class= "add-album__albumCover" type = "text" placeholder= "Album Image">
    <input class= "add-album__albumRating" type = "text" placeholder= "Album Rating">
    <input class= "add-album__artist" type = "text" placeholder= "Artist Name">
    <button class="add-album__submit">Submit</button>
    </section>
  `;
}