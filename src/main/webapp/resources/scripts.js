function collapse(menuNum) {
    const elements = document.getElementsByClassName('collapsible');
    let i;

    elements[menuNum].classList.toggle("active");
    const content = elements[menuNum].nextElementSibling;
    if (content.style.maxHeight) {
        content.style.maxHeight = null;
    } else {
        content.style.maxHeight = content.scrollHeight + "px";
    }

}