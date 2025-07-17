package ec.edu.uce.datos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamCopy {
    public static void main(String[] args) {
        byte[] b=new byte[128];
        int btamano=b.length;

        try (FileInputStream fis= new FileInputStream(args[0]);
            FileOutputStream fos= new FileOutputStream(args[1]))
        {

               System.out.println("Bytes disponibles"+fis.available());
               int input=0;
               input=fis.read();
               while (input!=-1)
               {
                   if (input<btamano){
                       fos.write(b,0,input);
                   }else{
                       fos.write(b);
                   }
               }

        }catch (FileNotFoundException e){
            System.err.println("Archivo no encontrado"+ e);
        }catch (IOException e){
            System.err.println("Error IOException"+e.getMessage());
        }

    }
}
