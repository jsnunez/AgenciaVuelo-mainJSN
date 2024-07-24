package com.agencia.reserva.infraestructure.in;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.agencia.escala.application.FindEscalaUseCase;
import com.agencia.escala.domain.entity.Escala;
import com.agencia.reserva.application.*;
import com.agencia.reserva.domain.entity.Asientosdetalles;
import com.agencia.reserva.domain.entity.BuscarVuelo;
import com.agencia.reserva.domain.entity.Ciudad;
import com.agencia.reserva.domain.entity.DetalleReserva;
import com.agencia.reserva.domain.entity.Pasajero;
import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.tipoDocumento.domain.entity.TipoDocumento;
import com.toedter.calendar.JCalendar;

public class vueloController {
  private final ConsultvueloUseCase consultvueloUseCase;
  private final BuscarCiudades buscarCiudades;
  private final BuscarvuelosUseCase buscarvuelosUseCase;
  private final CrearReservaUseCase crearReservaUseCase;
  private final VerificarPasajero verificarPasajero;
  private final BuscarTiposDocumentos buscarTiposDocumentos;
  private final FindEscalaUseCase findEscalaUseCase;
  private final CrearReservaDetalleUseCase crearReservaDetalleUseCase;
  private final AsignarsillaUseCase asignarsillaUseCase;
  private final BuscarSillasOcupadas buscarSillasOcupadas;
  private final DeleteReservaAgenteUseCase deleteReservaAgenteUseCase;
  private final DeleteDetalleReserva deleteDetalleReserva;
  private final EliminarAsientoPorPagoUseCase eliminarAsientoPorPagoUseCase;
  private final ConsultaPrecioUseCase consultaPrecioUseCase;
  private final PagoUseCase pagoUseCase;
  private final FindReservaAgenteUseCase findReservaAgenteUseCase;
  private final BuscarPasajerosReserva buscarPasajerosReserva;
  private final BuscarDetalleReserva buscarDetalleReserva;
  private final ActualizarReserva actualizarReserva;

  public vueloController(ConsultvueloUseCase consultvueloUseCase, BuscarCiudades buscarCiudades,
      BuscarvuelosUseCase buscarvuelosUseCase, CrearReservaUseCase crearReservaUseCase,
      VerificarPasajero verificarPasajero, BuscarTiposDocumentos buscarTiposDocumentos,
      FindEscalaUseCase findEscalaUseCase, CrearReservaDetalleUseCase crearReservaDetalleUseCase,
      AsignarsillaUseCase asignarsillaUseCase, BuscarSillasOcupadas buscarSillasOcupadas,
      DeleteReservaAgenteUseCase deleteReservaAgenteUseCase, DeleteDetalleReserva deleteDetalleReserva,
      EliminarAsientoPorPagoUseCase eliminarAsientoPorPagoUseCase, ConsultaPrecioUseCase consultaPrecioUseCase,
      PagoUseCase pagoUseCase, FindReservaAgenteUseCase findReservaAgenteUseCase,
      BuscarPasajerosReserva buscarPasajerosReserva, BuscarDetalleReserva buscarDetalleReserva,
      ActualizarReserva actualizarReserva) {
    this.consultvueloUseCase = consultvueloUseCase;
    this.buscarCiudades = buscarCiudades;
    this.buscarvuelosUseCase = buscarvuelosUseCase;
    this.crearReservaUseCase = crearReservaUseCase;
    this.verificarPasajero = verificarPasajero;
    this.buscarTiposDocumentos = buscarTiposDocumentos;
    this.findEscalaUseCase = findEscalaUseCase;
    this.crearReservaDetalleUseCase = crearReservaDetalleUseCase;
    this.asignarsillaUseCase = asignarsillaUseCase;
    this.buscarSillasOcupadas = buscarSillasOcupadas;
    this.deleteReservaAgenteUseCase = deleteReservaAgenteUseCase;
    this.deleteDetalleReserva = deleteDetalleReserva;
    this.eliminarAsientoPorPagoUseCase = eliminarAsientoPorPagoUseCase;
    this.consultaPrecioUseCase = consultaPrecioUseCase;
    this.pagoUseCase = pagoUseCase;
    this.findReservaAgenteUseCase = findReservaAgenteUseCase;
    this.buscarPasajerosReserva = buscarPasajerosReserva;
    this.buscarDetalleReserva = buscarDetalleReserva;
    this.actualizarReserva = actualizarReserva;
  }

