// let blogs_form = document.getElementById('course-validation');
window.onload = fetch_blogs;

async function fetch_blogs() {
    /* if (!sessionStorage.getItem('id')) {
         location.href = "dashboard.html";
         return;
     }*/
    let response = await fetch("api/blogs/get");
    let blogs = await response.json(); // read response body and parse as JSON
    console.log(blogs);
    // let courses_option1 = document.getElementById('courses1');
    // let courses_option2 = document.getElementById('courses2');

    // courses_option1.innerHTML = '<option value=""> Choose...</option>';

    // for (let i = 0; i < courses.length; i++) {
    //     courses_option1.innerHTML += '<option value="' + courses[i]['course_id'] + '">' + courses[i]['name'] + '</option>';
    // }
    // courses_option2.innerHTML = '<option value=""> Choose...</option>';
    //
    // for (let i = 0; i < courses.length; i++) {
    //     courses_option2.innerHTML += '<option value="' + courses[i]['course_id'] + '">' + courses[i]['name'] + '</option>';
    // }

}