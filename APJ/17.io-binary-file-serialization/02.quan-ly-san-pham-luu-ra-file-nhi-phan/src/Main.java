public class Main {
    private static boolean isRunning = true;

    public static void main(String[] args) {
        String mainMessage = "1. Add product\n" +
                "2. Change product details\n" +
                "3. Remove product\n" +
                "4. Show product list\n" +
                "5. Search products\n" +
                "6. Sort\n" +
                "0. Exit";
        while (isRunning) {
            int option = CLIScanner.getInteger(mainMessage, 6);
            handleMainMenuOption(option);
        }
        ProductController.saveProductListToFile();
    }

    private static void handleMainMenuOption(int option) {
        switch (option) {
            case 1 -> handleAddProduct();
            case 2 -> handleChangeProductDetails();
            case 3 -> handleRemoveProduct();
            case 4 -> ProductController.showAllProducts();
            case 5 -> handleShowProductByName();
            case 6 -> handleSort();
            case 0 -> isRunning = false;
        }
    }

    private static void handleSort() {
        int sortOptions = CLIScanner.getInteger("1. Ascending\n2. Descending\n0.Return", 2);
        if (sortOptions == 1) {
            ProductController.sortAscending();
        } else if (sortOptions == 2) {
            ProductController.sortDescending();
        }
    }

    private static void handleShowProductByName() {
        String name = CLIScanner.getString("Enter product name:");
        ProductController.showProductByName(name);
    }

    private static void handleRemoveProduct() {
        ProductController.removeProductById(getProductId());
    }

    private static void handleChangeProductDetails() {
        Product thisProduct = ProductController.getProductObjectById(getProductId());
        if (thisProduct == null) {
            System.out.println("Product not found!");
        } else {
            changeProductDetails(thisProduct);
        }
    }

    private static int getProductId() {
        return CLIScanner.getInteger("Enter product id", Integer.MAX_VALUE);
    }

    private static void changeProductDetails(Product thisProduct) {
        String newName = CLIScanner.getString("New name (blank for default):");
        int newPrice = CLIScanner.getInteger("New price (0 for default):", Integer.MAX_VALUE);
        String newManufacturer = CLIScanner.getString("New manufacturer (blank for default):");
        String newDescription = CLIScanner.getString("New description (blank for default):");

        if (isNotBlankString(newName)) thisProduct.setName(newName);
        if (newPrice != 0) thisProduct.setPrice(newPrice);
        if (isNotBlankString(newManufacturer)) thisProduct.setManufacturer(newName);
        if (isNotBlankString(newDescription)) thisProduct.setDescription(newName);
    }

    private static void handleAddProduct() {
        String name = CLIScanner.getString("Product name: ");
        int price = CLIScanner.getInteger("Price: ", Integer.MAX_VALUE);
        String manufacturer = CLIScanner.getString("Manufacturer: ");
        String description = CLIScanner.getString("Description: ");

        ProductController.addProduct(name, manufacturer, price, description);
    }

    private static boolean isNotBlankString(String string) {
        return !string.equals("");
    }
}
