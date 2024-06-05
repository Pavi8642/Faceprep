package shop;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OnlineShoppingSystem {
    private List<Product> products = new ArrayList<>();
    private ShoppingCart cart = new ShoppingCart();
    private Scanner scanner = new Scanner(System.in);
    private Map<String, String> credentials = new HashMap<>();

    private boolean isLoggedIn = false;
    private String currentUser = "";

    public OnlineShoppingSystem() {
        //products
        products.add(new Product(1, "Rice", 100.0));
        products.add(new Product(2, "Oil", 200.0));
        products.add(new Product(3, "Laptop", 30000.0));
        products.add(new Product(4, "Mobile Phone", 15000.0));
        products.add(new Product(5, "General Knowledge Book", 450.0));
        products.add(new Product(6, "Java Programming", 600.0));
        //username and password
        credentials.put("Placement", "Placement456");
        credentials.put("FacePrep", "Faceprep123");
    }

    public void displayProducts() {
        System.out.println("Available Products:");
        for (Product product : products) {
            System.out.println(product.getId() + ". " + product.getName() + " - $" + product.getPrice());
        }
    }

    public void login() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            isLoggedIn = true;
            currentUser = username;
            System.out.println("Welcome, " + username + "! You are now logged in.");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    public void logout() {
        isLoggedIn = false;
        currentUser = "";
        System.out.println("You have been logged out.");
    }

    public void addToCart(int productId) {
        if (!isLoggedIn) {
            System.out.println("Please login first.");
            return;
        }
        Product product = getProductById(productId);
        if (product != null) {
            cart.addItem(product);
            System.out.println(product.getName() + " added to cart.");
        } else {
            System.out.println("Invalid product ID.");
        }
    }

    public void viewCart() {
        System.out.println("Shopping Cart:");
        List<Product> items = cart.getItems();
        for (Product item : items) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total: $" + cart.getTotal());
    }

    public void checkout() {
        System.out.println("Thank you for shopping with us! Your total cost is: $" + cart.getTotal());
        cart = new ShoppingCart(); 
    }

    private Product getProductById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    public void start() {
        while (true) {
            if (!isLoggedIn) {
                System.out.println("Welcome to Online Shopping System!");
                System.out.println("1. Login\n2. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        login();
                        break;
                    case 2:
                        System.out.println("THANK YOU...");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } else {
                System.out.println("\n1. Display Products\n2. Add to Cart\n3. View Cart\n4. Checkout\n5. Logout\n6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        displayProducts();
                        break;
                    case 2:
                        System.out.print("Enter product ID to add to cart: ");
                        int productId = scanner.nextInt();
                        addToCart(productId);
                        break;
                    case 3:
                        viewCart();
                        break;
                    case 4:
                        checkout();
                        break;
                    case 5:
                        logout();
                        break;
                    case 6:
                        System.out.println("THANK YOU...");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
    }

    public static void main(String[] args) {
        OnlineShoppingSystem shoppingSystem = new OnlineShoppingSystem();
        shoppingSystem.start();
    }
}
