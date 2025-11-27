import java.util.*;
public class Banco {
    private String ruc;
    private String nombreBanco;
    private ArrayList <Cliente> clientes;
    private ArrayList <Empleado> empleados;
    private ArrayList <Cuenta> cuentas;
    private ArrayList <Transaccion> transacciones;
    private ArrayList <PagoPrestamo> prestamos;

    public Banco (String ruc, String nombreBanco,ArrayList <Cliente> clientes, ArrayList <Empleado> empleados, ArrayList <Cuenta> cuentas,ArrayList <Transaccion> transacciones) {
        setRuc(ruc);
        setNombreBanco(nombreBanco);
        this.clientes=clientes;
        this.empleados=empleados;
        this.cuentas=cuentas;
        this.transacciones=transacciones; 
    }
    public String getRuc () {
        return ruc;
    }
    public void setRuc (String ruc) {
        this.ruc=ruc;
    }
    public String getNombreBanco () {
        return nombreBanco;
    }
    public void setNombreBanco (String nombreBanco) {
        this.nombreBanco=nombreBanco;
    }
    public void registrarCliente (Cliente cliente) {
        if(!clientes.contains(cliente)) {
            clientes.add(cliente);
            System.out.println("El cliente fue registrado exitosamente" );
        } else {
            System.out.println("El cliente ya esta registrado");
        }
    }
    public void registrarEmpleado (Empleado empleado) {
        if(!empleados.contains(empleado)) {
            empleados.add(empleado);
            System.out.println("El empleado fue registrado exitosamente");
        } else {
            System.out.println("El empleado ya esta registrado:");
        }
    }
    public void registrarTransaccion (Transaccion transaccion) {
        transacciones.add(transaccion);
        System.out.println("La transacción se registró con exito");
    }
    public void registrarPrestamo (PagoPrestamo prestamo) {
        prestamos.add(prestamo);
        System.out.println("El prestamo se registró con exito");
    }
    public void registrarCuenta (Cuenta cuenta) {
        cuentas.add(cuenta);
        System.out.println("La cuenta fue registrada correctamente");
    }
    public void  eliminarCliente (String dni) {
        Cliente cliente = buscarCliente(dni);
        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("Cliente eliminado con éxito");
        } else {
            System.out.println("No se pudo eliminar al cliente");
        }
    }
    public void eliminarEmpleado(String dni){
        Empleado empleado = buscarEmpleado(dni);
        if(empleado != null){
            empleados.remove(empleado);
            System.out.println("Empleado eliminado con éxito");
        }else{
            System.out.println("No se pudo eliminar al empleado");
        }
        }
    public void eliminarCuenta (String numeroCuenta) {
        Cuenta cuenta = buscarCuenta(numeroCuenta);
        if (cuenta != null) {
            cuentas.remove(cuenta);
            System.out.println("Cuenta eliminada con éxito");
        } else {
            System.out.println("No se pudo eliminar la cuenta");
        }
    }
    public Cuenta buscarCuenta(String numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                System.out.println("Cuenta encontrada ");
                System.out.println(cuenta.toString());
                return cuenta;
            }
        }
        System.out.println("Cuenta no encontrada");
        return null;
    }
    public Transaccion buscarTransaccion(String id){
        for (Transaccion transaccion : transacciones){
            if(transaccion.getId().equals(id)){
                System.out.println("Transaccion encontrada");
                System.out.println(transaccion.toString());
                return transaccion;
            }
        }
        System.out.println("Transaccion no encontrada");
        return null;        
    }
    public Cliente buscarCliente (String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                System.out.println("Cliente encontrado ");
                System.out.println(cliente.toString());
                return cliente;
            } 
        }
        System.out.println("Cliente no encontrado");
        return null;
    }
    public Empleado buscarEmpleado (String dni){
        for (Empleado empleado: empleados){
            if (empleado.getDni().equals(dni)){
                System.out.println("Empleado encontrado");
                System.out.println(empleado.toString());
                return empleado;
            }
        }
        System.out.println("Empleado no encontrado");
        return null;
    }
    public void mostrarClientes(ArrayList <Cliente> clientes) {
        if (cuentas.isEmpty()) {
        System.out.println("No hay clientes registrados");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente.toString());
            }
        }
    }
    public void mostrarCuentas(ArrayList <Cuenta> cuentas) {
    if (cuentas.isEmpty()) {
        System.out.println("No hay cuentas registradas");
    } else {
        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta.toString());
        }
    }
}
public void mostrarTarjetas(ArrayList <Tarjeta> tarjetas){
    if(tarjetas.isEmpty()){
        System.out.println("No hay tarjetas registradas");
    }else{
        for (Tarjeta tarjeta :tarjetas){
            System.out.println(tarjeta.toString());
        }
    }
    }
public void mostrarEmpleados(ArrayList <Empleado> empleados){
    if(empleados.isEmpty()){
        System.out.println("No hay empleados registrados");
    }else{
        for(Empleado empleado : empleados){
            System.out.println(empleado.toString());
        }
    }
    }
    public void mostrarCuenta (Cuenta cuenta) {
        if (cuenta != null) {
            System.out.println(cuenta.toString());
        } else {
            System.out.println("La cuenta no existe");
        }
    }
    public void mostrarTransacciones (ArrayList <Transaccion> transacciones) {
        for (Transaccion transaccion : transacciones) {
            System.out.println(transaccion.toString());
        }
    }
    
    public void realizarDeposito(String id, double monto,String fecha, String hora, Cuenta cuentaDestino){
        Deposito deposito= new Deposito (id,monto,fecha,hora,cuentaDestino);
        deposito.procesar();
    }
    public void realizarRetiro (String id,double monto, String fecha, String hora,Cuenta cuentaOrigen ) {
        Retiro retiro = new Retiro (id,monto,fecha,hora,cuentaOrigen);
        retiro.procesar();
    }
}


