package com.agencia.reserva.application;

import com.agencia.reserva.domain.entity.Reserva;
//import com.agencia.reserva.domain.entity.vuelo;

import com.agencia.reserva.domain.service.vueloService;

public class ConsultaPrecioUseCase {
    private final vueloService vueloService;
    
    
    
    public ConsultaPrecioUseCase(com.agencia.reserva.domain.service.vueloService vueloService) {
        this.vueloService = vueloService;
    }
    public Reserva execute (int id){
        return vueloService.consultatarifa(id);

    }

}
