package com.agencia.reserva.application;

import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.reserva.domain.entity.vuelo;
import com.agencia.reserva.domain.service.vueloService;

public class PagoUseCase {
    private final vueloService vueloService;
    
    public PagoUseCase(vueloService vueloService) {
        this.vueloService = vueloService;
    }
    
   
    public void execute (Reserva reserva){
        vueloService.pagoReserva(reserva);

    }

}
