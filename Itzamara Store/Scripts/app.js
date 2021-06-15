const sign_in_btn = document.querySelector("#sing-in-btn");
const sign_up_btn = document.querySelector("#sing-up-btn");
const container = document.querySelector(".container");

sign_up_btn.addEventListener('click', () => {
    container.classList.add("sign_up_mode");

});

sign_in_btn.addEventListener('click', () => {
    container.classList.remove("sign_up_mode");
});