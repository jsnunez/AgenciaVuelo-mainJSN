package com.agencia.menu.infraestructure;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.agencia.cliente.aplication.CreateClienteCase;
import com.agencia.cliente.aplication.DeleteClienteCase;
import com.agencia.cliente.aplication.FindClienteCase;
import com.agencia.cliente.aplication.UpdateClienteCase;
import com.agencia.cliente.domain.service.ClienteService;
import com.agencia.cliente.infrastructure.in.ClienteController;
import com.agencia.cliente.infrastructure.out.ClienteRepository;
import com.agencia.escala.application.FindEscalaUseCase;
import com.agencia.escala.domain.service.EscalaService;
import com.agencia.escala.infraestructure.EscalaController;
import com.agencia.escala.infraestructure.EscalaRepository;
import com.agencia.menu.domain.Service.entity.User;
import com.agencia.reserva.application.AsignarsillaUseCase;
import com.agencia.reserva.application.BuscarCiudades;
import com.agencia.reserva.application.BuscarSillasOcupadas;
import com.agencia.reserva.application.BuscarTiposDocumentos;
import com.agencia.reserva.application.BuscarvuelosUseCase;
import com.agencia.reserva.application.CancelReservaClienteUseCase;
import com.agencia.reserva.application.ConsultaPrecioUseCase;
import com.agencia.reserva.application.ConsultvueloUseCase;
import com.agencia.reserva.application.CrearReservaDetalleUseCase;
import com.agencia.reserva.application.CrearReservaUseCase;
import com.agencia.reserva.application.CreateReservaAgenteUseCase;
import com.agencia.reserva.application.DeleteDetalleReserva;
import com.agencia.reserva.application.DeleteReservaAgenteUseCase;
import com.agencia.reserva.application.EliminarAsientoPorPagoUseCase;
import com.agencia.reserva.application.FindReservaAgenteUseCase;
import com.agencia.reserva.application.PagoUseCase;
import com.agencia.reserva.application.VerificarPasajero;
import com.agencia.reserva.domain.service.ReservaServiceOlf;
import com.agencia.reserva.domain.service.vueloService;
import com.agencia.reserva.infraestructure.in.ReservaController;
import com.agencia.reserva.infraestructure.in.vueloController;
import com.agencia.reserva.infraestructure.out.ReservaRepository;
import com.agencia.reserva.infraestructure.out.vueloRepository;
import com.agencia.tarifa.application.FindTarifaUseCase;
import com.agencia.tarifa.domain.service.TarifaService;
import com.agencia.tarifa.infraestructure.in.TarifaController;
import com.agencia.tarifa.infraestructure.out.TarifaRepository;
import com.agencia.tipoDocumento.application.FindTipoDocumentoUseCase;
import com.agencia.tipoDocumento.domain.entity.TipoDocumento;
import com.agencia.tipoDocumento.domain.service.TipoDocumentoService;
import com.agencia.tipoDocumento.infraestructure.TipoDocumentoController;
import com.agencia.tipoDocumento.infraestructure.TipoDocumentoRepository;
import com.agencia.tripulacion.application.FindTripulacionUseCase;
import com.agencia.tripulacion.domain.service.TripulacionService;
import com.agencia.tripulacion.infraestructure.TripulacionController;
import com.agencia.tripulacion.infraestructure.TripulacionRepository;

public class menuUI {

    private final BuscarTiposDocumentos buscarTiposDocumentos;
    private final com.agencia.menu.application.iniciarsesion iniciarsesion;

    public menuUI(BuscarTiposDocumentos buscarTiposDocumentos,
            com.agencia.menu.application.iniciarsesion iniciarsesion) {
        this.buscarTiposDocumentos = buscarTiposDocumentos;
        this.iniciarsesion = iniciarsesion;
    }

