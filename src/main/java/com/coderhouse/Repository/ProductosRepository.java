package com.coderhouse.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.coderhouse.models.Producto;

@Repository
public interface ProductosRepository extends JpaRepository<Producto, Long>{

}
