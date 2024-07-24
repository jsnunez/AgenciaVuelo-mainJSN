package com.agencia.reserva.application;

import java.util.List;

import com.agencia.reserva.domain.entity.BuscarVuelo;

import com.agencia.reserva.domain.entity.Pasajero;
import com.agencia.reserva.domain.service.vueloService;

public class BuscarPasajerosReserva {
    private final vueloService vueloService;

    public BuscarPasajerosReserva(com.agencia.reserva.domain.service.vueloService vueloService) {
        this.vueloService = vueloService;
    }
 public  List<Pasajero>  execute(BuscarVuelo vuelo)  {
                return vueloService.buscarPasajeros(vuelo);
            

        // vueloService.BuscarVuelo();
    }

}