    public void menu() throws SQLException {
        int ventana = 1;
        while (ventana != 0) {

            String tipoUser = mostrarMenu();
            User usuario = menuInicio();
            if (tipoUser == "Cliente") {

                usuario.setTipoUser("Cliente");
                usuario = iniciarsesion.execute(usuario);
                if (usuario.getNombre() == null) {
                    System.out.println("error incio sesion");
                    JOptionPane.showMessageDialog(null, "usuario y contraseña incorrecta");

                    continue;
                }
                mostrarUsuario(usuario);

                int opcionCliente = menuCliente();
                System.out.println(opcionCliente);
                switch (opcionCliente) {
                    case 1:// "Buscar Vuelos"
                        EscalaRepository escalaRepository = new EscalaRepository();
                        vueloService vueloService = new vueloRepository();
                        ReservaRepository reservaRepository = new ReservaRepository();
                        FindEscalaUseCase findEscalaUseCase = new FindEscalaUseCase(escalaRepository);
                        ConsultvueloUseCase consultvueloUseCase = new ConsultvueloUseCase(vueloService);
                        BuscarCiudades buscarCiudades = new BuscarCiudades(vueloService);
                        BuscarvuelosUseCase buscarvuelosUseCase = new BuscarvuelosUseCase(vueloService);
                        CrearReservaUseCase crearReservaUseCase = new CrearReservaUseCase(vueloService);
                        VerificarPasajero verificarPasajero = new VerificarPasajero(vueloService);
                        DeleteReservaAgenteUseCase deleteReservaAgenteUseCase = new DeleteReservaAgenteUseCase(
                                reservaRepository);
                        DeleteDetalleReserva deleteDetalleReserva = new DeleteDetalleReserva(reservaRepository);
                        EliminarAsientoPorPagoUseCase eliminarAsientoPorPagoUseCase = new EliminarAsientoPorPagoUseCase(
                                vueloService);
                        PagoUseCase pagoUseCase=new PagoUseCase(vueloService);
                        ConsultaPrecioUseCase consultaPrecioUseCase=new ConsultaPrecioUseCase(vueloService);

                        // BuscarTiposDocumentos buscarTiposDocumentos = new
                        // BuscarTiposDocumentos(vueloService);
                        AsignarsillaUseCase asignarSillaUseCase = new AsignarsillaUseCase(vueloService);
                        CrearReservaDetalleUseCase crearReservaDetalleUseCase = new CrearReservaDetalleUseCase(
                                vueloService);
                        BuscarSillasOcupadas buscarSillasOcupadas = new BuscarSillasOcupadas(vueloService);

                        vueloController consoleAdapterVuelo = new vueloController(consultvueloUseCase, buscarCiudades,
                                buscarvuelosUseCase, crearReservaUseCase, verificarPasajero, buscarTiposDocumentos,
                                findEscalaUseCase, crearReservaDetalleUseCase, asignarSillaUseCase,
                                buscarSillasOcupadas,
                                deleteReservaAgenteUseCase, deleteDetalleReserva, eliminarAsientoPorPagoUseCase, consultaPrecioUseCase,pagoUseCase);
                        consoleAdapterVuelo.buscar();
                        break;
                    case 2:// "Consultar Reserva de Vuelo"
                        reservaRepository = new ReservaRepository();

                        CreateReservaAgenteUseCase createReservaAgenteUseCase = new CreateReservaAgenteUseCase(
                                reservaRepository);
                        FindReservaAgenteUseCase findReservaAgenteUseCase = new FindReservaAgenteUseCase(
                                reservaRepository);
                        deleteReservaAgenteUseCase = new DeleteReservaAgenteUseCase(
                                reservaRepository);
                        CancelReservaClienteUseCase cancelReservaClienteUseCase = new CancelReservaClienteUseCase(
                                reservaRepository);
                        ReservaController reservaController = new ReservaController(createReservaAgenteUseCase,
                                findReservaAgenteUseCase,
                                deleteReservaAgenteUseCase, cancelReservaClienteUseCase);
                                reservaController.findReservaAgente();
                        break;
                    case 3:// "Cancelar Reserva de Vuelo

                        break;
                    case 4:// "Cancelar Reserva de Vuelo

                        break;
                    default:
                        break;
                }
            }
            if (tipoUser == "Empleado") {

                usuario.setTipoUser("Empleado");
                usuario = iniciarsesion.execute(usuario);
                System.out.println(usuario.getRol());
                if (usuario.getNombre() == null) {
                    System.out.println("error incio sesion");
                    JOptionPane.showMessageDialog(null, "usuario y contraseña incorrecta");

                    continue;
                }
                mostrarUsuario(usuario);

                if (usuario.getRol() == 3) {
                    int opcionAdmin = menuAdministrador();
                    System.out.println(opcionAdmin);
                    switch (opcionAdmin) {
                        case 1:
                            // registrarAvion();
                            break;
                        case 2:
                            // asignarTripulacionATrayecto();
                            break;
                        case 3:
                            // consultarInformacionAvion();
                            break;
                        case 4:
                            // consultarInformacionTrayecto();
                            break;
                        case 5:
                            // registrarAeropuerto();
                            break;
                        case 6:
                            // consultarInformacionAeropuerto();
                            break;
                        case 7:
                            // actualizarInformacionAvion();
                            break;
                        case 8:
                            // eliminarAvion();
                            break;
                        case 9:
                            // asignarAeronaveATrayecto();
                            break;
                        case 10:
                            // actualizarInformacionTrayecto();
                            break;
                        case 11:
                            // eliminarTrayecto();
                            break;
                        case 12:
                            // actualizarInformacionAeropuerto();
                            break;
                        case 13:
                            // eliminarAeropuerto();
                            break;
                        case 14:
                            // consultarInformacionVuelo();
                            break;
                        case 15:
                            // consultarAsignacionDeTripulacion();
                            break;
                        case 16:
                            // consultarEscalasDeUnTrayecto();
                            break;
                        case 17:
                            // actualizarInformacionEscala();
                            break;
                        case 18:
                            // eliminarEscala();
                            break;
                        case 19:
                            // registrarTarifaDeVuelo();
                            break;
                        case 20:
                            // actualizarInformacionTarifaDeVuelo();
                            break;
                        case 21:
                            // eliminarTarifaDeVuelo();
                            break;
                        case 22:
                            // consultarTarifaDeVuelo();
                            break;
                        case 23:
                            // registrarTipoDeDocumento();
                            break;
                        case 24:
                            // actualizarTipoDeDocumento();
                            break;
                        case 25:
                            // eliminarTipoDeDocumento();
                            break;
                        case 26:
                            // consultarTipoDeDocumento();
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }

                }
                if (usuario.getRol() == 4) {
                    int opcionAdmin = menuAgenteVentas();
                    System.out.println(opcionAdmin);
                    switch (opcionAdmin) {
                        case 1:
                            ReservaServiceOlf reservaServiceOlf= new ReservaRepository();
                            CreateReservaAgenteUseCase createReservaAgenteUseCase=new CreateReservaAgenteUseCase(reservaServiceOlf);
                            ReservaController reservaController=new ReservaController(createReservaAgenteUseCase, null, null, null);
                            reservaController.createReserva();                
                            break;
                        case 2:
                        ClienteService clienteService=new ClienteRepository();
                        FindClienteCase findClienteCase= new FindClienteCase(clienteService);
                        ClienteController findClienteController=new ClienteController(null, findClienteCase,null,null);
                        findClienteController.buscar();

                        
                        break;
                        case 3:
                        ReservaServiceOlf consultaService= new ReservaRepository();
                        FindReservaAgenteUseCase findReservaAgenteUseCase=new FindReservaAgenteUseCase(consultaService);
                        ReservaController reservaControllerConsulta=new ReservaController(null, findReservaAgenteUseCase, null, null);
                        reservaControllerConsulta.findReservaAgente();
                        break;

                        case 4:
                        //Registrar cliente
                        ClienteService crearClienteService = new ClienteRepository();
                        CreateClienteCase createClienteCase= new CreateClienteCase(crearClienteService);
                        ClienteController clienteControllerCrear=new ClienteController(createClienteCase,null,null,null);
                        clienteControllerCrear.crear();                                              
                        break;

                        case 5:
                        ReservaServiceOlf eliminarReserva=new ReservaRepository();
                        DeleteReservaAgenteUseCase deleteReservaAgenteUseCase=new DeleteReservaAgenteUseCase(eliminarReserva);
                        ReservaController reservaControllerEliminar=new ReservaController(null, null, deleteReservaAgenteUseCase, null);
                        reservaControllerEliminar.deleteReservaAgente();
                        break;

                        case 6:
                        // Eliminar informacion cliente
                        ClienteService deletService=new ClienteRepository();
                        DeleteClienteCase deleteClienteCase=new DeleteClienteCase(deletService);
                        ClienteController deleteController=new ClienteController(null,null, deleteClienteCase, null);
                        deleteController.eliminar();
                            break;

                        case 7:
                        //Consultar informacion vuelo
                        vueloService consultVueloService = new vueloRepository();
                        ConsultvueloUseCase consultvueloUseCase=new ConsultvueloUseCase(consultVueloService);
                        vueloController vueloController=new vueloController(consultvueloUseCase, null, null, null, null,null, null, null, null, null, null, null, null, null, null);
                        vueloController.consultar(); // Revisar con sebas si es el metodo
                            
                        
                            break;
                        case 8:
                        EscalaService findEscalaService=new EscalaRepository();
                        FindEscalaUseCase findEscalaUseCase=new FindEscalaUseCase(findEscalaService);
                        EscalaController escalaController=new EscalaController(findEscalaUseCase,null,null,null);
                        escalaController.findEscalas();                            
                        
                            break;

                        case 9:
                        // consultar tarifa vuelo
                        TarifaService findTarifaService=new TarifaRepository();
                        FindTarifaUseCase findTarifaUseCase=new FindTarifaUseCase(findTarifaService);
                        TarifaController tarifaController=new TarifaController(null,findTarifaUseCase,null, null);
                        tarifaController.buscar();

                        break;

                        case 10:
                        TripulacionService tripulacionService=new TripulacionRepository();
                        FindTripulacionUseCase findTripulacionUseCase=new FindTripulacionUseCase(tripulacionService);
                        TripulacionController tripulacionController=new TripulacionController(null,findTripulacionUseCase);
                        tripulacionController.findTripulacion();
                        break;

                        case 11:
                        TipoDocumentoService tipoDocumentoService=new TipoDocumentoRepository();
                        FindTipoDocumentoUseCase findTipoDocumentoUseCase=new FindTipoDocumentoUseCase(tipoDocumentoService);
                        TipoDocumentoController tipoDocumentoController=new TipoDocumentoController(null,null,null,findTipoDocumentoUseCase);
                        tipoDocumentoController.findIdtipoDocumento();  
                        break;
                        case 12:
                            // Actualizar informacion cliente
                            ClienteService updtService=new ClienteRepository();
                            UpdateClienteCase updateClienteCase= new UpdateClienteCase(updtService);
                            ClienteController updateClienteController=new ClienteController(null,null, null,updateClienteCase);
                            updateClienteController.actualizar();
                            break;
                        default:
                        System.out.println("Opción no válida.");
                        break;
                    }
                }
                if (usuario.getRol() == 5) {
                    int opcionAdmin = menuTecnico();
                    System.out.println(opcionAdmin);
                }

            }

            System.out.println(usuario.getNombre());
        }
    }

