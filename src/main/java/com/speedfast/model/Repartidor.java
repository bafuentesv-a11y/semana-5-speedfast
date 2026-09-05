package com.speedfast.model;

import java.util.List;
import java.util.Random;

/**
 * Representa un repartidor que realiza entregas de manera concurrente.
 */
public class Repartidor implements Runnable {

    private String nombre;
    private boolean disponible;
    private List<Pedido> pedidosAsignados;

    /**
     * Constructor de Repartidor.
     */
    public Repartidor(String nombre, boolean disponible, List<Pedido> pedidosAsignados) {
        this.nombre = nombre;
        this.disponible = disponible;
        this.pedidosAsignados = pedidosAsignados;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public List<Pedido> getPedidosAsignados() {
        return pedidosAsignados;
    }

    /**
     * Ejecuta las entregas de los pedidos asignados.
     */
    @Override
    public void run() {

        Random random = new Random();

        for (Pedido pedido : pedidosAsignados) {

            System.out.println(
                    "[Repartidor: " + nombre + "] Entregando "
                            + pedido.getClass().getSimpleName()
                            + " #" + pedido.getIdPedido() + "..."
            );

            try {
                // Simula un tiempo de entrega aleatorio
                int tiempo = 1000 + random.nextInt(3000);
                Thread.sleep(tiempo);

                System.out.println(
                        "[Repartidor: " + nombre + "] Pedido #"
                                + pedido.getIdPedido()
                                + " entregado."
                );

            } catch (InterruptedException e) {

                System.out.println(
                        "[Repartidor: " + nombre
                                + "] La entrega fue interrumpida."
                );

                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println(
                "[Repartidor: " + nombre
                        + "] Ha terminado todas sus entregas."
        );
    }

    @Override
    public String toString() {
        return nombre + (disponible ? " (Disponible)" : " (No disponible)");
    }
}