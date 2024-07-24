package com.agencia.tripulacion.infraestructure;

import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.agencia.tripulacion.application.CreateTripulacionUseCase;
import com.agencia.tripulacion.application.FindTripulacionUseCase;
import com.agencia.tripulacion.domain.entity.Tripulacion;

public class TripulacionController {

    private final CreateTripulacionUseCase createTripulacionUseCase;
    private final FindTripulacionUseCase findTripulacionUseCase;

    public TripulacionController(CreateTripulacionUseCase createTripulacionUseCase, FindTripulacionUseCase findTripulacionUseCase){
        this.createTripulacionUseCase = createTripulacionUseCase;
        this.findTripulacionUseCase = findTripulacionUseCase;
    }

        public void createTripulacion(){

            String inputidEmpleado=JOptionPane.showInputDialog(null,"ingrese id del empleado");
            int idEmpleado=Integer.parseInt(inputidEmpleado);

            String inputIdEscala=JOptionPane.showInputDialog(null,"Ingrese id de la escala");
            int idEscala=Integer.parseInt(inputIdEscala);


            Tripulacion tripulacion = new Tripulacion();

            tripulacion.setIdempleado(idEmpleado);
            tripulacion.setIdconexion(idEscala);

            createTripulacionUseCase.execute(tripulacion);
            JOptionPane.showMessageDialog(null,"Tripulacion creada con exito");

        }


        public void findTripulacion(){

            String inputidEscala=JOptionPane.showInputDialog(null,"Ingrese id de la escala");
            int idEscala=Integer.parseInt(inputidEscala);
            

            Tripulacion findTripulacion = findTripulacionUseCase.execute(idEscala);

            if (findTripulacion != null) {
                JPanel jPanel=new JPanel(new GridLayout(0,2));
                jPanel.add(new JLabel("id del empleado"));
                jPanel.add(new JLabel(String.valueOf(findTripulacion.getIdempleado())));
                jPanel.add(new JLabel("id de la escala"));
                jPanel.add(new JLabel(String.valueOf(findTripulacion.getIdconexion())));
                
            }



        }


}
