import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class Inventory<T extends Product> {
  private List<T> products;
  Scanner scanner;

  Inventory(){
    products = new ArrayList<>();
    scanner = new Scanner(System.in);
  }

  void addProduct(T product){
    products.add(product);
  }

  void eliminateProduct(T product){
    products.remove(product);
  }

  T searchProduct(T product) throws ProductNotFoundException {
    for (int i = 0; i < products.size(); i++) {
      if (Objects.equals(products.get(i), product))
        return products.get(i);
    }
    throw new ProductNotFoundException("Error, Producto no encontrado!");
  }

  T searchProductName(String name) throws ProductNotFoundException {
    for (int i = 0; i < products.size(); i++)
      if (products.get(i).getName().equalsIgnoreCase(name))
        return products.get(i);

    throw new ProductNotFoundException("Error, Producto no encontrado!");
  }

  void mostrarInventario(){
    System.out.println("---- Productos ----");
    for (int i = 0; i < products.size(); i++) {
      System.out.println(products.get(i).getDetails());
    }
    System.out.println();
  }

  List<T> getProducts() {
    return products;
  }
}

