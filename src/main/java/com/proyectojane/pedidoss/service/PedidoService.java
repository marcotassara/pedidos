package com.proyectojane.pedidoss.service;

import com.proyectojane.pedidoss.model.Pedido;
import com.proyectojane.pedidoss.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido crearPedido(Pedido pedido) {
        // Aquí podrías validar stock llamando al otro microservicio, 
        // pero por simplicidad para el examen, solo guardamos la venta.
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> obtenerPedidosPorUsuario(Long usuarioId) {
        return pedidoRepository.findByUsuarioId(usuarioId);
    }
    
    public List<Pedido> obtenerTodos() {
        return pedidoRepository.findAll();
    }
}