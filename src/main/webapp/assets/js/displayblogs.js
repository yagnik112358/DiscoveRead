// let blogs_form = document.getElementById('course-validation');
window.onload = fetch_blogs;

async function fetch_blogs() {

    let response = await fetch("api/blogs/getBlogs");
    let blogs = await response.json(); // read response body and parse as JSON

    console.log("blog starts");
    console.log(response);
    console.log(blogs);

    let container = document.getElementById("allBlogs");
    for (let i = 0; i < blogs.length; i++) {
        let div = document.createElement("div");
        div.innerHTML = 'Name: ' + blogs[i].name + ' \n' + 'Description: ' + ' ' + blogs[i].description;
        container.appendChild(div);
    }

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