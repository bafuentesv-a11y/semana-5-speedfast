# SpeedFast - Semana 5

## Sincronización de entregas

Proyecto desarrollado para la actividad de la Semana 5 de la asignatura **Desarrollo Orientado a Objetos II**.

El objetivo de esta actividad es implementar un sistema concurrente para coordinar las entregas de SpeedFast, utilizando hilos y mecanismos de sincronización para evitar que dos repartidores retiren el mismo pedido.

---

## Descripción del proyecto

SpeedFast cuenta con una zona de carga común donde se encuentran los pedidos pendientes de entrega.

En esta implementación participan tres repartidores que trabajan de manera concurrente. Cada repartidor accede a la misma `ZonaDeCarga`, retira un pedido disponible y realiza la entrega de forma independiente.

La sincronización permite controlar el acceso a la zona compartida y evitar que un mismo pedido sea retirado por más de un repartidor.

---

## Tecnologías utilizadas

- Java
- Programación Orientada a Objetos
- `Runnable`
- `ExecutorService`
- `Thread.sleep()`
- Métodos `synchronized`
- `enum`
- IntelliJ IDEA
- Git y GitHub

