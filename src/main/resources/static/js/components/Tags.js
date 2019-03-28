
export default function Tags(tags) {
    return `
        <ul id="tags">
            ${tags.map(tag => {
                return `
                    <li class="tag">${tag.tagName}</li>
                `;
            }).join('')}
        </ul>
        
        `} 