  public void consultar() throws SQLException {
    String idString = JOptionPane.showInputDialog("Ingrese ID vuelo");
    int id = Integer.parseInt(idString);
    consultvueloUseCase.execute(id);

  }

  public void buscar() {
    List<Ciudad> ciudades = new ArrayList<>();
    ciudades = buscarCiudades.execute();
    BuscarVuelo bvuelo = new BuscarVuelo();
    bvuelo = seleccionaCiudades(ciudades);
    String fechaida = SeleccionarFecha();
    bvuelo.setFechaIda(fechaida);
    bvuelo.setIdAeropuertoOrigen("0");
    List<String> vuelos = buscarvuelosUseCase.execute(bvuelo);
    String Idvuelo = SeleccionarVuelo(vuelos);
    var yesOrNo = 0;
    bvuelo.setIdvuelo(Idvuelo);
    int idReserva;
    int idDetalleReserva = 0;
    List<Escala> escalas = findEscalaUseCase.execute(Integer.valueOf(Idvuelo));
    List<Integer> listIdDetalleReserva = new ArrayList<>();
    ;
    if (escalas.isEmpty()) {
      System.out.println(escalas);
      // escalas.forEach(escala -> System.out.println(escala.getId()));
      JOptionPane.showMessageDialog(null, "No existen escalas para este vuelo ");

    }
    if (!escalas.isEmpty()) {
      for (Escala escala : escalas) {
        System.out.println("Escala id: " + escala.getId());
        System.out.println("Número de conexión: " + escala.getNumeroConexion());
        System.out.println("Id trayecto: " + escala.getIdViaje());
        System.out.println("Id Avión: " + escala.getIdAvion());
        System.out.println("Id aeropuerto origen: " + escala.getIdAeropuertoOrigen());
        System.out.println("Id aeropuerto destino: " + escala.getIdAeropuertoDestino());
        System.out.println("------------"); // Separador para mayor claridad
      }
    }
    Asientosdetalles asientodetalle = new Asientosdetalles();
    idReserva = crearReservaUseCase.execute(bvuelo);
    while (yesOrNo == 0) {

      List<TipoDocumento> tipos = buscarTiposDocumentos.execute();
      Pasajero pasajero = verificarPasajero(tipos, idReserva);
      if (pasajero.getDocumento().equals("ninguno")) {
        JOptionPane.showMessageDialog(null, "regreando al menu ");

        break;
      }
      System.out.println(pasajero.getIdTipoDocumento());
      System.out.println(pasajero.getDocumento());
      int idPasajero = verificarPasajero.execute(pasajero);
      DetalleReserva detalleReserva = new DetalleReserva();

      detalleReserva.setIdReserva(idReserva);
      detalleReserva.setIdPasajero(idPasajero);
      idDetalleReserva = crearReservaDetalleUseCase.execute(detalleReserva);
      detalleReserva.setId(idDetalleReserva);
      listIdDetalleReserva.add(idDetalleReserva);

      System.out.println("cantidad" + escalas.size());
      int sillaseleccionada;

      JOptionPane.showMessageDialog(null, "Selecciona silla");

      for (int j = 0; j < escalas.size(); j++) {

        sillaseleccionada = seleccionarSilla(escalas.get(j));
        asientodetalle.setIdConexion(escalas.get(j).getId());
        asientodetalle.setIdDetalleReserva(idDetalleReserva);
        asientodetalle.setIdAsiento(sillaseleccionada);
        asignarsillaUseCase.execute(asientodetalle);
      }

      yesOrNo = JOptionPane.showConfirmDialog(null, "Desea agregar un nuevo pasajero?");
      if (yesOrNo == JOptionPane.CANCEL_OPTION) {
        for (Integer id : listIdDetalleReserva) {
          eliminarAsientoPorPagoUseCase.execute(id);

        }
        deleteDetalleReserva.execute(idReserva);
        Reserva reserva = new Reserva();
        reserva.setId(idReserva);
        deleteReservaAgenteUseCase.execute(reserva);
        JOptionPane.showMessageDialog(null, "cerrando aplicativo");

      }
    }

    JOptionPane.showMessageDialog(null, "Entrando a pasarela de pago");
    // Consultar precio
    Reserva reservaPrecio = consultaPrecioUseCase.execute(idReserva);
    System.out.println("idreserva:" + idReserva);
    int tarifaTotal = reservaPrecio.getPrecio();
    System.out.println("la tarifa" + tarifaTotal);
    String mensaje = String.format("El Id de reserva: %d, tarifa: %d",
        idReserva, tarifaTotal);

    int respuesta = JOptionPane.showConfirmDialog(null, mensaje, "Confirmacion de pago", JOptionPane.YES_NO_OPTION);
    if (respuesta == JOptionPane.YES_OPTION) {
      String[] opcionesPago = { "Tarjeta de Crédito", "PSE", "Bancolombia", "PayPal" };
      JComboBox<String> comboBox = new JComboBox<>(opcionesPago);
      int seleccionPago = JOptionPane.showOptionDialog(null,
          new Object[] { "Selecciona un método de pago:", comboBox },
          "Método de Pago",
          JOptionPane.OK_CANCEL_OPTION,
          JOptionPane.QUESTION_MESSAGE,
          null,
          null,
          null);
      if (seleccionPago == JOptionPane.OK_OPTION) {
        String metodoSeleccionado = (String) comboBox.getSelectedItem();
        JOptionPane.showMessageDialog(null, "Método de pago seleccionado: " + metodoSeleccionado);

        // Ejecutar el método de pago
        pagoUseCase.execute(reservaPrecio);
        JOptionPane.showMessageDialog(null, "Procesando el pago...");

      } else {
        // aqui agregar opciones de eliminar la reserva,sientos

        for (Integer id : listIdDetalleReserva) {
          eliminarAsientoPorPagoUseCase.execute(id);

        }
        deleteDetalleReserva.execute(idReserva);
        Reserva reserva = new Reserva();
        reserva.setId(idReserva);
        deleteReservaAgenteUseCase.execute(reserva);

        JOptionPane.showMessageDialog(null, "No se ha realizado el pago y se cancela reserva ");

      }
    }
  }

