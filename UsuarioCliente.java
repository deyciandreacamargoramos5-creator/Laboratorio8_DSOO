import java.util.*;
public class UsuarioCliente extends Usuario {
    private double saldo;
    
    public UsuarioCliente(String nombreUsuario, String dni, int edad, String contraseña, String correo, boolean estado, double saldo){
        super(nombreUsuario, dni, edad, contraseña, correo, estado);
        this.saldo = saldo;
    }
    public double getSaldo(){
        return saldo;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    } 
    public void consultarSaldo(){
        System.out.println(nombreUsuario + "tu saldo actual de " + saldo);
    }
    public void depositar (double monto){
        if(monto > 0){
            saldo += monto;
            System.out.println("Deposito" + monto + "Saldo restante "+ saldo);
        }else{
            System.out.println("El monto a depositar debe ser mayor que cero");
            }
        }
    public void retirar (double monto){
        if(monto > 0 && monto <= saldo){
            saldo -= monto;
                System.out.println("Retiro de " + monto + "Saldo "+ saldo);
        }else{
                System.out.println("Monto insuficiente");
        }
    }
        @Override
    public void mostrarPermisos(){
        System.out.println("=== PERMISOS DEL CLIENTE BANCARIO ===");
        System.out.println("- Consultar su saldo");
        System.out.println("- Realizar depósitos");
        System.out.println("- Hacer retiros");
        System.out.println("- Consultar movimientos");
    }
    public void menu (Banco banco) {
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n=== MENU CLIENTE ===");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Salir");
            System.out.print("Elige opción: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.println("--- REALIZAR DEPÓSITO ---");
                    System.out.print("ID de transacción: ");
                    String id = sc.nextLine();
                    System.out.print("Número de cuenta: ");
                    String numeroCuenta = sc.nextLine();
                    System.out.print("Monto a depositar: ");
                    double monto = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Fecha (dd/mm/aaaa): ");
                    String fecha = sc.nextLine();
                    System.out.print("Hora (HH:mm): ");
                    String hora = sc.nextLine();
                    
                    Cuenta cuentaDestino = banco.buscarCuenta(numeroCuenta);
                    if (cuentaDestino != null) {
                        banco.realizarDeposito(id, monto, fecha, hora, cuentaDestino);
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;

                case 2:
                    System.out.println("--- REALIZAR RETIRO ---");
                    System.out.print("ID de transacción: ");
                    String idRetiro = sc.nextLine();
                    System.out.print("Número de cuenta: ");
                    String numCuenta = sc.nextLine();
                    System.out.print("Monto a retirar: ");
                    double montoRetiro = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Fecha (dd/mm/aaaa): ");
                    String fechaRetiro = sc.nextLine();
                    System.out.print("Hora (HH:mm): ");
                    String horaRetiro = sc.nextLine();
                    
                    Cuenta cuentaOrigen = banco.buscarCuenta(numCuenta);
                    if (cuentaOrigen != null) {
                        banco.realizarRetiro(idRetiro, montoRetiro, fechaRetiro, horaRetiro, cuentaOrigen);
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del menú cliente...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (op != 3);
    }
}

 