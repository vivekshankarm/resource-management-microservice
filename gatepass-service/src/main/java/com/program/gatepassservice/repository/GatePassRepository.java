package com.program.gatepassservice.repository;

import com.program.gatepassservice.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GatePassRepository extends JpaRepository<CustomerDetails,Long> {

}
