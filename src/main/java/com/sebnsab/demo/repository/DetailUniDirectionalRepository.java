package com.sebnsab.demo.repository;

import com.sebnsab.demo.model.DetailUniDirectional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailUniDirectionalRepository extends JpaRepository<DetailUniDirectional, Long> {
}
