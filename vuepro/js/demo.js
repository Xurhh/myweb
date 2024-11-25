


function Login(){
    
    
    let name  = document.getElementById("username").value;
    let pass = document.getElementById("password").value;
    
    fetch('http://8.138.15.94:8080/xrh/loginer', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({username: name,password:pass})
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }
        return response.json();
    })
    .then(data => {
        console.log('Login judge:', data);
        
        let status = data.status;
        if(status=="failed"){
            let spe = data.specific;
            alert(spe);
        }else{
            alert("成功！");
            window.open("http://8.138.15.94:80/main.html");
        }
        
    })

}
