export default function AlbumComments(albumComments) {
    return `
      <ul id="album-comments">
        ${albumComments.map(albumComment => {
        return `
            <li id="albumComment">
                <h3  class="album-comment">${albumComment.commentContent}</h3>
            </li>
        `;
    }).join('')}
    </ul>

    <section class="add-album-comment">
    <input class= "add-album-comment__comment" type = "text" placeholder= "Type your comment here.">
    <input class= "add-album-comment__album" type = "text" placeholder= "Album Name">
    <button class="add-album-comment__submit">Submit</button>
    </section>
    `
}