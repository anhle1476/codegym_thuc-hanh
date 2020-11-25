import java.io.IOException;
import java.util.ArrayList;

public class ProductController {
    private static final String savedProductFile = "products.data";
    private static ArrayList<Product> productList;
    private static int currentId;

    static {
        try {
            Object fileObject = SerializationUtil.deserializeObject(savedProductFile);
            productList = fileObject == null ? new ArrayList<>() : (ArrayList<Product>) fileObject;
            int maxId = -1;
            for (Product product : productList) {
                int currentId = product.getId();
                if (currentId > maxId) maxId = currentId;
            }
            currentId = maxId + 1;
        } catch (IOException | ClassNotFoundException e) {
            productList = new ArrayList<>();
            currentId = 0;
        }
    }

    public static void addProduct(String name, String manufacturer, int price, String description) {
        productList.add(new Product(currentId++, name, manufacturer, price, description));
    }

    public static void showAllProducts() {
        System.out.println("Products:");
        for (Product product : productList) {
            System.out.println(product);
        }
    }

//    public static void showProductById(int id) {
//        System.out.println("\nProduct id " + id + ":");;
//        System.out.println(getProductObjectById(id));
//    }

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

    public static void saveProductListToFile() {
        try {
            SerializationUtil.serializeObject(productList, savedProductFile);
        } catch (IOException e) {
            System.out.println("Error: Save products failed!");
            e.printStackTrace();
        }
    }
}
