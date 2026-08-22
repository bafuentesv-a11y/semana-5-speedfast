package com.speedfast;

import com.speedfast.model.Pedido;
import com.speedfast.model.PedidoComida;
import com.speedfast.model.PedidoEncomienda;
import com.speedfast.model.PedidoExpress;

public class Main {
    public static void main(String[] args) {
        Pedido pedidoComida = new PedidoComida(
                "#001", "Av. Italia 456", 4, "Entrega estándar");
        Pedido pedidoEncomienda = new PedidoEncomienda(
                "#002", "Av. Independencia 123", 6, "Entrega estándar");
        Pedido pedidoExpress = new PedidoExpress(
                "#003", "Av. Apoquindo 1500", 7, "Entrega express");

        Pedido[] pedidos = {pedidoComida, pedidoEncomienda, pedidoExpress};

        System.out.println("===== SPEEDFAST - SEMANA 2 =====");
        for (Pedido pedido : pedidos) {
            pedido.mostrarResumen();
            System.out.println("Tiempo estimado de entrega: "
                    + pedido.calcularTiempoEntrega() + " minutos");
            System.out.println("---------------------------------");
        }

        System.out.println("Comparación de tiempos:");
        for (Pedido pedido : pedidos) {
            System.out.printf("%s -> %d minutos%n",
                    pedido.getIdPedido(), pedido.calcularTiempoEntrega());
        }
    }
}
