import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductController {
    private static final List<Product> productList = new ArrayList<>();
    private static int currentId = 0;

    public static void addProduct(String name, int price) {
        productList.add(new Product(currentId++, name, price));
    }

    public static void showAllProducts() {
        System.out.println("Products:");
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public static void showProductById(int id) {
        System.out.println("\nProduct id " + id + ":");;
        System.out.println(getProductObjectById(id));
    }

    public static void showProductByName(String name) {
        for (Product product : productList) {
            if (product.getName().equals(name)) {
                System.out.println(product);
                return;
            }
        }
        System.out.println("Product not found!");
    }

    public static Product getProductObjectById(int id) {
        if (id < 0 || id >= currentId) return null;
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        System.out.println("Product Not Found!");
        return null;
    }

    public static void removeProductById(int id) {
        Product thisProduct = getProductObjectById(id);
        if (thisProduct == null) return;
        productList.remove(thisProduct);
    }

    public static void sortAscending() {
        System.out.println("Sort ascending by price: ");
        sortProducts(true);
    }

    public static void sortDescending() {
        System.out.println("Sort descending by price: ");
        sortProducts(false);
    }

    private static void sortProducts(boolean isAscending) {
        productList.sort((o1, o2) -> (o1.getPrice() - o2.getPrice()) * (isAscending ? 1 : -1));
        showAllProducts();
    }
}
