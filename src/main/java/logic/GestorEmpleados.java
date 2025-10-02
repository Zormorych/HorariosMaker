package logic;

import java.util.ArrayList;
import java.util.List;

public class GestorEmpleados {
    private List<Empleado> empleados;

    public GestorEmpleados() {
        empleados = new ArrayList<>();
        // Lista fija de empleados
        empleados.add(new Empleado("Rafa",40));
        empleados.add(new Empleado("Veronica",40));
        empleados.add(new Empleado("Pablo", 25));
        empleados.add(new Empleado("Pedro", 20));
        empleados.add(new Empleado("Alex", 25));
        empleados.add(new Empleado("Silvia", 25));
        empleados.add(new Empleado("Quero", 20));
        empleados.add(new Empleado("Anna", 20));
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }





}
