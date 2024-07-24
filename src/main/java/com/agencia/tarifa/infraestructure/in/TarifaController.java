package com.agencia.tarifa.infraestructure.in;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.agencia.tarifa.application.CreateTarifaUseCase;
import com.agencia.tarifa.application.DeleteTarifaUseCase;
import com.agencia.tarifa.application.FindTarifaUseCase;
import com.agencia.tarifa.application.UpdateTarifaUseCase;
import com.agencia.tarifa.domain.entity.Tarifa;

public class TarifaController {
    private CreateTarifaUseCase createTarifaUseCase;
    private FindTarifaUseCase findTarifaUseCase;
    private DeleteTarifaUseCase deleteTarifaUseCase;
    private UpdateTarifaUseCase updateTarifaUseCase;

    public TarifaController(CreateTarifaUseCase createTarifaUseCase, FindTarifaUseCase findTarifaUseCase,
            DeleteTarifaUseCase deleteTarifaUseCase, UpdateTarifaUseCase updateTarifaUseCase) {
        this.createTarifaUseCase = createTarifaUseCase;
        this.findTarifaUseCase = findTarifaUseCase;
        this.deleteTarifaUseCase = deleteTarifaUseCase;
        this.updateTarifaUseCase = updateTarifaUseCase;
    }

    public TarifaController(CreateTarifaUseCase createTarifaUseCase) {
        this.createTarifaUseCase = createTarifaUseCase;
    }

    public void crear() throws SQLException {

        String descripcion = JOptionPane.showInputDialog("Ingrese descripcion");
        String detalle = JOptionPane.showInputDialog("Ingrese detalle");
        String valorString = JOptionPane.showInputDialog("Ingrese valor");
        BigDecimal valor = new BigDecimal(valorString);
        Tarifa tarifa = new Tarifa();
        tarifa.setDescripcion(descripcion);
        tarifa.setDetalles(detalle);
        tarifa.setValor(valor);

        createTarifaUseCase.execute(tarifa);
        JOptionPane.showMessageDialog(null, "Tarifa creada correctamnte!  ");

    }

    public void buscar() throws SQLException {
        String idString = JOptionPane.showInputDialog("Ingrese Id a bucar");
        int id = Integer.parseInt(idString);
        Tarifa tarifa = new Tarifa();

        tarifa = findTarifaUseCase.execute(id);
        if (tarifa != null) {
            JPanel panel = new JPanel(new GridLayout(0, 2));
            panel.add(new JLabel("Tarifa Encontrada"));
            panel.add(new JLabel("Id de la tarifa:"));
            panel.add(new JLabel(String.valueOf(tarifa.getId())));
            panel.add(new JLabel("Detalle de la tarifa:"));
            panel.add(new JLabel(tarifa.getDetalles()));
            panel.add(new JLabel("Descripcion de la tarifa:"));
            panel.add(new JLabel(tarifa.getDescripcion()));
            panel.add(new JLabel("Valor de la tarifa:"));
            panel.add(new JLabel(String.valueOf(tarifa.getValor())));

        } else {
            JOptionPane.showMessageDialog(null, "Tarifa no encontrada  ");
        }

    }

    public void actualizar() throws SQLException {
        String idString = JOptionPane.showInputDialog("Ingrese id modificar");
        int id = Integer.parseInt(idString);

        Tarifa tarifaExistente = new Tarifa();
        tarifaExistente = findTarifaUseCase.execute(id);
        if (tarifaExistente != null) {
            String descripcion = JOptionPane.showInputDialog("Ingrese descripcion");

            String detalle = JOptionPane.showInputDialog("Ingrese detalle");

            String valorString = JOptionPane.showInputDialog("Ingrese valor");

            Tarifa tarifa = new Tarifa();
            BigDecimal valor = new BigDecimal(valorString);
            tarifa.setId(id);
            tarifa.setDescripcion(descripcion);
            tarifa.setDetalles(detalle);
            tarifa.setValor(valor);
            updateTarifaUseCase.execute(tarifa);
        }else{
            JOptionPane.showMessageDialog(null, "Tarifa no encontrada  ");
        }

        
    }

    public void eliminar() throws SQLException {
        String idString = JOptionPane.showInputDialog("Ingrese id a eliminar");
        int id = Integer.parseInt(idString);

        Tarifa tarifaExistente= new Tarifa();
        tarifaExistente = findTarifaUseCase.execute(id);
        if (tarifaExistente!= null) {
            deleteTarifaUseCase.execute(id);
            JOptionPane.showMessageDialog(null, "Tarifa eliminada correctamente ");
        }else{
            JOptionPane.showMessageDialog(null, "Tarifa no encontrada  ");
        }
        
    }
}
