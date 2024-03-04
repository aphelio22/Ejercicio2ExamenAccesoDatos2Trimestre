package com.example.ejercicio2examenaccesodatos2trimestre.controller;

import com.example.ejercicio2examenaccesodatos2trimestre.model.Cliente;
import com.example.ejercicio2examenaccesodatos2trimestre.repository.ClienteRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
 @RequestMapping("api/clientexamen")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientePorId/{id}")
    public Cliente getClienteById(@PathVariable Integer id) {
        return clienteRepository.getClienteById(id);
    }

    @GetMapping("/clientesActivosConVentas")
    public List<Cliente> getClientesActivosConVentasMayores(@RequestParam Double cantidad) {
        return clienteRepository.findClientesActivosConVentasMayores(cantidad);
    }

    @PostMapping("/nuevoCliente/post")
    public ResponseEntity<Cliente> nuevoCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity<Cliente>(clienteRepository.save(cliente), HttpStatus.OK);
    }

    @GetMapping("/resumenEstadistico")
    public Map<String, Object> getResumenEstadistico() {
        Map<String, Object> resumen = new HashMap<>();
        Double totalVentas = clienteRepository.sumTotalVentas();
        resumen.put("total", totalVentas);

        Double promedioVentas = clienteRepository.avgVentas();
        resumen.put("promedio", promedioVentas);

        Long clientesInactivos = clienteRepository.countClientesInactivos();
        resumen.put("inactivos", clientesInactivos);

        return resumen;
    }
}
