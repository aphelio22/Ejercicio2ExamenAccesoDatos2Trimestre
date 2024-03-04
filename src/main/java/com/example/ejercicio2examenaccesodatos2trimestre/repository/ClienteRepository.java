package com.example.ejercicio2examenaccesodatos2trimestre.repository;

import com.example.ejercicio2examenaccesodatos2trimestre.model.Cliente;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    public Cliente getClienteById(Integer id);

    @Query("select c from Cliente c where c.estado = 'activo' AND c.total > :cantidad")
    List<Cliente> findClientesActivosConVentasMayores(@Param("cantidad") Double cantidad);

    @Query("select COUNT(c) from Cliente c where c.estado = 'inactivo'")
    Long countClientesInactivos();

    @Query("select SUM(c.total) from Cliente c")
    Double sumTotalVentas();

    @Query("select AVG(c.total) from Cliente c where c.estado = 'activo'")
    Double avgVentas();
}
