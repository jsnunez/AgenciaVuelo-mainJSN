package com.agencia.menu.domain.Service.entity;

public class User {
int idTipoDocumento;
String NumeroDocumento;
String password;
String nombre;
String tipoUser;
public User() {
}
public User(int idTipoDocumento, String numeroDocumento, String password, String nombre, String tipoUser) {
    this.idTipoDocumento = idTipoDocumento;
    NumeroDocumento = numeroDocumento;
    this.password = password;
    this.nombre = nombre;
    this.tipoUser = tipoUser;
}
public int getIdTipoDocumento() {
    return idTipoDocumento;
}
public void setIdTipoDocumento(int idTipoDocumento) {
    this.idTipoDocumento = idTipoDocumento;
}
public String getNumeroDocumento() {
    return NumeroDocumento;
}
public void setNumeroDocumento(String numeroDocumento) {
    NumeroDocumento = numeroDocumento;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public String getTipoUser() {
    return tipoUser;
}
public void setTipoUser(String tipoUser) {
    this.tipoUser = tipoUser;
}




}