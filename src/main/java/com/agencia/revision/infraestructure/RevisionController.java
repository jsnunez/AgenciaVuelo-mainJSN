package com.agencia.revision.infraestructure;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.agencia.revision.application.CreateRevisionUseCase;
import com.agencia.revision.application.DeleteRevisionUseCase;
import com.agencia.revision.application.FindRevisionUseCase;
import com.agencia.revision.application.UpdateRevisionUseCase;
import com.agencia.revision.domain.entity.Revision;

public class RevisionController {
    private final CreateRevisionUseCase createRevisionUseCase;
    private final UpdateRevisionUseCase updateRevisionUseCase;
    private final FindRevisionUseCase findRevisionUseCase;
    private final DeleteRevisionUseCase deleteRevisionUseCase;

    public RevisionController(CreateRevisionUseCase createRevisionUseCase, UpdateRevisionUseCase updateRevisionUseCase,
            FindRevisionUseCase findRevisionUseCase, DeleteRevisionUseCase deleteRevisionUseCase) {
        this.createRevisionUseCase = createRevisionUseCase;
        this.updateRevisionUseCase = updateRevisionUseCase;
        this.findRevisionUseCase = findRevisionUseCase;
        this.deleteRevisionUseCase = deleteRevisionUseCase;

    }

    // Scanner scanner = new Scanner(System.in);

    // public void gestionRevision(){

    // while(true){
    // System.out.println("1. Crear Revision: ");
    // System.out.println("2. Borrar Revision: ");
    // System.out.println("3. Encontrar Revision: ");
    // System.out.println("4. Actualizar Revision: ");
    // System.out.println("5. Salir: ");

    // int opcion = scanner.nextInt();
    // scanner.nextLine();

    // switch (opcion) {
    // case 1:

    // createRevision();
    // break;

    // case 2:
    // deleteRevision();
    // break;

    // case 3:
    // findRevision();
    // break;

    // case 4:
    // updateRevision();
    // break;
    // }
    // }
    // }

    public void createRevision() {

        System.out.println("Ingrese la fecha de la revisión (YYYY-MM-DD):");
        String inputFecha = JOptionPane.showInputDialog(null, "Ingrese fecha de la revisión YYYY-MM-DD");

        System.out.println("Ingrese el ID del avion:");
        String inputIdAvion = JOptionPane.showInputDialog(null, "Ingrese Id del avión");
        int idAvion = Integer.parseInt(inputIdAvion);

        String inputDescripcion = JOptionPane.showInputDialog(null, "Ingrese Descripcion de la revisión");

        String inputIdEmpleado = JOptionPane.showInputDialog(null, "Ingrese Id del empleado");
        int idEmpleado = Integer.parseInt(inputIdEmpleado);

        Revision revision = new Revision();

        revision.setFechaRevision(inputFecha);
        revision.setIdAvion(idAvion);
        revision.setDescripcion(inputDescripcion);
        revision.setIdEmpleado(idEmpleado);

        createRevisionUseCase.execute(revision);
        JOptionPane.showMessageDialog(null, "Revisión Registrada con exito");

    }

    public void findRevision() {

        String inputIdConsulta = JOptionPane.showInputDialog(null, "Ingrese el id de la revisión a a consultar:");
        int idRevision = Integer.parseInt(inputIdConsulta);

        Revision foundRevision = findRevisionUseCase.execute(idRevision);

        if (foundRevision != null) {
            String mensaje = String.format(
                    "Revision id: %d\n" +
                            "Fecha revisión: %s\n" +
                            "ID Avión: %d\n" +
                            "Descripción de la revisión: %s\n" +
                            "ID empleado encargado: %d\n",
                    foundRevision.getId(),
                    foundRevision.getFechaRevision(),
                    foundRevision.getIdAvion(),
                    foundRevision.getDescripcion(),
                    foundRevision.getIdEmpleado());
            JOptionPane.showMessageDialog(null, mensaje, "Detalle de revision", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Id no encontrado");
        }

    }

    public void updateRevision() {

        String inputIdConsulta = JOptionPane.showInputDialog(null, "Ingrese el id de la revisión ha actualizar");
        int revisionUpdate = Integer.parseInt(inputIdConsulta);

        Revision revisionExistente = new Revision();
        revisionExistente.setId(revisionUpdate);
        if (revisionExistente != null) {
            String inputFecha = JOptionPane.showInputDialog(null, "ingrese nueva fecha AAAA-MM-DD");

            String inputIdAvion = JOptionPane.showInputDialog(null, "Agregue el id del avión");
            int nuevoidAvion = Integer.parseInt(inputIdAvion);

            String nuevaDescripcion = JOptionPane.showInputDialog(null, "ingrese descripcion de la revision");

            String inputIdNuevoEmpleado = JOptionPane.showInputDialog(null, "Ingrse nuevo id Empleado");
            int nuevoEmpleado = Integer.parseInt(inputIdNuevoEmpleado);

            Revision newRevision = new Revision();
            newRevision.setId(revisionUpdate);
            newRevision.setFechaRevision(inputFecha);
            newRevision.setIdAvion(nuevoidAvion);
            newRevision.setDescripcion(nuevaDescripcion);
            newRevision.setIdEmpleado(nuevoEmpleado);

            updateRevisionUseCase.execute(newRevision);
            JOptionPane.showMessageDialog(null,"REvision actualizada");

        }
    }

    public void deleteRevision() {

        String inputIdElim=JOptionPane.showInputDialog(null,"Ingrese id de la revisión a eliminar");
        int idDelete=Integer.parseInt(inputIdElim);

        deleteRevisionUseCase.execute(idDelete);

        if (deleteRevisionUseCase != null) {
            JOptionPane.showMessageDialog(null, "Revisión eliminada");
        } else {
            JOptionPane.showMessageDialog(null, "Revisión no encontrada");
        }
    }

}
