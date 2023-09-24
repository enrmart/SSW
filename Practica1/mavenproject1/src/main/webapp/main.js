document.querySelector('.barras').addEventListener('click', () => {
    document.querySelector('.navMenu').classList.toggle('show');
    
});

ScrollReveal().reveal('.showcase');
ScrollReveal().reveal('.newsCards', {delay : 300});
ScrollReveal().reveal('.cards-banner1', {delay : 300});
ScrollReveal().reveal('.cards-banner2', {delay : 300});
ScrollReveal().reveal('.social', {delay : 300});
ScrollReveal().reveal('.footer', {delay : 300});