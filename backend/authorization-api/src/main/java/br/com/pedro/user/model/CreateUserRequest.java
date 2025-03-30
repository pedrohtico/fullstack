package br.com.pedro.user.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class CreateUserRequest {

    @NonNull
    private String username;
    
    @NonNull
    private String password;
    
    @NonNull
    private String email;

}
