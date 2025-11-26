
import java.util.*;
public class UsuarioAdmi extends Usuario {
    Scanner sc= new Scanner(System.in);
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Empleado> empleados = new ArrayList<>();
    ArrayList<Cuenta> cuentas = new ArrayList<>();
    ArrayList<Transaccion> transacciones = new ArrayList<>();
    ArrayList<Tarjeta> tarjetas = new ArrayList<>();
    public UsuarioAdmi (String nombreUsuario, String dni,int edad,String contraseña, String correo, boolean estado){
        super(nombreUsuario, dni, edad, contraseña, correo, estado);
    }
    
    public boolean login(String contraseña){
        
        if(getContraseña().equals(contraseña)){
            System.out.println("Inicio de sesion exitoso"); 
            return true;
        }else{
            System.out.println("Contraseña incorrecta");
            return false;
        }
    }
    public void menu (Banco banco){
        int opcion;
            do{
                System.out.println("\n=== MENU ===");
                System.out.println("1. Mostrar lista de clientes");
                System.out.println("2. Mostrar lista de empleados");
                System.out.println("3. Mostrar lista de cuentas");
                System.out.println("4. Mostrar lista de tarjetas");
                System.out.println("5. Mostrar lista de transacciones");
                System.out.println("6. Buscar un Empleado");
                System.out.println("7. Buscar un Cliente");
                System.out.println("8. Buscar una Cuenta");
                System.out.println("9. Buscar una transaccion");
                System.out.println("10. Agregar Empleado");
                System.out.println("11. Agregar Cliente");
                System.out.println("12. Agregar Cuenta");
                System.out.println("13. ELiminar empleado");
                System.out.println("14. Eliminar cliente");
                System.out.println("15. Eliminar cuenta");
                System.out.println("16. Salir del programa");
                System.out.print("Elegir opción: ");
                opcion=sc.nextInt();
                sc.nextLine();
                switch(opcion){
                    case 1:
                    banco.mostrarClientes(clientes);
                    break;

                    case 2:
                    banco.mostrarEmpleados(empleados);
                    break;
                    
                    case 3:
                    banco.mostrarCuentas(cuentas);
                    break;

                    case 4:
                    banco.mostrarTarjetas(tarjetas);
                    break;

                    case 5:
                    banco.mostrarTransacciones(transacciones);
                    break;

                    case 6:
                    banco.buscarEmpleado(dni);                    
                    break;

                    case 7:
                    banco.buscarCliente(dni);                    
                    break;

                    case 8:
                        System.out.println("Ingrese el Numero de la Cuenta:" );
                        String numeroCuenta = sc.nextLine();
                    banco.buscarCuenta(numeroCuenta);
                    break;

                    case 9:
                        System.out.println("Ingrese el ID de la transaccion: ");
                        String id = sc.nextLine();
                    banco.buscarTransaccion(id);
                    break;

                    case 10:
                        System.out.print("Ingrese el nombre del empleado: ");
                        String nombre = sc.nextLine();
                        System.out.print("Ingrese el DNI del empleado: ");
                        String dni = sc.nextLine();
                        System.out.print("Ingrese la dirección del empleado: ");
                        String direccion = sc.nextLine();
                        System.out.print("Ingrese el telefono del empleado: ");
                        String telefono = sc.nextLine();
                        System.out.print("Ingrese el telefono del empleado: ");
                        String codigo = sc.nextLine();
                        System.out.print("Ingrese el codigo del empleado: ");
                        String cargo = sc.nextLine();
                        System.out.print("Ingrese el salario del empleado: ");
                        String salario = sc.nextLine();
                        Empleado nuevoEmpleado = new Empleado(nombre, dni,direccion, telefono, codigo, cargo, salario);
                    banco.registrarEmpleado(nuevoEmpleado);
                    break;

                    case 11:
                        System.out.print("Ingrese el nombre del cliente: ");
                        String nombreCliente = sc.nextLine();
                        System.out.print("Ingrese el DNI del cliente: ");
                        String dniCliente = sc.nextLine();
                        System.out.print("Ingrese la dirección del cliente: ");
                        String direccionCliente = sc.nextLine();
                        System.out.print("Ingrese el teléfono del cliente: ");
                        String telefonoCliente = sc.nextLine();
                        Cliente nuevoCliente = new Cliente(nombreCliente, dniCliente, direccionCliente, telefonoCliente);
                    banco.registrarCliente(nuevoCliente);
                    break;

                    case 12:
                        System.out.print("Ingrese el tipo de cuenta: "); 
                        String tipo = sc.nextLine();
                        System.out.print("Ingrese el DNI del cliente titular: "); 
                        dniCliente = sc.nextLine();
                        Cliente titular = banco.buscarCliente(dniCliente);
                        if (titular == null) {
                            System.out.println("Cliente no encontrado. No se puede crear la cuenta.");
                            break;
                        }
                        System.out.print("Ingrese el número de tarjeta: "); 
                        String numeroTarjeta = sc.nextLine();
                        System.out.print("Ingrese el tipo de tarjeta: ");
                        String tipoTarjeta = sc.nextLine();
                        System.out.print("Ingrese la fecha de vencimiento (dd/mm/aaaa): ");
                        String fechaVencimiento = sc.nextLine();
                        System.out.print("Ingrese el CVV: ");
                        int cvv = sc.nextInt();
                        sc.nextLine(); 
                        System.out.print("Ingrese el estado de la tarjeta (activa/bloqueada): ");
                        String estado = sc.nextLine();
                        Tarjeta tarjeta = new Tarjeta(numeroTarjeta, tipoTarjeta, fechaVencimiento, cvv, estado);
                        System.out.print("Ingrese el número de cuenta: ");
                        numeroCuenta = sc.nextLine();
                        Cuenta nuevaCuenta = new Cuenta(tipo, titular, tarjeta, numeroCuenta);
                    banco.registrarCuenta(nuevaCuenta);
                    break;

                    case 13:
                        System.out.println("Ingrese el DNI del empleado a eliminar: ");
                        String dniEmpleado = sc.nextLine();
                    banco.eliminarEmpleado(dniEmpleado);
                    break;

                    case 14:
                        System.out.println("Ingrese el DNI del cliente a eliminar: ");
                        dniCliente = sc.nextLine();
                    banco.eliminarCliente(dniCliente);
                    break;

                    case 15:
                        System.out.println("Ingrese el Número de Cuenta a eliminar");
                        numeroCuenta = sc.nextLine();
                    banco.eliminarCuenta(numeroCuenta);
                    break;

                    default:
                    System.out.println("Opción inválida. Intente nuevamente.");

                }
            }while (opcion != 16);    
    }    
}    
