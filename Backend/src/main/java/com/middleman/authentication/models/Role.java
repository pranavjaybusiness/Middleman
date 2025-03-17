package com.middleman.authentication.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.middleman.authentication.models.ERole;

@Document(collection = "roles")
public class Role {
    @Id
    private String id;

    private ERole role;



    public Role() {
        
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public ERole getRole() {
        return role;
      }
    
      public void setRole(ERole role) {
        this.role = role;
      }


}
