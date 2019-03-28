export default function SongComments(songComments) {
    return `
      <ul id="song-comments">
        ${songComments.map(songComment => {
        return `
            <li id="songComment">
                <h3  class="song-comment">${songComment.commentContent}</h3>
            </li>
        `;
    }).join('')}
    </ul>

    <section class="add-song-comment">
    <input class= "add-song-comment__comment" type = "text" placeholder= "Type your comment here.">
    <input class= "add-song-comment__song" type = "text" placeholder= "Song Name">
    <button class="add-song-comment__submit">Submit</button>
    </section>
    `
}