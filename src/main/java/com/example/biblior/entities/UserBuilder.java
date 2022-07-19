package com.example.biblior.entities;

public class UserBuilder {
    private UserType userType;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userPassword;

    private void setUserType(UserType type) {
        this.userType = type;
    }

    private void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    private void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    private void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    private void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public UserBuilder type(UserType type){
        setUserType(type);
        return this;
    }
    public UserBuilder firstName(String firstName){
        setUserFirstName(firstName);
        return this;
    }
    public UserBuilder lastName(String lastName){
        setUserLastName(lastName);
        return this;
    }
    public UserBuilder email(String email){
        setUserEmail(email);
        return this;
    }
    public UserBuilder password(String password){
        setUserPassword(password);
        return this;
    }
    public User build(){
        if(check()){
            if(this.userType==UserType.Admin){
                return new Admin(this.userFirstName, this.userLastName, this.userEmail, this.userPassword);
            }else if(this.userType==UserType.Librarian){
                return new Librarian(this.userFirstName, this.userLastName, this.userEmail, this.userPassword);
            }else if(this.userType==UserType.WarehouseWorker){
                return new WarehouseWorker(this.userFirstName, this.userLastName, this.userEmail, this.userPassword);
            }else if(this.userType==UserType.Reader){
                return new Reader(this.userFirstName, this.userLastName, this.userEmail, this.userPassword);
            }else{
                throw new IllegalArgumentException("Select the right user type.");
            }
        }else{
            throw new IllegalArgumentException("First name, last name, email and password cannot be null.");
        }
    }
    private boolean check(){
        return this.userFirstName != null && this.userLastName != null && this.userEmail != null && this.userPassword != null;
    }
}
