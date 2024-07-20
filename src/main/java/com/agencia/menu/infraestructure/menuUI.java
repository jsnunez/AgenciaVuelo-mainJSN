package com.agencia.menu.infraestructure;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.agencia.menu.domain.Service.entity.User;
import com.agencia.reserva.application.BuscarTiposDocumentos;
import com.agencia.tipoDocumento.domain.entity.TipoDocumento;

public class menuUI {
  

private final BuscarTiposDocumentos buscarTiposDocumentos;
private final  com.agencia.menu.application.iniciarsesion iniciarsesion;


    public menuUI(BuscarTiposDocumentos buscarTiposDocumentos, com.agencia.menu.application.iniciarsesion iniciarsesion) {
    this.buscarTiposDocumentos = buscarTiposDocumentos;
    this.iniciarsesion = iniciarsesion;
}

    public void menu() {
        String tipoUser = mostrarMenu();
        User usuario=menuInicio();

        if (tipoUser == "Cliente") {
            usuario.setTipoUser("Cliente");
            usuario= iniciarsesion.execute(usuario);
        }
        if (tipoUser == "Empleado") {
            
            usuario.setTipoUser("Empleado");
            usuario= iniciarsesion.execute(usuario);
        }

        mostrarUsuario(usuario);
        System.out.println(usuario.getNombre());
    }

    private void mostrarUsuario(User usuario) {
        JPanel panelUsuario = new JPanel(new GridLayout(0, 2));
        panelUsuario.add(new JLabel("nombre:"));
        panelUsuario.add(new JLabel(usuario.getNombre()));
        panelUsuario.add(new JLabel("numero identificaicon:"));
        panelUsuario.add(new JLabel(usuario.getNumeroDocumento()));
        panelUsuario.add(new JLabel("tipo de usuario:"));
        panelUsuario.add(new JLabel(usuario.getTipoUser()));

 JOptionPane.showConfirmDialog(null, panelUsuario, "Tipo Usuario",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    }

    public String mostrarMenu() {
  
        String tipousuario = "";
        while (tipousuario=="") {
            
       
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
