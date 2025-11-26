import java.util.*;
public class UsuarioEmpleado extends Usuario {
    private String cargo;
    
    public UsuarioEmpleado(String nombreUsuario,int edad, String dni, String contraseña, String correo, String cargo,boolean estado) {
        super(nombreUsuario, dni, edad, contraseña, correo, estado);
        this.cargo = cargo;
    }

    @Override
    public void mostrarPermisos() {
        System.out.println("Permisos de EMPLEADO:");
        System.out.println("- Registrar nuevos clientes");
        System.out.println("- Consultar informacion de clientes");
        System.out.println("- Crear cuentas para clientes");
        System.out.println("- Registrar prestamos");
    }

    @Override
    public void menu (Banco banco) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMENU EMPLEADO");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Consultar cliente por DNI");
            System.out.println("3. Crear cuenta");
            System.out.println("4. Ver todas las cuentas");
            System.out.println("5. Registrar prestamo");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1: {
                    System.out.println("\nREGISTRAR CLIENTE");
                    System.out.print("Nombre cliente: ");
                    String nombre = sc.nextLine();
                    System.out.print("DNI cliente: ");
                    String dni = sc.nextLine();
                    System.out.print("Dirección cliente: ");
                    String direccion = sc.nextLine();
                    System.out.print("Teléfono cliente: ");
                    String telefono = sc.nextLine();
                    
                    Cliente nuevo = new Cliente(nombre, dni, direccion, telefono);
                    banco.registrarCliente(nuevo);
                    System.out.println("Cliente registrado correctamente.");
                    break;
                }

                case 2: {
                    System.out.println("\nCONSULTAR CLIENTE");
                    System.out.print("Ingrese DNI del cliente: ");
                    String dniBuscar = sc.nextLine();
                    Cliente c = banco.buscarCliente(dniBuscar);
                    if (c != null) {
                        System.out.println("Cliente encontrado: " + c);
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                }

                case 3: {
                    banco.registrarCuenta(null);
                    break;
                }

                case 4: {
                    System.out.println("\nCUENTAS REGISTRADAS");
                    banco.mostrarCuentas(null);
                    break;
                }

                case 5: {
                    System.out.println("\nREGISTRAR PRESTAMO");
                    System.out.println("Ingrese el id:");
                    String id= sc.next();
                    System.out.print("Ingrese el numero de cuenta asociada al prestamo: ");
                    String numeroCuenta = sc.nextLine();
                    Cuenta cuenta = banco.buscarCuenta(numeroCuenta);
                    if (cuenta == null) {
                        System.out.println("La cuenta no existe. No se puede registrar el prestamo.");
                        break;
                    }
                    double monto = solicitarMonto(sc, "monto solicitado para el prestamo");
                    if (monto <=0) break;
                    double tasaAnual = solicitarMonto(sc, "tasa anual (%)");
                    if (tasaAnual<= 0) break;
                    System.out.print("Ingrese la cantidad de meses para pagar el prestamo: ");
                    int meses = Integer.parseInt(sc.nextLine());
                    if (meses<= 0) {
                        System.out.println("Numero de meses invalido.");
                        break;
                    }
                    double interes = monto * (tasaAnual/ 12/ 100);
                    double capital = monto;
                    PagoPrestamo nuevoPrestamo = new PagoPrestamo(id,monto, null, null, interes, capital, meses, tasaAnual, cuenta);
                    banco.registrarPrestamo(nuevoPrestamo);
                    System.out.println("Prestamo registrado correctamente.");
                    System.out.println(nuevoPrestamo.toString());
                    break;
                }

                case 0:
                    System.out.println("Saliendo del menu de empleado...");
                    return;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);
    }

    private static double solicitarMonto(Scanner sc, String accion) {
        double monto = 0;
        while (true) {
            System.out.print("Monto de " + accion + " (o 'x' para cancelar): ");
            String entrada = sc.nextLine().trim();

            if (entrada.equalsIgnoreCase("x")) {
                System.out.println("Operacion cancelada.");
                return -1;
            }

            if (entrada.isEmpty()) {
                System.out.println("Error: el monto no puede estar vacio.");
                continue;
            }

            boolean esNumero = true;
            int puntos = 0;
            for (int i = 0; i < entrada.length(); i++) {
                char c = entrada.charAt(i);
                if (c == '.') {
                    puntos++;
                    if (puntos > 1) esNumero = false;
                } else if (c < '0' || c > '9') {
                    esNumero = false;
                    break;
                }
            }

            if (!esNumero) {
                System.out.println("Error: el monto debe ser un numero valido.");
                continue;
            }

            monto = Double.parseDouble(entrada);
            if (monto <= 0) {
                System.out.println("El monto debe ser mayor que cero.");
                continue;
            }

            return monto;
        }
    }
}
