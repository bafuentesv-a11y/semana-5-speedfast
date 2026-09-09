package com.speedfast.model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("       SPEEDFAST - SEMANA 5");
        System.out.println("   SINCRONIZACIÓN DE ENTREGAS");
        System.out.println("======================================\n");

        // Crear pedidos
        Pedido pedidoComida1 = new PedidoComida(
                101,
                "Av. Italia 456",
                4,
                "Entrega estándar"
        );

        Pedido pedidoExpress1 = new PedidoExpress(
                102,
                "Av. Apoquindo 1500",
                7,
                "Entrega express"
        );

        Pedido pedidoEncomienda1 = new PedidoEncomienda(
                103,
                "Av. Independencia 123",
                6,
                "Entrega estándar"
        );

        Pedido pedidoComida2 = new PedidoComida(
                104,
                "Av. Providencia 850",
                3,
                "Entrega estándar"
        );

        Pedido pedidoExpress2 = new PedidoExpress(
                105,
                "Av. Las Condes 2500",
                5,
                "Entrega express"
        );

        Pedido pedidoEncomienda2 = new PedidoEncomienda(
                106,
                "Av. Vicuña Mackenna 1200",
                8,
                "Entrega estándar"
        );

        // Crear zona de carga compartida
        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        // Agregar pedidos a la zona de carga
        zonaDeCarga.agregarPedido(pedidoComida1);
        zonaDeCarga.agregarPedido(pedidoExpress1);
        zonaDeCarga.agregarPedido(pedidoEncomienda1);
        zonaDeCarga.agregarPedido(pedidoComida2);
        zonaDeCarga.agregarPedido(pedidoExpress2);
        zonaDeCarga.agregarPedido(pedidoEncomienda2);

        // Crear repartidores
        Repartidor camila = new Repartidor(
                "Camila",
                true,
                zonaDeCarga
        );

        Repartidor luis = new Repartidor(
                "Luis",
                true,
                zonaDeCarga
        );

        Repartidor pedro = new Repartidor(
                "Pedro",
                true,
                zonaDeCarga
        );

        // Crear y ejecutar los hilos
        System.out.println("\n===== INICIO DE ENTREGAS =====\n");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(camila);
        executor.submit(luis);
        executor.submit(pedro);

        executor.shutdown();

        // Esperar a que todos los repartidores terminen
        while (!executor.isTerminated()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(
                        "La espera de las entregas fue interrumpida."
                );
                Thread.currentThread().interrupt();
                break;
            }
        }

        // Mensaje final
        System.out.println(
                "\n===== TODOS LOS PEDIDOS HAN SIDO ENTREGADOS ====="
        );

        System.out.println(
                "Todos los pedidos han sido entregados correctamente"
        );

        System.out.println("\n======================================");
        System.out.println("       FIN DE LA SIMULACIÓN");
        System.out.println("======================================");
    }
}