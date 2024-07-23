package com.agencia.reserva.infraestructure.in;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.agencia.reserva.application.CancelReservaClienteUseCase;
import com.agencia.reserva.application.CreateReservaAgenteUseCase;
import com.agencia.reserva.application.DeleteReservaAgenteUseCase;
import com.agencia.reserva.application.FindReservaAgenteUseCase;
import com.agencia.reserva.domain.entity.Reserva;

public class ReservaController {
    private final CreateReservaAgenteUseCase createReservaAgenteUseCase;
    private final FindReservaAgenteUseCase findReservaAgenteUseCase;
    private final DeleteReservaAgenteUseCase deleteReservaAgenteUseCase;
    private final CancelReservaClienteUseCase cancelReservaClienteUseCase;

    public ReservaController(CreateReservaAgenteUseCase createReservaAgenteUseCase,
            FindReservaAgenteUseCase findReservaAgenteUseCase, DeleteReservaAgenteUseCase deleteReservaAgenteUseCase,
            CancelReservaClienteUseCase cancelReservaClienteUseCase) {
        this.createReservaAgenteUseCase = createReservaAgenteUseCase;
        this.findReservaAgenteUseCase = findReservaAgenteUseCase;
        this.deleteReservaAgenteUseCase = deleteReservaAgenteUseCase;
        this.cancelReservaClienteUseCase = cancelReservaClienteUseCase;

    }

    // Scanner scanner = new Scanner(System.in);

    // public void gestionReserva() {
    // while (true) {
    // System.out.println("1. crear Reserva");
    // System.out.println("2. Consultar resrva vuelo Agente");
    // System.out.println("3. Eliminar tipo documento");
    // System.out.println("4. Buscar documento");
    // System.out.println("5. Salir");

    // int opcion = scanner.nextInt();
    // scanner.nextLine();

    // switch (opcion) {
    // case 1:
    // createReserva();
    // break;
    // case 2:
    // findReservaAgente();
    // break;
    // case 3:
    // deleteReservaAgente();
    // break;

    // case 4:
    // cancelarReserva();
    // break;

    // default:
    // break;
    // }

    // }
    // }

    public void createReserva() {

        String fechaInput = JOptionPane.showInputDialog(null, "Ingrese fecha AAAA-MM-DD");

        String inputIdVuelo = JOptionPane.showInputDialog(null, "Ingrese Id Vuelo Porfavor");
        int idVueloReservaAgente = Integer.parseInt(inputIdVuelo);

        String inputCliente = JOptionPane.showInputDialog(null, "Ingrese id Cliente");
        int idCliente = Integer.parseInt(inputCliente);

        Reserva reserva = new Reserva();
        reserva.setFechaReserva(fechaInput);
        reserva.setIdVuelo(idVueloReservaAgente);
        reserva.setIdCliente(idCliente);
        createReservaAgenteUseCase.execute(reserva);
        JOptionPane.showMessageDialog(null, "Reserva Creada con exito");

    }

    public void findReservaAgente() {
        System.out.println("Ingrese id de la reserva");
        String inputIdReserva = JOptionPane.showInputDialog(null, "Ingrese id de la reserva porfavor");
        int idReserva = Integer.parseInt(inputIdReserva);

        Reserva reserva = findReservaAgenteUseCase.execute(idReserva);
        if (reserva != null) {
            JPanel panelEncontrar = new JPanel(new GridLayout(0, 2));
            panelEncontrar.add(new JLabel("id:"));
            panelEncontrar.add(new JLabel(String.valueOf(reserva.getId())));
            panelEncontrar.add(new JLabel("Fecha:"));
            panelEncontrar.add(new JLabel(reserva.getFechaReserva()));
            panelEncontrar.add(new JLabel("Aeropuerto Origen:"));
            panelEncontrar.add(new JLabel(reserva.getAeropuertoOrigen()));
            panelEncontrar.add(new JLabel("Aeropuerto Destino:"));
            panelEncontrar.add(new JLabel(reserva.getAeropuertoDestino()));
            panelEncontrar.add(new JLabel("Nombre Cliente:"));
            panelEncontrar.add(new JLabel(reserva.getNombreCliente()));
            panelEncontrar.add(new JLabel("Precio Vuelo:"));
            panelEncontrar.add(new JLabel((String.valueOf(reserva.getPrecio()))));
            panelEncontrar.add(new JLabel("Estado Reserva:"));
            panelEncontrar.add(new JLabel((String.valueOf(reserva.getEstado()))));
            JOptionPane.showMessageDialog(null, panelEncontrar, "Detalles de la Reserva",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {

            JOptionPane.showMessageDialog(null, "Reserva no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void deleteReservaAgente() {
        System.out.println("ingrese id reserva eliminar");
        String inputidReservaString = JOptionPane.showInputDialog(null, "Ingrese Id de Reserva a eliminar ");
        int idReservaEliminar = Integer.parseInt(inputidReservaString);

        // Reserva elimina = new Reserva();
        Reserva reserva = findReservaAgenteUseCase.execute(idReservaEliminar);
        if (reserva != null) {
            deleteReservaAgenteUseCase.execute(reserva);
            JOptionPane.showMessageDialog(null, "Reserva Eliminada con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "Reserva no encontrada");
        }
        // elimina.setId(idReservaEliminar);

    }

    public void cancelarReserva() {
        System.out.println("ingrese id reserva cancelar");
        String inputReservaAgente = JOptionPane.showInputDialog(null, "Ingrese ID de la reserva a eliminar");
        int idReservaAgente = Integer.parseInt(inputReservaAgente);

        // Reserva cancela = new Reserva();
        Reserva reserva = findReservaAgenteUseCase.execute(idReservaAgente);
        if (reserva != null) {
            JPanel panelEncontrar = new JPanel(new GridLayout(0, 2));
            panelEncontrar.add(new JLabel("id:"));
            panelEncontrar.add(new JLabel(String.valueOf(reserva.getId())));
            panelEncontrar.add(new JLabel("Fecha:"));
            panelEncontrar.add(new JLabel(reserva.getFechaReserva()));
            panelEncontrar.add(new JLabel("Aeropuerto Origen:"));
            panelEncontrar.add(new JLabel(reserva.getAeropuertoOrigen()));
            panelEncontrar.add(new JLabel("Aeropuerto Destino:"));
            panelEncontrar.add(new JLabel(reserva.getAeropuertoDestino()));
            panelEncontrar.add(new JLabel("Nombre Cliente:"));
            panelEncontrar.add(new JLabel(reserva.getNombreCliente()));
            panelEncontrar.add(new JLabel("Precio Vuelo:"));
            panelEncontrar.add(new JLabel((String.valueOf(reserva.getPrecio()))));
            panelEncontrar.add(new JLabel("Estado Reserva:"));
            panelEncontrar.add(new JLabel((String.valueOf(reserva.getEstado()))));
            JOptionPane.showMessageDialog(null, panelEncontrar, "Detalles de la Reserva",
                    JOptionPane.INFORMATION_MESSAGE);
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea cancelar esta reserva?",
                    "Confirmar Cancelación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                cancelReservaClienteUseCase.execute(reserva);
                JOptionPane.showMessageDialog(null, "Reserva Cancelada con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "No se realizó cancelación");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Reserva no encontrada");
        }

    }
}
