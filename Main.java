import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        ArrayList<Transaccion> transacciones = new ArrayList<>();
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        // DATOS DEL BANCO
        Cliente cliente1 = new Cliente("Juan", "74259631", "Av. Lima 123", "987654321");
        Cliente cliente2 = new Cliente("Maria", "85142796", "Jr. Arequipa 450", "912345678");
    
        Tarjeta tarjeta1 = new Tarjeta("455789012", "VISA", "12/28", 987, "ACTIVA");
        Tarjeta tarjeta2 = new Tarjeta("512398765", "MASTERCARD", "08/27", 654, "ACTIVA");
       
        Cuenta cuenta1 = new Cuenta("Ahorros", cliente1, tarjeta1, "001-0001");
        Cuenta cuenta2 = new Cuenta("Corriente", cliente2, tarjeta2, "001-0002");
   
        cuentas.add(cuenta1);
        clientes.add(cliente1);
        tarjetas.add(tarjeta1);
        cuentas.add(cuenta2);
        clientes.add(cliente2);
        tarjetas.add(tarjeta2);
        //USUARIOS PARA INICIAR SESION
        Banco banco = new Banco("123456789","BCP",clientes,empleados,cuentas,transacciones);
        Usuario usuarioAdmin = new UsuarioAdmi("admin","11111111",30,"admin123","admin@gmail.com",true);
        Usuario usuarioEmpleado = new UsuarioEmpleado("empleado1",25,"22222222","emple123","empleado@gmail.com","Cajero",true);
        Usuario usuarioCliente = new UsuarioCliente("cliente1","33333333",21,"cli123","cliente@gmail.com",true,1500.0);

        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuarioAdmin);
        usuarios.add(usuarioEmpleado);
        usuarios.add(usuarioCliente);

        Usuario usuarioLogeado = null;
        while (usuarioLogeado == null) {
        System.out.println("===== INICIAR SESIÓN =====");
        System.out.print("Usuario: ");
        String user = sc.nextLine();
        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        for (Usuario u : usuarios) {
            if (u.getNombreUsuario().equals(user) && u.getContraseña().equals(pass)) {
                usuarioLogeado = u;
                break;
            }
        }

        if (usuarioLogeado == null) {
            System.out.println("Usuario o contraseña incorrectos. Intente nuevamente");
        }
        }

        System.out.println("\nBienvenido " + usuarioLogeado.getNombreUsuario());
        if (usuarioLogeado instanceof UsuarioAdmi) {
            ((UsuarioAdmi) usuarioLogeado).menu(banco);
        } 
        else if (usuarioLogeado instanceof UsuarioEmpleado) {
            ((UsuarioEmpleado) usuarioLogeado).menu(banco);
        } 
        else if (usuarioLogeado instanceof UsuarioCliente) {
            ((UsuarioCliente) usuarioLogeado).menu(banco);
        } 
        else {
            System.out.println("Usuario sin rol definido.");
        }
    }

}
    


