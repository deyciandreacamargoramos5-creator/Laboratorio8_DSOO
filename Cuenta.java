public class Cuenta {
    private String tipo;
    private Cliente titular;
    private Tarjeta tarjeta;
    private double saldo;
    private String numeroCuenta;
    
    public Cuenta(String tipo, Cliente titular, Tarjeta tarjeta, String numeroCuenta){
        this.tipo = tipo;
        this.titular = titular;
        this.tarjeta = tarjeta;
        this.saldo = 0.0;
        this.numeroCuenta =numeroCuenta;
    }
    public String getTipo(){
        return tipo;
    }
    public Cliente getTitular(){
        return  titular;
    }
    public Tarjeta getTarjeta(){
        return tarjeta;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setTitular(Cliente titular){
        this.titular = titular;
    }
    public void setTarjeta(Tarjeta tarjeta){
        this.tarjeta = tarjeta;
    }
    public double getSaldo() { 
        return saldo; 
    }
    public void setSaldo(double saldo) { 
        this.saldo = saldo; 
    }
     public String getNumeroCuenta() {
        return numeroCuenta;
    }
    @Override
    public String toString(){
        return "\n--->Cuenta<---\nTitular: "+titular+"\nTipo: " + tipo + "\nTarjeta: " + tarjeta;
    }
    
}
