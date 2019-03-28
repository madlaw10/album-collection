export default function ArtistComments(artistComments) {
    return `
      <ul id="artist-comments">
        ${artistComments.map(artistComment => {
        return `
            <li id="artistComment">
                <h3  class="artist-comment">${artistComment.commentContent}</h3>
            </li>
        `;
    }).join('')}
    </ul>

    <section class="add-artist-comment">
    <input class= "add-artist-comment__comment" type = "text" placeholder= "Type your comment here.">
    <input class= "add-artist-comment__artist" type = "text" placeholder= "Artist Name">
    <button class="add-artist-comment__submit">Submit</button>
    </section>
    `
}