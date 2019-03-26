


function modal(){
const portModal = document.getElementById('album-modal');
const portOpen = document.querySelector('.grid-item-container');
const portClose = document.getElementById('port-close-btn');

//Listen for open click
portOpen.addEventListener('click', openModal);
//Listen for close click
portClose.addEventListener('click', closeModal);
//Listen for click outside of model
window.addEventListener('click', clickOutside);

function openModal(){
  portModal.style.display = 'block';
}

function closeModal(){
  portModal.style.display = 'none';
}

//Function to close model if click is outside of modal
function clickOutside(e){
  if(e.target == portModal){
    portModal.style.display = 'none';
  }
}
}

export default{
    modal
}