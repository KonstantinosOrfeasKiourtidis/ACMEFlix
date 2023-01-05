package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.Account;
import com.team5.ACMEFlix.domain.CreditCard;
import com.team5.ACMEFlix.repository.AccountRepository;
import com.team5.ACMEFlix.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Transactional(readOnly = true)
    public List<CreditCard> findAllCreditCards() {
        return creditCardRepository.findAll();
    }


    @Transactional(readOnly = true)
    public ResponseEntity<CreditCard> findCreditCardById(Long id) {
        return creditCardRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Transactional(readOnly = true)
    public List<CreditCard> findAllCreditCardsByAccountId(Long id) {
        return creditCardRepository.findCreditCardByAccountId(id);
    }

    @Transactional
    public void addCreditCardByAccountId(CreditCard creditCard, Long id) {
        Optional<Account> accountExists = accountRepository.findById(id);
        if(!accountExists.isPresent()){
            throw new IllegalStateException("Account does not exist");
        }
        else{
            creditCard.setAccount(accountExists.get());
            creditCardRepository.save(creditCard);
        }
    }

    @Transactional
    public void addCreditCardsByAccountId(CreditCard[] creditCards, Long id) {
        Optional<Account> accountExists = accountRepository.findById(id);
        if(!accountExists.isPresent()){
            throw new IllegalStateException("Account does not exist");
        }
        else{
            for(CreditCard creditCard : creditCards) {
                creditCard.setAccount(accountExists.get());
                creditCardRepository.save(creditCard);
            }
        }
    }

    @Transactional
    public void deleteCreditCardById(Long id) {
        boolean exists = creditCardRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Credit card does not exist");
        }
        else{
            creditCardRepository.deleteById(id);
        }
    }

    @Transactional
    public void deleteCreditCardsByIds(Long[] ids) {
        for(Long id : ids) {
            boolean exists = creditCardRepository.existsById(id);
            if (!exists) {
                throw new IllegalStateException("Credit card does not exist");
            } else {
                creditCardRepository.deleteById(id);
            }
        }
    }



    @Transactional
    public void updateCreditCardById(CreditCard creditCard, Long id) {
        CreditCard foundCreditCard = creditCardRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Credit card doesnt not exists"
        ));

        if(creditCard.getCardNo() !=null && creditCard.getCardNo().length() >0 &&
                !Objects.equals(foundCreditCard.getCardNo(), creditCard.getCardNo())){
            foundCreditCard.setCardNo(creditCard.getCardNo());
        }

        if(creditCard.getCardName() !=null && creditCard.getCardName().length() >0 &&
                !Objects.equals(foundCreditCard.getCardName(), creditCard.getCardName())){
            foundCreditCard.setCardName(creditCard.getCardName());
        }

        if(creditCard.getCardCvc() !=null && creditCard.getCardCvc().length() >0 &&
                !Objects.equals(foundCreditCard.getCardCvc(), creditCard.getCardCvc())){
            foundCreditCard.setCardCvc(creditCard.getCardCvc());
        }

        if(creditCard.getCardType() !=null &&
                !Objects.equals(foundCreditCard.getCardType(), creditCard.getCardType())){
            foundCreditCard.setCardType(creditCard.getCardType());
        }
    }


}
