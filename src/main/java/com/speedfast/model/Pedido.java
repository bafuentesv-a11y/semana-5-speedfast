package com.speedfast.model;

/**
 * Clase abstracta que representa los datos comunes de cualquier pedido.
 */
public abstract class Pedido {

    private final String idPedido;
    private final String direccionEntrega;
    private final double distanciaKm;
    private final String tipoEntrega;

    public Pedido(String idPedido, String direccionEntrega,
                  double distanciaKm, String tipoEntrega) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.tipoEntrega = tipoEntrega;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    /** Muestra la información común del pedido. */
    public void mostrarResumen() {
        System.out.println("Pedido " + idPedido);
        System.out.println("Dirección: " + direccionEntrega);
        System.out.printf("Distancia: %.1f km%n", distanciaKm);
        System.out.println("Tipo de entrega: " + tipoEntrega);
    }

    /** Cada subclase calcula su propio tiempo. */
    public abstract int calcularTiempoEntrega();

    /** Cada subclase define cómo asignar un repartidor. */
    public abstract void asignarRepartidor();

    /** Cada subclase puede realizar una asignación manual. */
    public abstract void asignarRepartidor(String nombreRepartidor);

    /** Cada subclase define cómo se reserva el pedido. */
    public abstract void reservar();
}