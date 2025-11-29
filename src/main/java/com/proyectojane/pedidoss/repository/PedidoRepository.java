package com.proyectojane.pedidoss.repository;

import com.proyectojane.pedidoss.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Buscar todos los pedidos de un usuario específico
    List<Pedido> findByUsuarioId(Long usuarioId);
}