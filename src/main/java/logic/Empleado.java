package logic;

public class Empleado { // declaramos clase con sus atributos
   private String name;  //nombre del empleado
   private double horas; //horas de CONTRATO


    //constructor
    public Empleado (String name, double horas){
        this.horas = horas;
        this.name = name;
    }

    //getter

    public String getEmpleadoName(){ //getter del nombre
        return name;
    }

    public double getHoras(){ //getter horas contrato
        return horas;
    }
    //setter
    public void  setName(String name){
        this.name = name;
    }
    public void  setHoras(double horas){
        this.horas= horas;
    }

    @Override // para despues imprimir
    public String toString() {
        return "Empleado: " + name + " | Horas contrato: " + horas;
    }











}
