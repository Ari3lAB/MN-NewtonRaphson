package newtonraphson;

import java.util.Scanner;

/**
 *
 * @author Ariel AB
 */
public class NewtonRaphson {

    Scanner teclado = new Scanner(System.in);

    private void reglaFalsa(double xI, double error) {
        double xInicial = xI;
        double eMax = error;
        double fxI = f(xInicial);
        double fPrimaX = deriv(xInicial);
        short contador = 1;

        System.out.println("Valores iniciales: Xi = " + xInicial + " Error: " + eMax);

        while (Math.abs(fxI) >= eMax) {
            System.out.println("\n\nIteracion #" + contador);
            System.out.print("\nF(Xi)= ");
            System.out.printf("%06f", fxI);
            System.out.print("\nF'(X)= ");
            System.out.printf("%06f", fPrimaX);

            xInicial = xSiguiente(xInicial, fxI, fPrimaX);
            fxI = f(xInicial);
            fPrimaX = deriv(xInicial);

            contador++;
            System.out.print("\nX+1 = ");
            System.out.printf("%06f", xInicial);
            System.out.print("\nF'(X+1)= ");
            System.out.printf("%06f", fPrimaX);

        }
        System.out.print("\n\nRaiz: ");
        System.out.printf("%06f", xInicial);
        System.out.print("\nF(X" + contador + ")= ");
        System.out.printf("%06f", fPrimaX);

    }

    private double f(double x) {
        double fx;
        fx = (double) (((Math.pow((Math.E), (0.5 * x)))) + (5 * x) - 5);
        return fx;
    }

    private double deriv(double x) {
        double dxdy;
        dxdy = (double) ((((Math.pow((Math.E), (0.5 * x)))) / 2) + 5);
        return dxdy;
    }

    private double xSiguiente(double xI, double fx, double fPrimaX) {                                //metodo para calcular xM (en biseccion)
        return xI - (fx / fPrimaX);
    }

    public void main() {
        double xI;
        double error;
        System.out.println("Ingrese el valor inicial:");
        xI = teclado.nextDouble();
        System.out.println("Ingrese el error máximo:");
        error = teclado.nextDouble();
        reglaFalsa(xI, error);
    }
}