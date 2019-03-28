import SongComments from './SongComments'
import Tags from './Tags'

export default function Songs(songs) {
    return `
        <ol id="songs">
            ${songs.map(song => {
                return `
                    <li class="song">
                        <h3 class="song__title">${song.songTitle}<span><small> (${song.duration})</small></span></h3>
                        <div class="song__comment_list hidden">
                            <ul>
                                <li>${Tags(song.tags)}</li>
                                <li>${SongComments(song.songComments)}</li>
                            </ul>
                        </div>
                    </li>
                `;
            }).join('')}
        </ol>
        
       
        
        `}   