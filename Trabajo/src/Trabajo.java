import java.util.ArrayList;
import java.util.Scanner;

public class Trabajo {
    public static void main(String[] args) {
        Datos seleccion = new Datos();
        seleccion.ingresarValor();
    }
}

class Datos {
    public ArrayList<Integer> ingresarValor() {
        Scanner c = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            System.out.println("Inicio");
            System.out.println("1- Ingresar un Arreglo");
            System.out.println("2- Ordenar un Arreglo");
            System.out.println("0- Salir");

            int seleccion = c.nextInt();

            switch (seleccion) {
                case 1:
                    System.out.print("Ingresar el tamaño del arreglo: ");
                    int cantidad = c.nextInt();
                    for (int i = 0; i < cantidad; i++) {
                        System.out.print("Ingresar el numero para la posición " + (i + 1) + ": ");
                        int dato = c.nextInt();
                        lista.add(dato);
                    }
                    mostrarMenuOrdenamiento(lista);
                    continuar = false;
                    break;

                case 2:
                    if (lista.isEmpty()) {
                        System.out.println("Primero ingrese el arreglo");
                    } else {
                        mostrarMenuOrdenamiento(lista);
                    }
                    continuar = false;
                    break;

                case 0:
                    continuar = false;
                    System.out.println("Saliendo.\nVuelva Pronto.");
                    break;

                default:
                    System.out.println("Selección no valida, por favor intente nuevamente");
            }
        }
        c.close();
        return lista;
    }

    public void mostrarMenuOrdenamiento(ArrayList<Integer> lista) {
        Ordenamiento b = new Ordenamiento();
        Scanner b1 = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nMENU:");
            System.out.println("1- Metodo Burbuja");
            System.out.println("2- Metodo Seleccion");
            System.out.println("3- Metodo Insercion");
            System.out.println("4- Metodo Burbuja Mejorado");
            System.out.print("\nEscoja el metodo de ordenamiento: ");
            int metodo = b1.nextInt();
            if (metodo != 0) {
                System.out.println("\nEscoja una opcion:");
                System.out.println("1- Ascendente");
                System.out.println("2- Descendente");
                int orden = b1.nextInt();
                System.out.println("\nDesea ver cada paso:");
                System.out.println("1- Sí");
                System.out.println("2- No");
                int verPasos = b1.nextInt();
                if (verPasos == 1) {
                    boolean Pasos = true;
                    switch (metodo) {
                        case 1:
                            b.ordenBurbuja(lista, orden, Pasos);
                            break;
                        case 2:
                            b.ordenSeleccion(lista, orden, Pasos);
                            break;
                        case 3:
                            b.ordenInsercion(lista, orden, Pasos);
                            break;
                        case 4:
                            b.ordenBurbujaM(lista, orden, Pasos);
                            break;
                        default:
                            System.out.println("Selección no valida, por favor intente nuevamente");
                    }
                } else {
                    boolean Pasos = false;
                    switch (metodo) {
                        case 1:
                            b.ordenBurbuja(lista, orden, Pasos);
                            break;
                        case 2:
                            b.ordenSeleccion(lista, orden, Pasos);
                            break;
                        case 3:
                            b.ordenInsercion(lista, orden, Pasos);
                            break;
                        case 4:
                            b.ordenBurbujaM(lista, orden, Pasos);
                            break;
                        default:
                            System.out.println("Selección no válida, por favor intente nuevamente");
                    }

                }
            }
        }
        b1.close();
    }
}

class Ordenamiento {
    public void ordenBurbuja(ArrayList<Integer> lista, int orden, boolean Pasos) {
        int n = lista.size();
        boolean intercambio;
        for (int i = 0; i < n - 1; i++) {
            intercambio = false;
            if (Pasos) { // Mostrar la pasada solo si Pasos es true
                System.out.println("Pasada número " + (i + 1));
            }
            for (int j = 0; j < n - i - 1; j++) {
                if (Pasos) {
                    System.out.println("\ti=" + i + " j=" + j + " [j]=" + lista.get(j) + " [j+1]=" + lista.get(j + 1));
                }
                boolean condicion = (orden == 1) ? lista.get(j) > lista.get(j + 1) : lista.get(j) < lista.get(j + 1);
                if (condicion) {
                    if (Pasos) {
                        System.out.println("\t\tSe intercambia " + lista.get(j) + " con " + lista.get(j + 1));
                    }
                    int temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                    intercambio = true;
                }
                if (Pasos) {
                    System.out.println("\t\t--------" + lista);
                }
            }
            if (!intercambio)
                break;
        }
        System.out.println("\nLista ordenada por Método Burbuja: " + lista);
    }