  public Pasajero verificarPasajero(List<TipoDocumento> tipos, int id) {
    int idtipodocumento = 0;
    List<String> listTiposDocuemtnos = new ArrayList<>();
    for (TipoDocumento tipoDocumento : tipos) {
      listTiposDocuemtnos.add(tipoDocumento.getNombre());
    }
    String tipoDocumento = null;
    JComboBox<String> comboBoxTipoDocumento = new JComboBox<>(listTiposDocuemtnos.toArray(new String[0]));
    JPanel panelBuscar = new JPanel(new GridLayout(0, 2));
    // JPanel panel = new JPanel(new GridLayout(0, 2));
    panelBuscar.add(new JLabel("Seleccione tipo Documento:"));
    panelBuscar.add(comboBoxTipoDocumento);
    JLabel documetoJLabel = new JLabel("Numero documento:");
    JTextField documentoField = new JTextField();
    panelBuscar.add(documetoJLabel);
    panelBuscar.add(documentoField);
    int result = JOptionPane.showConfirmDialog(null, panelBuscar, "ingrese datos del usuario",
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE);
    String numeroDocumento = "";

    if (result == JOptionPane.OK_OPTION) {
      tipoDocumento = (String) comboBoxTipoDocumento.getSelectedItem();
      numeroDocumento = documentoField.getText();
    }

    if (result == JOptionPane.CANCEL_OPTION) {
      Reserva elimina = new Reserva();
      elimina.setId(id);
      deleteReservaAgenteUseCase.execute(elimina);
      JOptionPane.showMessageDialog(null, "se cancelo la reseva");
      tipoDocumento = "DNI";
      numeroDocumento = "ninguno";

    }

    for (TipoDocumento selecionado : tipos) {
      if (tipoDocumento.equals(selecionado.getNombre())) {
        idtipodocumento = selecionado.getId();
      }
    }
    Pasajero pasajero = new Pasajero(idtipodocumento, numeroDocumento);
    pasajero.setTipoDocumento(tipoDocumento);
    return pasajero;

  }

