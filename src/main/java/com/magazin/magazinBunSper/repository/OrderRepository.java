package com.magazin.magazinBunSper.repository;

import com.magazin.magazinBunSper.model.Orderer;
import com.sun.jdi.LongType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Orderer, Long> {
}
