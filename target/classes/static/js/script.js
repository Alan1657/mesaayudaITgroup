function validateLogin(event) {
    event.preventDefault();

    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    // Realizar solicitud GET al endpoint correspondiente
    fetch('/usuario/username/' + username)
            .then(response => response.json())
            .then(usuario => {
                if (usuario && usuario.password === password) {
                    // Usuario y contraseña válidos
                    window.location.href = "/paginaPrincipal";
                    localStorage.setItem('username', username);
                    localStorage.setItem('nombres', usuario.nombreUsu + " " + usuario.apellidoUsu);
                } else {
                    // Usuario o contraseña incorrectos
                    alert("Nombre de usuario o contraseña incorrectos");
                }
            })
            .catch(error => {
                console.error("Error al consultar el usuario:", error);
            });
}

function logout() {
    window.location.href = "/"; // Redirige al archivo login.html
}

// llenar información de inicio

function datosLogin() {
    var nombres = localStorage.getItem('nombres');
    var username = localStorage.getItem('username');

    document.getElementById("username").innerHTML = nombres;
    document.getElementById("nombres").innerHTML = nombres;

    document.getElementById("user").innerHTML = username;

}

//generar las tablas de inicio

// Tablas tickets

async function fetchTableTickets() {
    try {
        const response = await fetch('/ticket', {
            method: 'GET'
        });
        const data = await response.json();

        const tableBody = document.querySelector('#ticket-table tbody');

        data.forEach((row) => {

            const newRow = document.createElement('tr');

            const idTicket = document.createElement('td');
            const numeroTicket = document.createElement('td');
            const fechaRegTicket = document.createElement('td');
            const idCategoria = document.createElement('td');
            const idCliente = document.createElement('td');
            ;
            const idUrgencia = document.createElement('td');
            const idEstado = document.createElement('td');

            const actionsCell = document.createElement('td');

            idTicket.textContent = row.idTicket;
            numeroTicket.textContent = row.numeroTicket;
            fechaRegTicket.textContent = row.fechaRegTicket;
            idCategoria.textContent = row.idCategoria.nombreCat;
            idCliente.textContent = row.idCliente.nombreCli + " " + row.idCliente.apellidoCli;
            idUrgencia.textContent = row.idUrgencia.urgencia;
            idEstado.textContent = row.idEstado.estado;

            const editButton = document.createElement('button');
            editButton.textContent = 'Modificar';
            editButton.className = 'btn btn-primary btn-sm mr-2';
            editButton.addEventListener('click', () => {
                // Lógica para redirigir a la página de edición del ticket
                window.location.href = `/modificarTicket?id=${row.idTicket}`;
            });

            const deleteButton = document.createElement('button');
            deleteButton.textContent = 'Eliminar';
            deleteButton.className = 'btn btn-danger btn-sm';
            deleteButton.addEventListener('click', async () => {
                // Lógica para eliminar el registro
                if (confirm('¿Estás seguro de que deseas eliminar este ticket?')) {
                    try {
                        const response = await fetch(`/ticket/${row.idTicket}`, {
                            method: 'DELETE'
                        });
                        if (response.ok) {
                            // Eliminar la fila de la tabla
                            newRow.remove();
                            console.log('Ticket eliminado con éxito.');
                        } else {
                            console.log('Error al eliminar el ticket:', response.statusText);
                        }
                    } catch (error) {
                        console.log('Error al eliminar el ticket:', error);
                    }
                }
            });

            actionsCell.appendChild(editButton);
            actionsCell.appendChild(deleteButton);

            newRow.appendChild(idTicket);
            newRow.appendChild(numeroTicket);
            newRow.appendChild(fechaRegTicket);
            newRow.appendChild(idCategoria);
            newRow.appendChild(idCliente);
            newRow.appendChild(idUrgencia);
            newRow.appendChild(idEstado);

            newRow.appendChild(actionsCell);

            tableBody.appendChild(newRow);
        });
    } catch (error) {
        console.log('Error al obtener los datos:', error);
    }
}

