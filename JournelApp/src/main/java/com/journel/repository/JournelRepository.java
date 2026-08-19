package com.journel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.journel.entity.Journel;

@Repository
public interface JournelRepository extends JpaRepository<Journel, Integer> {

}
