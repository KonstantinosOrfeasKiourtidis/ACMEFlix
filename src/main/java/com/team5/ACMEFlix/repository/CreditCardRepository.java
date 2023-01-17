package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    List<CreditCard> findCreditCardsByAccount_Id(Long id);
}
