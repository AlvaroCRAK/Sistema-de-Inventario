import java.util.Objects;
class Clothes extends Product {
  private String brand;
  private int id = 3;
  Clothes(String name, double price, int mount, String brand){
    super(name, price, mount);
    setBrand(brand);
  }
  String getBrand(){
    return brand;
  }
  @Override
  public String getDetails(){
    return String.format("Clothes [Name: %s, Price: %f, Mount: %d, Brand: %s]", 
                          super.getName(), super.getPrice(), super.getMount(), getBrand());
  }
  void setBrand(String brand){
    this.brand = brand;
  }
  @Override
  public boolean equals(Object object){
    if ( object == this ) return true;
    if ( object == null && object.getClass() != this.getClass() ) return false;
    Clothes clothes = (Clothes) object;
    return super.getName().equals(clothes.getName()) && super.getPrice() == clothes.getPrice() &&
            super.getMount() == clothes.getMount() && this.getBrand().equals(clothes.getBrand());
  }
  @Override
  public int hashCode(){
    return Objects.hash(super.getName(), super.getPrice(), super.getMount(), this.brand);
  }
  @Override
  public int getId(){
    return id;
  }
}
