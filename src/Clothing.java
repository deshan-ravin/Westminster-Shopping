public class Clothing extends Product{                    // declaring instance variables of Clothing class

    private String size;
    private String colour;
                                                     //setting the default constructor

    public Clothing() {}
                                                     //setting the overloaded constructor
    public Clothing(String productId,String productName,int availableStocks,
                    double price,String size,String colour){
        super(productId,productName,availableStocks,price);        //inherit the instance variables from the parent product class
        this.size=size;
        this.colour=colour;}
                                                      //getters and setters for the class instances
    public String getSize() {return size;}
    public String getColour() {return colour;}

    public void setSize(String size) {this.size = size;}
    public void setColour(String colour) {this.colour = colour;}

    @Override
    public String getProductTypeInput() {
        return "Clothing";
    }
}
