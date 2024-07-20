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
      String query = "SELECT nombre  FROM clientes c where idtipodocumento= ? AND numerodocumento=? AND password= ?";
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
          usuario.setNombre(rs.getString("nombre"));

        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    }
    if (usuario.getTipoUser().equals("Empleado")) {
      String query = "SELECT nombre  FROM empleados c where idtipodocumento= ? AND numerodocumento=? AND password= ?";
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
          usuario.setNombre(rs.getString("nombre"));

        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    }
    

    return usuario;
  }

}