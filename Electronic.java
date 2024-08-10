import java.util.Objects;
class Electronic extends Product {
  private String size;
  private int id = 1;
  Electronic(String name, double price, int mount, String size){
    super(name, price, mount);
    setSize(size);
  }
  String getSize(){
    return size;
  }
  void setSize(String size){
    this.size = size;
  }
  @Override
  public String getDetails(){
    return String.format("Electronic [Name: %s, Price: %f, Mount: %d, Size: %s]", 
                          super.getName(), super.getPrice(), super.getMount(), getSize());
  } 
  @Override
  public boolean equals(Object object){
    if ( object == this ) return true;
    if ( object == null || object.getClass() != this.getClass() ) return false;
    Electronic elec = (Electronic) object;
    return this.getName().equals(elec.getName()) && this.getPrice() == elec.getPrice() 
            && this.getMount() == elec.getMount() && this.getSize().equals(elec.getSize());
  }
  @Override
  public int hashCode(){
    return Objects.hash(super.getName(), super.getPrice(), super.getMount(), this.size); 
  }
  @Override
  public int getId(){
    return id;
  }
}
