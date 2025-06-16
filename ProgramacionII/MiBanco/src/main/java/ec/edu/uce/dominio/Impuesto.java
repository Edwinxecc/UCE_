/**
 * @author Edwin Caiza
 */

package ec.edu.uce.dominio;

public class Impuesto {

    public static double calcularImpuesto(Empleado empleado){
        double impuesto=0.00;
        if (empleado instanceof Director){
            Director director = (Director) empleado;
            impuesto=(director.getSalario()+ director.getComision())*0.15;

        }else if(empleado instanceof Manager){
            Manager manager = (Manager)empleado;
            impuesto=manager.getSalario()+manager.getBono()*0.10;

        }else{
            impuesto=empleado.getSalario()*0.05;
        }
        return impuesto;
    }
}