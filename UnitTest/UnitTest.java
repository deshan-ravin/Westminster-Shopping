import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.*;

public class UnitTest {

    @Test
    public void addProduct() {
        WestminsterShoppingManager shoppingManager = new WestminsterShoppingManager();
        Electronics electronics = new Electronics();
        Clothing clothing=new Clothing();

        shoppingManager.addProduct(electronics);
        shoppingManager.addProduct(clothing);

        assertTrue(shoppingManager.getManagerProductlist().contains(electronics));
    }

    @Test
    public void deleteProduct() {
        WestminsterShoppingManager shoppingManager = new WestminsterShoppingManager();
        Electronics electronics = new Electronics();

        shoppingManager.addProduct(electronics);
        shoppingManager.deleteProduct(electronics.getProductId());

        assertFalse(shoppingManager.getManagerProductlist().contains(electronics));
    }

    @Test
    public void print() {
        WestminsterShoppingManager shoppingManager = new WestminsterShoppingManager();
        Electronics electronics = new Electronics("123", "Laptop", 10, 999.99, "Dell", 12);
        shoppingManager.addProduct(electronics);

        // Redirect the standard output to capture printed content
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        shoppingManager.print();

        // Reset the standard output
        System.setOut(System.out);

        // Customize this assertion based on the actual output format
        assertEquals("""
                -------------------------------------------------------
                Product Type    : Electronic
                Product ID      : 123abc
                Product Name    : Laptop
                Remaining Stocks: 10
                Price           : 999.99
                Brand           : Dell
                Warranty Period : 12
                -------------------------------------------------------
                """, outputStream.toString().trim());
    }

    @Test
   public void save() {
        WestminsterShoppingManager shoppingManager = new WestminsterShoppingManager();
        Electronics electronics = new Electronics("123", "Laptop", 10, 999.99, "Dell", 12);
        shoppingManager.addProduct(electronics);

        // Set up the test file path
        String testFilePath = "testProductData.txt";

        // Save the data to the test file
        try {
            shoppingManager.save();

            // Read the content of the test file
            BufferedReader reader = new BufferedReader(new FileReader(testFilePath));
            String savedContent = reader.readLine();
            reader.close();

            // assertion
            assertEquals("Product Type- Electronic, 123, Laptop, 10, 999.99, Dell, 12", savedContent);
        } catch (IOException e) {
            fail("IOException occurred during the test");
        }
    }


    @Test
   public void Load() {
        WestminsterShoppingManager shoppingManager = new WestminsterShoppingManager();

        // Prepare a temporary file with sample content
        String inputFileContent = "Product Type- Electronic, 123, Laptop, 10, 999.99, Dell, 12";
        Path tempFilePath;
        try {
            tempFilePath = Files.createTempFile("tempTestFile", ".txt");
            Files.writeString(tempFilePath, inputFileContent);
        } catch (IOException e) {
            throw new RuntimeException("Error creating temporary file.", e);
        }

        // Set up the input stream to simulate reading from the temporary file
        System.setIn(new ByteArrayInputStream("".getBytes()));

        // Load the data
        try {
            toString();
        } catch (Exception e) {
            ;
        }

        // Reset the input stream
        System.setIn(System.in);

        // Validate the loaded data
        assertEquals(1, shoppingManager.getManagerProductlist().size());
        assertTrue(shoppingManager.getManagerProductlist().get(0) instanceof Electronics);

        // Delete the temporary file
        try {
            Files.delete(tempFilePath);
        } catch (IOException e) {
            throw new RuntimeException("Error deleting temporary file.", e);
        }
    }
}


