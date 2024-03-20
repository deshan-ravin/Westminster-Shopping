public abstract class Product implements Comparable<Product> {                  //created the product class an abstract class

                                                // declaring instance variables of Product abstract class
    private String productId;
    private String productName;
    private int availableStocks;
    private double price;
                                                //setting the default constructor
    public Product() {}
                                                //setting the overloaded constructor
    public  Product(String productId,String productName,int availableStocks,double price){
        this.productId=productId;
        this.productName=productName;
        this.availableStocks=availableStocks;
        this.price=price;}
                                                        //getters and setters for the class instances
    public String getProductId() {return productId;}

    public String getProductName() {return productName;}

    public int getAvailableStocks() {return availableStocks;}

    public abstract String getProductTypeInput();

    public double getPrice() {return price;}
    public void setProductId(String productId) {this.productId = productId;}
    public void setProductName(String productName) {this.productName = productName;}
    public void setAvailableStocks(int availableStocks) {this.availableStocks = availableStocks;}
    public void setPrice(double price) {this.price = price;}


    @Override
    public int compareTo(Product P) {
        return this.getProductId().compareTo(P.getProductId());
    }                                                               //overridden comarable method to compare the products in order to sort
}
