package br.com.pedro.user.repository;

import br.com.pedro.user.model.entity.UserEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserRepository {
    
    public EntityManager em;

    @Inject
    public UserRepository(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public UserEntity createUser(UserEntity user) {
        em.persist(user);

        return user;
    }

    public UserEntity findById(Long id) {
        try {
            return em.find(UserEntity.class, id);
        } catch (NoResultException e) {
            return null;
        }
    }

}
