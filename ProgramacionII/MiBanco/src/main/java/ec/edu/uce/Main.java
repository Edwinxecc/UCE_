package ec.edu.uce;

import ec.edu.uce.dominio.Cliente;
import ec.edu.uce.dominio.Empleado;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cliente obj = new Cliente(123, "Edwin", "Caiza", "edcaiza@uce.edu.ec");
        System.out.println(obj.getApellido());
        System.out.println(obj.validarCorreo());


    }
}