package com.glo.app.repository;
import com.glo.app.entity.CustomerIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerIdentityRepository extends JpaRepository<CustomerIdentity, Long> {
}
