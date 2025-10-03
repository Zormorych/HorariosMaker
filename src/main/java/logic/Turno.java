package logic;


import java.time.LocalDate;
import java.util.ArrayList;

public class Turno {
    private LocalDate fecha;
    private String franja; //mañana o tarde
    private ArrayList<Empleado> empleadosAsignados;
    private double duracionHoras;


    //constructor de 3 parametros
    public Turno(LocalDate fecha, String franja, double duracionHoras) {
        this.fecha = fecha;
        this.franja = franja;
        this.duracionHoras = 0.0;
        this.empleadosAsignados = new ArrayList<>();
    }
    //constructor de 2 parametros
    public Turno(LocalDate fecha, String franja) {
        this(fecha, franja, 0.0); // llama al de 3 parámetros con 0.0 por defecto
    }

    // Getters
    public LocalDate getFecha() {
        return fecha;
    }

    public String getFranja() {
        return franja;
    }

    public ArrayList<Empleado> getEmpleadosAsignados() {
        return empleadosAsignados;
    }

    // Getter de duracionHoras
    public double getDuracionHoras() {
        return duracionHoras; }

    // Setter temporal
    public void setDuracionHoras(double horas) {
        this.duracionHoras = 0.0; }

    //metodo para asignar empleado
    public void asignarEmpleado(Empleado e) {
        empleadosAsignados.add(e);
    }

    @Override //para imprimir el turno
    public String toString() {
        if (empleadosAsignados.isEmpty()) {
            return "Fecha: " + fecha + " | Franja: " + franja + " | Empleados: sin asignar"+
                    " | Horas: " + duracionHoras;
        } else {
            StringBuilder names = new StringBuilder();
            for (Empleado emp : empleadosAsignados) {
                if (!names.isEmpty()) {
                    names.append(", ");
                }
                names.append(emp.getEmpleadoName());
            }
            return "Fecha: " + fecha + " | Franja: " + franja + " | Empleados: " + names.toString()
                    +" Horas: "+ duracionHoras;
        }
    }






}