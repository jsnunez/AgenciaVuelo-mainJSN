package com.agencia.reserva.domain.entity;

public class DetalleReserva {
int id;
int idReserva;
int idPasajero;
int idconexion;
public DetalleReserva() {
}
public DetalleReserva(int id, int idReserva, int idPasajero, int idconexion) {
    this.id = id;
    this.idReserva = idReserva;
    this.idPasajero = idPasajero;
    this.idconexion = idconexion;
}
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public int getIdReserva() {
    return idReserva;
}
public void setIdReserva(int idReserva) {
    this.idReserva = idReserva;
}
public int getIdPasajero() {
    return idPasajero;
}
public void setIdPasajero(int idPasajero) {
    this.idPasajero = idPasajero;
}
public int getIdconexion() {
    return idconexion;
}
public void setIdconexion(int idconexion) {
    this.idconexion = idconexion;
}


}
