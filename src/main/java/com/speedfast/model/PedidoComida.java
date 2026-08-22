package com.speedfast.model;

public class PedidoComida extends Pedido {

    public PedidoComida(String idPedido, String direccionEntrega, double distanciaKm, String tipoEntrega) {
        super(idPedido, direccionEntrega, distanciaKm, tipoEntrega);
    }

    @Override
    public int calcularTiempoEntrega() {
        return (int) Math.round(15 + (2 * getDistanciaKm()));
    }

    @Override
    public void mostrarResumen() {
        super.mostrarResumen();
        System.out.println("Factor de duración: 15 min base + 2 min por km.");
    }
}
