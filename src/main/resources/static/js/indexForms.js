const postMethodOption = document.querySelector("input#postMethod"); // Select radio element for Method
const dataBindingOption = document.querySelector("input#dataBinding"); // Select radio element for Data Binding
const form = document.querySelector("form"); // Getting form element
postMethodOption.addEventListener("click", function (){
    if (this.checked){
        form.setAttribute("method", "post");
        form.setAttribute("action", "/Formularios/Post");
    }
    else{
        form.setAttribute("method", "get");
        form.setAttribute("action", "/Formularios/Get");
    }
});

dataBindingOption.addEventListener("click", function (){
    let action = form.attributes.action;
    if(this.checked){
        postMethodOption.checked = true;
        form.setAttribute("method", "post");
        form.setAttribute("action", "/DataBinding");
    }
    else{
        form.setAttribute("action", action); // FIND A WAY TO GET THE PREVIOUS ACTION ATTRIBUTE
    }
});