    public void ordenSeleccion(ArrayList<Integer> lista, int orden, boolean Pasos) {
        for (int i = 0; i < lista.size() - 1; i++) {
            int indice = i;
            if (Pasos) { // Mostrar la pasada solo si Pasos es true
                System.out.println("Pasada número " + (i + 1));
            }
            for (int j = i + 1; j < lista.size(); j++) {
                if (Pasos) {
                    System.out.println("\ti=" + i + " j=" + j + " [i]=" + lista.get(i) + " [j]=" + lista.get(j));
                }
                boolean condicion = (orden == 1) ? lista.get(j) < lista.get(indice) : lista.get(j) > lista.get(indice);
                if (condicion) {
                    if (Pasos) {
                        System.out.println("\t\tNuevo índice para intercambio: " + j);
                    }
                    indice = j;
                }
            }
            if (indice != i) {
                if (Pasos) {
                    System.out.println("\t\tSe intercambia " + lista.get(i) + " con " + lista.get(indice));
                }
                int temp = lista.get(i);
                lista.set(i, lista.get(indice));
                lista.set(indice, temp);
            }
            if (Pasos) {
                System.out.println("\t\t--------" + lista);
            }
        }
        System.out.println("\nLista ordenada por Método Selección: " + lista);
    }

    public void ordenInsercion(ArrayList<Integer> lista, int orden, boolean Pasos) {
        int n = lista.size();
        for (int i = 1; i < n; i++) {
            int actual = lista.get(i);
            int j = i - 1;
            if (Pasos) { // Mostrar la pasada solo si Pasos es true
                System.out.println("Pasada número " + i);
                System.out.println("\ti=" + i + " j=" + j + " [i]=" + lista.get(i) + " [j]=" + lista.get(j));
            }
            while (j >= 0 && ((orden == 1) ? lista.get(j) > actual : lista.get(j) < actual)) {
                if (Pasos) {
                    System.out.println("\t\tSe compara " + actual + " con " + lista.get(j));
                }
                lista.set(j + 1, lista.get(j));
                j--;
                if (Pasos) {
                    System.out.println("\t\t--------" + lista);
                }
            }
            lista.set(j + 1, actual);
            if (Pasos) {
                System.out.println("\t\t--------" + lista);
            }
        }
        System.out.println("\nLista ordenada por Método Inserción: " + lista);
    }

    public void ordenBurbujaM(ArrayList<Integer> lista, int orden, boolean Pasos) {
        int n = lista.size();
        boolean intercambio;
        for (int i = 0; i < n - 1; i++) {
            intercambio = false;
            if (Pasos) { // Mostrar la pasada solo si Pasos es true
                System.out.println("Pasada número " + (i + 1));
            }
            for (int j = 0; j < n - i - 1; j++) {
                if (Pasos) {
                    System.out.println("\ti=" + i + " j=" + j + " [j]=" + lista.get(j) + " [j+1]=" + lista.get(j + 1));
                }
                boolean condicion = (orden == 1) ? lista.get(j) > lista.get(j + 1) : lista.get(j) < lista.get(j + 1);
                if (condicion) {
                    if (Pasos) {
                        System.out.println("\t\tSe intercambia " + lista.get(j) + " con " + lista.get(j + 1));
                    }
                    int temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                    intercambio = true;
                }
                if (Pasos) {
                    System.out.println("\t\t--------" + lista);
                }
            }
            if (!intercambio) {
                break;
            }
        }
        System.out.println("\nLista ordenada por Método Burbuja Mejorado: " + lista);
    }

    public void prinArreglo(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}