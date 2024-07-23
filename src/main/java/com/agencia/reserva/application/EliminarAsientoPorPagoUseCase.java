package com.agencia.reserva.application;

import com.agencia.reserva.domain.service.vueloService;

public class EliminarAsientoPorPagoUseCase {
    private final vueloService vueloService;

    public EliminarAsientoPorPagoUseCase(com.agencia.reserva.domain.service.vueloService vueloService) {
        this.vueloService = vueloService;
    }

    public void execute(int id){
        vueloService.eliminarAsientoPago(id);
    }

}
