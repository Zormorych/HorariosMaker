package gui;

import logic.Cuadrante;
import logic.GestorEmpleados;
import logic.Turno;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuConsola {
    private GestorEmpleados gestorEmpleados = new GestorEmpleados(); // instancia del gestor de empleados (ya con la lista fija)

    public void iniciar() { // método que arranca el menú
        Scanner sc = new Scanner(System.in); // objeto para leer entrada del usuario
        int opcion; // variable para guardar la opción elegida

        do { // bucle que repite el menú hasta que el usuario elija salir
            System.out.println("===== MENÚ PRINCIPAL =====");
            System.out.println("1. Listar empleados");
            System.out.println("2. Generar turnos semanales");
            System.out.println("3. Añadir trabajadores al horario");
            System.out.println("0. Salir");//0 para salir
            System.out.print("Elige una opción: "); // mensaje para pedir opción
            opcion = sc.nextInt(); // leemos un número del usuario
            sc.nextLine(); // limpiamos el buffer de entrada

            switch (opcion) { // evaluamos la opción elegida
                case 1 -> listarEmpleados(); // si elige 1, se muestran los empleados
                case 2 -> generarTurnos(); //metodo para generar los turnos (esta abajo)
                case 0 -> System.out.println("Saliendo..."); // si elige 0, mostramos mensaje de salida
                default -> System.out.println("Opción no válida"); // si mete otra cosa, error
            }
        } while (opcion != 0); // se repite mientras no pulse 0

        sc.close(); // cerramos el Scanner al salir
    }

    private void listarEmpleados() { // método para mostrar los empleados
        System.out.println("Lista de empleados:"); // encabezado
        gestorEmpleados.getEmpleados().forEach( // recorremos todos los empleados
                e -> System.out.println("- " + e.getEmpleadoName() + " (" + e.getHoras() + "h/sem)") // imprimimos nombre y horas
        );
    }


    private void generarTurnos() {
        // Creamos un cuadrante vacío
        Cuadrante cuadranteDeGui = new Cuadrante();

        // Generamos los turnos a partir de un lunes concreto
        cuadranteDeGui.generarTurnosSemanal(LocalDate.of(2025, 10, 6));

        // Mostramos todos los turnos generados usando la lista
        System.out.println("Turnos generados para la semana:");
        for (Turno t : cuadranteDeGui.getListaDeTurnos()) {
            System.out.println(t); // aquí se apoya en el toString() de Turno
        }
    }

}
