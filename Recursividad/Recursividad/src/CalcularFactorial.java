
public class CalcularFactorial {

    // Creamos un metodo que se llama factorial que va a recibir un parametro y va a retornar un valor double
    public double factorial(double numero) {
        // Creamos una condicion si el numero <= 1
        if (numero <= 1) {
            return 1;

        } else {
            return numero * factorial(numero - 1);

        }
    }
    // imprime factoriales para los valores dfel 0 al 10
    public void mostrarFactorial() {
        for (int contador = 0; contador <= 5; contador++) {
            System.out.printf("%d! = %.0f\n", contador, factorial(contador));
        }
    }
}
