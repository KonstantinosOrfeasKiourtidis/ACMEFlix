package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.Account;
import com.team5.ACMEFlix.domain.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

    @Query(value = "SELECT * FROM CREDIT_CARDS WHERE ACCOUNT_ID = ?", nativeQuery = true)
    List<CreditCard> findCreditCardByAccountId(Long id);
}
