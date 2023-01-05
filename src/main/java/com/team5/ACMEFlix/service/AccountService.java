package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.*;
import com.team5.ACMEFlix.domain.enumeration.CardType;
import com.team5.ACMEFlix.domain.enumeration.SubscriptionType;
import com.team5.ACMEFlix.helpers.LoginForm;
import com.team5.ACMEFlix.helpers.RegisterForm;
import com.team5.ACMEFlix.helpers.SubscribeForm;
import com.team5.ACMEFlix.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class AccountService {
    @Autowired
    private  AccountRepository accountRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PaymentRepository paymentRepository;


    @Transactional(readOnly = true)
    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Account> findAccountById(Long id) {
        return accountRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Account> findAccountByEmail(String email) {
        Optional<Account> accountExists = accountRepository.findAccountByEmail(email);
        if(!accountExists.isPresent()){
            throw new IllegalStateException("Account does not exist");
        }
        return accountExists.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Transactional
    public void addAccount(Account account) {
        account.getAddress()
                .forEach(a -> a.setAccount(account));
        account.getCreditCards()
                .forEach(c -> c.setAccount(account));
        account.getProfiles()
                .forEach(p -> p.setAccount(account));
       accountRepository.save(account);
    }

    @Transactional
    public void addAccounts(Account... accounts) {
        for(Account account : accounts){
            account.getAddress()
                    .forEach(a -> a.setAccount(account));
            account.getCreditCards()
                    .forEach(c -> c.setAccount(account));
            account.getProfiles()
                    .forEach(p -> p.setAccount(account));
            accountRepository.save(account);
        }
    }


    @Transactional
    public void deleteAccountById(Long id) {
        boolean exists = accountRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Account does not exist");
        }
        else{
            accountRepository.deleteById(id);
        }
    }

    @Transactional
    public void deleteAccountsByIds(Long[] ids) {
        for(Long id : ids){
            boolean exists = accountRepository.existsById(id);
            if(!exists){
                throw new IllegalStateException("Account does not exist");
            }
            else{
                accountRepository.deleteById(id);
            }
        }
    }

    @Transactional
    public void updateAccountByIdPut(Long id, String email, String firstname, String lastname, String phoneNo, String username, String password) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Account doesnt not exists"
        ));


        if(email !=null && email.length() >0 &&
            !Objects.equals(account.getEmail(), email)){
            Optional<Account> accountOptional = accountRepository.findAccountByEmail(email);
            if(accountOptional.isPresent()){
                throw new IllegalStateException("Email is currently used");
            }
            account.setEmail(email);
        }

        if(firstname !=null && firstname.length() >0 &&
                !Objects.equals(account.getFirstname(), firstname)){
            account.setFirstname(firstname);
        }

        if(lastname !=null && lastname.length() >0 &&
                !Objects.equals(account.getLastname(), lastname)){
            account.setLastname(lastname);
        }

        if(phoneNo !=null && phoneNo.length() >0 &&
                !Objects.equals(account.getPhoneNo(), phoneNo)){
            account.setPhoneNo(phoneNo);
        }

        if(username !=null && username.length() >0 &&
                !Objects.equals(account.getUsername(), username)){
            account.setUsername(username);
        }

        if(password !=null && password.length() >0 &&
                !Objects.equals(account.getPassword(), password)){
            account.setPassword(password);
        }

    }

    @Transactional
    public void updateAccountByIdPatch(Account account, Long id) {
        Account foundAccount = accountRepository.findById(id).orElseThrow(() -> new IllegalStateException(
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
            List<Address> addresses = addressRepository.findAddressesByAccountId(id);
            if(!addresses.isEmpty()){
                for (int i = 0; i < addresses.size()-1; i++) {
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
            List<CreditCard> creditCards = creditCardRepository.findCreditCardByAccountId(id);
            if(!creditCards.isEmpty()){
                for (int i = 0; i < creditCards.size()-1; i++) {
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
            List<Profile> profiles = profileRepository.findProfileByByAccountId(id);
            if(!profiles.isEmpty()){
                for (int i = 0; i < profiles.size()-1; i++) {
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

    @Transactional
    public void login(LoginForm loginForm) {

        Optional<Account> accountExists = accountRepository.findAccountByEmail(loginForm.getEmail());
        if(!accountExists.isPresent()){
            throw new IllegalStateException("The email or the password are incorrect");
        }

        if(!accountExists.get().getPassword().equals(loginForm.getPassword())){
            throw new IllegalStateException("The email or the password are incorrect");
        }


    }
    @Transactional
    public void register(RegisterForm registerForm) {
        if(!(registerForm.getEmail()!=null || registerForm.getEmail().length() > 0)){
            throw new IllegalStateException("Email is a required field");
        }

        if(!(registerForm.getFirstname()!=null || registerForm.getFirstname().length() > 0)){
            throw new IllegalStateException("First name is a required field");
        }
        if(!(registerForm.getLastname()!=null || registerForm.getLastname().length() > 0)){
            throw new IllegalStateException("Last name is a required field");
        }
        if(!(registerForm.getUsername()!=null || registerForm.getUsername().length() > 0)){
            throw new IllegalStateException("Username is a required field");
        }
        if(!(registerForm.getPassword()!=null || registerForm.getPassword().length() > 0)){
            throw new IllegalStateException("Password is a required field");
        }

        if(!(registerForm.getConfirmPassword()!=null || registerForm.getConfirmPassword().length() > 0)){
            throw new IllegalStateException("Repeat password is a required field");
        }

        if(!(registerForm.getPhoneNo()!=null || registerForm.getPhoneNo().length() > 0)){
            throw new IllegalStateException("Phone number is a required field");
        }


        Optional<Account> accountExists = accountRepository.findAccountByEmail(registerForm.getEmail());
        if(accountExists.isPresent()){
            throw new IllegalStateException("The email is in use");
        }

        if(!registerForm.getPassword().equals(registerForm.getConfirmPassword())){
            throw new IllegalStateException("The passwords are not the same");
        }

        Account account = new Account();




        account.setEmail(registerForm.getEmail());
        account.setUsername(registerForm.getUsername());
        account.setFirstname(registerForm.getFirstname());
        account.setLastname(registerForm.getLastname());
        account.setLastname(registerForm.getLastname());
        account.setPhoneNo(registerForm.getPhoneNo());

        account.setPassword(registerForm.getPassword());
        //account.setPassword(passwordEncoder.encode(registerForm.getPassword()));


        account.setAddress(registerForm.getAddress());
        account.setCreditCards(registerForm.getCreditCards());

        //account.setCreationDate();

        registerForm.getAddress()
                .forEach(a -> a.setAccount(account));

        registerForm.getCreditCards()
                .forEach(c -> c.setAccount(account));

        Account emptyAccount = account;
        emptyAccount.setProfiles(Collections.emptyList()) ;

        emptyAccount.getProfiles().
                forEach(p -> p.setAccount(emptyAccount));

        account.setSubscriptionType(SubscriptionType.NO_SUBSCRIPTION);
        accountRepository.save(account);
    }


    @Transactional
    public void subscribe(Long id, SubscribeForm subscribeForm) {
        Account foundAccount = accountRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Account doesnt not exists"
        ));

        if(foundAccount.getCreditCards()==null || foundAccount.getCreditCards().isEmpty()){
            throw new IllegalStateException("The account does not have any valid credit cards");
        }

        if(foundAccount.getAddress()==null || foundAccount.getAddress().isEmpty()){
            throw new IllegalStateException("The account does not have any valid billing addresses");
        }

        if(!subscribeForm.getSubscriptionType().equals(SubscriptionType.NO_SUBSCRIPTION) &&
                !subscribeForm.getSubscriptionType().equals(SubscriptionType.BASIC) &&
                !subscribeForm.getSubscriptionType().equals(SubscriptionType.STANDARD)&&
                !subscribeForm.getSubscriptionType().equals(SubscriptionType.PREMIUM)
        ){
            throw new IllegalStateException("Not a valid plan");
        }

        foundAccount.setSubscriptionType(subscribeForm.getSubscriptionType());

        if(!foundAccount.getProfiles().isEmpty()){

        }
        else{
                Profile profile = new Profile();
                profile.setFirstname(foundAccount.getFirstname());
                profile.setAgeRestricted(false);
                profile.setAccount(foundAccount);

                Profile profileKids = new Profile();
                profileKids.setFirstname("KIDS");
                profileKids.setAccount(foundAccount);
                profileKids.setAgeRestricted(true);
                profileKids.setAccount(foundAccount);
                profileRepository.save(profile);
                profileRepository.save(profile);

        }

        Payment payment = new Payment();
        payment.setAmount(subscribeForm.getSubscriptionType().getPrice());
        payment.setSubscriptionType(subscribeForm.getSubscriptionType());
        payment.setAccount(foundAccount);
        payment.setCreditCard(foundAccount.getCreditCards().get(0));
        payment.setAddress(foundAccount.getAddress().get(0));

        paymentRepository.save(payment);
    }

}
