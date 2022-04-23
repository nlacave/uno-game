import org.json.simple.JSONObject;

public class Persona {

    static String nombre;
    static int dni;

    //CONSTRUCTOR
    public Persona(String nombre, int dni){
        this.nombre = nombre;
        this.dni = dni;
    }

    //** GUARDAR EL OBJETO **
    public JSONObject dameJSON(){
        JSONObject objeto = new JSONObject();
        objeto.put("dni", this.dni);
        objeto.put("nombre", this.nombre);

        return objeto;
    }

    //** CARGAR EL OBJETO **
    public static Persona parsearJSON(JSONObject objeto){
        dni = (int) objeto.get("dni");
        nombre = (String) objeto.get("nombre");

        return new Persona(nombre, dni);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", dni=" + dni +
                '}';
    }
}
