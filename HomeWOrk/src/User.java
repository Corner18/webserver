import java.util.ArrayList;

public class User {

    public User(String id, String name, String surname, String city){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.city = city;
    }


    private String id;
    private String name;
    private String surname;
    private String city;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private static User mInstance;
    private ArrayList<User> users = null;

    private ArrayList<String> messages = null;

    public static User getInstance() {
        if(mInstance == null)
            mInstance = new User();

        return mInstance;
    }

    private User() {
        users = new ArrayList<User>();
        users.add(new User("1", "Anastasia", "Egorova", "Kazan"));
        users.add(new User("2", "Aliya", "Mukhutdinova", "Almet"));
        users.add(new User("3", "Salavat", "Nizamov", "Kazan"));
        users.add(new User("4", "Emil", "Mubarakov", "Kazan"));
        users.add(new User("5", "Kamila", "Bulanova", "Magnitogorsk"));


    }

    public ArrayList<User> getArrayUsers() {
        return this.users;
    }





}

