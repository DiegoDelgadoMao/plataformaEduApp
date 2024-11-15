// assets/js/services/api.js
const BASE_URL = "http://localhost:9001/api";

const apiCall = async (endpoint, method = "GET", data = null) => {
    const options = {
        method,
        headers: { "Content-Type": "application/json" }
    };
    if (data) options.body = JSON.stringify(data);
    const response = await fetch(`${BASE_URL}/${endpoint}`, options);
    return response.json();
};
$(document).ready(function () {
    // Verificar si el usuario está autenticado
    if (!sessionStorage.getItem('isLoggedIn')) {
        // Redirigir al login si no está autenticado
        window.location.href = 'login.html';
    }
});
