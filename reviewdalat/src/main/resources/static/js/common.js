function topNavResponsive() {
    var x = document.getElementById("header-top-nav");
    if (x.className === "top-nav") {
        x.className += " responsive";
    } else {
        x.className = "top-nav";
    }
}