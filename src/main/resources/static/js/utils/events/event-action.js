
function on(element, eventType, callback) {
    element.addEventListener(eventType, (event) => callback(event))
}

function toggle(element){
    element.classList.toggle('hidden')
   }

export default {
    on,
    toggle
}