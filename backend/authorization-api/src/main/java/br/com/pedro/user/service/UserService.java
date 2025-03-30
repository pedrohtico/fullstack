package br.com.pedro.user.service;

import br.com.pedro.user.model.CreateUserRequest;
import br.com.pedro.user.model.entity.UserEntity;
import br.com.pedro.user.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UserService {

    private UserRepository repository;

    @Inject
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void create(CreateUserRequest newUser) {
        UserEntity user = UserEntity.builder()
                                        .username(newUser.getUsername())
                                        .password(newUser.getPassword())
                                        .email(newUser.getEmail())
                                    .build();

        this.repository.createUser(user);
    }

    public UserEntity getUserById(Long id) {
        return this.repository.findById(id);
    }

}
