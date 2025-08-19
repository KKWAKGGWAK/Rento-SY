package com.rento.rento.domain.manager.service;

import com.rento.rento.common.exception.DomainException;
import com.rento.rento.common.exception.ErrorType;
import com.rento.rento.domain.manager.dto.details.CustomManagerDetails;
import com.rento.rento.domain.manager.entity.Manager;
import com.rento.rento.domain.manager.respository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomMangerDetailsService implements UserDetailsService {

    private final ManagerRepository managerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Manager manager = managerRepository.findByLoginId(username)
                .orElseThrow(() -> new DomainException(ErrorType.MANAGER_NOT_FOUND));

        if (manager != null) {
            return new CustomManagerDetails(manager);
        }

        return null;
    }
}
