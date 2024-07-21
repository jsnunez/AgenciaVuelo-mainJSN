package com.agencia.menu.infraestructure;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.agencia.escala.application.FindEscalaUseCase;
import com.agencia.escala.infraestructure.EscalaRepository;
import com.agencia.menu.domain.Service.entity.User;
import com.agencia.reserva.application.AsignarsillaUseCase;
import com.agencia.reserva.application.BuscarCiudades;
import com.agencia.reserva.application.BuscarSillasOcupadas;
import com.agencia.reserva.application.BuscarTiposDocumentos;
import com.agencia.reserva.application.BuscarvuelosUseCase;
import com.agencia.reserva.application.ConsultvueloUseCase;
import com.agencia.reserva.application.CrearReservaDetalleUseCase;
import com.agencia.reserva.application.CrearReservaUseCase;
import com.agencia.reserva.application.VerificarPasajero;
import com.agencia.reserva.domain.service.vueloService;
import com.agencia.reserva.infraestructure.in.vueloController;
import com.agencia.reserva.infraestructure.out.vueloRepository;
import com.agencia.tipoDocumento.domain.entity.TipoDocumento;

public class menuUI {

    private final BuscarTiposDocumentos buscarTiposDocumentos;
    private final com.agencia.menu.application.iniciarsesion iniciarsesion;

    public menuUI(BuscarTiposDocumentos buscarTiposDocumentos,
            com.agencia.menu.application.iniciarsesion iniciarsesion) {
        this.buscarTiposDocumentos = buscarTiposDocumentos;
        this.iniciarsesion = iniciarsesion;
    }

    public void menu() {
        String tipoUser = mostrarMenu();
        User usuario = menuInicio();

        if (tipoUser == "Cliente") {
            usuario.setTipoUser("Cliente");
            usuario = iniciarsesion.execute(usuario);
            int opcionCliente = menuCliente();
            System.out.println(opcionCliente);
            switch (opcionCliente) {
                case 1:
                    EscalaRepository escalaRepository = new EscalaRepository();
                    vueloService vueloService = new vueloRepository();
                    FindEscalaUseCase findEscalaUseCase = new FindEscalaUseCase(escalaRepository);
                    ConsultvueloUseCase consultvueloUseCase = new ConsultvueloUseCase(vueloService);
                    BuscarCiudades buscarCiudades = new BuscarCiudades(vueloService);
                    BuscarvuelosUseCase buscarvuelosUseCase = new BuscarvuelosUseCase(vueloService);
                    CrearReservaUseCase crearReservaUseCase = new CrearReservaUseCase(vueloService);
                    VerificarPasajero verificarPasajero = new VerificarPasajero(vueloService);
                    // BuscarTiposDocumentos buscarTiposDocumentos = new
                    // BuscarTiposDocumentos(vueloService);
                    AsignarsillaUseCase asignarSillaUseCase = new AsignarsillaUseCase(vueloService);
                    CrearReservaDetalleUseCase crearReservaDetalleUseCase = new CrearReservaDetalleUseCase(
                            vueloService);
                    BuscarSillasOcupadas buscarSillasOcupadas = new BuscarSillasOcupadas(vueloService);

                    vueloController consoleAdapterVuelo = new vueloController(consultvueloUseCase, buscarCiudades,
                            buscarvuelosUseCase, crearReservaUseCase, verificarPasajero, buscarTiposDocumentos,
                            findEscalaUseCase, crearReservaDetalleUseCase, asignarSillaUseCase, buscarSillasOcupadas);
                    consoleAdapterVuelo.buscar();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                default:
                    break;
            }
        }
        if (tipoUser == "Empleado") {

            usuario.setTipoUser("Empleado");
            usuario = iniciarsesion.execute(usuario);
            System.out.println(usuario.getRol());
            mostrarUsuario(usuario);

            if (usuario.getRol() == 3) {
                int opcionAdmin = menuAdministrador();
                System.out.println(opcionAdmin);
            }
            if (usuario.getRol() == 4) {
                int opcionAdmin = menuAgenteVentas();
                System.out.println(opcionAdmin);
            }
            if (usuario.getRol() == 5) {
                int opcionAdmin = menuTecnico();
                System.out.println(opcionAdmin);
            }

        }

        System.out.println(usuario.getNombre());
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'menuTecnico'");
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
        opcionesAdmin.add("Registrar Avión");
        opcionesAdmin.add("Asignar Tripulación a Trayecto");
        opcionesAdmin.add("Registrar Avión");
        opcionesAdmin.add("Asignar Tripulación a Trayecto");
        opcionesAdmin.add("Consultar Información de Avión");
        opcionesAdmin.add("Consultar Información de Trayecto");
        opcionesAdmin.add("Registrar Aeropuerto");
        opcionesAdmin.add("Consultar Información de Aeropuerto");
        opcionesAdmin.add("Actualizar Información de Avión");
        opcionesAdmin.add("Eliminar Avión");
        opcionesAdmin.add("Asignar Aeronave a Trayecto");
        opcionesAdmin.add("Actualizar Información de Trayecto");
        opcionesAdmin.add("Eliminar Trayecto");
        opcionesAdmin.add("Actualizar Información de Aeropuerto");
        opcionesAdmin.add("Eliminar Aeropuerto");
        opcionesAdmin.add("Consultar Información de Vuelo");
        opcionesAdmin.add("Consultar Asignación de Tripulación");
        opcionesAdmin.add("Consultar Escalas de un Trayecto");
        opcionesAdmin.add("Actualizar Información de Escala");
        opcionesAdmin.add("Eliminar Escala");
        opcionesAdmin.add("Registrar Tarifa de Vuelo");
        opcionesAdmin.add("Actualizar Información de Tarifa de Vuelo");
        opcionesAdmin.add("Eliminar Tarifa de Vuelo");
        opcionesAdmin.add("Consultar Tarifa de Vuelo");
        opcionesAdmin.add("Registrar Tipo de Documento");
        opcionesAdmin.add("Actualizar Tipo de Documento");
        opcionesAdmin.add("Eliminar Tipo de Documento");
        opcionesAdmin.add("Consultar Tipo de Documento");
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
                System.exit(0);
            }
            System.out.println(tipousuario);
        }
        return tipousuario;

    }

    public User menuInicio() {
        List<TipoDocumento> tipos = buscarTiposDocumentos.execute();
        List<String> listTiposDocuemtnos = new ArrayList<>();
        User user = new User();
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
        }
        System.out.println(user.getNombre());
        System.out.println(user.getIdTipoDocumento());
        System.out.println(user.getNumeroDocumento());
        System.out.println(user.getPassword());
        return user;

    }
}
