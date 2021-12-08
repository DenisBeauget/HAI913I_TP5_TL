package user;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import logger.Lps;
import logger.OurFormatter;

public class Main {
    private static final java.util.logging.Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static java.util.logging.FileHandler tx;

    private java.io.IOException e1638959879505;

    public static logger.OurFormatter of;
    
  

    public static void main(java.lang.String[] args) throws user.ProductException, SecurityException, IOException {

        /**
         * Here start testing content for log generator.
         * This part is here only for logging part, CLI and global application steel be use without this testing part
         * like normal java app.
         */
        // Here the initial repository
        user.Repository ourRepo = new user.Repository();
        // Some product to test functionnality
        /**
         * Scenario : 10 products and 4 user, some add product, remove and fectch to see some ouput logging
         * before parse result
         */
        user.Product p1 = new user.Product("1", "Eggs", 3.5, "25/11/2021");
        user.Product p2 = new user.Product("2", "Chicken", 6.5, "22/12/2021");
        user.Product p3 = new user.Product("3", "Sausage", 3.5, "25/12/2021");
        user.Product p4 = new user.Product("4", "Bacon", 17.5, "25/12/2021");
        user.Product p5 = new user.Product("5", "Chair", 47, "no expiration date");
        user.Product p6 = new user.Product("6", "Desk", 717, "no expiration date");
        user.Product p7 = new user.Product("7", "computer", 1800, "no expiration date");
        user.Product p8 = new user.Product("8", "chocolate", 1.5, "25/12/2022");
        user.Product p9 = new user.Product("9", "Pasar", 2.5, "25/12/2022");
        user.Product p10 = new user.Product("10", "tablet", 217, "no expiration date");
        user.User testUser = new user.User("DNS", 23, "jetest@gmail.com", "unpassword");
        user.User richUser = new user.User("ToRich", 55, "imRich@gmail.com", "richNoHack");
        user.User muchContent = new user.User("tooMuch", 45, "tooMuch@gmail.com", "123456");
        user.User someContent = new user.User("someThings", 18, "Some@gmail.com", "idontcare");
        ourRepo.addProduct(testUser, p1);
        ourRepo.addProduct(testUser, p2);
        ourRepo.addProduct(someContent, p3);
        ourRepo.addProduct(someContent, p4);
        ourRepo.addProduct(richUser, p5);
        ourRepo.addProduct(richUser, p6);
        ourRepo.addProduct(richUser, p7);
        ourRepo.addProduct(muchContent, p8);
        ourRepo.addProduct(muchContent, p9);
        ourRepo.addProduct(muchContent, p10);
        ourRepo.removeProduct(muchContent, "9");
        ourRepo.removeProduct(muchContent, "10");
        ourRepo.addProduct(muchContent, p10);
        ourRepo.addProduct(muchContent, p9);
        ourRepo.fetchProductByPrice(someContent, 4);
        ourRepo.fetchProductByPrice(richUser, 40);
        ourRepo.fetchProduct(someContent, "4");
        java.lang.StringBuilder builder = new java.lang.StringBuilder();
        java.util.Scanner sc = new java.util.Scanner(java.lang.System.in);
        builder.append("\n1 : Display every product of our repository");
        builder.append("\n2 : Fetch a product by provided ID");
        builder.append("\n3 : Add a new product to our repository");
        builder.append("\n4 : Delete a product by provided ID");
        builder.append("\n5 : Update a product info");
        builder.append("\n0 : To quit application");
        int cpt = 999;
        while (cpt != 0) {
            java.lang.System.out.println(builder.toString());
            cpt = sc.nextInt();
            switch (cpt) {
                case 1 :
                    java.lang.System.out.println("All product in our repository : \n");
                    java.lang.System.out.println(ourRepo.showAllProduct());
                    break;
                case 2 :
                    java.lang.System.out.println("Give us the ID of the product you need to see");
                    String toFetch = sc.next();
                    ourRepo.fetchProduct(testUser, toFetch);
                    break;
                case 3 :
                    java.lang.System.out.println("For add a new product to our repository we need to know some info about your product");
                    java.lang.System.out.println("ID of your product : \n");
                    String toID = sc.next();
                    java.lang.System.out.println("Price of your product : ");
                    int toPrice = sc.nextInt();
                    java.lang.System.out.println("Name of your product : \n");
                    java.lang.String toName = sc.next();
                    java.lang.System.out.println("Expiration date of your product : ");
                    java.lang.String toDate = sc.next();
                    user.Product toAdd = new user.Product(toID, toName, toPrice, toDate);
                    ourRepo.addProduct(testUser, toAdd);
                    break;
                case 4 :
                    java.lang.System.out.println("For delete a product you need to provide the ID of this product");
                    String toRemove = sc.next();
                    ourRepo.removeProduct(testUser, toRemove);
                    break;
                case 5 :
                    java.lang.System.out.println("For update a product you need to provide the ID of this product");
                    java.lang.System.out.println("ID of your product : \n");
                    String toIDup1 = sc.next();
                    java.lang.System.out.println("Price of your product : ");
                    toPrice = sc.nextInt();
                    java.lang.System.out.println("Name of your product : \n");
                    toName = sc.next();
                    java.lang.System.out.println("Expiration date of your product : ");
                    toDate = sc.next();
                    ourRepo.updateProduct(testUser, toIDup1, toName, toPrice, toDate);
                    break;
                case 0 :
                    java.lang.System.out.println("Thanks for visit, have a good day !");
                    break;
            }
        } 
    }
}