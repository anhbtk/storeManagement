package com.store.Store.repository;

import com.store.Store.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MysqlRepository extends JpaRepository<Address, Integer>
{

}
