package com.agencia.reserva.application;

import java.util.List;

import com.agencia.reserva.domain.entity.DetalleReserva;
import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.reserva.domain.service.vueloService;

public class BuscarDetalleReserva {
    private final vueloService vueloService;

    public BuscarDetalleReserva(com.agencia.reserva.domain.service.vueloService vueloService) {
        this.vueloService = vueloService;
    }
public  List<DetalleReserva>  execute(Reserva reserva)  {
                return vueloService.buscarDetalleReserva(reserva);
            

        // vueloService.BuscarVuelo();
    }


}
