package com.agencia.escala.infraestructure;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.agencia.escala.application.AsignAvionUseCase;
import com.agencia.escala.application.DeleteEscalaUseCase;
import com.agencia.escala.application.FindEscalaUseCase;
import com.agencia.escala.application.UpdateEscalaUseCase;
import com.agencia.escala.domain.entity.Escala;



public class EscalaController {
    private final FindEscalaUseCase findEscalaUseCase;
    private final UpdateEscalaUseCase updateEscalaUseCase;
    private final DeleteEscalaUseCase deleteEscalaUseCase;
    private final AsignAvionUseCase asignAvionUseCase;

    public EscalaController(FindEscalaUseCase findEscalaUseCase, UpdateEscalaUseCase updateEscalaUseCase, DeleteEscalaUseCase deleteEscalaUseCase, AsignAvionUseCase asignAvionUseCase) {
        this.findEscalaUseCase = findEscalaUseCase;
        this.updateEscalaUseCase = updateEscalaUseCase;
        this.deleteEscalaUseCase = deleteEscalaUseCase;
        this.asignAvionUseCase = asignAvionUseCase;
    }


   public void findEscalas() {
    String inputid=JOptionPane.showInputDialog(null,"Ingrese id del trayecto para consultar escalas");
    int idTrayecto=Integer.parseInt(inputid);
    
    List<Escala> escalas= new ArrayList<>();
    escalas = findEscalaUseCase.execute(idTrayecto); // Asumiendo que devuelve una lista de escalas

    if (!escalas.isEmpty()) {
        System.out.println(escalas);
        // escalas.forEach(escala -> System.out.println(escala.getId()));

        for (Escala escala : escalas) {
            JPanel panel=new JPanel(new GridLayout(0,2));
            panel.add(new JLabel("Escala id:"));
            panel.add(new JLabel(String.valueOf(escala.getId())));
            panel.add(new JLabel("Número de conexión:"));
            panel.add(new JLabel(String.valueOf(escala.getNumeroConexion())));
            panel.add(new JLabel("Id Trayecto:"));
            panel.add(new JLabel(String.valueOf(escala.getIdViaje())));
            panel.add(new JLabel("Id Avión:"));
            panel.add(new JLabel(String.valueOf(escala.getIdAvion())));
            panel.add(new JLabel("Id Aeropuerto origen:"));
            panel.add(new JLabel(escala.getIdAeropuertoOrigen()));
            panel.add(new JLabel("Id Aeropuerto destino:"));
            panel.add(new JLabel(escala.getIdAeropuertoDestino()));
            
           
        }
    } else {
        JOptionPane.showConfirmDialog(null,"No se encontraron escalas para el id de viaje proporcionado");
        
    }
}


    public void updateEscala() {

        String inputIdEscala=JOptionPane.showInputDialog(null,"ingrese id de la escala a actualziar");
        int idEscala=Integer.parseInt(inputIdEscala);

        
        
        String inputIdAvion=JOptionPane.showInputDialog(null,"ingrese id de la Avion a actualziar");
        int idAvion=Integer.parseInt(inputIdAvion);

        String inputIdAeropuertoOrigen=JOptionPane.showInputDialog(null,"ingrese id de la Aeropuerto origen a actualziar");
        //int idAeropuertoOrigen=Integer.parseInt(inputIdAeropuertoOrigen);

        String inputIdAeropuertoLlegada=JOptionPane.showInputDialog(null,"ingrese id de la Aeropuerto llegada a actualziar");
        //int idAeropuertoLlegada=Integer.parseInt(inputIdAeropuertoLlegada);


        Escala newEscala = new Escala();

        newEscala.setId(idEscala);
        newEscala.setIdAvion(idAvion);
        newEscala.setIdAeropuertoOrigen(inputIdAeropuertoOrigen);
        newEscala.setIdAeropuertoDestino(inputIdAeropuertoLlegada);


        updateEscalaUseCase.execute(newEscala);
        JOptionPane.showMessageDialog(null,"Escala Actualizada con exito");

    }

    public void deleteEscala(){
        String inputIdEscala=JOptionPane.showInputDialog(null,"ingrese id de la escala a eliminar");
        int idEscala=Integer.parseInt(inputIdEscala);
        

        // User userD = new User();
        deleteEscalaUseCase.execute(idEscala);

        if(deleteEscalaUseCase != null){
            JOptionPane.showMessageDialog(null,"Escala eliminada");
        }else{
            JOptionPane.showMessageDialog(null,"No se pudo eliminar la escala");
        }
    }

    public void asignAvion(){

        String inputIdEscala=JOptionPane.showInputDialog(null,"Ingrese id escala");
        int idEscala=Integer.parseInt(inputIdEscala);

        String inputIdAvion=JOptionPane.showInputDialog(null,"Ingrese id avion la cual quiere asignar a la escala");
        int idAvion=Integer.parseInt(inputIdAvion);

        
        Escala escala = new Escala();

        escala.setId(idEscala);
        escala.setIdAvion(idAvion);

        asignAvionUseCase.execute(escala);

        JOptionPane.showMessageDialog(null,"Avion asignado");

    }

}

