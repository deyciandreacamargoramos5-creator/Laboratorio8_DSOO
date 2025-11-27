
public class Validaciones {
    // validaciones de tarjeta
    public static boolean numeroTarjeta(String numero) {
        return numero != null && numero.matches("\\d{12}");
    }

    public static boolean tipoTarjeta(String tipo) {
        return tipo != null && (tipo.equalsIgnoreCase("credito") || tipo.equalsIgnoreCase("debito"));
    }

    public static boolean fecha(String fecha) {
        if (fecha == null || !fecha.matches("\\d{2}/\\d{2,4}")) {
        System.out.println("Formato de fecha inválido. Use MM/yy o MM/yyyy.");
        return false;
        }
        int mes=1,año=2025;
        if (mes < 1 || mes > 12) {
        System.out.println("Mes inválido (debe ser 01 a 12)");
        return false;
    }

    if (año < 2025) {
        System.out.println("Año inválido. No puede ser menor a 2025");
        return false;
    }

    return true;
    }

    public static boolean cvv(int cvv) {
        return cvv >= 100 && cvv <= 9999;
    }

    public static boolean estadoTarjeta(String estado) {
        return estado != null &&(estado.equalsIgnoreCase("activa") || estado.equalsIgnoreCase("bloqueada") ||estado.equalsIgnoreCase("expirada") || estado.equalsIgnoreCase("pendiente"));
    }
    // validaciones de cuenta 
     public static boolean validarString(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public static boolean validarNumeroCuenta(String numero) {
        return numero != null && numero.matches("\\d{6,20}");
    }
    
    public static boolean validarObjeto(Object obj) {
        return obj != null;
    }

    public static boolean validarMonto(double monto) {
        return monto > 0;
    }

    public static boolean validarSaldo(double saldo) {
        return saldo >= 0;
    }

    public static String validarTipoCuenta(String tipo) {
        if (validarString(tipo)) {
            return tipo;
        }
        System.out.println("Tipo de cuenta inválido.");
        return "NO DEFINIDO";
    }

    public static Cliente validarTitular(Cliente titular) {
        if (validarObjeto(titular)) {
            return titular;
        }
        System.out.println("Titular inválido.");
        return null;
    }

    public static Tarjeta validarTarjeta(Tarjeta tarjeta) {
        if (validarObjeto(tarjeta)) {
            return tarjeta;
        }
        System.out.println("Tarjeta inválida.");
        return null;
    }

    public static String validarNumCuenta(String numero) {
        if (validarNumeroCuenta(numero)) {
            return numero;
        }
        System.out.println("Número de cuenta inválido.");
        return "000000";
    }

    public static double validarSetSaldo(double saldo) {
        if (validarSaldo(saldo)) {
            return saldo;
        }
        System.out.println("El saldo no puede ser negativo.");
        return 0.0;
    }

    public static double depositar(double saldoActual, double monto) {
        if (validarMonto(monto)) {
            return saldoActual + monto;
        }
        System.out.println("Monto inválido para depositar.");
        return saldoActual;
    }

    public static double retirar(double saldoActual, double monto) {
        if (validarMonto(monto) && monto <= saldoActual) {
            return saldoActual - monto;
        }
        System.out.println("Monto inválido o saldo insuficiente.");
        return saldoActual;
    }
}

