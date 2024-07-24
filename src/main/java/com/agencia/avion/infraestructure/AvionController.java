package com.agencia.avion.infraestructure;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;

import com.agencia.avion.application.CreateAvionUseCase;
import com.agencia.avion.application.DeleteAvionUseCase;
import com.agencia.avion.application.FindAvionUseCase;
import com.agencia.avion.application.UpdateAvionUseCase;
import com.agencia.avion.domain.entity.Avion;

public class AvionController {

    private final CreateAvionUseCase createAvionUseCase;
    private final UpdateAvionUseCase updateAvionUseCase;
    private final DeleteAvionUseCase deleteAvionUseCase;
    private final FindAvionUseCase findAvionUseCase;

    public AvionController(CreateAvionUseCase createAvionUseCase, UpdateAvionUseCase updateAvionUseCase,
        DeleteAvionUseCase deleteAvionUseCase, FindAvionUseCase findAvionUseCase) {
        this.createAvionUseCase = createAvionUseCase;
        this.updateAvionUseCase = updateAvionUseCase;
        this.deleteAvionUseCase = deleteAvionUseCase;
        this.findAvionUseCase = findAvionUseCase;
    }


    public void createAvion(){
      
            String inputMatricula=JOptionPane.showInputDialog(null,"Ingrese matricua del aviòn");

            String inputCapacidad=JOptionPane.showInputDialog(null,"Ingese capacidad del aviòn");
            int capacidad=Integer.parseInt(inputCapacidad);

            String inputFecha=JOptionPane.showInputDialog(null,"ingrese fecha de fabricacion");

            String inputEstado=JOptionPane.showInputDialog(null,"ingrese id del estado");
            int estado=Integer.parseInt(inputEstado);
            
            String inputModelo=JOptionPane.showInputDialog(null,"ingrese id del modelo");
            int modelo=Integer.parseInt(inputModelo);

            String inputAerolinea=JOptionPane.showInputDialog(inputModelo);
            int aerolinea=Integer.parseInt(inputAerolinea);
            
            Avion avion = new Avion();
            avion.setMatricula(inputMatricula);
            avion.setCapacidad(capacidad);
            avion.setFechaFabricacion(inputFecha);
            avion.setIdEstado(estado);
            avion.setIdModelo(modelo);
            avion.setIdAerolinea(aerolinea);
            
            createAvionUseCase.execute(avion);
            JOptionPane.showMessageDialog(null,"Avion creado con exito");
    

        
    }

    public void deleteAvion(){
        String inputIdAvion =JOptionPane.showInputDialog(null,"Ingrese id del aviòn a eliminar");
        int idAvion=Integer.parseInt(inputIdAvion);
     
        // User userD = new User();
        deleteAvionUseCase.execute(idAvion);

        if(deleteAvionUseCase != null){
            JOptionPane.showMessageDialog(null,"Aviòn eiminado con exito!");
        }else{
            JOptionPane.showMessageDialog(null,"No se pudo eliminar el aviòn");
        }
    }

    public void updateAvion(){

        String inputIdAvion =JOptionPane.showInputDialog(null,"Ingrese id del aviòn a actualizar");
        int idAvion=Integer.parseInt(inputIdAvion);

        Avion avionExistente =new Avion();
        avionExistente.setId(idAvion);
        avionExistente = findAvionUseCase.execute(idAvion);

        if (avionExistente!= null){
            String inputMatricula=JOptionPane.showInputDialog(null,"Ingrese matricula");

            String inputCapacidad=JOptionPane.showInputDialog(null,"Ingrese matricula");
            int capacidad=Integer.parseInt(inputCapacidad);

            String inputFecha=JOptionPane.showInputDialog(null,"Ingrese matricula");
            String inputEstado=JOptionPane.showInputDialog(null,"Ingrese matricula");
            int estado=Integer.parseInt(inputEstado);
            
            String inputModelo=JOptionPane.showInputDialog(null,"Ingrese matricula");
            int modelo=Integer.parseInt(inputModelo);
            
            String inputAerolinea=JOptionPane.showInputDialog(null,"Ingrese matricula");
            int aerolinea=Integer.parseInt(inputAerolinea);
            
            Avion newAvion = new Avion();
            newAvion.setMatricula(inputMatricula);
            newAvion.setCapacidad(capacidad);
            newAvion.setFechaFabricacion(inputFecha);
            newAvion.setIdEstado(estado);
            newAvion.setIdModelo(modelo);
            newAvion.setIdAerolinea(aerolinea);
            
            updateAvionUseCase.execute(newAvion);
        }
        else{
            JOptionPane.showMessageDialog(null,"El aviòn no existe");
        }
    
    }

    public void findAvion(){

        String inputConIdAvion=JOptionPane.showInputDialog(null,"Ingrese id matricula");
        int idAvion=Integer.parseInt(inputConIdAvion);
        
        
        Avion foundAvion = findAvionUseCase.execute(idAvion);

        if(foundAvion != null){

            JPanel panelEncontrar = new JPanel(new GridLayout(0, 2));
            panelEncontrar.add(new JLabel("id:"));
            panelEncontrar.add(new JLabel(String.valueOf(foundAvion.getId())));
            
            panelEncontrar.add(new JLabel("Matricula:"));
            panelEncontrar.add(new JLabel(foundAvion.getMatricula()));

            panelEncontrar.add(new JLabel("Capacidad:"));
            panelEncontrar.add(new JLabel(String.valueOf(foundAvion.getCapacidad())));

            panelEncontrar.add(new JLabel("Fecha Fabricación:"));
            panelEncontrar.add(new JLabel(foundAvion.getFechaFabricacion()));

            panelEncontrar.add(new JLabel("id Estado:"));
            panelEncontrar.add(new JLabel(String.valueOf(foundAvion.getIdEstado())));

            panelEncontrar.add(new JLabel("id Modelo:"));
            panelEncontrar.add(new JLabel(String.valueOf(foundAvion.getIdModelo())));

            panelEncontrar.add(new JLabel("id Aerolínea:"));
            panelEncontrar.add(new JLabel(String.valueOf(foundAvion.getIdAerolinea())));
            
            JOptionPane.showMessageDialog(null,panelEncontrar, "Detalles Avión encontrado", JOptionPane.INFORMATION_MESSAGE);
          
        }else{
            JOptionPane.showMessageDialog(null, "Avion no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }
            
    }

}

