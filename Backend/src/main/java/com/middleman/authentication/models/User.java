package com.middleman.authentication.models;
import jakarta.validation.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Set;
import java.util.HashSet;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    
    @DBRef
    private Set<Role> roles = new HashSet<>();   

    //already validated the email and password when signing up
    private String email;
    private String password;

    public User(){

    }

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }


    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
    public String getEmail() {
        return email;
      }
    
      public void setEmail(String email) {
        this.email = email;
      }
    
      public String getPassword() {
        return password;
      }
    
      public void setPassword(String password) {
        this.password = password;
      }
    
      public Set<Role> getRoles() {
        return roles;
      }
    
      public void setRoles(Set<Role> roles) {
        this.roles = roles;
      }

}
