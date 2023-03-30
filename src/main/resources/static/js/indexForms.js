const postMethod = document.querySelector("input#postMethod"); //Select radio element
postMethod.addEventListener("click", function (){
    const form = document.querySelector("form"); // Getting form element
    if (this.checked){
        form.setAttribute("method", "post");
        form.setAttribute("action", "/Formularios/Post");
    }
    else{
        form.setAttribute("method", "get");
        form.setAttribute("action", "/Formularios/Get");
    }
});