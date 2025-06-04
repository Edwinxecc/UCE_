package ec.edu.uce.dominio;

public class ReporteCliente {
    public String reporteCliente(){
        Banco banco = Banco.getInstance();
        String texto = "";
        for (Cliente cli: banco.getClientes()){
            if (cli != null){
                texto += cli + "\r\n";
                for (Cuenta c: cli.consultarCuentas()){
                    if (c != null){

                    }
                }
            }
        }
    }
}
