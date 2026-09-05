package com.speedfast.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Controla las operaciones generales de los envíos.
 */
public class ControladorDeEnvios
        implements Despachable, Cancelable, Rastreable {

    private final List<Pedido> pedidos;
    private final List<String> historial;

    public ControladorDeEnvios() {
        pedidos = new ArrayList<>();
        historial = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);

        System.out.println("Pedido " + pedido.getIdPedido()
                + " agregado al sistema.");
    }

    public void mostrarPedidos() {
        System.out.println("\n===== PEDIDOS REGISTRADOS =====");

        for (Pedido pedido : pedidos) {
            pedido.mostrarResumen();

            System.out.println("Tiempo estimado: "
                    + pedido.calcularTiempoEntrega()
                    + " minutos");

            System.out.println("------------------------------");
        }
    }

    public void reservarPedidos() {
        System.out.println("\n===== RESERVA DE PEDIDOS =====");

        for (Pedido pedido : pedidos) {
            pedido.reservar();

            historial.add("Pedido "
                    + pedido.getIdPedido()
                    + " - Reservado");
        }
    }

    @Override
    public void despachar() {
        System.out.println("\n===== DESPACHO =====");

        for (Pedido pedido : pedidos) {

            System.out.println("Pedido "
                    + pedido.getIdPedido()
                    + " despachado correctamente.");

            historial.add("Pedido "
                    + pedido.getIdPedido()
                    + " - Despachado");
        }
    }

    @Override
    public void cancelar() {
        System.out.println("\n===== CANCELACIÓN =====");

        if (!pedidos.isEmpty()) {

            Pedido pedido = pedidos.get(pedidos.size() - 1);

            System.out.println("Pedido "
                    + pedido.getIdPedido()
                    + " cancelado correctamente.");

            historial.add("Pedido "
                    + pedido.getIdPedido()
                    + " - Cancelado");
        }
    }

    public void cancelar(String idPedido) {

        for (Pedido pedido : pedidos) {

            if (pedido.getIdPedido().equals(idPedido)) {

                System.out.println("Pedido "
                        + pedido.getIdPedido()
                        + " cancelado correctamente.");

                historial.add("Pedido "
                        + pedido.getIdPedido()
                        + " - Cancelado");

                return;
            }
        }

        System.out.println("No se encontró el pedido " + idPedido);
    }

    @Override
    public void verHistorial() {
        System.out.println("\n===== HISTORIAL =====");

        if (historial.isEmpty()) {
            System.out.println("No existen operaciones registradas.");
            return;
        }

        for (String registro : historial) {
            System.out.println("- " + registro);
        }
    }
}