package com.proyectojane.pedidoss.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId; // ID del cliente que compró
    private String nombreCliente; // Para mostrarlo fácil en el admin
    
    private Double totalCompra;
    
    @Column(columnDefinition = "TEXT")
    private String detalleProductos; // Ej: "2x CocaCola, 1x Pan" (JSON stringificado)

    private String estado; // PAGADO, ENVIADO, ENTREGADO

    private LocalDateTime fechaCreacion;

    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
        if (this.estado == null) {
            this.estado = "PAGADO"; // Por defecto al crear
        }
    }
}