package com.agencia.tipoDocumento.infraestructure;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.agencia.tipoDocumento.application.CreateTipoDocumentoUseCase;
import com.agencia.tipoDocumento.application.DeleteTipoDocumentoUseCase;
import com.agencia.tipoDocumento.application.FindTipoDocumentoUseCase;
import com.agencia.tipoDocumento.application.UpdateTipoDocumentoUseCase;
import com.agencia.tipoDocumento.domain.entity.TipoDocumento;

public class TipoDocumentoController {

    private final CreateTipoDocumentoUseCase createTipoDocumentoUseCase;
    private final UpdateTipoDocumentoUseCase updateTipoDocumentoUseCase;
    private final DeleteTipoDocumentoUseCase deleteTipoDocumentoUseCase;
    private final FindTipoDocumentoUseCase findTipoDocumentoUseCase;

    public TipoDocumentoController(CreateTipoDocumentoUseCase createTipoDocumentoUseCase,
            UpdateTipoDocumentoUseCase updateTipoDocumentoUseCase,
            DeleteTipoDocumentoUseCase deleteTipoDocumentoUseCase, FindTipoDocumentoUseCase findTipoDocumentoUseCase) {
        this.createTipoDocumentoUseCase = createTipoDocumentoUseCase;
        this.updateTipoDocumentoUseCase = updateTipoDocumentoUseCase;
        this.deleteTipoDocumentoUseCase = deleteTipoDocumentoUseCase;
        this.findTipoDocumentoUseCase = findTipoDocumentoUseCase;
    }

    public void createTipoDocumento() {
        String imputNombre = JOptionPane.showInputDialog(null, "Ingrese Nombre de documento");

        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setNombre(imputNombre);
        createTipoDocumentoUseCase.execute(tipoDocumento);
    }

    public void updateTipoDocumento() {

        String inputId = JOptionPane.showInputDialog(null, "Ingrese Id de documento");
        int nuevoId = Integer.parseInt(inputId);

        TipoDocumento tipoDocumentoExistente = new TipoDocumento();
        tipoDocumentoExistente.setId(nuevoId);

        if (tipoDocumentoExistente != null) {
            String inputNombre = JOptionPane.showInputDialog(null, "ingrese nombre de documento");
            TipoDocumento updttipoDocumento = new TipoDocumento();

            updttipoDocumento.setId(nuevoId);
            updttipoDocumento.setNombre(inputNombre);
            updateTipoDocumentoUseCase.execute(updttipoDocumento);

            JOptionPane.showMessageDialog(null, "Actualización creada");

        }
        JOptionPane.showMessageDialog(null, "Id no encontrado");

    }

    public void deleteTipoDocumento() {
        String inputId = JOptionPane.showInputDialog(null, "Ingrese Id de documento");
        int nuevoId = Integer.parseInt(inputId);

        TipoDocumento documentExistente = new TipoDocumento();
        documentExistente.setId(nuevoId);
        if(documentExistente != null){
            deleteTipoDocumentoUseCase.execute(documentExistente);
            JOptionPane.showMessageDialog(null, "Eliminación realizada");
        }

        JOptionPane.showMessageDialog(null,"Id no encontrado");
    }

    public void findIdtipoDocumento() {
        String inputId = JOptionPane.showInputDialog(null, "Ingrese Id de documento");
        int nuevoId = Integer.parseInt(inputId);

        TipoDocumento encontrar = findTipoDocumentoUseCase.execute(nuevoId);
        if (encontrar != null) {
            JOptionPane.showMessageDialog(null, String.format(
                "Id: %d%nNombre: %s",
                encontrar.getId(),
                encontrar.getNombre()
            ));
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el tipo de documento", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
