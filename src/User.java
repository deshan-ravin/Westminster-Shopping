public class User {                                  // declaring instance variables of User class
    private String userName;
    protected String password;
                                                    //setting the default constructor
    public User() {}
                                                   //setting the overloaded constructor
    public User(String userName,String password){
        this.userName=userName;
        this.password=password;}
                                                   //getters and setters for the class instances

    public String getUserName() {return userName;}
    public String getPassword() {return password;}

    public void setUserName(String userName) {this.userName = userName;}
    public void setPassword(String password) {this.password = password;}

    @Override
    public String toString() {                                  //toString method to print the data
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';}
}
