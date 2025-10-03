package logic;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cuadrante {
    //atributo listaDeTurnos con los turnos del cuadrante, solo admite objetos de la clase Turno
    private ArrayList<Turno> listaDeTurnos;

    //constructor que inicializa la lista vacia
    public Cuadrante(){
    this.listaDeTurnos = new ArrayList<>();
    }

    //getter para listaDeTurnos
    public ArrayList<Turno> getListaDeTurnos() {
        return listaDeTurnos;
    }




    // metodo para generar turno semanal de lunes a domingo
    // Método que genera los turnos de una semana (lunes a domingo)
    public void generarTurnosSemanal(LocalDate lunes) {
        // Guardamos la fecha de inicio (lunes que recibimos por parámetro)
        LocalDate fecha = lunes;

        // Recorremos 7 días: del lunes al domingo
        for (int i = 0; i < 7; i++) {

            // Turno de mañana
            // Creamos un nuevo turno con la fecha y la franja "mañana"
            Turno turnoManana = new Turno(fecha, "mañana");
            // Le asignamos la duración en horas según qué día de la semana sea
            turnoManana.setDuracionHoras(calcularHorasTurno(fecha));
            // Lo añadimos a la lista de turnos del cuadrante
            listaDeTurnos.add(turnoManana);

            // Turno de tarde
            // Creamos un nuevo turno con la misma fecha y la franja "tarde"
            Turno turnoTarde = new Turno(fecha, "tarde");
            // Igual que antes, le ponemos la duración de horas que corresponda
            turnoTarde.setDuracionHoras(calcularHorasTurno(fecha));
            // Lo añadimos a la lista de turnos
            listaDeTurnos.add(turnoTarde);

            // Pasamos al día siguiente (sumamos 1 día a la fecha actual)
            fecha = fecha.plusDays(1);
        }
    }

// Método auxiliar privado: decide cuántas horas dura un turno
// según el día de la semana de la fecha que recibe

    private double calcularHorasTurno(LocalDate fecha) {
        return switch (fecha.getDayOfWeek()) { // obtenemos el día de la semana
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> 8.0;   // de lunes a viernes → 8 horas
            case SATURDAY -> 6.5;   // sábado → 6,5 horas
            case SUNDAY -> 5.5;   // domingo → 5,5 horas
            default -> 0.0;   // nunca debería pasar, valor de seguridad
        };
    }


    // Método para asignar un empleado a un turno concreto
    public void asignarTurno(LocalDate fecha, String franja, Empleado empleado) {
        for (Turno t : listaDeTurnos) {
            // comprobamos que coinciden fecha y franja
            if (t.getFecha().equals(fecha) && t.getFranja().equalsIgnoreCase(franja)) {
                t.asignarEmpleado(empleado);
                break; // dejamos de buscar porque ya lo encontramos
            }
        }
    }

    // Método para mostrar todos los turnos del cuadrante
    public void mostrarCuadrante() {
        for (Turno t : listaDeTurnos) {
            System.out.println(t); // aquí usa el toString() de Turno
        }
    }



}
