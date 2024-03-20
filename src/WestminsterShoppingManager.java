import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class WestminsterShoppingManager implements ShoppingManager{
    static Scanner input = new Scanner(System.in);                                      // input scanner
    private ArrayList<Product> managerProductlist=new ArrayList<>();                   //Declaring the hashmap with reference to Product objects

    public WestminsterShoppingManager() {                                                //setting the constructor
        this.managerProductlist = managerProductlist;}

    public void managerMenu() {                                                          //prompting manager option menu
        while (true) {
            System.out.println("""
                                    
                                       ╔════▣◎▣════╗
                    ------------------⌬ Manager Menu ⌬-------------------
                                    
                    ✠ Select the Option:
                     [Enter a number]\n
                    ➤Add Product                (1)
                    ➤Remove Product             (2)             
                    ➤Print the List Of Products (3)
                    ➤Save List of Products      (4)
                    ➤Load List of Products      (5)
                    ➤Main Menu                  (0)
                    """);
            printFor();                                                                 //manager input option
            int managerInput = intInputValidation("\n◉ Enter Option:", 5, 0, "\n ⚠ Input Out Of Range. Try Again!");

            switch (managerInput) {                                                      //switch to run the methods based on manager's input
                case 1:                                                                 //case 1 to add a product
                    while (true){
                        printFor();                                                     // messege prompt to select the product type
                    System.out.println("""
                            \n✠ Select A Product Type                                  
                                            
                                Electronics - "E" or "e"
                                Clothing    - "C" or "c"
                            """);
                        printFor();
                    while (true) {
                        System.out.print("\n\uD834\uDF44 Enter Product Type:");      //getting the product type input from manager
                        String productTypeInput = input.next();                     //the input to get which type pf the product is(E or C)
                        if (productTypeInput.equalsIgnoreCase("e")) {     //condition to get inputs if its a electronic
                            printFor();

                            System.out.print("\n▪Enter Product ID:");
                            String id = input.next();
                            System.out.print("\n▪Enter Product Name:");
                            String name = input.next();
                            int stocks = intInputValidation("\n▪Enter Available Stocks:", 2000, 0, "\n✘ Maximum Stock Limit Exceeded.Try Aagin.");
                            double price = doubleInputValidation("\n▪Enter Product Price($):",0,"\nInvalid Input! Enter a Valid Digit.");
                            System.out.print("\n▪Enter Product Brand:");            //getting brand input
                            String brand = input.next();
                            int warranty = intInputValidation("\n▪Enter Warranty Period(Months):", 36, 0, "\n✘ Warranty Period Out of Limit.Try Aagin.");
                            Electronics electronics = new Electronics(id, name, stocks, price, brand, warranty);       //electronic object created
                            addProduct(electronics);                                                                   //adding electronic product to arraylist using method
                            break;

                        } else if (productTypeInput.equalsIgnoreCase("c")) {    //condition to get inputs if its a clothing
                            printFor();

                            System.out.print("\n▪Enter Product ID:");
                            String id = input.next();
                            System.out.print("\n▪Enter Product Name:");
                            String name = input.next();
                            int stocks = intInputValidation("\n▪Enter Available Stocks:", 2000, 0, "\n✘ Maximum Stock Limit Exceeded.Try Aagin.");
                            double price = doubleInputValidation("\n▪Enter Product Price($):",0,"\nInvalid Input! Enter a Valid Digit.");
                            System.out.print("\n▪Enter the size:");
                            String size=input.next();
                            System.out.print("\n▪Enter the color:");
                            String color = input.next();                                                    //getting color input
                            Clothing clothing = new Clothing(id, name, stocks, price, size, color);        //clothing object created

                            addProduct(clothing);                                                          //adding clothing product to arraylist using method
                            break;
                        } else {
                            printFor();
                            System.out.println("\n⚠ Invalid Input! Enter 'E' or 'C'");
                        }
                    }
                    String continueCheck;                                           //variable declared to check the repetition
                    while (true){
                        System.out.print("\n" +"[Yes-'y' No-'n']\n"+
                                "◉Do you want to add another product: ");
                        continueCheck=input.next();                                //getting user input to add aproduct again
                        if (continueCheck.equalsIgnoreCase("y")){
                            break;}
                        else if (continueCheck.equalsIgnoreCase("n")){
                            break;}
                        else {
                            System.out.println("Invalid Input! Try Again");
                        }
                    }
                    if (continueCheck.equalsIgnoreCase("y")){
                        continue;}
                    else {
                        break;}
                    }
                    break;
                case 2:                                                                 //case2 to delete product
                    printFor();
                    try {
                        System.out.println("\n✠ Enter 'Product ID' of the Product that Want to Remove.");
                        System.out.print("\n◉ Enter Product Id:");
                        String removeId = input.next();                                      //getting user input to delete a product
                        deleteProduct(removeId);
                    }catch (Exception e){}

                    break;

                case 3:                                                                 //case 3 to print the products
                    print();                                                            //calling print method
                    break;

                case 4:                                                                 //case 4 to save the products
                    save();                                                             //calling save method
                    break;

                case 5:                                                                 //case 5 to load the products
                    load();                                                             //calling the load method
                    break;

                case 0:
                    System.out.println("loading main menu ⧗..⧒..");
                    printFor();

                    return;

                default:                                                                //default to handle if the cases are than what is given
                    printFor();
                    System.out.println("\n\n⚠ Invalid Input.Try Again!");
                    System.out.print("\n◉ Enter Option:");

            }
        }
    }
    @Override
    public void addProduct(Product product) {
        managerProductlist.add(product);
        printFor();
        System.out.println("\n        ✧༝┉˚*❋ ❋*˚┉༝✧");
        System.out.println("* Product Added successfully *\n");
        printFor();

        if (managerProductlist.size()>50){
            System.out.println("Product Limit Over");
        }
    }
    @Override
    public void deleteProduct(String id) {
            for (Product product : managerProductlist) {                                       //loop to go through intill there is a product
                if (product.getProductId().equals(id)) {                                      //checking for ID similarity
                    managerProductlist.remove(product);
                    printFor();
                    System.out.print("\n☩ Product with the product id '" + product.getProductId() + "' has been deleted ☩\n");
                }
            }

            System.out.print("\n☯ No. of Products Remaining ➼ " + managerProductlist.size());



    }

    @Override
    public void print() {                                                                   //print method to print the products in the arraylist

            Collections.sort(managerProductlist);                                          // sort function to arrange in alphabetical order of the key
            for (Product product : managerProductlist) {                                   //for loop to go through each product
                if (managerProductlist.isEmpty()) {                                        //condition to check wheather the arraylist is empty
                    System.out.println("Product List Is Empty⚠ Need To Add Products.");
                }
                else if (product instanceof Electronics) {                                  //printing electronic products by checking the instance
                    System.out.println("""
                               Product Type    : Electronic""" +
                            "\nProduct ID      : " + product.getProductId()+
                            "\nProduct Name    : " + product.getProductName() +
                            "\nRemaining Stocks: " + product.getAvailableStocks() +
                            "\nPrice           : " + product.getPrice() +
                            "\nBrand           : " + ((Electronics) product).getBrand() +
                            "\nWarranty Period : " + ((Electronics) product).getWarrantyPeriod());
                } else if (product instanceof Clothing) {                                  //printing clothing product by checking the instance
                    System.out.println("""
                               Product Type    : Clothing""" +
                            "\nProduct ID      : " + product.getProductId()+
                            "\nProduct Name    : " + product.getProductName() +
                            "\nRemaining Stocks: " + product.getAvailableStocks() +
                            "\nPrice           : " + product.getPrice() +
                            "\nCloth Size      : " + ((Clothing) product).getSize() +
                            "\nCloth Color     : " + ((Clothing) product).getColour());

                }
            }
            printFor();
    }

    @Override
    public void save() {
        printFor();
        try {
            FileWriter saveProductData = new FileWriter("ProductData.txt");

            for (Product product : managerProductlist) {
                if (product instanceof Electronics) {
                    saveProductData.write("Product Type- Electronic" +", "+ product.getProductId() + ", " + product.getProductName() + ", " + product.getAvailableStocks() + ", " + product.getPrice() + ", " +
                            ((Electronics) product).getBrand() + ", " + ((Electronics) product).getWarrantyPeriod() + System.lineSeparator());
                } else if (product instanceof Clothing) {
                    saveProductData.write("Product Type- Clothing" +", "+ product.getProductId() + ", " + product.getProductName() + ", " + product.getAvailableStocks() + ", " + product.getPrice() + ", " +
                            ((Clothing) product).getSize() + ", " + ((Clothing) product).getColour() + System.lineSeparator());
                }
            }

            System.out.println("\n   ★---Data Saved Successfully---★  \n");
            printFor();
            saveProductData.close();
        } catch (IOException e) {
            System.out.println("\nError in saving the products to the File ⚠ \n");
            printFor();
        }
    }

    @Override
    public void load() {
        File file = new File("ProductData.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();

                // Check if the tokens array has at least 7 elements
                if (data.startsWith("Product Type-")) {
                    try {
                        String[] tokens = data.replace("Product Type-", "").split(", ");
                        String productType = tokens[0];                 // Assuming product type is the first token
                        String id = tokens[1];                          // Assuming id is the second token
                        String name = tokens[2];                        // Assuming name is the third token
                        int stocks = Integer.parseInt(tokens[3]);       // Assuming stocks is the fourth token
                        double price = Double.parseDouble(tokens[4]);   // Assuming price is the fifth token
                        if (productType.contains("Electronic")) {               // Checking for an electronic product
                            String brand = tokens[5];                           // Assuming brand is the sixth token
                            int warrantyPeriod = Integer.parseInt(tokens[6]);   // Assuming warrantyPeriod is the seventh token
                            managerProductlist.add(new Electronics(id, name, stocks, price, brand, warrantyPeriod));
                        } else if (productType.contains("Clothing")) {          // Checking for a clothing product
                            String size = tokens[5];                            // Assuming size is the sixth token
                            String colour = tokens[6];                          // Assuming colour is the seventh token
                            managerProductlist.add(new Clothing(id, name, stocks, price, size, colour));
                        }
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                        System.err.println("Error parsing data: " + data);
                    }
                } else {
                    System.err.println("Invalid data format: " + data);
                }
            }
            System.out.println("\n      ★---Data Successfully Loaded---★ \n");
            printFor();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Methods used to reduce repetition and functionality easy.

    public static int intInputValidation(String note1,int max, int min,String alert1){        //method to get and validate inputs of integer type
        while (true){
            try {
                System.out.print(note1);                                        //message to get double input from manager
                int input1=input.nextInt();

                if(input1>max){                                                 //condition to check the max range value
                    printFor();
                    System.out.println(alert1);
                    printFor();
                    continue;
                }
                if (input1<min){
                    printFor();
                    System.out.println(alert1);
                    printFor();
                    continue;
                }
                return input1;
            }catch (InputMismatchException e){
                printFor();
                System.out.println("\n⚠ Invalid Input! Enter an Integer.");
                printFor();
                input.next();}
        }
    }
    private static double doubleInputValidation(String note2,int min,String alert2){         //method to get and validate inputs of double type
        while (true){                                               // loop to continue until its correct
            try {
                System.out.print(note2);                             //message to get double input from manager
                double input2=input.nextDouble();

                if (input2<min){                                    //condition to check the range
                    printFor();
                    System.out.println(alert2);
                    printFor();
                    continue;
                }
                return input2;
            }catch (InputMismatchException e){
                printFor();
                System.out.println("\n⚠ Invalid Input! Enter an Integer.");
                printFor();
                input.next();}
        }
    }
    public ArrayList<Product> getManagerProductlist() {
        return managerProductlist;
    }

    public static void printFor(){                         //method to print the dashed horizontal line
        for (int k = 0; k < 55; k++) {
            System.out.print("-");}
    }
}




