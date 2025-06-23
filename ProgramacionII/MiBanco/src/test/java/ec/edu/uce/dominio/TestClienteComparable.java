package ec.edu.uce.dominio;


import java.util.Set;
import java.util.TreeSet;
import static ec.edu.uce.dominio.Genero.FEMENINO;
public class TestClienteComparable {
    public static void main(String[] args) {
        Set<Cliente>listaCliente=new TreeSet<>();
        listaCliente.add(new Cliente ("XIMENA","GUERRON",FEMENINO));
        listaCliente.add(new Cliente ("CAROL","ZAPATA",FEMENINO));
        listaCliente.add(new Cliente ("RUBEN","AGUIRRE",FEMENINO));
        listaCliente.add(new Cliente ("GABRIELA","TUTILLO",FEMENINO));
        for(Cliente cli:listaCliente){
            System.out.println(cli);
        }
    }
}
