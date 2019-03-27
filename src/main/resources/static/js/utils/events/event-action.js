
function on(element, eventType, callback) {
    element.addEventListener(eventType, (event) => callback(event))
}

function toggle(element) {
    element.classList.toggle('hidden')
   }

function hide(element) {
    element.classList.add('hidden')
}

function display(element) {
    element.classList.remove('hidden')
}

export default {
    on,
    toggle,
    hide,
    display
}