import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String mainMessage = "1. Thêm sản phẩm\n" +
                "2. Sửa thông tin sản phẩm theo id\n" +
                "3. Xoá sản phẩm theo id\n" +
                "4. Hiển thị danh sách sản phẩm\n" +
                "5. Tìm kiếm sản phẩm theo tên\n" +
                "6. Sắp xếp sản phẩm\n" +
                "0. Thoát";
        while (true) {
            int option = getInteger(mainMessage, 6);
            switch (option) {
                case 0:
                    return;
                case 1:
                    handleAddProduct();
                    break;
                case 2:
                    handleChangeProductDetails();
                    break;
                case 3:
                    handleRemoveProduct();
                    break;
                case 4:
                    ProductController.showAllProducts();
                    break;
                case 5:
                    handleShowProductByName();
                    break;
                case 6:
                    handleSort();
                    break;
            }
        }
    }

    private static void handleSort() {
        int sortOptions = getInteger("1. Theo thứ tự tăng dần\n2. Theo thứ tự giảm dần\n0.Trở về", 2);
        if (sortOptions == 1) {
            ProductController.sortAscending();
        } else if (sortOptions == 2) {
            ProductController.sortDescending();
        }
    }

    private static void handleShowProductByName() {
        String name = getString("Enter product name:");
        ProductController.showProductByName(name);
    }

    private static void handleRemoveProduct() {
        int id = getInteger("Enter product id", Integer.MAX_VALUE);
        ProductController.removeProductById(id);
    }

    private static void handleChangeProductDetails() {
        int id = getInteger("Enter product id", Integer.MAX_VALUE);
        Product thisProduct = ProductController.getProductObjectById(id);
        if (thisProduct == null) {
            System.out.println("Product not found!");
            return;
        }
        thisProduct.setName(getString("New name:"));
        thisProduct.setPrice(getInteger("New price:", Integer.MAX_VALUE));
    }

    private static void handleAddProduct() {
        String name = getString("Enter product name:");
        int price = getInteger("Enter price:", Integer.MAX_VALUE);
        ProductController.addProduct(name, price);
    }

    public static int getInteger(String message, int limit) {
        int option;
        do {
            System.out.println(message);
            option = Integer.parseInt(scanner.nextLine());
        } while (option < 0 || option > limit);
        return option;
    }

    public static String getString(String message) {
        System.out.println(message);
        String str;
        do {
            str = scanner.nextLine().trim();
        } while (str.length() == 0);
        return str;
    }
}
