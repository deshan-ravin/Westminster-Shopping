import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.print("""
                              \n4
                              
                              ◣──»--•--«──•~❉᯽❉~•──»--•--«──◢
                                           WELCOME\n""");
            int rollOption = WestminsterShoppingManager.intInputValidation("\n(1) Manger   \uD83D\uDC26\n" +
                    "(2) Customer \uD83E\uDD89\n" + "(0) Quit     \uD83D\uDC32\n" +
                    "\n◉ Select Option:", 2, 0, "\nInvalid Input. Try Again!");

            switch (rollOption) {
                case 1:
                    WestminsterShoppingManager westminsterShoppingManager = new WestminsterShoppingManager();
                    westminsterShoppingManager.managerMenu();
                    break;
                case 2:
                    WestminsterShoppingManager.printFor();
                    WestminsterShoppingCentreGUI applicationGUI = new WestminsterShoppingCentreGUI();
                    SwingUtilities.invokeLater(() -> {
                        applicationGUI.setVisible(true);
                    });
                    break;
                case 0:
                    System.out.println("\n       --You have Quit the Shopping Centre--\n " +
                            "             !!!....Good BYE....!!!");
                    return;
            }
        }
    }
}

