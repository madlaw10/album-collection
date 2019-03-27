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
  `;
}