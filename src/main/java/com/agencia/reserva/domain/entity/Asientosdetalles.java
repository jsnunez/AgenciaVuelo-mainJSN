package com.agencia.reserva.domain.entity;

public class Asientosdetalles {
int idConexion;
int idDetalleReserva;
int idAsiento;
int idConexionnuevo;
public Asientosdetalles(int idConexion, int idDetalleReserva, int idAsiento, int idConexionnuevo) {
    this.idConexion = idConexion;
    this.idDetalleReserva = idDetalleReserva;
    this.idAsiento = idAsiento;
    this.idConexionnuevo = idConexionnuevo;
}
public Asientosdetalles() {
}
public int getIdConexion() {
    return idConexion;
}
public void setIdConexion(int idConexion) {
    this.idConexion = idConexion;
}
public int getIdDetalleReserva() {
    return idDetalleReserva;
}
public void setIdDetalleReserva(int idDetalleReserva) {
    this.idDetalleReserva = idDetalleReserva;
}
public int getIdAsiento() {
    return idAsiento;
}
public void setIdAsiento(int idAsiento) {
    this.idAsiento = idAsiento;
}
public int getIdConexionnuevo() {
    return idConexionnuevo;
}
public void setIdConexionnuevo(int idConexionnuevo) {
    this.idConexionnuevo = idConexionnuevo;
}



}
