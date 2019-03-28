import SongComments from './SongComments'

export default function Songs(songs) {
    return `
        <ol id="songs">
            ${songs.map(song => {
                return `
                    <li class="song">
                        <h3 class="song__title">${song.songTitle}</h3>
                            <div>
                            ${SongComments(song.songComments)}
                            </div>
                    </li>
                `;
            }).join('')}
        </ol>
        `}   