public class Cliente extends Persona{
    
    public Cliente(String nombre, String dni, String direccion, String telefono){
        super(nombre,dni,direccion,telefono);
        
    }
    
    public String toString(){
        return super.toString();
    }
}