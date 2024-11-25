

fetch('http://8.138.15.94:8080/xrh/view')
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        
        const mainElement = document.querySelector('.main');
 
        
        data.forEach(item => {
           
            const unitElement = document.createElement('div');
            unitElement.className = 'unit';
            
           
            const imgElement = document.createElement('img');
            imgElement.src = '/src/'+item.photo; 
            imgElement.className= 'imag';
            
            unitElement.appendChild(imgElement);
 
           
            const pElement = document.createElement('p');
            pElement.textContent = item.text; 
            unitElement.appendChild(pElement);
 
           
            mainElement.appendChild(unitElement);

            
        });
    })
    .catch(error => {
        console.error('There has been a problem with your fetch operation:', error);
    });