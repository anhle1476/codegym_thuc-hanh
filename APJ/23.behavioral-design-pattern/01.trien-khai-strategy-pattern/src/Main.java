public class Main {
    public static void main(String[] args) {
        User a = new User("A");
        User b = new User("B");
        User c = new User("C");

        XMLStorage xmlStorage = new XMLStorage();
        SQLStorage sqlStorage = new SQLStorage();
        UserController controller = new UserController(xmlStorage);
        controller.storeUser(a);

        controller.setStorage(sqlStorage);
        controller.storeUser(b);

        controller.setStorage(xmlStorage);
        controller.storeUser(c);
    }
}