    private int menuCliente() {
        ArrayList<String> opcionCliente = new ArrayList<>();
        opcionCliente.add("Buscar Vuelos");
        // opcionCliente.add("Seleccionar Vuelo");
        // opcionCliente.add("Añadir Pasajeros");
        // opcionCliente.add("Seleccionar Asientos");
        // opcionCliente.add("Realizar Pago");
        opcionCliente.add("Consultar Reserva de Vuelo");
        opcionCliente.add("Cancelar Reserva de Vuelo");
        opcionCliente.add("Modificar Reserva de Vuelo");
        JComboBox<String> comboBoxMenuAgente = new JComboBox<>(opcionCliente.toArray(new String[0]));
        JPanel panelTipoUser = new JPanel(new GridLayout(0, 1));
        panelTipoUser.add(new JLabel("Menu Cliente:"));
        panelTipoUser.add(comboBoxMenuAgente);

        int resultTipo = JOptionPane.showConfirmDialog(null, panelTipoUser, "Clientes",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        String opcionSeleccionada = "";
        if (resultTipo == JOptionPane.OK_OPTION) {
            opcionSeleccionada = (String) comboBoxMenuAgente.getSelectedItem();

        }
        int contador = 0;
        for (String opciones : opcionCliente) {
            contador++;
            if (opciones.equals(opcionSeleccionada)) {
                break;
            }
        }

        return contador;
    }

    private int menuTecnico() {
        ArrayList<String> opcionTecnico = new ArrayList<>();
        opcionTecnico.add("  Actualizar Información de Revisión");
        opcionTecnico.add("Eliminar Revisión de Mantenimiento");
        JComboBox<String> comboBoxMenuAgente = new JComboBox<>(opcionTecnico.toArray(new String[0]));
        JPanel panelTipoUser = new JPanel(new GridLayout(0, 1));
        panelTipoUser.add(new JLabel("Menu Tecnicos:"));
        panelTipoUser.add(comboBoxMenuAgente);

        int resultTipo = JOptionPane.showConfirmDialog(null, panelTipoUser, "tecnicos",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        String opcionSeleccionada = "";
        if (resultTipo == JOptionPane.OK_OPTION) {
            opcionSeleccionada = (String) comboBoxMenuAgente.getSelectedItem();

        }
        int contador = 0;
        for (String opciones : opcionTecnico) {
            contador++;
            if (opciones.equals(opcionSeleccionada)) {
                break;
            }
        }

        return contador;

    }

    private int menuAgenteVentas() {

        ArrayList<String> opcionesAgente = new ArrayList<>();
        opcionesAgente.add("Crear Reserva de Vuelo");
        opcionesAgente.add("Consultar Información de Cliente");
        opcionesAgente.add("Consultar Reserva de Vuelo");
        opcionesAgente.add("Registrar Cliente");
        opcionesAgente.add("Actualizar Información de Cliente");
        opcionesAgente.add("Eliminar Reserva de Vuelo");
        opcionesAgente.add("Consultar Información de Vuelo");
        opcionesAgente.add("Consultar Asignación de Tripulación");
        opcionesAgente.add("Consultar Escalas de un Trayecto");
        opcionesAgente.add("Consultar Tarifa de Vuelo");
        opcionesAgente.add("Consultar Tipo de Documento");

        JComboBox<String> comboBoxMenuAgente = new JComboBox<>(opcionesAgente.toArray(new String[0]));
        JPanel panelTipoUser = new JPanel(new GridLayout(0, 1));
        panelTipoUser.add(new JLabel("menu Agente Ventas:"));
        panelTipoUser.add(comboBoxMenuAgente);

        int resultTipo = JOptionPane.showConfirmDialog(null, panelTipoUser, "Tipo Usuario",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        String opcionSeleccionada = "";
        if (resultTipo == JOptionPane.OK_OPTION) {
            opcionSeleccionada = (String) comboBoxMenuAgente.getSelectedItem();

        }
        int contador = 0;
        for (String opciones : opcionesAgente) {
            contador++;
            if (opciones.equals(opcionSeleccionada)) {
                break;
            }
        }

        return contador;
    }

    private int menuAdministrador() {

        ArrayList<String> opcionesAdmin = new ArrayList<>();

        opcionesAdmin.add("Registrar Avión"); // 1
        opcionesAdmin.add("Asignar Tripulación a Trayecto"); // 2
        opcionesAdmin.add("Consultar Información de Avión"); // 3
        opcionesAdmin.add("Consultar Información de Trayecto"); // 4
        opcionesAdmin.add("Registrar Aeropuerto"); // 5
        opcionesAdmin.add("Consultar Información de Aeropuerto"); // 6
        opcionesAdmin.add("Actualizar Información de Avión"); // 7
        opcionesAdmin.add("Eliminar Avión"); // 8
        opcionesAdmin.add("Asignar Aeronave a Trayecto"); // 9
        opcionesAdmin.add("Actualizar Información de Trayecto"); // 10
        opcionesAdmin.add("Eliminar Trayecto"); // 11
        opcionesAdmin.add("Actualizar Información de Aeropuerto"); // 12
        opcionesAdmin.add("Eliminar Aeropuerto"); // 13
        opcionesAdmin.add("Consultar Información de Vuelo"); // 14
        opcionesAdmin.add("Consultar Asignación de Tripulación"); // 15
        opcionesAdmin.add("Consultar Escalas de un Trayecto"); // 16
        opcionesAdmin.add("Actualizar Información de Escala"); // 17
        opcionesAdmin.add("Eliminar Escala"); // 18
        opcionesAdmin.add("Registrar Tarifa de Vuelo"); // 19
        opcionesAdmin.add("Actualizar Información de Tarifa de Vuelo"); // 20
        opcionesAdmin.add("Eliminar Tarifa de Vuelo"); // 21
        opcionesAdmin.add("Consultar Tarifa de Vuelo"); // 22
        opcionesAdmin.add("Registrar Tipo de Documento"); // 23
        opcionesAdmin.add("Actualizar Tipo de Documento"); // 24
        opcionesAdmin.add("Eliminar Tipo de Documento"); // 25
        opcionesAdmin.add("Consultar Tipo de Documento"); // 26
        JComboBox<String> comboBoxMenuAdmin = new JComboBox<>(opcionesAdmin.toArray(new String[0]));
        JPanel panelTipoUser = new JPanel(new GridLayout(0, 1));
        panelTipoUser.add(new JLabel("menu administrador:"));
        panelTipoUser.add(comboBoxMenuAdmin);

        int resultTipo = JOptionPane.showConfirmDialog(null, panelTipoUser, "Tipo Usuario",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        String opcionSeleccionada = "";
        if (resultTipo == JOptionPane.OK_OPTION) {
            opcionSeleccionada = (String) comboBoxMenuAdmin.getSelectedItem();

        }
        int contador = 0;
        for (String opciones : opcionesAdmin) {
            contador++;
            if (opciones.equals(opcionSeleccionada)) {
                break;
            }
        }

        return contador;

    }

    private void mostrarUsuario(User usuario) {
        JPanel panelUsuario = new JPanel(new GridLayout(0, 2));
        panelUsuario.add(new JLabel("nombre:"));
        panelUsuario.add(new JLabel(usuario.getNombre()));
        panelUsuario.add(new JLabel("numero identificaicon:"));
        panelUsuario.add(new JLabel(usuario.getNumeroDocumento()));
        panelUsuario.add(new JLabel("tipo de usuario:"));
        panelUsuario.add(new JLabel(usuario.getTipoUser()));

        panelUsuario.add(new JLabel("tipo de rol:"));
        panelUsuario.add(new JLabel(usuario.getStringRol()));

        JOptionPane.showConfirmDialog(null, panelUsuario, "Tipo Usuario",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    }

    public String mostrarMenu() {

        String tipousuario = "";
        while (tipousuario == "") {

            ArrayList<String> tiposUsuario = new ArrayList<>();
            tiposUsuario.add("Cliente");
            tiposUsuario.add("Empleado");

            JComboBox<String> comboBoxTipoUser = new JComboBox<>(tiposUsuario.toArray(new String[0]));
            JPanel panelTipoUser = new JPanel(new GridLayout(0, 1));
            panelTipoUser.add(new JLabel("Seleccione tipo usuario:"));
            panelTipoUser.add(comboBoxTipoUser);

            int resultTipo = JOptionPane.showConfirmDialog(null, panelTipoUser, "Tipo Usuario",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (resultTipo == JOptionPane.OK_OPTION) {
                tipousuario = (String) comboBoxTipoUser.getSelectedItem();

            }
            if (resultTipo == JOptionPane.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "gracias por visitar nuestro sitio");
                System.exit(0);
            }
            System.out.println(tipousuario);
        }
        return tipousuario;

    }

    public User menuInicio() {
        User user = new User(0, "", "", null, null, 0, null);
        while ((user.getNumeroDocumento().equals("") | user.getPassword().equals(""))) {

            List<TipoDocumento> tipos = buscarTiposDocumentos.execute();
            List<String> listTiposDocuemtnos = new ArrayList<>();

            for (TipoDocumento tipoDocumento : tipos) {
                listTiposDocuemtnos.add(tipoDocumento.getNombre());
            }
            JComboBox<String> comboBoxTipoDocumento = new JComboBox<>(listTiposDocuemtnos.toArray(new String[0]));

            JPanel panelInicio = new JPanel(new GridLayout(0, 2));
            panelInicio.add(new JLabel("Seleccione tipo documento:"));
            panelInicio.add(comboBoxTipoDocumento);
            panelInicio.add(new JLabel("Ingrese numero documento: "));
            JTextField documentoField = new JTextField();
            panelInicio.add(documentoField);
            user.setNumeroDocumento(null);
            panelInicio.add(new JLabel("Ingrese password: "));
            JTextField passwordField = new JTextField();
            panelInicio.add(passwordField);
            String tipoDocumento = null;
            int result = JOptionPane.showConfirmDialog(null, panelInicio, "inicio de sesion",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                tipoDocumento = (String) comboBoxTipoDocumento.getSelectedItem();
                for (TipoDocumento selecionado : tipos) {
                    if (tipoDocumento.equals(selecionado.getNombre())) {
                        user.setIdTipoDocumento(selecionado.getId());
                    }
                    user.setNumeroDocumento(documentoField.getText());
                    user.setPassword(passwordField.getText());

                }
                if (user.getNumeroDocumento().equals("") | user.getPassword().equals("")) {
                    JOptionPane.showMessageDialog(null, "campos en blanco, revisar campos");

                }
            }
            if (result == JOptionPane.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "gracias por visitar nuestro sitio");
                System.exit(0);
            }
            System.out.println(user.getNombre());
            System.out.println(user.getIdTipoDocumento());
            System.out.println(user.getNumeroDocumento());
            System.out.println(user.getPassword());

        }
        return user;
    }
}
