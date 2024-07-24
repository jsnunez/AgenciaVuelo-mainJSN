package com.agencia.trayecto.infraestructure;



import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;

import com.agencia.trayecto.application.DeleteTrayectoUseCase;
import com.agencia.trayecto.application.FindTrayectoUseCase;
import com.agencia.trayecto.application.UpdateTrayectoUseCase;
import com.agencia.trayecto.domain.entity.Trayecto;

public class TrayectoController {

    private final FindTrayectoUseCase findTrayectoUseCase;
    private final UpdateTrayectoUseCase updateTrayectoUseCase;
    private final DeleteTrayectoUseCase deleteTrayectoUseCase;

    public TrayectoController(FindTrayectoUseCase findTrayectoUseCase, UpdateTrayectoUseCase updateTrayectoUseCase, DeleteTrayectoUseCase deleteTrayectoUseCase){
        this.findTrayectoUseCase = findTrayectoUseCase;
        this.updateTrayectoUseCase = updateTrayectoUseCase;
        this.deleteTrayectoUseCase = deleteTrayectoUseCase;
    }
    public void findTrayecto(){
        String inputId=JOptionPane.showInputDialog(null, "ingrese id del trayecto a consultar");
        int idTrayecto=Integer.parseInt(inputId);

        Trayecto foundTrayecto = findTrayectoUseCase.execute(idTrayecto);

        if(foundTrayecto != null){
            JPanel panel=new JPanel(new GridLayout(0,2));
            panel.add(new JLabel("Trayecto id:"));
            panel.add(new JLabel(String.valueOf(foundTrayecto.getId())));
            panel.add(new JLabel("Trayecto fecha viaje:"));
            panel.add(new JLabel(foundTrayecto.getFechaViaje()));
            panel.add(new JLabel("Trayecto precio viaje:"));
            panel.add(new JLabel(String.valueOf(foundTrayecto.getPrecioViaje())));
            panel.add(new JLabel("Trayecto aeropuerto origen:"));
            panel.add(new JLabel(foundTrayecto.getIdOrigenAeropuerto()));
            panel.add(new JLabel("Trayecto aeropuerto destino:"));
            panel.add(new JLabel(foundTrayecto.getIdDestinoAeropuerto()));
            
        }else{
            JOptionPane.showMessageDialog(null,"Trayecto no encontrado");
        }

    }

    public void updateTrayecto(){

        
        String inputId = JOptionPane.showInputDialog(null, "Ingrese el id para actualizar el trayecto:");
        int idTrayectoUpdate = Integer.parseInt(inputId);

        String nuevaFecha = JOptionPane.showInputDialog(null, "Ingrese la nueva fecha de viaje:");

        String inputPrecio = JOptionPane.showInputDialog(null, "Ingrese el precio del trayecto:");
        int nuevoPrecio = Integer.parseInt(inputPrecio);

        String nuevoAeropuerto = JOptionPane.showInputDialog(null, "Ingrese el id del aeropuerto de origen:");

        String destinoAeropuerto = JOptionPane.showInputDialog(null, "Ingrese el id del aeropuerto de destino:");


        Trayecto updateTrayecto = new Trayecto();

        updateTrayecto.setId(idTrayectoUpdate);
        updateTrayecto.setFechaViaje(nuevaFecha);
        updateTrayecto.setPrecioViaje(nuevoPrecio);
        updateTrayecto.setIdOrigenAeropuerto(nuevoAeropuerto);
        updateTrayecto.setIdDestinoAeropuerto(destinoAeropuerto);

        updateTrayectoUseCase.execute(updateTrayecto);

    }

    public void deleteTrayecto(){
        String inputId=JOptionPane.showInputDialog(null,"Ingrese id del trayecto a eliminar");
        int idTrayecto=Integer.parseInt(inputId);
        
        deleteTrayectoUseCase.execute(idTrayecto);

        if (deleteTrayectoUseCase != null) {
            JOptionPane.showConfirmDialog(null,"Eliminado con exito");
            
        }else{
            JOptionPane.showConfirmDialog(null,"No se encontro id");
            
        }
    }

}
