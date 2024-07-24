import java.sql.SQLException;

import com.agencia.menu.application.iniciarsesion;
import com.agencia.menu.domain.Service.menuService;
import com.agencia.menu.infraestructure.menuRepository;
import com.agencia.menu.infraestructure.menuUI;
import com.agencia.reserva.application.BuscarTiposDocumentos;
import com.agencia.reserva.domain.service.vueloService;
import com.agencia.reserva.infraestructure.out.vueloRepository;

public class Main {
    public static void main(String[] args) throws SQLException {

        menuService menuService = new menuRepository();
        vueloService vueloService = new vueloRepository();
        BuscarTiposDocumentos buscarTiposDocumentos = new BuscarTiposDocumentos(vueloService);
        iniciarsesion iniciarsesion = new iniciarsesion(menuService);
        menuUI menuUI = new menuUI(buscarTiposDocumentos, iniciarsesion);
        menuUI.menu();

    }}