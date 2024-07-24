package com.agencia.reserva.application;

import com.agencia.reserva.domain.entity.Asientosdetalles;
import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.reserva.domain.service.vueloService;

public class ActualizarReserva {
    private final vueloService vueloService;

    public ActualizarReserva(com.agencia.reserva.domain.service.vueloService vueloService) {
        this.vueloService = vueloService;
    }

      public void execute(Reserva reserva,Asientosdetalles asientosdetalles) {
        vueloService.modificarReserva(reserva,asientosdetalles);
    }
}
