package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{


    Optional<Account> findAccountByEmail(String email);

}
