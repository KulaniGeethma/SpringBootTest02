package com.example.springboottest02.repo;
import com.example.springboottest02.model.userModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends JpaRepository<userModel, Integer> {
}