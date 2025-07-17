package ec.edu.uce.dominio;

import ec.edu.uce.datos.EmpleadoDAO;
import ec.edu.uce.datos.EmpleadoDAOMemoryImplementation;

import java.time.chrono.ChronoLocalDate;
import java.util.Date;
import java.util.Scanner;

public class TestEmpleatoInteractivo {
    public static EmpleadoDAOMemoryImplementation Dao=new EmpleadoDAOMemoryImplementation();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Empleado empleado=null;
        String opcion="S";
        opcion=scan.next();
        switch (opcion){
            case "C":{
                empleado=new Empleado(0,"Paco","Patin","@gmail","Quito","000000",500.00,"Asistente",new Date());
                Dao.agregarEmpleado(empleado);
                System.out.println("Empleado creado exitosamente \r\n"+empleado);
            }
            //break;
            case "A":{
                empleado=new Empleado(0,"Paco","Patin","@gmail","Quito","000000",500.00,"Asistente",new Date());
                Dao.agregarEmpleado(empleado);
                empleado=new Empleado(0,"Jimmy","Patin","@gmail","Quito","000000",500.00,"Asistente",new Date());
                Dao.editarEmpleado(empleado);
                System.out.println("Empleado actualizado exitosamente\r\n"+empleado);
            }
            break;
            case "E":{

            }
            break;
            case "B":{
                empleado=new Empleado(0,"Paco","Patin","@gmail","Quito","000000",500.00,"Asistente",new Date());
                Dao.agregarEmpleado(empleado);
                int id=0;
                empleado=null;
                empleado=Dao.buscarEmpleadoPorId(id);
                if (empleado==null){
                    System.out.println("Empleado NO encontrado: "+id);
                }else{
                    System.out.println("Empleado encontrado: "+empleado);
                }
            }
            break;
            case "S":{
                System.out.println("Ha salido del sistema");
            }
            break;
            default:
                System.out.println("No ha seleccionado una opción válida");
        }
    }
}

