document.getElementById('togglePassword').addEventListener('pointerover', function () {
    let contraseniaInput = document.getElementById('password');
    if (contraseniaInput.type === 'password') {
        contraseniaInput.type = 'text';
    } else {
        contraseniaInput.type = 'password';
    }
});


function validateForm() {
    let inputs = document.querySelectorAll('input[type="text"], input[type="email"], input[type="password"], input[type="date"]');
    let valid = true;

  
    let dniPattern = /^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$/i;

    // Verifica cada campo del formulario
    inputs.forEach(function(input) {
        if (input.value.trim() === '') {
            valid = false;
            input.classList.add('is-invalid');  // Agrega una clase para marcar el campo como inválido
        } else {
            input.classList.remove('is-invalid');
        }

      

        // Validación específica para DNI
        if (input.name === 'dni' && !dniPattern.test(input.value)) {
            valid = false;
            input.classList.add('is-invalid');
        }
    });

    // Verifica que las contraseñas coincidan
    let password = document.querySelector('[name="password"]').value;
    let repeatPassword = document.querySelector('[name="repeatPassword"]').value;

    if (password !== repeatPassword) {
        valid = false;
        document.querySelector('[name="password"]').classList.add('is-invalid');
        document.querySelector('[name="repeatPassword"]').classList.add('is-invalid');
        alert("Las contraseñas no coinciden. Por favor, inténtalo de nuevo.");
    } else {
        document.querySelector('[name="password"]').classList.remove('is-invalid');
        document.querySelector('[name="repeatPassword"]').classList.remove('is-invalid');
    }

    if (!valid) {
        alert("Por favor, completa todos los campos y asegúrate de que el correo electrónico y el DNI tengan un formato válido.");
    }

    return valid;
}