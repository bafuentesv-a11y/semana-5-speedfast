package org.example;

public class PedidoEncomienda extends Pedido {

    public PedidoEncomienda(int idPedido, String direccionEntrega, String tipoPedido) {
        super(idPedido, direccionEntrega, tipoPedido);
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("[Pedido Encomienda]");
        System.out.println();
        System.out.println("Asignando repartidor...");
        System.out.println();
        System.out.println("→ Validando peso y embalaje... OK");
    }

    public void asignarRepartidor(String nombreRepartidor) {
        asignarRepartidor();
        System.out.println("→ Pedido asignado a " + nombreRepartidor);
    }
}

