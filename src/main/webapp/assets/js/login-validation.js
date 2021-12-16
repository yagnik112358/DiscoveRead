let login_form = document.getElementById('login-validation');
login_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (login_form.checkValidity() === true) {
        document.getElementById("submit-button").style.display = "none";
        document.getElementById("spinner-button").style.display = "block";
        let response = await fetch('api/users/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                email: document.getElementById('email').value,
            })
        });
        let result = await response;
        console.log("NO1");
        console.log(response);
        console.log("NO2");
        if(result['status'] === 200){
            let data = response.json();
            console.log("NO3");
            console.log(data);
            console.log("NO4");


            document.getElementById("submit-button").style.display = "block";
            document.getElementById("spinner-button").style.display = "none";

            //sessionStorage.setItem('userid', data["userid"]);

            localStorage.setItem("email",document.getElementById("email").value);
            location.href="home.html";
        }
        else{
            document.getElementById("submit-button").style.display = "block";
            document.getElementById("spinner-button").style.display = "none";

            document.getElementById("login-alert").style.display = "block";
        }
    }
});
function myfunc()
{
document.getElementById("sample1").innerHTML=localStorage.getItem("email");
}