"use strict";

const categories = document.querySelector(".categories");
categories.addEventListener("click", (evt) => {
    const category = evt.target.closest(".category");
    if (!category) return;
    const categoryId = category.querySelector("p").innerText;
    window.location.href=`/category/${categoryId}`;
})

