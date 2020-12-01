public class UserController {
    UserStorage storage;

    public UserController(UserStorage storage) {
        this.storage = storage;
    }

    public void setStorage(UserStorage storage) {
        this.storage = storage;
    }

    public void storeUser(User user) {
        storage.store(user);
    }
}
