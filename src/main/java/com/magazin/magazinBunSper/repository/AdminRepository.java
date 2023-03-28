package com.magazin.magazinBunSper.repository;

import com.magazin.magazinBunSper.model.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin,Integer> {
}
