package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.UserModel;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    public abstract ArrayList<UserModel> findByPriority(Integer priority);
}
