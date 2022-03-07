package com.revature.repository;
import com.revature.model.chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface chefRepository extends JpaRepository<chef, Integer> {
    @Query("FROM chef")
    chef save(chef chef);

    @Query("FROM chef")
    List<chef> findAll();

    @Query("FROM chef")
    chef findByName(String name);

    @Query("FROM chef")
    List<chef> findAllBySpecialty(String specialty);

    @Query("FROM chef")
    List<chef> findAllByTag(String tag);

    @Query("FROM chef")
    chef deleteBy(chef chef);
}