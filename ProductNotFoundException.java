class ProductNotFoundException extends Exception {
  private String message;
  ProductNotFoundException(String message){
    super(message);
  }
}
