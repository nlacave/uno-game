import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try{

            Scanner in = new Scanner(System.in);
            String datosPersona;
            boolean on = true;

            //CREAMOS FILEWRITER
            FileWriter archivoAlumnos = new FileWriter("ArchivoPrueba.json", true);

            while(on){
                System.out.println("Ingrese una opcion");
                System.out.println("1- Guardar persona");
                System.out.println("2- Cargar persona");

                System.out.println("\nElija una opcion: ");
                int n = in.nextInt();

                if(n == 1){
                    System.out.println("Nombre: ");
                    String nombre = in.next();
                    System.out.println("DNI: ");
                    int dni = in.nextInt();

                    //1º: Creamos el objeto persona
                    //2º: GUARDAMOS LOS DATOS DE LA PERSONA EN UN STRING
                    //ESTO ES PARA GUARDARLO EN EL ARCHIVO EN FORMATO JSON PERO COMO TEXTO
                    datosPersona = new Persona(nombre, dni).dameJSON().toJSONString();

                    //** GUARDAMOS EL OBJETO EN EL ARCHIVO **
                    archivoAlumnos.write(datosPersona);
                    archivoAlumnos.flush();
                    archivoAlumnos.close();

                }else if(n == 2){

                    //** CARGAMOS EL OBJETO QUE ESTA EN EL ARCHIVO **
                    FileReader reader = new FileReader("ArchivoPrueba.json");
                    JSONParser parser = new JSONParser();
                    JSONObject p = (JSONObject) parser.parse(reader);
                    System.out.println(p);

                    //PARA TERMINAR
                    on = false;
                }
            }

        }catch(Exception e){
            System.out.println("ARCHIVO NO ENCONTRADO");
        }

    }
}
