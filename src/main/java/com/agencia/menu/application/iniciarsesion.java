package com.agencia.menu.application;


import com.agencia.menu.domain.Service.menuService;
import com.agencia.menu.domain.Service.entity.User;

public class iniciarsesion {
    private final menuService menuService;

    public iniciarsesion(menuService menuService) {
        this.menuService = menuService;
    }

    
    public User execute(User usuario) {
     
       return menuService.inciarSesion(usuario);
     
    }
}
