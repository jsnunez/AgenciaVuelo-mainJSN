package com.agencia.reserva.application;

import com.agencia.reserva.domain.service.ReservaServiceOlf;

public class DeleteDetalleReserva {
    private final ReservaServiceOlf reservaServiceOlf;

    public DeleteDetalleReserva(ReservaServiceOlf reservaServiceOlf) {
        this.reservaServiceOlf = reservaServiceOlf;
    }
 public void execute(int id){
        reservaServiceOlf.deleteDetalleReserva(id);
    }

    
}
