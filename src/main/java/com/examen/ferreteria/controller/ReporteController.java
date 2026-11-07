package com.examen.ferreteria.controller;

import com.examen.ferreteria.dto.ArticuloCategoriaDTO;
import com.examen.ferreteria.dto.ClienteFacturaDTO;
import com.examen.ferreteria.dto.DetalleFacturaDTO;
import com.examen.ferreteria.entity.Articulo;
import com.examen.ferreteria.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    // Endpoint 1: /api/articulos/mostrarActivosFiltro?nombre=...
    @GetMapping("/articulos/mostrarActivosFiltro")
    public List<Articulo> mostrarActivosFiltro(@RequestParam("nombre") String nombre) {
        return reporteService.listarArticulosPorFiltro(nombre);
    }

    // Endpoint 2: /api/articulos/reporteArticuloCategoria
    @GetMapping("/articulos/reporteArticuloCategoria")
    public List<ArticuloCategoriaDTO> reporteArticuloCategoria() {
        return reporteService.obtenerReporteArticuloCategoria();
    }

    // Endpoint 3: /api/clientes/reporteClienteFactura
    @GetMapping("/clientes/reporteClienteFactura")
    public List<ClienteFacturaDTO> reporteClienteFactura() {
        return reporteService.obtenerReporteClienteFactura();
    }

    // Endpoint 4: /api/facturas/reporteDetalleFactura
    @GetMapping("/facturas/reporteDetalleFactura")
    public List<DetalleFacturaDTO> reporteDetalleFactura() {
        return reporteService.obtenerReporteDetalleFactura();
    }
}
