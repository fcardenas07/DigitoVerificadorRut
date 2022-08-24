import java.util.Scanner;

public class DigitoVerificador {
    public static void main(String[] args) {
        calcularDigitoVerificador();

    }

    public static void calcularDigitoVerificador() {
        String rut = ingresarRut();
        rut = tomarNumerosRut(rut);
        rut = invertirRut(rut);
        int[] digitos = multiplicarDigitos(rut);
        int suma = sumarDigitos(digitos);
        int sumaDividida = dividirSuma(suma);
        int resultado = multiplicar(sumaDividida);
        int resta = Math.abs(suma - resultado);
        String digitoVerificador = asignarDigito(resta);
        System.out.println("Digito Verificador = " + digitoVerificador);
    }

    private static int dividirSuma(int suma) {
        return suma / 11;
    }

    private static String asignarDigito(int resta) {
        String digito = "";
        int resultado = 11 - resta;

        if (resultado < 10) {
            digito = String.valueOf(resultado);
        } else if (resultado == 10) {
            digito = "k";
        } else if (resultado == 11) {
            digito = "0";
        }
        return digito;
    }

    private static int multiplicar(int suma) {
        return suma * 11;
    }

    private static int sumarDigitos(int[] digitos) {
        int suma = 0;
        for (int digito : digitos) {
            suma += digito;
        }
        return suma;
    }

    private static int[] multiplicarDigitos(String rut) {
        int[] digitos = new int[rut.length()];
        int[] cadena = {2, 3, 4, 5, 6, 7};
        int indice = 0;

        for (int i = 0; i < rut.length(); i++) {
            int numero = Character.getNumericValue(rut.charAt(i));
            digitos[i] = numero * cadena[indice];
            indice++;
            if (indice > cadena.length - 1) indice = 0;
        }
        return digitos;
    }

    private static String invertirRut(String rut) {
        StringBuilder rut2 = new StringBuilder(rut);
        return rut2.reverse().toString();
    }

    private static String tomarNumerosRut(String rut) {
        String rut2 = rut.replaceAll("[^0-9kK]", "");
        return rut2.substring(0, rut2.length() - 1);
    }

    private static String ingresarRut() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresar rut");
        return teclado.nextLine();
    }
}
