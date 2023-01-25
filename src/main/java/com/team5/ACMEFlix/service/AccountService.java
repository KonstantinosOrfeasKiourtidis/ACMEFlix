package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.*;
import com.team5.ACMEFlix.domain.enumeration.CardType;
import com.team5.ACMEFlix.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class AccountService {
    @Autowired
    private  AccountRepository accountRepository;
    @Autowired
    private RatingRepository ratingRepository;


    @Transactional(readOnly = true)
    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Account> findAccountById(Long id) {
        return accountRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Account> findAccountByEmail(String email) {
        Optional<Account> accountExists = accountRepository.findAccountByEmail(email);
        if(!accountExists.isPresent()){
            throw new NoSuchElementException("Account does not exist");
        }
        return accountExists;
    }

    @Transactional
    public Account addAccount(Account account) {
        account.getAddress()
                .forEach(a -> a.setAccount(account));
        account.getCreditCards()
                .forEach(c -> c.setAccount(account));
        account.getProfiles()
                .forEach(p -> p.setAccount(account));
       accountRepository.save(account);
       return account;
    }

    @Transactional
    public List<Account> addAccounts(List<Account> accounts) {
        for(Account account : accounts){
            account.getAddress()
                    .forEach(a -> a.setAccount(account));
            account.getCreditCards()
                    .forEach(c -> c.setAccount(account));
            account.getProfiles()
                    .forEach(p -> p.setAccount(account));
            accountRepository.save(account);
        }
        return accounts;
    }


    @Transactional
    public void deleteAccountById(Long id) {
        boolean exists = accountRepository.existsById(id);
        if(!exists){
            throw new NoSuchElementException("Account does not exist");
        }
        else{

            accountRepository.deleteById(id);
        }
    }

    @Transactional
    public void deleteAccountsByIds(List<Long> ids) {
        for(Long id : ids){
            boolean exists = accountRepository.existsById(id);
            if(!exists){
                throw new NoSuchElementException("Account does not exist");
            }
            else{
                List<Account> accounts = accountRepository.findAllById(ids);

                List<Profile> profiles = new ArrayList<>();
                for (Account account : accounts){
                    profiles.addAll(account.getProfiles());

                }

                for (Profile profile : profiles){
                    ratingRepository.deleteAllByProfileId(profile.getId());

                }

                accountRepository.deleteById(id);
            }
        }
    }


    @Transactional
    public void updateAccountByIdPatch(Long id, Account account) {
        Account foundAccount = accountRepository.findById(id).orElseThrow(() -> new NoSuchElementException(
                "Account doesnt not exists"
        ));

        if(account.getEmail() !=null && account.getEmail().length() >0 &&
                !Objects.equals(foundAccount.getEmail(), account.getEmail())){
            Optional<Account> accountOptional = accountRepository.findAccountByEmail(account.getEmail());
            if(accountOptional.isPresent()){
                throw new IllegalStateException("Email is currently used");
            }
            foundAccount.setEmail(account.getEmail());
        }

        if(account.getFirstname() !=null && account.getFirstname().length() >0 &&
                !Objects.equals(foundAccount.getFirstname(), account.getFirstname())){
            foundAccount.setFirstname(account.getFirstname());
        }

        if(account.getLastname() !=null && account.getLastname().length() >0 &&
                !Objects.equals(foundAccount.getLastname(), account.getLastname())){
            foundAccount.setLastname(account.getLastname());
        }

        if(account.getPhoneNo() !=null && account.getPhoneNo().length() >0 &&
                !Objects.equals(foundAccount.getPhoneNo(), account.getPhoneNo())){
            foundAccount.setPhoneNo(account.getPhoneNo());
        }

        if(account.getUsername() !=null && account.getUsername().length() >0 &&
                !Objects.equals(foundAccount.getUsername(), account.getUsername())){
            foundAccount.setUsername(account.getUsername());
        }

        if(account.getPassword() !=null && account.getPassword().length() >0 &&
                !Objects.equals(foundAccount.getPassword(), account.getPassword())){
            foundAccount.setPassword(account.getPassword());
        }


        if(account.getAddress() !=null &&
                !Objects.equals(foundAccount.getAddress(), account.getAddress())){
            List<Address> addresses = account.getAddress();
            if(!addresses.isEmpty()){
                for (int i = 0; i < addresses.size(); i++) {
                    if (account.getAddress().get(i).getProvince() != null &&
                            account.getAddress().get(i).getProvince().length() >0 &&
                            !Objects.equals(addresses.get(i).getProvince(), account.getAddress().get(i).getProvince())) {
                        addresses.get(i).setProvince(account.getAddress().get(i).getProvince());
                    }

                    if (account.getAddress().get(i).getCountry() != null &&
                            account.getAddress().get(i).getCountry().length() >0 &&
                            !Objects.equals(addresses.get(i).getCountry(), account.getAddress().get(i).getCountry())) {
                        addresses.get(i).setCountry(account.getAddress().get(i).getCountry());
                    }

                    if (account.getAddress().get(i).getPostalCode() != null &&
                            account.getAddress().get(i).getPostalCode().length() >0 &&
                            !Objects.equals(addresses.get(i).getPostalCode(), account.getAddress().get(i).getPostalCode())) {
                        addresses.get(i).setPostalCode(account.getAddress().get(i).getPostalCode());
                    }

                    if (account.getAddress().get(i).getStreetNo() != null &&
                            account.getAddress().get(i).getStreetNo().length() >0 &&
                            !Objects.equals(addresses.get(i).getStreetNo(), account.getAddress().get(i).getStreetNo())) {
                        addresses.get(i).setStreetNo(account.getAddress().get(i).getStreetNo());
                    }

                    if (account.getAddress().get(i).getStreetName() != null &&
                            account.getAddress().get(i).getStreetName().length() >0 &&
                            !Objects.equals(addresses.get(i).getStreetName(), account.getAddress().get(i).getStreetName())) {
                        addresses.get(i).setStreetName(account.getAddress().get(i).getStreetName());
                    }

                }
            }
        }


        if(account.getCreditCards() !=null &&
                !Objects.equals(foundAccount.getCreditCards(), account.getCreditCards())){
            List<CreditCard> creditCards = account.getCreditCards();
            if(!creditCards.isEmpty()){
                for (int i = 0; i < creditCards.size(); i++) {
                    if (account.getCreditCards().get(i).getCardNo() != null &&
                            account.getCreditCards().get(i).getCardNo().length() >0 &&
                            !Objects.equals(creditCards.get(i).getCardNo(), account.getCreditCards().get(i).getCardNo())) {
                        creditCards.get(i).setCardNo(account.getCreditCards().get(i).getCardNo());
                    }

                    if (account.getCreditCards().get(i).getCardCvc() != null &&
                            account.getCreditCards().get(i).getCardCvc().length() >0 &&
                            !Objects.equals(creditCards.get(i).getCardCvc(), account.getCreditCards().get(i).getCardCvc())) {
                        creditCards.get(i).setCardCvc(account.getCreditCards().get(i).getCardCvc());
                    }

                    if (account.getCreditCards().get(i).getCardName() != null &&
                            account.getCreditCards().get(i).getCardName().length() >0 &&
                            !Objects.equals(creditCards.get(i).getCardName(), account.getCreditCards().get(i).getCardName())) {
                        creditCards.get(i).setCardName(account.getCreditCards().get(i).getCardName());
                    }

                    if (account.getCreditCards().get(i).getCardType() != null &&
                          (account.getCreditCards().get(i).getCardType().equals(CardType.MASTERCARD) ||
                                  account.getCreditCards().get(i).getCardType().equals(CardType.VISA) ||
                                          account.getCreditCards().get(i).getCardType().equals(CardType.AMERICAN_EXPRESS) ||
                                  account.getCreditCards().get(i).getCardType().equals(CardType.PAYPAL)) &&
                            !Objects.equals(creditCards.get(i).getCardType(), account.getCreditCards().get(i).getCardType())) {
                        creditCards.get(i).setCardType(account.getCreditCards().get(i).getCardType());
                    }

                }
            }
        }

        if(account.getProfiles() !=null &&
                !Objects.equals(foundAccount.getProfiles(), account.getProfiles())){
            List<Profile> profiles = account.getProfiles();
            if(!profiles.isEmpty()){
                for (int i = 0; i < profiles.size(); i++) {
                    if (account.getProfiles().get(i).getFirstname() != null &&
                            account.getProfiles().get(i).getFirstname().length() >0 &&
                            !Objects.equals(profiles.get(i).getFirstname(), account.getProfiles().get(i).getFirstname())) {
                        profiles.get(i).setFirstname(account.getProfiles().get(i).getFirstname());
                    }

                    if (account.getProfiles().get(i).getImageUrl() != null &&
                            account.getProfiles().get(i).getImageUrl().length() >0 &&
                            !Objects.equals(profiles.get(i).getImageUrl(), account.getProfiles().get(i).getImageUrl())) {
                        profiles.get(i).setImageUrl(account.getProfiles().get(i).getImageUrl());
                    }

                    if (account.getProfiles().get(i).getAgeRestricted() != null &&
                            !Objects.equals(profiles.get(i).getAgeRestricted(), account.getProfiles().get(i).getAgeRestricted())) {
                        profiles.get(i).setAgeRestricted(account.getProfiles().get(i).getAgeRestricted());
                    }

                }
            }
        }

    }

}
