package gui;

import logic.Cuadrante;
import logic.Empleado;
import logic.GestorEmpleados;
import logic.Turno;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuConsola {
    private GestorEmpleados gestorEmpleados = new GestorEmpleados(); // instancia del gestor de empleados (ya con la lista fija)
    private Scanner sc = new Scanner(System.in);
    private Cuadrante cuadranteDeGui = new Cuadrante(); // atributo de la clase
    public void iniciar() { // método que arranca el menú
        int opcion; // variable para guardar la opción elegida

        do { // bucle que repite el menú hasta que el usuario elija salir
            System.out.println("===== MENÚ PRINCIPAL =====");
            System.out.println("1. Listar empleados");
            System.out.println("2. Generar turnos semanales");
            System.out.println("3. Asignar empleados a cada turno");
            System.out.println("0. Salir");//0 para salir
            System.out.print("Elige una opción: "); // mensaje para pedir opción
            opcion = sc.nextInt(); // leemos un número del usuario
            sc.nextLine(); // limpiamos el buffer de entrada

            switch (opcion) { // evaluamos la opción elegida
                case 1 -> listarEmpleados(); // si elige 1, se muestran los empleados
                case 2 -> generarTurnos(); //metodo para generar los turnos
                case 3 -> asignarEmpleadoATurno();
                case 0 -> {
                    System.out.println("Saliendo...");
                    sc.close(); // aquí cerramos el scanner
                }
                default -> System.out.println("Opción no válida"); // si mete otra cosa, F
            }
        } while (opcion != 0); // se repite mientras no pulse 0
    }

    private void listarEmpleados() {
        System.out.println("Lista de empleados:");
        int i = 1;
        for (Empleado e : gestorEmpleados.getEmpleados()) {
            System.out.println(i + ". " + e.getEmpleadoName() + " (" + e.getHoras() + "h/sem)");
            i++;
        }
    }




    private void generarTurnos() {
        cuadranteDeGui = new Cuadrante(); // reiniciamos cuadrante
        cuadranteDeGui.generarTurnosSemanal(LocalDate.of(2025, 10, 6));
        System.out.println("Turnos generados para la semana:");
        cuadranteDeGui.mostrarCuadrante();
    }

    private void asignarEmpleadoATurno() {
        // 1. Elegir empleado
        listarEmpleados(); // mostramos la lista numerada
        System.out.print("Elige el número de empleado: ");
        int numEmpleado = sc.nextInt();
        sc.nextLine(); // limpiar buffer
        Empleado empleado = gestorEmpleados.getEmpleados().get(numEmpleado - 1);

        // 2. Elegir día del mes (ejemplo: 6 para 6 de octubre 2025)
        System.out.print("Introduce día del mes: ");
        int dia = sc.nextInt();
        sc.nextLine();
        LocalDate fecha = LocalDate.of(2025, 10, dia); // por ahora fijo a octubre 2025

        // 3. Elegir franja
        System.out.print("Introduce franja (mañana/tarde): ");
        String franja = sc.nextLine();

        // 4. Asignar al cuadrante
        cuadranteDeGui.asignarTurno(fecha, franja, empleado);

        // 5. Confirmación
        System.out.println("✅ " + empleado.getEmpleadoName()
                + " asignado al turno de " + fecha + " (" + franja + ")");
    }



}


