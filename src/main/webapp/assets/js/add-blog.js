let blog_form = document.getElementById('blog-validation');
//let course_form = document.getElementById('course-validation');
//window.onload = fetch_courses;

blog_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (blog_form.checkValidity() === true) {
        console.log("YES");
        console.log(document.getElementById('name').value);
        console.log(document.getElementById('description').value);
        console.log("YES");
        let response = await fetch('api/blogs/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                name: document.getElementById('name').value,

                description: document.getElementById('description').value,
                //userid:sessionStorage.getItem("userid"),
            })
        }).then(
            response => {
                if (response['status'] === 203) {
                    document.getElementById("login-success").style.display = "none";
                    document.getElementById("login-alert").style.display = "block";

                } else {
                    document.getElementById("login-alert").style.display = "none";
                    document.getElementById("login-success").style.display = "block";
                    document.getElementById("user-validation").reset();
                    setTimeout(function (){
                        location.href="index.html";
                    },2000);
                }
            }
        );
    } else {
        user_form.classList.add('was-validated');
    }
});