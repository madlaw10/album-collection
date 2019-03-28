
import apiAction from '../utils/api/api-action.js';

export default function ArtistComments(artistComments) {
    return `
      <ul id="artist-comments">
        ${artistComments.map(artistComment => {
        return `
            <li id="artistComment">
                <h3  class="artist-comment">${artistComment.commentContent}</h3>
            </li>
       ` ;
    }).join('')}
    
    </ul>`
    

}