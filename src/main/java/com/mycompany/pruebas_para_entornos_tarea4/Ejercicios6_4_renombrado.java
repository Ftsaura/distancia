package com.mycompany.pruebas_para_entornos_tarea4;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicios6_4_renombrado 
{

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        
        while (true) 
        {
            System.out.println("Elija una opción:");
            System.out.println("1. Generar y analizar array");
            System.out.println("2. Mezclar dos arrays");
            System.out.println("3. Verificar orden de un array");
            System.out.println("4. Desplazar elementos a la derecha");
            System.out.println("5. Buscar elemento en un array");
            System.out.println("0. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) 
            {
                case 1:
                    System.out.println("Ha elegido la opción 1.");
                    generarYAnalizarArray();
                    mostrarSeparadorcambiado();
                    break;
                case 2:
                    System.out.println("Ha elegido la opción 2.");
                    mezclarDosArrays();
                    mostrarSeparadorcambiado();
                    break;
                case 3:
                    System.out.println("Ha elegido la opción 3.");
                    verificarOrdenArray();
                    mostrarSeparadorcambiado();
                    break;
                case 4:
                    System.out.println("Ha elegido la opción 4.");
                    desplazarDerecha();
                    mostrarSeparadorcambiado();
                    break;
                case 5:
                    System.out.println("Ha elegido la opción 5.");
                    buscarElementoEnArray();
                    mostrarSeparadorcambiado();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    public static void mostrarSeparadorcambiado() 
    {
        System.out.println("-----------------------------------------------------------------------------");
    }


    // Ejercicio 1
    public static void generarYAnalizarArray() 
    {
        int[] array = generarArrayAleatorio(10, -100, 100);
        mostrarArray(array);

        int[] resultados = calcularMediaPositivosNegativos(array);
        System.out.println("Media de positivos: " + resultados[0]);
        System.out.println("Media de negativos: " + resultados[1]);
        System.out.println("Cantidad de ceros: " + resultados[2]);
    }

    // Ejercicio 2
    public static void mezclarDosArrays() 
    {
        int[] arrayA = generarArrayAleatorio(10, 1, 100);
        int[] arrayB = generarArrayAleatorio(10, 1, 100);

        int[] arrayMezclado = mezclarArrays(arrayA, arrayB);
        System.out.println("Array A: " + Arrays.toString(arrayA));
        System.out.println("Array B: " + Arrays.toString(arrayB));
        System.out.println("Array Mezclado: " + Arrays.toString(arrayMezclado));
    }

    // Ejercicio 3
   public static void verificarOrdenArray() 
   {
        int[] array;
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Quiere generar el array automáticamente? (1 = sí, 2 = no):");
        int opcion = scanner.nextInt();

        switch (opcion) 
        {
            case 1:
                array = generarArrayAleatorio(10, -100, 100);
                System.out.println("Array generado automáticamente:");
                mostrarArray(array);
                break;
            case 2:
                array = leerArrayDesdeTeclado();
                break;
            default:
                System.out.println("Opción no válida. Inténtelo de nuevo.");
                return;
        }

        if (estaOrdenado(array)) 
            System.out.println("El array está ordenado.");
         else 
            System.out.println("El array no está ordenado.");
        
    }

    // Ejercicio 4
        public static void desplazarDerecha() 
        {
        int[] array;
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Quiere generar el array automáticamente? (1 = sí, 2 = no):");
        int opcion = scanner.nextInt();

        switch (opcion) 
            {
            case 1:
                array = generarArrayAleatorio(10, -100, 100);
                System.out.println("Array generado automáticamente:");
                mostrarArray(array);
                break;
            case 2:
                array = leerArrayDesdeTeclado();
                break;
            default:
                System.out.println("Opción no válida. Inténtelo de nuevo.");
                return;
            }

        int[] arrayDesplazado = desplazarDerecha(array);
        System.out.println("Array Desplazado: " + Arrays.toString(arrayDesplazado));
        }

    // Ejercicio 5
        public static void buscarElementoEnArray() 
        {
        int[] array;
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Quiere generar el array automáticamente? (1 = sí, 2 = no):");
        int opcion = scanner.nextInt();

        switch (opcion) 
        {
            case 1:
                array = generarArrayAleatorio(10, -100, 100);
                System.out.println("Array generado automáticamente:");
                mostrarArray(array);
                break;
            case 2:
                array = leerArrayDesdeTeclado();
                break;
            default:
                System.out.println("Opción no válida. Inténtelo de nuevo.");
                return;
        }

        System.out.println("Ingrese el valor a buscar:");
        int valor = scanner.nextInt();

        int posicion = buscarElemento(array, valor);
        if (posicion != -1) 
        {
            System.out.println("El valor " + valor + " está en la posición " + posicion);
        } else 
        {
            System.out.println("El valor " + valor + " no está en el array.");
        }
    }

    // Métodos auxiliares

    public static int[] generarArrayAleatorio(int longitud, int min, int max) 
    {
        int[] array = new int[longitud];
        Random random = new Random();
        for (int i = 0; i < longitud; i++) 
        {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    public static void mostrarArray(int[] array) 
    {
        System.out.println("Array: " + Arrays.toString(array));
    }

    public static int[] calcularMediaPositivosNegativos(int[] array) 
    {
        int sumPositivos = 0;
        int countPositivos = 0;
        int sumNegativos = 0;
        int countNegativos = 0;
        int countCeros = 0;

        for (int num : array) 
        {
            if (num > 0) {
                sumPositivos += num;
                countPositivos++;
            } else if (num < 0) 
            {
                sumNegativos += num;
                countNegativos++;
            } else 
            {
                countCeros++;
            }
        }

        double mediaPositivos = (countPositivos > 0) ? (double) sumPositivos / countPositivos : 0;
        double mediaNegativos = (countNegativos > 0) ? (double) sumNegativos / countNegativos : 0;

        return new int[]{(int) mediaPositivos, (int) mediaNegativos, countCeros};
    }

    public static int[] mezclarArrays(int[] arrayA, int[] arrayB) 
    {
        int[] arrayMezclado = new int[arrayA.length + arrayB.length];
        int index = 0;

        for (int i = 0; i < arrayA.length; i++) 
        {
            arrayMezclado[index++] = arrayA[i];
            arrayMezclado[index++] = arrayB[i];
        }

        return arrayMezclado;
    }

    public static int[] leerArrayDesdeTeclado() 
    {
        System.out.println("Ingrese los elementos del array (separados por espacio):");
        Scanner scanner = new Scanner(System.in);
        String[] elementos = scanner.nextLine().split(" ");

        int[] array = new int[elementos.length];
        for (int i = 0; i < elementos.length; i++) 
        {
            array[i] = Integer.parseInt(elementos[i]);
        }

        return array;
    }

    public static boolean estaOrdenado(int[] array) 
    {
        boolean creciente = true;
        boolean decreciente = true;

        for (int i = 1; i < array.length; i++) 
        {
            if (array[i] > array[i - 1]) 
            {
                decreciente = false;
            } else if (array[i] < array[i - 1]) 
            {
                creciente = false;
            }
        }

        return creciente || decreciente;
    }

    public static int[] desplazarDerecha(int[] array) 
    {
        int[] arrayDesplazado = new int[array.length];
        arrayDesplazado[0] = array[array.length - 1];

        for (int i = 1; i < array.length; i++) 
        {
            arrayDesplazado[i] = array[i - 1];
        }

        return arrayDesplazado;
    }

    public static int buscarElemento(int[] array, int valor) 
    {
        for (int i = 0; i < array.length; i++) 
        {
            if (array[i] == valor) 
            {
                return i;
            }
        }
        return -1;
    }
}