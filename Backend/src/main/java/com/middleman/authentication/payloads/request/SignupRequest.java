package com.middleman.authentication.payloads.request;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Set;

public class SignupRequest {
        
        /*
        * Email constraints:
        * Non Empty
        * Must follow standard email format example@domain.com
        * Max Size is 50
        * Must contain only valid Characters (Letters and Numbers) as well as special characters
        * There must be atleast one @
        * Valid Domain Name - After the @ there should be atleast one dot
        * No Spaces within or after the string
        */

        @NotBlank(message = "Email cannot be blank")
        @Size(max = 50, message = "Email can be at most 50 characters long")
        @Email(message = "Invalid email format")
        private String email;


        /*
        * Password Contraints:
        * Not Empty
        * Min Size 8, Max Size 40
        * Atleast one Number
        * Atleast one uppercase character
        * Atleast one lowercase character
        * No Whitespaces
        */
      
        @NotBlank(message = "Password cannot be blank")
        @Size(min = 8, max = 40, message = "password must be within 8 and 40 characters")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]+$",
        message = "Password must contain at least one uppercase letter, one lowercase letter, and one number, with no spaces")
        private String password;

        private Set<String> roles;

        /**
         * If email passed in is valid format, it will set email 
         * @param email inputted email by user
         */
        public void setEmail(String email){
            this.email = email;
        }
        /**
         * 
         * @return email user entered
         */
        public String getEmail(){
            return this.email;
        }
        /**
         * if password passed in is valid format, it will set password
         * @param password inputted password by user
         */
        public void setPassword(String password){
            this.password = password;
        }
        /**
         * 
         * @return password user entered 
         */
        public String getPassword(){
            return this.password;
        }
        public Set<String> getRoles() {
            return this.roles;
          }
        
          public void setRole(Set<String> roles) {
            this.roles = roles;
          }

    
    


     



    
}
