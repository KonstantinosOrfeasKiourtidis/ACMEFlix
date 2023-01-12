package com.team5.ACMEFlix.repository;

import com.team5.ACMEFlix.domain.Account;
import com.team5.ACMEFlix.domain.Address;
import com.team5.ACMEFlix.domain.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAddressesByAccountId(Long id);
}
