package com.coderhouse.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderhouse.models.Ventas;
@Repository
public interface VentasRepository extends JpaRepository<Ventas, Long> {

}
