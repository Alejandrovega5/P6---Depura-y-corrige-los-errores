package tema2_debug;

import java.util.Scanner;

/**
 * Programa con errores para practicar la depuración.
 * El programa pide una temperatura y muestra si hace frío, calor o temperatura templada.
 * Después, repite mientras el usuario quiera continuar.
 */
public class Temperaturas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        mostrarMensajeBienvenida(); //AVG24/10/2025: Le falta el cierre de la sentencia. Le he añadido ";"

        boolean continuar = true;

        while (continuar) {//AVG24/10/2025: Aqui he quitado el boolean false porque si no nunca se va inicializar.
            double temperatura = pedirTemperatura(sc);
            mostrarResultado(temperatura); //AVG24/10/2025: Le falta el cierre de la sentencia. Le he añadido ";"

            System.out.print("¿Desea introducir otra temperatura? (s/n): ");
            String respuesta = sc.next();

            if (respuesta.equalsIgnoreCase("n")) { //AVG24/10/2025: he cambiado la expresion == por un equalsIgnoreCase para que funcione porque java no deja comparar letras con ==. 
                continuar = false; 
                
            } 
            while (!respuesta.equalsIgnoreCase("n") && !respuesta.equalsIgnoreCase("s")) {
            System.out.println("Error, la respuesta tiene que ser s/n");
            System.out.print("¿Desea introducir otra temperatura? (s/n): ");
            respuesta = sc.next();
            }
        }
        sc.close();
        System.out.println("Programa finalizado."); //AVG24/10/2025: Le falta el cierre de la sentencia. Le he añadido ";"
    }

    public static void mostrarMensajeBienvenida() {
        System.out.println("Bienvenido al analizador de temperaturas."); //AVG24/10/2025: Le falta el cierre de la sentencia. Le he añadido ";"
        System.out.println("Este programa indica si hace frío, calor o está templado.");//AVG24/10/2025: Le falta el cierre de la sentencia. Le he añadido ";"
    }
  
    public static double pedirTemperatura(Scanner sc) {                
        double t; 
        do {
            System.out.print("Introduce la temperatura en grados: ");
            t = sc.nextDouble();
            if (t < -10 || t > 50) { //AVG24/10/2025: He cambiado el operador logico tiene que ser un or (||) porque si es un and (&&) nunca se va cumplir
                System.out.println("Temperatura fuera del rango permitido (-10 a 50)."); //AVG24/10/2025: Le falta el cierre de la sentencia. Le he añadido ";". 
                
            }
        } while (t < -10 || t > 50);//AVG24/10/2025:Aqui tambien he cambiado el operador logico de and a or. Con esto si me salgo del rango de temperatura me lo vuelve a pedir.
        return t;
    }

    public static void mostrarResultado(double temperatura) {
        if (temperatura < 15)
            System.out.println("Hace frío.");//AVG24/10/2025: Le falta el cierre de la sentencia. Le he añadido ";"
        else if (temperatura >= 15 && temperatura < 30)
            System.out.println("Temperatura templada.");//AVG24/10/2025: Le falta el cierre de la sentencia. Le he añadido ";"
        else if (temperatura >= 30)
            System.out.println("¡Hace mucho calor!");//AVG24/10/2025: Le falta el cierre de la sentencia. Le he añadido ";"
        else
            System.out.println("Valor no reconocido.");//AVG24/10/2025: Le falta el cierre de la sentencia. Le he añadido ";"
    }
}





