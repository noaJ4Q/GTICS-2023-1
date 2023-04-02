const postMethodOption = document.querySelector("input#postMethod");
const dataBindingOption = document.querySelector("input#dataBinding");
const form = document.querySelector("form");

postMethodOption.addEventListener("click", function (){
    if(this.checked){
        form.setAttribute("action", "/Formularios/Post");
        form.setAttribute("method", "post");
    }
    else{
        if(dataBindingOption.checked){
            dataBindingOption.checked = false;
            form.setAttribute("action", "/Formularios/Get");
            form.setAttribute("method", "get");
        }
        else{
            form.setAttribute("action", "/Formularios/Get");
            form.setAttribute("method", "get");
        }
    }
});

dataBindingOption.addEventListener("click", function (){
    if(this.checked){
        if(postMethodOption.checked){
            form.setAttribute("action", "/Formularios/DataBinding");
        }
        else{
            postMethodOption.checked = true;
            form.setAttribute("action", "/Formularios/DataBinding");
            form.setAttribute("method", "post");
        }
    }
    else{
        postMethodOption.checked = false;
        form.setAttribute("action", "/Formularios/Get");
        form.setAttribute("method", "get");
    }
});

// TRY TO FIND A WAY TO SCALE THIS SET OF CHECKBOXES FOR N CHECKBOXES