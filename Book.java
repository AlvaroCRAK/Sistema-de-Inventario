import java.util.Objects;
class Book extends Product {
  private String author;
  private int id = 2; 
  Book(String name, double price, int mount, String author){
    super(name, price, mount);
    setAuthor(author);
  }
  String getAuthor(){
    return author;
  }
  void setAuthor(String author){
    this.author = author;
  }
  @Override
  public String getDetails(){
    return String.format("Book [Name: %s, Price: %f, Mount: %d, Author: %s", 
                          super.getName(), super.getPrice(), super.getMount(), getAuthor());
  }
  @Override
  public boolean equals(Object object){
    if ( object == this ) return true;
    if ( object == null || object.getClass() != this.getClass() ) return false;
    Book book = (Book) object;
    return super.getName().equals(book.getName()) && super.getPrice() == book.getPrice() 
            && super.getMount() == book.getMount() && this.author.equals(book.getAuthor());
  }
  @Override
  public int hashCode(){
    return Objects.hash(super.getName(), super.getPrice(), super.getMount(), this.author);
  }
  @Override
  public int getId(){
    return id;
  }
}
