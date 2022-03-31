window.scroll({
        top: 2500,
        left: 0,
        behavior: "smooth",
    });
    window.scrollBy({
        top: 100,
        left: 0,
        behavior: "smooth",
    });
window.onload=function(){
        
    const tagglebtn = document.querySelector(".toggle-button");
    const navlink = document.querySelector(".navlink");

    tagglebtn.addEventListener("click", () => {
        navlink.classList.toggle("active");
        tagglebtn.classList.toggle("active");
        
    })
}
