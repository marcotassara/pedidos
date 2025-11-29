package com.proyectojane.pedidoss.controller;

import com.proyectojane.pedidoss.model.Pedido;
import com.proyectojane.pedidoss.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*") // Permite conexión desde React
@Tag(name = "Microservicio de Pedidos", description = "Gestión de ventas y órdenes de compra")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    @Operation(summary = "Crear nuevo pedido", description = "Registra una compra realizada por un usuario")
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoService.crearPedido(pedido));
    }

    @GetMapping("/usuario/{usuarioId}")
    @Operation(summary = "Mis Pedidos", description = "Obtiene el historial de compras de un cliente")
    public List<Pedido> verPedidosUsuario(@PathVariable Long usuarioId) {
        return pedidoService.obtenerPedidosPorUsuario(usuarioId);
    }

    @GetMapping
    @Operation(summary = "Listar todas las ventas", description = "Uso exclusivo para administradores")
    public List<Pedido> verTodos() {
        return pedidoService.obtenerTodos();
    }
}