// Tabla de clientes
async function fetchTableClientes() {
    try {
        const response = await fetch('/cliente', {
            method: 'GET'
        });
        const data = await response.json();

        const tableBody = document.querySelector('#clientes-table tbody');

        data.forEach((row) => {

            const newRow = document.createElement('tr');

            const idCliente = document.createElement('td');
            const nombreCli = document.createElement('td');
            const telefono = document.createElement('td');
            const correo = document.createElement('td');
            const idArea = document.createElement('td');
            const dnicli = document.createElement('td');

            const actionsCell = document.createElement('td');

            idCliente.textContent = row.idCliente;
            nombreCli.textContent = row.nombreCli + " " + row.apellidoCli;
            telefono.textContent = row.telefono;
            correo.textContent = row.correo;
            idArea.textContent = row.idArea.nombreArea;
            dnicli.textContent = row.dnicli;

            const editButton = document.createElement('button');
            editButton.textContent = 'Modificar';
            editButton.className = 'btn btn-primary btn-sm mr-2';
            editButton.addEventListener('click', () => {
                // Lógica para redirigir a la página de edición del ticket
                window.location.href = `/modificarCliente?id=${row.idCliente}`;
            });

            const deleteButton = document.createElement('button');
            deleteButton.textContent = 'Eliminar';
            deleteButton.className = 'btn btn-danger btn-sm';
            deleteButton.addEventListener('click', async () => {
                // Lógica para eliminar el registro
                if (confirm('¿Estás seguro de que deseas eliminar este cliente?')) {
                    try {
                        const response = await fetch(`/cliente/${row.idCliente}`, {
                            method: 'DELETE'
                        });
                        if (response.ok) {
                            // Eliminar la fila de la tabla
                            newRow.remove();
                            console.log('cliente eliminado con éxito.');
                        } else {
                            console.log('Error al eliminar el cliente:', response.statusText);
                        }
                    } catch (error) {
                        console.log('Error al eliminar el cliente:', error);
                    }
                }
            });

            actionsCell.appendChild(editButton);
            actionsCell.appendChild(deleteButton);

            newRow.appendChild(idCliente);
            newRow.appendChild(nombreCli);
            newRow.appendChild(telefono);
            newRow.appendChild(correo);
            newRow.appendChild(idArea);
            newRow.appendChild(dnicli);

            newRow.appendChild(actionsCell);

            tableBody.appendChild(newRow);
        });
    } catch (error) {
        console.log('Error al obtener los datos:', error);
    }
}

// Tabla de usuarios

