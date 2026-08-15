package org.example;

public class Main {

    public static void main(String[] args) {

        PedidoComida comida = new PedidoComida(1, "Av. Providencia 123", "Comida");

        PedidoEncomienda encomienda = new PedidoEncomienda(2, "Av. Matta 456", "Encomienda");

        PedidoExpress express = new PedidoExpress(3, "Av. Apoquindo 789", "Express");

        System.out.println("=== SOBRECARGA ===");

        comida.asignarRepartidor("Juan Pérez");

        encomienda.asignarRepartidor("Camila Soto");

        express.asignarRepartidor("Luis Díaz");

        System.out.println("\n=== POLIMORFISMO ===");

        Pedido[] pedidos = {comida, encomienda, express};

        for (Pedido pedido : pedidos) {
            pedido.asignarRepartidor();
        }
    }
}