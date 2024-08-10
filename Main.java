import java.util.Scanner;

public class Main {
  private static Scanner scanner = new Scanner(System.in);
  private static Inventory<Product> inventario = new Inventory<>();

  public static void main(String[] args) {
    menuOpciones();
    System.exit(0);
  }

  static void menu() {
    System.out.println("\n---- Sistema de Inventario ----");
    System.out.println("1. Agregar Producto");
    System.out.println("2. Actualizar Producto");
    System.out.println("3. Eliminar Producto");
    System.out.println("4. Consultar Producto");
    System.out.println("5. Mostrar Inventario");
    System.out.println("6. Salir");
    System.out.print("Seleccione una opcion: ");
  }

  static void menuOpciones() {
    int opc;
    while (true) {
      menu();
      try {
        opc = scanner.nextInt();
      } catch (java.util.InputMismatchException e) {
        opc = 0;
        System.out.println(e.getMessage());
      } finally {
        scanner.nextLine();
      }
      switch (opc) {
        case 1:
          agregarProducto();
          break;

        case 2:
            actualizarProducto();
          break;

        case 3:
            eliminarProducto();
          break;

        case 4:
            consultarProducto();
          break;

        case 5:
          inventario.mostrarInventario();
          break;

        case 6:
          System.out.println("Gracias por usar el sistema de inventario, que tenga buen día ^<^");
          return;

        default:
          System.out.println("Opcion no valida, intente de nuevo por favor");
      }
    }
  }

  static void tipoProducto() {
    System.out.println("--- Tipo de Producto ---");
    System.out.println("1. Electronico");
    System.out.println("2. Libro");
    System.out.println("3. Ropa");
    System.out.print("Seleccione una opcion: ");
  }

  static int tipoProducto(int opc) {
    while (true) {
      try {
        opc = scanner.nextInt();
        return opc;
      } catch (java.util.InputMismatchException e) {
        scanner.nextLine();
        System.out.println(e.getMessage());
        System.out.println("Opcion no valida, intente de nuevo!");
        tipoProducto();
      }
    }
  }

  static void agregarProducto() {
    tipoProducto();
    int tipo = tipoProducto(0);
    scanner.nextLine();
    System.out.print("Ingrese el nombre: ");
    String name = scanner.nextLine();

    double price;
    int mount;
    while (true) {
      try {
        System.out.print("Ingrese el precio: ");
        price = scanner.nextDouble();
        break;
      } catch (java.util.InputMismatchException e) {
        System.out.println("No valido");
        scanner.nextLine();
      }
    }
    while (true) {
      try {
        System.out.print("Ingrese la cantidad: ");
        mount = scanner.nextInt();
        break;
      } catch (java.util.InputMismatchException e) {
        System.out.println("No valido");
        scanner.nextLine();
      }finally{
        scanner.nextLine();
      }
    }

    String otro;
    switch (tipo) {
      case 1:
        System.out.print("Ingrese el tamaño (descriptivo): ");
        otro = scanner.nextLine();
        inventario.addProduct((Product) new Electronic(name, price, mount, otro));
        break;
      case 2:
        System.out.print("Ingrese el autor: ");
        otro = scanner.nextLine();
        inventario.addProduct((Product) new Book(name, price, mount, otro));
        break;
      case 3:
        System.out.print("Ingrese la marca: ");
        otro = scanner.nextLine();
        inventario.addProduct((Product) new Clothes(name, price, mount, otro));
        break;
    }
    System.out.println("Producto agregado con exito!");
  }

  static void actualizarProducto() {
    System.out.print("Ingrese el nombre del producto: ");
    String name = scanner.nextLine();
    Product product;
    try {
      product = inventario.searchProductName(name);
    } catch (ProductNotFoundException e) {
      System.out.println(e.getMessage());
      return;
    }

    System.out.println("Datos actuales: ");
    System.out.println(product.getDetails());

    inventario.eliminateProduct(product);

    double price;
    int mount;
    while (true) {
      try {
        System.out.print("Ingrese el precio: ");
        price = scanner.nextDouble();
        break;
      } catch (java.util.InputMismatchException e) {
        System.out.println("No valido");
        scanner.nextLine();
      }
    }
    while (true) {
      try {
        System.out.print("Ingrese la cantidad: ");
        mount = scanner.nextInt();
        break;
      } catch (java.util.InputMismatchException e) {
        System.out.println("No valido");
        scanner.nextLine();
      } finally{
        scanner.nextLine();
      }
    }

    String otro;
    switch (product.getId()) {
      case 1:
        System.out.print("Ingrese el tamaño (descriptivo): ");
        otro = scanner.nextLine();
        product = new Electronic(name, price, mount, otro);
        break;
      case 2:
        System.out.print("Ingrese el autor: ");
        otro = scanner.nextLine();
        product = new Book(name, price, mount, otro);
        break;
      case 3:
        System.out.print("Ingrese la marca: ");
        otro = scanner.nextLine();
        product = new Clothes(name, price, mount, otro);
        break;
    }
    inventario.eliminateProduct(product);
    inventario.addProduct(product);
    System.out.println("Producto actualizado con exito!");
  }

  static void eliminarProducto() {
    System.out.print("Ingrese el nombre del producto a eliminar: ");
    String name = scanner.nextLine();
    Product product;
    try {
      product = inventario.searchProductName(name);
    } catch (ProductNotFoundException e) {
      System.out.println(e.getMessage());
      return;
    }
    inventario.eliminateProduct(product);
    System.out.println("Producto eliminado con exito!");
  }

  static void consultarProducto() {
    System.out.print("Ingrese el nombre del producto a consultar: ");
    String name = scanner.nextLine();
    Product product;
    try {
      product = inventario.searchProductName(name);
    } catch (ProductNotFoundException e) {
      System.out.println(e.getMessage());
      return;
    }
    System.out.println(product.getDetails());
  }
}

