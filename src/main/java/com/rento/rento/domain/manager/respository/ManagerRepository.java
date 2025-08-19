package com.rento.rento.domain.manager.respository;

import com.rento.rento.domain.company.entity.Company;
import com.rento.rento.domain.manager.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Optional<Manager> findByLoginId(String managerId);

    boolean existsByCompanyId(Company companyId);

    boolean existsByLoginId(String loginId);

    boolean existsByEmail(String email);

    List<Manager> findAllByCompanyCode(String companyCode);
}
