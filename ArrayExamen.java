package Examen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayExamen {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        int idCounter = 1;

        while (true) {
            System.out.println("Ingrese el nombre del producto:");
            String nombre = entrada.nextLine();

            boolean Existe = false;
            for (Producto producto : productos) {
                if (producto.getNombre().equalsIgnoreCase(nombre)) {
                    Existe = true;
                    break;
                }
            }
            if (Existe) {
                System.out.println("El nombre del producto ya existe. Intente con otro nombre.");
                continue;
            }

            System.out.println("Ingrese la marca del producto:");
            String marca = entrada.nextLine();
            System.out.println("Ingrese el precio del producto:");
            double precio = Double.parseDouble(entrada.nextLine());

            Producto producto = new Producto(idCounter, nombre, marca, precio);


            boolean idExistente = false;
            for (Producto prod : productos) {
                if (prod.getId() == idCounter) {
                    idExistente = true;
                    break;
                }
            }
            if (!idExistente) {
                productos.add(producto);
                idCounter++;
            } else {
                System.out.println("El ID del producto ya existe. Intente de nuevo.");
            }

            System.out.println("¿Desea ingresar otro producto? (si/no)");
            String respuesta = entrada.nextLine();
            if (respuesta.equalsIgnoreCase("no")) {
                break;
            }
        }

        System.out.println("Productos registrados:");
        Iterator<Producto> iterator = productos.iterator();
        while (iterator.hasNext()) {
            Producto producto = iterator.next();
            System.out.println(producto);
        }

        entrada.close();
    }

}
 class Producto {
    private int id;
    private String codigo;
    private String nombre;
    private String marca;
    private double precio;

    public Producto(int id, String nombre, String marca, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.codigo = Codigo(nombre, marca);
    }

    private String Codigo(String nombre, String marca) {
        String codigo = nombre.substring(0, 3) + marca.substring(0, 2);
        int numeroAleatorio = (int) (Math.random() * 900) + 100;
        return codigo + numeroAleatorio;
    }

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return
                "id =" + id +
                ", codigo = '" + codigo + '\'' +
                ", nombre = '" + nombre + '\'' +
                ", marca = '" + marca + '\'' +
                ", precio = " + precio  ;
    }
}