  public BuscarVuelo seleccionaCiudades(List<Ciudad> ciudades) {
    List<String> nombres = new ArrayList<>();
    for (Ciudad ciudad : ciudades) {
      nombres.add(ciudad.getCiudad());
    }

    JComboBox<String> comboBoxCiudadesorigen = new JComboBox<>(nombres.toArray(new String[0]));
    JComboBox<String> comboBoxCiudadesdestino = new JComboBox<>(nombres.toArray(new String[0]));

    JPanel panel = new JPanel(new GridLayout(0, 2));
    panel.add(new JLabel("Seleccione una ciudad origen:"));
    panel.add(comboBoxCiudadesorigen);
    panel.add(new JLabel("Seleccione una ciudad destino:"));
    panel.add(comboBoxCiudadesdestino);
    BuscarVuelo bvuelo = new BuscarVuelo();
    int result = JOptionPane.showConfirmDialog(null, panel, "Seleccionar Ciudad origen y destino",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    if (result == JOptionPane.OK_OPTION) {
      String selectedCiudadorigen = (String) comboBoxCiudadesorigen.getSelectedItem();
      String selectedCiudaddestino = (String) comboBoxCiudadesdestino.getSelectedItem();
      System.out.println("Ciudad origen seleccionada: " + selectedCiudadorigen);
      System.out.println("Ciudad destino seleccionada: " + selectedCiudaddestino);
      bvuelo.setCiudadOrigen(selectedCiudadorigen);
      bvuelo.setCiudadDestino(selectedCiudaddestino);
    }
    return bvuelo;

  }

  public String SeleccionarFecha() {
    JCalendar calendar = new JCalendar();
    JPanel panelc = new JPanel(new GridLayout(0, 2));
    panelc.add(new JLabel("Seleccione una fecha:"));
    panelc.add(calendar);

    int resultc = JOptionPane.showConfirmDialog(null, panelc, "Seleccionar Fecha", JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE);
    String fechaida = "";
    if (resultc == JOptionPane.OK_OPTION) {
      Date selectedDate = calendar.getDate();
      Calendar cal = Calendar.getInstance();
      cal.setTime(selectedDate);
      int dia = cal.get(Calendar.DAY_OF_MONTH);
      int mes = cal.get(Calendar.MONTH) + 1; // Los meses comienzan en 0 en Calendar, por lo que se añade 1
      int año = cal.get(Calendar.YEAR);
      fechaida = año + "-" + mes + "-" + dia;
      System.out.println(fechaida);
    }
    return fechaida;

  }

  public String SeleccionarVuelo(List<String> vuelos) {
    JComboBox<String> comboBoxVuelos = new JComboBox<>(vuelos.toArray(new String[0]));

    JPanel panel = new JPanel(new GridLayout(0, 2));
    panel.add(new JLabel("Seleccione Vuelo:"));
    panel.add(comboBoxVuelos);

    int resultVuelo = JOptionPane.showConfirmDialog(null, panel, "Seleccionar vuelo", JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE);
    String selectVuelo = "";
    if (resultVuelo == JOptionPane.OK_OPTION) {
      selectVuelo = (String) comboBoxVuelos.getSelectedItem();
      System.out.println(selectVuelo);
    }
    return selectVuelo;
  }

  public void actualizar() throws SQLException {
    // String idString = JOptionPane.showInputDialog("Ingrese id modificar");
    // int id = Integer.parseInt(idString);
    // String descripcion = JOptionPane.showInputDialog("Ingrese descripcion");
    // String detalle = JOptionPane.showInputDialog("Ingrese detalle");
    // String valorString = JOptionPane.showInputDialog("Ingrese valor");
    // vuelo vuelo = new vuelo();
    // BigDecimal valor = new BigDecimal(valorString);
    // vuelo.setId(id);
  }

  public void eliminar() throws SQLException {

  }

  public void modificarReserva() {

    String inputReserva = JOptionPane.showInputDialog(null, "Ingrese ID de la reserva a eliminar");
    int idReserva = Integer.parseInt(inputReserva);

    Reserva reserva = findReservaAgenteUseCase.execute(idReserva);
    List<DetalleReserva> lisDetalleReservas = buscarDetalleReserva.execute(reserva);
    if (reserva != null) {
      BuscarVuelo bvuelo = new BuscarVuelo();
      bvuelo.setIdAeropuertoOrigen(reserva.getAeropuertoOrigen());
      bvuelo.setIdAeropuertoDestino(reserva.getAeropuertoDestino());

      bvuelo.setIdvuelo(inputReserva);
      List<Pasajero> pasajeros = buscarPasajerosReserva.execute(bvuelo);
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
      for (Pasajero pasajero : pasajeros) {
        panelEncontrar.add(new JLabel("Nombre pasajero:"));
        panelEncontrar.add(new JLabel(pasajero.getNombre()));
      }
      panelEncontrar.add(new JLabel("Precio Vuelo:"));
      panelEncontrar.add(new JLabel((String.valueOf(reserva.getPrecio()))));
      panelEncontrar.add(new JLabel("Estado Reserva:"));
      panelEncontrar.add(new JLabel((String.valueOf(reserva.getEstado()))));
      JOptionPane.showMessageDialog(null, panelEncontrar, "Detalles de la Reserva",
          JOptionPane.INFORMATION_MESSAGE);
      int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea modificar esta reserva?",
          "Confirmar modificacion", JOptionPane.YES_NO_OPTION);
      if (confirmacion == JOptionPane.YES_OPTION) {

        String fechaida = SeleccionarFecha();
        bvuelo.setIdvuelo(inputReserva);
        bvuelo.setFechaIda(fechaida);
        List<String> vuelos = buscarvuelosUseCase.execute(bvuelo);
        String Idvuelo = SeleccionarVuelo(vuelos);
        bvuelo.setIdvuelo(Idvuelo);
        // int idReservaM;
        int idDetalleReserva = 0;
        List<Escala> escalas = findEscalaUseCase.execute(Integer.valueOf(Idvuelo));
        List<Integer> listIdDetalleReserva = new ArrayList<>();
        ;
        if (escalas.isEmpty()) {
          System.out.println(escalas);
          // escalas.forEach(escala -> System.out.println(escala.getId()));
          JOptionPane.showMessageDialog(null, "No existen escalas para este vuelo ");

        }
        if (!escalas.isEmpty()) {
          for (Escala escala : escalas) {
            System.out.println("Escala id: " + escala.getId());
            System.out.println("Número de conexión: " + escala.getNumeroConexion());
            System.out.println("Id trayecto: " + escala.getIdViaje());
            System.out.println("Id Avión: " + escala.getIdAvion());
            System.out.println("Id aeropuerto origen: " + escala.getIdAeropuertoOrigen());
            System.out.println("Id aeropuerto destino: " + escala.getIdAeropuertoDestino());
            System.out.println("------------"); // Separador para mayor claridad
          }
        }
        Asientosdetalles asientodetalle = new Asientosdetalles();
        for (Pasajero pasajero : pasajeros) {

          if (pasajero.getDocumento().equals("ninguno")) {
            JOptionPane.showMessageDialog(null, "regreando al menu ");

            break;
          }
          System.out.println(pasajero.getIdTipoDocumento());
          System.out.println(pasajero.getDocumento());
          int idPasajero = verificarPasajero.execute(pasajero);
          reserva.setFechaReserva(fechaida);
          reserva.setIdVuelo(Integer.parseInt(Idvuelo));
          DetalleReserva detalleReserva = new DetalleReserva();
          detalleReserva.setIdPasajero(pasajero.getId());
          for (DetalleReserva detalleReserva2 : lisDetalleReservas) {
            System.out.println( "detalle"+detalleReserva2);
            if (detalleReserva.getIdPasajero() == idPasajero) {
              detalleReserva.setId( detalleReserva2.getId());

            }
          }

          // System.out.println("cantidad" + escalas.size());
          int sillaseleccionada;

          JOptionPane.showMessageDialog(null, "Selecciona silla");

          for (int j = 0; j < escalas.size(); j++) {

            sillaseleccionada = seleccionarSilla(escalas.get(j));
            asientodetalle.setIdConexion(escalas.get(j).getId());
            asientodetalle.setIdDetalleReserva(detalleReserva.getId());
            asientodetalle.setIdAsiento(sillaseleccionada);
            actualizarReserva.execute(reserva, asientodetalle);
          }

        }

   
        JOptionPane.showMessageDialog(null, "Reserva Cancelada con éxito");
      } else {
        JOptionPane.showMessageDialog(null, "No se realizó cancelación");
      }

    } else {
      JOptionPane.showMessageDialog(null, "Reserva no encontrada");
    }
  }

