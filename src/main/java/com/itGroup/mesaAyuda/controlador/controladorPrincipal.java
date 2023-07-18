/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.itGroup.mesaAyuda.controlador;

import com.google.gson.Gson;
import com.itGroup.mesaAyuda.modelo.AreaCliente;
import com.itGroup.mesaAyuda.modelo.CategoriaTicket;
import com.itGroup.mesaAyuda.modelo.Cliente;
import com.itGroup.mesaAyuda.modelo.EstadoTicket;
import com.itGroup.mesaAyuda.modelo.EstadoUsu;
import com.itGroup.mesaAyuda.modelo.Ticket;
import com.itGroup.mesaAyuda.modelo.TipoUsuario;
import com.itGroup.mesaAyuda.modelo.UrgenciaTicket;
import com.itGroup.mesaAyuda.modelo.Usuario;
import com.itGroup.mesaAyuda.servicio.areaClienteServicio;
import com.itGroup.mesaAyuda.servicio.categoriaTicketServicio;
import com.itGroup.mesaAyuda.servicio.clienteServicio;
import com.itGroup.mesaAyuda.servicio.estadoTicketServicio;
import com.itGroup.mesaAyuda.servicio.estadoUsuServicio;
import com.itGroup.mesaAyuda.servicio.ticketServicio;
import com.itGroup.mesaAyuda.servicio.tipoUsuarioServicio;
import com.itGroup.mesaAyuda.servicio.urgenciaTicketServicio;
import com.itGroup.mesaAyuda.servicio.usuarioServicio;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class controladorPrincipal {

    @Autowired
    ticketServicio ticketservicio;

    @Autowired
    clienteServicio clienteservicio;

    @Autowired
    categoriaTicketServicio categoriaticketServicio;

    @Autowired
    usuarioServicio usuarioservicio;

    @Autowired
    urgenciaTicketServicio urgenciaticketServicio;

    @Autowired
    estadoTicketServicio estadoticketServicio;

    @Autowired
    areaClienteServicio areaclienteServicio;

    @Autowired
    tipoUsuarioServicio tipousuarioServicio;

    @Autowired
    estadoUsuServicio estadousuServicio;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping("/paginaPrincipal")
    public String pagePrincipal() {
        return "index";
    }

    @RequestMapping("/paginaTickets")
    public String paginaTickets() {
        return "/tickets/tickets";
    }

    @RequestMapping("/nuevoTicket")
    public String paginaNuevoTickets(Model model, Ticket ticket) {

        //Clientes
        List<Cliente> clientes = clienteservicio.listar();
        model.addAttribute("clientes", clientes);

        //categoria
        List<CategoriaTicket> categorias = categoriaticketServicio.listar();
        model.addAttribute("categorias", categorias);

        //Usuario
        List<Usuario> usuarios = usuarioservicio.listar();
        model.addAttribute("usuarios", usuarios);
        //Urgencia
        List<UrgenciaTicket> prioridad = urgenciaticketServicio.listar();
        model.addAttribute("prioridad", prioridad);

        //Estado Ticket
        List<EstadoTicket> estados = estadoticketServicio.listar();
        model.addAttribute("estados", estados);

        //Id tipo usuario
        List<TipoUsuario> tipos = tipousuarioServicio.listar();
        model.addAttribute("tipos", tipos);

        return "/tickets/crearModificarTicket";
    }

    @RequestMapping("/guardarTicket")
    public String guardarTicket(Model model, Ticket ticket) {

        if (ticket.getIdTicket() == null) {
            ticket.setNumeroTicket("TXX");
            ticketservicio.guardar(ticket);
            ticket.setNumeroTicket("T00" + ticket.getIdTicket());
            ticketservicio.guardar(ticket);

            Ticket ticketcorreo = ticketservicio.buscar(ticket);
            
            
            // Crear una instancia de Gson
            Gson gson = new Gson();

            // Convertir tuObjeto a una cadena de texto en formato JSON
            String json = gson.toJson(ticketcorreo);

            // Llamar al servicio enviarCorreo en el puerto 8001
            String url = "http://localhost:8001/enviarCorreo";
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, json, String.class);
            // Manejar la respuesta recibida del servicio enviarCorreo
            String responseBody = responseEntity.getBody();
            System.out.println(responseBody);

        } else {
            ticket.setNumeroTicket("T00" + ticket.getIdTicket());
            ticketservicio.guardar(ticket);

            Ticket ticketcorreo = ticketservicio.buscar(ticket);

            // Llamar al servicio enviarCorreo en el puerto 8001
            String url = "http://localhost:8001/enviarCorreo";
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, ticketcorreo, String.class);
            // Manejar la respuesta recibida del servicio enviarCorreo
            String responseBody = responseEntity.getBody();
            System.out.println(responseBody);

        }

        return "redirect:paginaTickets";
    }

    @RequestMapping("/modificarTicket")
    public String modificarTicket(@RequestParam("id") Integer ticketId, Model model, Ticket ticket) {

        //Clientes
        List<Cliente> clientes = clienteservicio.listar();
        model.addAttribute("clientes", clientes);

        //categoria
        List<CategoriaTicket> categorias = categoriaticketServicio.listar();
        model.addAttribute("categorias", categorias);

        //Usuario
        List<Usuario> usuarios = usuarioservicio.listar();
        model.addAttribute("usuarios", usuarios);
        //Urgencia
        List<UrgenciaTicket> prioridad = urgenciaticketServicio.listar();
        model.addAttribute("prioridad", prioridad);

        //Estado Ticket
        List<EstadoTicket> estados = estadoticketServicio.listar();
        model.addAttribute("estados", estados);

        // Obtener información del ticket que deseas modificar utilizando el ID recibido
        ticket = ticketservicio.buscar(ticketId);
        
        //Id tipo usuario
        List<TipoUsuario> tipos = tipousuarioServicio.listar();
        model.addAttribute("tipos", tipos);

        // Agregar el JSON al modelo para enviarlo a la vista
        model.addAttribute("ticket", ticket);

        return "/tickets/crearModificarTicket";
    }

    @RequestMapping("/paginaClientes")
    public String paginaClientes() {
        return "/clientes/clientes";
    }

    @RequestMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente, Model model) {

        //Area Cliente
        List<AreaCliente> areas = areaclienteServicio.listar();
        model.addAttribute("areas", areas);

        return "/clientes/crearModificarCliente";
    }

    @RequestMapping("/modificarCliente")
    public String modificarClientes(@RequestParam("id") Integer idCliente, Model model, Cliente cliente) {

        //Area Cliente
        List<AreaCliente> areas = areaclienteServicio.listar();
        model.addAttribute("areas", areas);

        // Obtener información del ticket que deseas modificar utilizando el ID recibido
        cliente = clienteservicio.buscar(idCliente);

        // Agregar el JSON al modelo para enviarlo a la vista
        model.addAttribute("cliente", cliente);

        return "/clientes/crearModificarCliente";
    }

    @RequestMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente, Model model) {

        if (cliente.getIdCliente() == null) {

            cliente.setFechaRegCli(new Date());
            clienteservicio.guardar(cliente);

        } else {
            Date fechaCliente = clienteservicio.buscar(cliente).getFechaRegCli();
            cliente.setFechaRegCli(fechaCliente);
            clienteservicio.guardar(cliente);
        }

        return "redirect:paginaClientes";
    }

    @RequestMapping("/paginaTipos")
    public String paginaTipos() {
        return "/servicios/tipos";
    }

    @RequestMapping("/paginaServicios")
    public String paginaServicios() {
        return "/servicios/servicios";
    }

    @RequestMapping("/paginaUsuarios")
    public String paginaUsuarios() {
        return "/usuarios/usuarios";
    }

    @RequestMapping("/nuevoUsuario")
    public String nuevoUsuario(Usuario usuario, Model model) {

        //Estado usuario EstadoUsu idEstadoUsu
        List<EstadoUsu> estados = estadousuServicio.listar();
        model.addAttribute("estados", estados);

        List<TipoUsuario> tiposUsuarios = tipousuarioServicio.listar();
        model.addAttribute("tiposUsuarios", tiposUsuarios);

        return "/usuarios/CrearModificarusuario";
    }

    @RequestMapping("/modificarUsuario")
    public String modificarUsuario(@RequestParam("id") Integer idUsuario, Model model, Usuario usuario) {

        //Estado usuario EstadoUsu idEstadoUsu
        List<EstadoUsu> estados = estadousuServicio.listar();
        model.addAttribute("estados", estados);

        List<TipoUsuario> tiposUsuarios = tipousuarioServicio.listar();
        model.addAttribute("tiposUsuarios", tiposUsuarios);

        // Obtener información del usuario que deseas modificar utilizando el ID recibido
        usuario = usuarioservicio.buscar(idUsuario);

        // Agregar el JSON al modelo para enviarlo a la vista
        model.addAttribute("usuario", usuario);

        return "/usuarios/CrearModificarusuario";
    }

    @RequestMapping("/guardarUsuario")
    public String guardarUsuario(Usuario usuario, Model model) {

        if (usuario.getIdUsuario() == null) {

            usuario.setFechaRegUsu(new Date());
            usuario.setUsuario(usuario.getCorreoUsu());
            usuarioservicio.guardar(usuario);

        } else {
            Date fechaUsuario = usuarioservicio.buscar(usuario).getFechaRegUsu();
            String usuarioString = usuarioservicio.buscar(usuario).getCorreoUsu();
            usuario.setFechaRegUsu(fechaUsuario);
            usuario.setUsuario(usuarioString);

            usuarioservicio.guardar(usuario);
        }

        return "redirect:paginaUsuarios";
    }

    @RequestMapping("/paginaMicuenta")
    public String paginaMicuenta() {
        return "/usuarios/mi_cuenta";
    }

}
