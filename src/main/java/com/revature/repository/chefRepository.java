package com.revature.repository;
import com.revature.model.chef;
import com.revature.model.recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface chefRepository extends JpaRepository<chef, Integer> {
    chef save(chef chef);

    @Query("FROM chef")
    List<chef> findAll();

    @Query("FROM chef WHERE chefName = ?1")
    chef findByName(String name);

    @Query("FROM chef WHERE specialty = ?1")
    List<chef> findAllBySpecialty(String specialty);

    @Query("FROM chef WHERE tag = ?1")
    List<chef> findAllByTag(String tag);

    @Query("FROM chef WHERE id = ?1")
    chef findById(int Id);

    @Query
    void deleteById(int id);
}