document.addEventListener('DOMContentLoaded', function() {
    const botonesBorrar = document.querySelectorAll('.borrar-btn');

    botonesBorrar.forEach(boton => {
        boton.addEventListener('click', function() {
            const socioId = this.getAttribute('data-socio-id');
            mostrarConfirmacion(socioId);
        });
    });
});

function mostrarConfirmacion(id) {
    document.getElementById("confirmacion-" + id).style.display = "block";
}

function ocultarConfirmacion(id) {
    document.getElementById("confirmacion-" + id).style.display = "none";
}

function confirmarBorrado(id) {
    fetch("/borrarSocio/" + id, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        }
    })
    .then(response => {
        if (response.ok) {
            window.location.href = "/admin/sociosAdmin";
        } else {
            console.error("Error al borrar el socio");
        }
    })
    .catch(error => {
        console.error("Error al realizar la solicitud:", error);
    });
}