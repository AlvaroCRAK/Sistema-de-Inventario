abstract class Product {
  private String name;
  private double price;
  private int mount;
  private int id = 0;
  Product(String name, double price, int mount){
    setName(name);
    setPrice(price);
    setMount(mount);
  }
  String getName(){
    return name;
  }
  double getPrice(){
    return price;
  }
  int getMount(){
    return mount;
  }
  void setName(String name){
    this.name = name;
  }
  void setPrice(double price){
    this.price = price;
  }
  void setMount(int mount){
    this.mount = mount;
  }
  abstract public String getDetails();

  abstract public boolean equals(Object object);

  abstract public int hashCode();

  int getId(){
    return id;
  }
}
