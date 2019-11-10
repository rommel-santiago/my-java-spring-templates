package com.sebnsab.demo.repository;

import com.sebnsab.demo.model.DetailBiDirectional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailBiDirectionalRepository extends JpaRepository<DetailBiDirectional, Long> {
}
