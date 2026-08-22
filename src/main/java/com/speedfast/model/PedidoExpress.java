package com.speedfast.model;

/**
 * Representa un pedido de tipo express.
 */
public class PedidoExpress extends Pedido {

    public PedidoExpress(String idPedido, String direccionEntrega,
                         double distanciaKm, String tipoEntrega) {

        super(idPedido, direccionEntrega, distanciaKm, tipoEntrega);
    }

    @Override
    public int calcularTiempoEntrega() {
        return getDistanciaKm() > 5 ? 15 : 10;
    }

    /**
     * Asigna un repartidor al pedido express.
     */
    public void asignarRepartidor() {
        System.out.println("[Pedido Express]");
        System.out.println();
        System.out.println("Asignando repartidor...");
        System.out.println();
        System.out.println("-> Repartidor más cercano con disponibilidad inmediata encontrado.");
    }

    /**
     * Asigna un repartidor específico.
     */
    public void asignarRepartidor(String nombreRepartidor) {
        asignarRepartidor();
        System.out.println("-> Pedido asignado a " + nombreRepartidor);
    }
}