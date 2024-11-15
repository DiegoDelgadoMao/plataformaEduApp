const API_URL = "http://localhost:9001/api/estudiantes";
const API_USUARIOS_URL = "http://localhost:9001/api/usuarios";

// Cargar lista de estudiantes al cargar la página
$(document).ready(function () {
    cargarEstudiantes();
    cargarUsuarios(); // Nueva función para cargar usuarios en el select

    // Guardar estudiante (crear o actualizar)
    $("#btnGuardar").click(function () {
        const estudianteId = $("#estudianteId").val();
        const usuarioId = $("#usuarioId").val();
        const grado = $("#grado").val();

        const estudiante = {
            usuario: { id: usuarioId },
            grado: grado
        };

        if (estudianteId) {
            actualizarEstudiante(estudianteId, estudiante);
        } else {
            crearEstudiante(estudiante);
        }
    });

    // Limpiar el formulario
    $("#btnLimpiar").click(function () {
        limpiarFormulario();
    });
});
// Función para cargar todos los usuarios en el campo de selección
function cargarUsuarios() {
    $.ajax({
        url: API_USUARIOS_URL,
        type: "GET",
        success: function (usuarios) {
            $("#usuarioId").empty().append('<option value="">Seleccione un usuario</option>');
            usuarios.forEach(usuario => {
                $("#usuarioId").append(`
                    <option value="${usuario.id}">${usuario.nombre}</option>
                `);
            });
        },
        error: function (xhr) {
            alert("Error al cargar usuarios: " + xhr.responseText);
        }
    });
}

// Función para cargar todos los estudiantes
function cargarEstudiantes() {
    $.ajax({
        url: API_URL,
        type: "GET",
        success: function (estudiantes) {
            $("#estudiantesList").empty();
            estudiantes.forEach(estudiante => {
                $("#estudiantesList").append(`
                    <li class="list-group-item">
                        ID: ${estudiante.id} - Grado: ${estudiante.grado}
                        <button class="btn btn-sm btn-info mx-2" onclick="obtenerEstudiante(${estudiante.id})">Editar</button>
                        <button class="btn btn-sm btn-danger" onclick="eliminarEstudiante(${estudiante.id})">Eliminar</button>
                    </li>
                `);
            });
        },
        error: function (xhr) {
            console.error("Error al cargar estudiantes: ", xhr.responseText);
            alert("Error al cargar estudiantes: " + xhr.responseText);
        }
    });
}

// Función para crear un estudiante
function crearEstudiante(estudiante) {
    $.ajax({
        url: API_URL,
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(estudiante),
        success: function () {
            alert("Estudiante creado correctamente");
            cargarEstudiantes();
            limpiarFormulario();
        },
        error: function (xhr) {
            alert("Error al crear estudiante: " + xhr.responseText);
        }
    });
}

// Función para obtener un estudiante por ID y llenar el formulario para editar
function obtenerEstudiante(id) {
    $.ajax({
        url: `${API_URL}/${id}`,
        type: "GET",
        success: function (estudiante) {
            $("#estudianteId").val(estudiante.id);
            $("#usuarioId").val(estudiante.usuario.id);
            $("#grado").val(estudiante.grado);
        },
        error: function (xhr) {
            alert("Error al obtener estudiante: " + xhr.responseText);
        }
    });
}

// Función para actualizar un estudiante
function actualizarEstudiante(id, estudiante) {
    $.ajax({
        url: `${API_URL}/${id}`,
        type: "PUT",
        contentType: "application/json",
        data: JSON.stringify(estudiante),
        success: function () {
            alert("Estudiante actualizado correctamente");
            cargarEstudiantes();
            limpiarFormulario();
        },
        error: function (xhr) {
            alert("Error al actualizar estudiante: " + xhr.responseText);
        }
    });
}

// Función para eliminar un estudiante
function eliminarEstudiante(id) {
    if (confirm("¿Está seguro de eliminar este estudiante?")) {
        $.ajax({
            url: `${API_URL}/${id}`,
            type: "DELETE",
            success: function () {
                alert("Estudiante eliminado correctamente");
                cargarEstudiantes();
            },
            error: function (xhr) {
                alert("Error al eliminar estudiante: " + xhr.responseText);
            }
        });
    }
}

// Función para limpiar el formulario
function limpiarFormulario() {
    $("#estudianteId").val("");
    $("#usuarioId").val("");
    $("#grado").val("");
}
