package com.speedfast.model;

public class PedidoEncomienda extends Pedido {

    public PedidoEncomienda(String idPedido, String direccionEntrega, double distanciaKm, String tipoEntrega) {
        super(idPedido, direccionEntrega, distanciaKm, tipoEntrega);
    }

    @Override
    public int calcularTiempoEntrega() {
        return (int) Math.round(20 + (1.5 * getDistanciaKm()));
    }

    @Override
    public void mostrarResumen() {
        super.mostrarResumen();
        System.out.println("Factor de duración: 20 min base + 1,5 min por km.");
    }
}
