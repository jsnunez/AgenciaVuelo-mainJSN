package com.agencia.menu.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.agencia.menu.domain.Service.menuService;
import com.agencia.menu.domain.Service.entity.User;

public class menuRepository implements menuService {
  private Connection connection;

  public menuRepository() {
    try {
      Properties props = new Properties();
      props.load(getClass().getClassLoader().getResourceAsStream("configdb.properties"));
      String url = props.getProperty("url");
      String user = props.getProperty("user");
      String password = props.getProperty("password");

      System.out.println("URL: " + url); // Verificar la URL cargada
      System.out.println("User: " + user); // Verificar el usuario cargado
      // N
      connection = DriverManager.getConnection(url, user, password);
      System.out.println("Conexión exitosa!");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  @Override
  public User inciarSesion(User usuario) {

    if (usuario.getTipoUser().equals("Cliente")) {
      String query = "SELECT c.nombre,c.rol,r.nombre AS rol  FROM clientes AS c JOIN roles AS r ON c.rol=r.id  where idtipodocumento= ? AND numerodocumento=? AND password= ?";
    System.out.println(usuario.getNombre());
    System.out.println(usuario.getIdTipoDocumento());
    System.out.println(usuario.getNumeroDocumento());
    System.out.println(usuario.getPassword());

    try (PreparedStatement ps = connection.prepareStatement(query)) {
      ps.setInt(1, usuario.getIdTipoDocumento());
      ps.setString(2, usuario.getNumeroDocumento());
      ps.setString(3, usuario.getPassword());

      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          usuario.setNombre(rs.getString("c.nombre"));
          usuario.setRol(rs.getInt("c.rol"));
          usuario.setStringRol(rs.getString("rol"));

        }




      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    }
    if (usuario.getTipoUser().equals("Empleado")) {
      String query = "SELECT e.nombre, e.idrol, r.nombre AS rol  FROM empleados  AS e JOIN roles AS r ON e.idrol=r.id  where idtipodocumento= ? AND numerodocumento=? AND password= ?;";
    System.out.println(usuario.getNombre());
    System.out.println(usuario.getIdTipoDocumento());
    System.out.println(usuario.getNumeroDocumento());
    System.out.println(usuario.getPassword());

    try (PreparedStatement ps = connection.prepareStatement(query)) {
      ps.setInt(1, usuario.getIdTipoDocumento());
      ps.setString(2, usuario.getNumeroDocumento());
      ps.setString(3, usuario.getPassword());

      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          usuario.setNombre(rs.getString("e.nombre"));
          usuario.setRol(rs.getInt("e.idrol"));
          usuario.setStringRol(rs.getString("rol"));
System.out.println(usuario.getStringRol());
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    }
    

    return usuario;
  }



}