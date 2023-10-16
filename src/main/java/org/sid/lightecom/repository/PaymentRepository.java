package org.sid.lightecom.repository;

import org.sid.lightecom.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
