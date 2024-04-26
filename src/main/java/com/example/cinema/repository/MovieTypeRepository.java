package com.example.ThucTapLTS.repository;

import com.example.ThucTapLTS.entity.MovieTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieTypeRepository extends JpaRepository<MovieTypeEntity, Integer> {
}
