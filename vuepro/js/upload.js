function upload() {
    const fileInput = document.getElementById('photo');
    const file = fileInput.files[0]; 
    const text1 = document.getElementById("text");
    const text = text1.value
    if (!file) {
        alert('Please select a file to upload.');
        return;
    }

    const formData = new FormData(); 
    formData.append('photo', file); 
    formData.append('text',text);

    
    fetch('http://8.138.15.94:8080/xrh/upload', { 
        method: 'POST',
        body: formData
    })
    .then(response => response.json()) 
    .then(data => {
        

        if (data.success) {
            alert('File uploaded successfully!');
            
        } else {
            alert('File upload failed: ' + data.message);
        }
        
    })
    .catch(error => {
        console.error('Error uploading file:', error);
        alert('An error occurred while uploading the file.');
    });
}