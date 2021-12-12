let user_form = document.getElementById('user-validation');
let course_form = document.getElementById('course-validation');
window.onload = fetch_courses;

user_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (user_form.checkValidity() === true) {
        console.log("YES");
        console.log(document.getElementById('name'));
        let response = await fetch('api/users/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                name: document.getElementById('name').value,

                email: document.getElementById('email').value,
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
/*
course_form.onsubmit = async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (course_form.checkValidity() === true) {
        let form_data1 = new FormData();
        let form_data2 = new FormData();
         form_data1.append('name', document.getElementById('name1').value);
        form_data1.append('description', document.getElementById('description1').value);
        form_data1.append('credits', document.getElementById('credits1').value);
        form_data2.append('name', document.getElementById('name2').value);
        form_data2.append('description', document.getElementById('description2').value);
        form_data2.append('credits', document.getElementById('credits2').value);
        // $.ajax({
        //   type: "POST",
        //   url: "api/courses/register",
        //   enctype: 'multipart/form-data',
        //   data: form_data,
        //   processData: false,
        //   contentType: false,
        // }).done(function(response, status) {
        //   console.log(response, status);
        // });
        let response1 = await fetch('api/courses/register', {
            method: 'POST',
            body: form_data1
        });
        let response2 = await fetch('api/courses/register', {
            method: 'POST',
            body: form_data2
        });

        let result1 = await response1;
        let result2 = await response2;
        if (result1['status'] === 203 && result2['status'] === 203) {
            document.getElementById("course-success").style.display = "none";
            document.getElementById("course-alert").style.display = "block";

        } else {
            document.getElementById("course-alert").style.display = "none";
            document.getElementById("course-success").style.display = "block";

        }
        console.log(result1);
        console.log(result2);
    } else {
        course_form.classList.add('was-validated');
    }
};
*/
async function fetch_courses() {
   /* if (!sessionStorage.getItem('id')) {
        location.href = "dashboard.html";
        return;
    }*/
    let response = await fetch("api/courses/get");
    let courses = await response.json(); // read response body and parse as JSON
    console.log(courses);
    let courses_option1 = document.getElementById('courses1');
    let courses_option2 = document.getElementById('courses2');

    courses_option1.innerHTML = '<option value=""> Choose...</option>';

    for (let i = 0; i < courses.length; i++) {
        courses_option1.innerHTML += '<option value="' + courses[i]['course_id'] + '">' + courses[i]['name'] + '</option>';
    }
    courses_option2.innerHTML = '<option value=""> Choose...</option>';

    for (let i = 0; i < courses.length; i++) {
        courses_option2.innerHTML += '<option value="' + courses[i]['course_id'] + '">' + courses[i]['name'] + '</option>';
    }

}