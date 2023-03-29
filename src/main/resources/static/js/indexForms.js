const postMethod = document.querySelector("input#postMethod");
postMethod.addEventListener("click", function (){
    const forms = document.querySelectorAll("form");
    if (this.checked){
        forms[0].setAttribute("method", "post");
        forms[1].setAttribute("method", "post");
    }
    else{
        forms[0].setAttribute("method", "get");
        forms[1].setAttribute("method", "get");
    }
});