  public int seleccionarSilla(Escala escala) {
    JPanel optionsPanel = new JPanel(new GridLayout(6, 20)); // 6 filas y 20 columnas
    optionsPanel.setOpaque(false);
    optionsPanel.setBackground(Color.black);
    JRadioButton[][] options = new JRadioButton[6][20];
    List<String> listaOcupadas = buscarSillasOcupadas.execute(escala.getId());

    ButtonGroup group = new ButtonGroup();

    for (int row = 0; row < 6; row++) {
      for (int col = 0; col < 20; col++) {
        options[row][col] = new JRadioButton(Integer.toString(row * 20 + col + 1));
        options[row][col].setBackground(Color.gray);
        options[row][col].setForeground(Color.green);

        group.add(options[row][col]);
        optionsPanel.add(options[row][col]);

        for (String silla : listaOcupadas) {
          int numsilla = Integer.parseInt(silla);
          int fila = (numsilla - 1) / 20;
          int columna = (numsilla - 1) % 20;

          if (row == fila && col == columna) {
            options[row][col].setEnabled(false);
            options[row][col].setOpaque(true);
          }
        }
      }
    }

    JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
    mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    mainPanel.setOpaque(false);
    mainPanel.add(optionsPanel, BorderLayout.CENTER);

    BackgroundPanel backgroundPanel = new BackgroundPanel(mainPanel, "src\\main\\resources\\avion.png");
    JOptionPane.showMessageDialog(null, backgroundPanel, "Aeropuerto Salida: " + escala.getIdAeropuertoOrigen()
        + " Aeropuerto Llegada: " + escala.getIdAeropuertoDestino(), JOptionPane.PLAIN_MESSAGE);

    String sillaseleccionada = "";
    boolean asientoSeleccionado = false;

    for (int row = 0; row < 6; row++) {
      for (int col = 0; col < 20; col++) {
        if (options[row][col].isSelected()) {
          sillaseleccionada = options[row][col].getText();
          asientoSeleccionado = true;
          System.out.println("Seleccionaste: " + sillaseleccionada);
          break;
        }
      }
      if (asientoSeleccionado) {
        break;
      }
    }

    if (!asientoSeleccionado) {
      System.out.println("No seleccionaste sillas.");
      return -1; // o cualquier otro valor por defecto para indicar que no se hizo una selección
    }

    try {
      return Integer.parseInt(sillaseleccionada);
    } catch (NumberFormatException e) {
      System.out.println("Invalid seat selection: " + sillaseleccionada);
      return -1; // o cualquier otro valor por defecto para indicar una entrada inválida
    }
  }

  class BackgroundPanel extends JPanel {
    private Image backgroundImage;
    @SuppressWarnings("unused")
    private JComponent component;

    public BackgroundPanel(JComponent component, String filePath) {
      this.component = component;
      try {
        backgroundImage = ImageIO.read(new File(filePath));
      } catch (IOException e) {
        e.printStackTrace();
      }
      setLayout(new GridBagLayout());
      add(component);
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (backgroundImage != null) {
        int imgWidth = backgroundImage.getWidth(this);
        int imgHeight = backgroundImage.getHeight(this);
        int x = (getWidth() - imgWidth) / 2;
        int y = (getHeight() - imgHeight) / 2;
        g.drawImage(backgroundImage, x, y, imgWidth, imgHeight, this);
      }
    }

    @Override
    public Dimension getPreferredSize() {
      if (backgroundImage != null) {
        return new Dimension(1200, 700);
      } else {
        return super.getPreferredSize();
      }
    }
  }

}
