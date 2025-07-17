package ec.edu.uce;

import ec.edu.uce.dominio.Banco;

import java.io.*;

public class TestPersistencia {
    public static void main(String[] args) {
        Banco banco = Banco.getInstance();
        banco.inicializar();
        // Deserealizando
        try (FileOutputStream fos= new FileOutputStream(args[0]);
             ObjectOutputStream oss= new ObjectOutputStream(fos)) {
            oss.writeObject(banco);
        }catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Serealizar
        try (FileInputStream fis = new FileInputStream(args[0]);
             ObjectInputStream ois = new ObjectInputStream(fis)){
            banco = (Banco) ois.readObject();
        }catch (IOException | ClassNotFoundException e){
            System.err.println(e.getMessage());
        }
        System.out.println(banco.consultarClientes());
    }
}
