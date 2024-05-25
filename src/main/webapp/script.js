function validateLogin() {
    const email = document.getElementById('loginEmail').value;
    const password = document.getElementById('loginPassword').value;
    

    if (!email || !password) {
        alert('Both email and password are required.');
    } 
    if(email == 'mcu123@gmail.com' && password == 'mcu123@' && document.getElementById('loginCheckbox').checked == true) {
        alert('Login successful!');
        // Here you can add your login logic, e.g., send data to the server
        document.loginform.action = get_action();
        
        function get_action() {
        return "operationPage.html";
    }
        
    }
    else{
        alert("Wrong Password");
    }
}