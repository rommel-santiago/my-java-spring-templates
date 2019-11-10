package com.sebnsab.demo.repository;

import com.sebnsab.demo.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {


    @Query("select t from Transaction t " +
           "left join fetch t.detailBiDirectionals db " +
           "left join fetch t.detailUniDirectionals du " +
           "where t.id = :id")
    public Transaction getById(@Param("id") Long id);


}
