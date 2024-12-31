window.addEventListener("scroll", () => {
  const header = document.getElementById("main-header");

  if (window.scrollY >= 150) {
    if (!header.classList.contains("colored")) header.classList.add("colored");
  } else {
    if (header.classList.contains("colored"))
      header.classList.remove("colored");
  }
});
