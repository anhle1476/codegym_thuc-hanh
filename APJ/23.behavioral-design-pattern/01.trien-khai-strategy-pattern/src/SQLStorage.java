public class SQLStorage implements UserStorage {
    @Override
    public void store(User user) {
        System.out.println("Save " + user.getName() + " to SQL storage");
    }
}
