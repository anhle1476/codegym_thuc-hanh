public class Human {
    public static final String MALE = "Male";
    public static final String FEMALE = "Female";

    private final String name;
    private final String gender;
    private final String dayOfBirth;

    public Human(String name, String gender, String dayOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }
}
