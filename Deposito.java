public class Deposito extends Transaccion {
    private Cuenta cuentaDestino;

    public Deposito(String id, double monto, String fecha, String hora, Cuenta cuentaDestino) {
        super(id, monto, fecha, hora, "Deposito", "Pendiente");
        this.cuentaDestino = cuentaDestino;
    }

    public Cuenta getCuentaDestino() { return cuentaDestino; }

    public void procesar() {
        double actual = cuentaDestino.getSaldo();
        double nuevo = actual + getMonto();
        cuentaDestino.setSaldo(cuentaDestino.getSaldo()+nuevo); 
        setEstado("Procesada");
        System.out.println("Deposito: " + getMonto() + " agregado a cuenta " + cuentaDestino.getNumeroCuenta() +"Saldo anterior: " + actual + "nuevo saldo: " + nuevo);
    }

    @Override
    public String toString() {
        return "\n--->Deposito<---\n" + super.toString() + "\nCuentaDestino: "+cuentaDestino.getNumeroCuenta();
    }
}