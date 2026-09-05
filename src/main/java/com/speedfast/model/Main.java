package com.speedfast.model;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("       SPEEDFAST - SEMANA 4");
        System.out.println("   SIMULACIÓN DE ENTREGAS CON HILOS");
        System.out.println("======================================\n");


        // ==========================================
        // CREACIÓN DE PEDIDOS
        // ==========================================

        Pedido pedidoComida1 = new PedidoComida(
                "101",
                "Av. Italia 456",
                4,
                "Entrega estándar"
        );

        Pedido pedidoExpress1 = new PedidoExpress(
                "102",
                "Av. Apoquindo 1500",
                7,
                "Entrega express"
        );

        Pedido pedidoEncomienda1 = new PedidoEncomienda(
                "103",
                "Av. Independencia 123",
                6,
                "Entrega estándar"
        );

        Pedido pedidoComida2 = new PedidoComida(
                "104",
                "Av. Providencia 850",
                3,
                "Entrega estándar"
        );

        Pedido pedidoExpress2 = new PedidoExpress(
                "105",
                "Av. Las Condes 2500",
                5,
                "Entrega express"
        );

        Pedido pedidoEncomienda2 = new PedidoEncomienda(
                "106",
                "Av. Vicuña Mackenna 1200",
                8,
                "Entrega estándar"
        );


        // ==========================================
        // CREACIÓN DE LISTAS DE PEDIDOS
        // ==========================================

        List<Pedido> pedidosCamila = Arrays.asList(
                pedidoComida1,
                pedidoExpress1
        );

        List<Pedido> pedidosLuis = Arrays.asList(
                pedidoEncomienda1,
                pedidoComida2
        );

        List<Pedido> pedidosPedro = Arrays.asList(
                pedidoExpress2,
                pedidoEncomienda2
        );


        // ==========================================
        // CREACIÓN DE REPARTIDORES
        // ==========================================

        Repartidor camila = new Repartidor(
                "Camila",
                true,
                pedidosCamila
        );

        Repartidor luis = new Repartidor(
                "Luis",
                true,
                pedidosLuis
        );

        Repartidor pedro = new Repartidor(
                "Pedro",
                true,
                pedidosPedro
        );


        // ==========================================
        // EJECUCIÓN CONCURRENTE
        // ==========================================

        System.out.println("===== INICIO DE ENTREGAS =====\n");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(camila);
        executor.submit(luis);
        executor.submit(pedro);

        executor.shutdown();


        // ==========================================
        // ESPERA A QUE TERMINEN LOS REPARTIDORES
        // ==========================================

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


        // ==========================================
        // FINALIZACIÓN
        // ==========================================

        System.out.println("\n===== TODAS LAS ENTREGAS HAN TERMINADO =====");

        System.out.println("Camila: " + camila);
        System.out.println("Luis: " + luis);
        System.out.println("Pedro: " + pedro);

        System.out.println("\n======================================");
        System.out.println("       FIN DE LA SIMULACIÓN");
        System.out.println("======================================");
    }
}