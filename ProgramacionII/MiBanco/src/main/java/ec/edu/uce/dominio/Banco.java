package ec.edu.uce.dominio;

public class Banco {
    //metodos crud

    private Empleado[] satff;
    private int numEmpleados;
    public void agreagarEmpleado(Empleado empleado){
        if(numEmpleados == satff.length){
            Empleado [] empaux = satff;
            satff = new Empleado[numEmpleados+1];
            System.arraycopy(empaux , 0,satff,0,numEmpleados);
        }
        satff[numEmpleados] = empleado;
        numEmpleados++;
    }

    public String consultarEmoeleados(){
        String texto = "";
        //consultar con un for ech
        //validadar
        // que este funcional
        // tambien añadir con sobre carga con un objeto cliente
        for (Empleado e: satff){
            texto += e + "\r\n";
        }
    }
}
