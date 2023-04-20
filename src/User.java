public class User {
    private String username;
    private String password;
    private Integer practice;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.practice = 0;
    }

    // Getters e Setters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getPractice(){return practice; }

}