async function fetchTableUsuarios() {
    try {
        const response = await fetch('/usuario', {
            method: 'GET'
        });
        const data = await response.json();

        const tableBody = document.querySelector('#usuarios-table tbody');

        data.forEach((row) => {

            const newRow = document.createElement('tr');

            const idUsuario = document.createElement('td');
            const nombreUsu = document.createElement('td');
            const telefonoUsu = document.createElement('td');
            const correoUsu = document.createElement('td');
            const tipoUsuarioList = document.createElement('td');
            const idEstadoUsu = document.createElement('td');

            const actionsCell = document.createElement('td');

            idUsuario.textContent = row.idUsuario;
            nombreUsu.textContent = row.nombreUsu + " " + row.apellidoUsu;
            telefonoUsu.textContent = row.telefonoUsu;
            correoUsu.textContent = row.correoUsu;
            if (row.tipoUsuarioList[0] == null) {
                tipoUsuarioList.textContent = "";
            } else {
                tipoUsuarioList.textContent = row.tipoUsuarioList[0].tipo;
            }
            if (row.tipoUsuarioList[1] == null) {
                tipoUsuarioList.textContent = tipoUsuarioList.textContent + "";
            } else {
                tipoUsuarioList.textContent = tipoUsuarioList.textContent + "-" + row.tipoUsuarioList[1].tipo;
            }

            idEstadoUsu.textContent = row.idEstadoUsu.estadoUsu;

            const editButton = document.createElement('button');
            editButton.textContent = 'Modificar';
            editButton.className = 'btn btn-primary btn-sm mr-2';
            editButton.addEventListener('click', () => {
                // Lógica para redirigir a la página de edición del ticket
                window.location.href = `/modificarUsuario?id=${row.idUsuario}`;
            });

            const deleteButton = document.createElement('button');
            deleteButton.textContent = 'Eliminar';
            deleteButton.className = 'btn btn-danger btn-sm';
            deleteButton.addEventListener('click', async () => {
                // Lógica para eliminar el registro
                if (confirm('¿Estás seguro de que deseas eliminar este usuario?')) {
                    try {
                        const response = await fetch(`/usuario/${row.idUsuario}`, {
                            method: 'DELETE'
                        });
                        if (response.ok) {
                            // Eliminar la fila de la tabla
                            newRow.remove();
                            console.log('usuario eliminado con éxito.');
                        } else {
                            console.log('Error al eliminar el usuario:', response.statusText);
                        }
                    } catch (error) {
                        console.log('Error al eliminar el usuario:', error);
                    }
                }
            });

            actionsCell.appendChild(editButton);
            actionsCell.appendChild(deleteButton);

            newRow.appendChild(idUsuario);
            newRow.appendChild(nombreUsu);
            newRow.appendChild(telefonoUsu);
            newRow.appendChild(correoUsu);
            newRow.appendChild(tipoUsuarioList);
            newRow.appendChild(idEstadoUsu);

            newRow.appendChild(actionsCell);

            tableBody.appendChild(newRow);
        });
    } catch (error) {
        console.log('Error al obtener los datos:', error);
    }
}

async function fetchServicioUrgencia(idCategoria, idCliente) {

        try {
        const response = await fetch(`/serviciourgencia/${idCliente}/${idCategoria}`, {
            method: 'GET'
        });
        const data = await response.json();
        
        document.getElementById('idUrgencia').value=data.idUrgencia;

    } catch (error) {
        console.log('Error al realizar el servicio de urgencia:', error);
    }

}


// Función que se ejecutará cuando cambie la categoría o el usuario
function handleCategoryUserChange() {
    const idCategoria = document.getElementById('idCategoria').value;
    const idCliente = document.getElementById('idCliente').value;
    fetchServicioUrgencia(idCategoria, idCliente);
   }

// Evento que se dispara cuando cambia la categoría
document.getElementById('idCategoria').addEventListener('change', handleCategoryUserChange);

// Evento que se dispara cuando cambia el usuario
document.getElementById('idCliente').addEventListener('change', handleCategoryUserChange);

// Función para observar los cambios en el elemento idUrgencia
function observeIdUrgencia() {
  var idUrgenciaElement = document.getElementById('idUrgencia');

  var observer = new MutationObserver(function() {
    handleCategoryUrgenciaChange();
  });

  var config = { attributes: true, childList: true, subtree: true };
  observer.observe(idUrgenciaElement, config);
}

// Función que se ejecutará cuando cambie la categoría o el usuario
function handleCategoryUrgenciaChange() {
    const idCategoria = document.getElementById('idCategoria').value;
    const idUrgencia = document.getElementById('idUrgencia').value;
    fetchServicioDerivación(idUrgencia,idCategoria);
}

async function fetchServicioDerivación(idUrgencia,idCategoriaTicket) {

    try {
        const response = await fetch(`/servicioderivacion/${idCategoriaTicket}/${idUrgencia}`, {
            method: 'GET'
        }); 
        const data = await response.json();
        
        document.getElementById('idTipoUs').value=data.idTipoUs;

    } catch (error) {
        console.log('Error al realizar el servicio de urgencia:', error);
    }

}

// Evento que se dispara cuando cambia el usuario
document.getElementById('idUrgencia').addEventListener('change', handleCategoryUrgenciaChange);

// Evento que se dispara cuando cambia el usuario
document.getElementById('idCategoria').addEventListener('change', handleCategoryUrgenciaChange);

// Evento que se dispara cuando cambia el usuario
document.getElementById('idCliente').addEventListener('change', handleCategoryUrgenciaChange);






