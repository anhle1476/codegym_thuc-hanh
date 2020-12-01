public class XMLStorage implements UserStorage {
    @Override
    public void store(User user) {
        System.out.println("Save " + user.getName() + " to XML storage");
    }
}
