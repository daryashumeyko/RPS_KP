package WeddingAgency.Models;

public class User {
    private int userId;
    private String name;
    private String surname;
    private String age;
    private String telephone;
    private String weddingWishes;
    private String category;
    private String description;
    private int typeOfUser;
    private String login;
    private String password;
    private String email;
    private float rating;

    public User(){
    }

    public User(int id, String name, String surname, String age,
                String telephone, String weddingWishes, String category,
                String description, int typeOfUser, String login, String password,
                String email, float rating){
        userId = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.telephone = telephone;
        this.weddingWishes = weddingWishes;
        this.category = category;
        this.description = description;
        this.typeOfUser = typeOfUser;
        this.login = login;
        this.password = password;
        this.email = email;
        this.rating = rating;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String gettelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWeddingWishes() {
        return weddingWishes;
    }

    public void setWeddingWishes(String weddingWishes) {
        this.weddingWishes = weddingWishes;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(int typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}