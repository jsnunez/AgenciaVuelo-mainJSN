package com.agencia.cliente.infrastructure.in;

import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.agencia.cliente.aplication.CreateClienteCase;
import com.agencia.cliente.aplication.DeleteClienteCase;
import com.agencia.cliente.aplication.FindClienteCase;
import com.agencia.cliente.aplication.UpdateClienteCase;
import com.agencia.cliente.domain.entity.Cliente;
import com.agencia.cliente.domain.service.ClienteService;

public class ClienteController {
    private CreateClienteCase createClienteCase;
    private FindClienteCase findClienteCase;
    private DeleteClienteCase deleteClienteCase;
    private UpdateClienteCase updateClienteCase;

    public ClienteController(CreateClienteCase createClienteCase,
            FindClienteCase findClienteCase, DeleteClienteCase deleteClienteCase,
            UpdateClienteCase updateClienteCase) {
        this.createClienteCase = createClienteCase;
        this.findClienteCase = findClienteCase;
        this.deleteClienteCase = deleteClienteCase;
        this.updateClienteCase = updateClienteCase;
    }

    public void crear() throws SQLException {
        String nombre = JOptionPane.showInputDialog("Nombre del cliente:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad del cliente:"));
        int idtipodocumento = Integer.parseInt(JOptionPane.showInputDialog("ID del tipo de documento:"));
        String numerodocumento = JOptionPane.showInputDialog("Número de documento:");
        int rol = Integer.parseInt(JOptionPane.showInputDialog("Rol:"));

        Cliente cliente = new Cliente(rol, numerodocumento, rol, rol, numerodocumento, rol);
        cliente.setNombre(nombre);
        cliente.setEdad(edad);
        cliente.setIdtipodocumento(idtipodocumento);
        cliente.setNumerodocumento(numerodocumento);
        cliente.setRol(rol);

        createClienteCase.execute(cliente);
        JOptionPane.showMessageDialog(null, "Cliente creado correctamente!");
    }

    public void actualizar() throws SQLException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID del cliente a actualizar:"));
        String nombre = JOptionPane.showInputDialog("Nombre del cliente:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad del cliente:"));
        int idtipodocumento = Integer.parseInt(JOptionPane.showInputDialog("ID del tipo de documento:"));
        String numerodocumento = JOptionPane.showInputDialog("Número de documento:");
        int rol = Integer.parseInt(JOptionPane.showInputDialog("Rol:"));

        Cliente cliente = new Cliente(rol, numerodocumento, rol, rol, numerodocumento, rol);
        cliente.setId(id);
        cliente.setNombre(nombre);
        cliente.setEdad(edad);
        cliente.setIdtipodocumento(idtipodocumento);
        cliente.setNumerodocumento(numerodocumento);
        cliente.setRol(rol);

        updateClienteCase.execute(cliente);
        JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente!");
    }

    public void buscar() throws SQLException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID del cliente a buscar:"));
        Cliente cliente = findClienteCase.execute(id);

        if (cliente != null) {
            JPanel panel = new JPanel(new GridLayout(0, 2));
            panel.add(new JLabel("ID cliente"));
            panel.add(new JLabel(String.valueOf(cliente.getId())));
            panel.add(new JLabel("Nombre cliente"));
            panel.add(new JLabel(cliente.getNombre()));
            panel.add(new JLabel("Edad cliente"));
            panel.add(new JLabel(String.valueOf(cliente.getEdad())));
            panel.add(new JLabel("ID Tipo Documento"));
            panel.add(new JLabel(String.valueOf(cliente.getIdtipodocumento())));
            panel.add(new JLabel("Número Documento"));
            panel.add(new JLabel(cliente.getNumerodocumento()));
            panel.add(new JLabel("Rol"));
            panel.add(new JLabel(String.valueOf(cliente.getRol())));

        } else {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado!");
        }
    }

    public void eliminar() throws SQLException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID del cliente a eliminar:"));
        Cliente clienteExistente = findClienteCase.execute(id);
        if (clienteExistente == null) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado!");
            return;
        } else {
            deleteClienteCase.execute(id);
            JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente!");
        }

    }
}
