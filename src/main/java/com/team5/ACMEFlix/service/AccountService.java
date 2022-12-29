package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.*;
import com.team5.ACMEFlix.domain.enumeration.SubscriptionType;
import com.team5.ACMEFlix.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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


    //region Read
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public Optional<Account> getAccountByEmail(String email) {
        Optional<Account> accountExists = accountRepository.findAccountByEmail(email);
        if(!accountExists.isPresent()){
            throw new IllegalStateException("Account does not exist");
        }
        return accountExists;
    }
    //endregion

    //region Create
    public void addAccount(Account account) {
        account.getAddress()
                .forEach(a -> a.setAccount(account));
        account.getCreditCards()
                .forEach(c -> c.setAccount(account));
        account.getProfiles()
                .forEach(p -> p.setAccount(account));
       accountRepository.save(account);
    }

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

    public void addProfileByAccountId(Profile profile, Long id) {
        Optional<Account> accountExists = accountRepository.findById(id);
        if(!accountExists.isPresent()){
            throw new IllegalStateException("Account does not exist");
        }
        else{
            profile.setAccount(accountExists.get());
            profileRepository.save(profile);
        }
    }


    public void addCreditByAccountId(CreditCard creditCard, Long id) {
        Optional<Account> accountExists = accountRepository.findById(id);
        if(!accountExists.isPresent()){
            throw new IllegalStateException("Account does not exist");
        }
        else{
            creditCard.setAccount(accountExists.get());
            creditCardRepository.save(creditCard);
        }
    }

    public void addAddressByAccountId(Address address, Long id) {
        Optional<Account> accountExists = accountRepository.findById(id);
        if(!accountExists.isPresent()){
            throw new IllegalStateException("Account does not exist");
        }
        else{
            address.setAccount(accountExists.get());
            addressRepository.save(address);
        }
    }
    //endregion

    //region Delete
    public void deleteAccountById(Long id) {
        boolean exists = accountRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Account does not exist");
        }
        else{
            accountRepository.deleteById(id);
        }
    }

    public void deleteAccounts(Long[] ids) {
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

    public void deleteProfileById(Long id) {
        boolean exists = profileRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Profile does not exist");
        }
        else{
            profileRepository.deleteById(id);
        }
    }

    public void deleteCreditCardById(Long id) {
        boolean exists = creditCardRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Credit card does not exist");
        }
        else{
            creditCardRepository.deleteById(id);
        }
    }

    public void deleteAddressById(Long id) {
        boolean exists = addressRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Address does not exist");
        }
        else{
            addressRepository.deleteById(id);
        }
    }
    //endregion

    //region Update
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
                for(Address address : addresses) {
                    addressRepository.deleteById(address.getId());
                }
            }

            List<Address> newAddresses = account.getAddress();
            for(Address address : newAddresses) {

                address.setAccount(foundAccount);
               addressRepository.save(address);
            }

        }

        if(account.getCreditCards() !=null &&
                !Objects.equals(foundAccount.getCreditCards(), account.getCreditCards())){
            List<CreditCard> creditCards = creditCardRepository.findCreditCardByAccountId(id);
            if(!creditCards.isEmpty()){

                for(CreditCard creditCard : creditCards) {
                    creditCardRepository.deleteById(creditCard.getId());
                }
            }

            List<CreditCard> newCreditCards = account.getCreditCards();
            for(CreditCard creditCard : newCreditCards) {

                creditCard.setAccount(foundAccount);
                creditCardRepository.save(creditCard);
            }


        }

        if(account.getProfiles() !=null &&
                !Objects.equals(foundAccount.getProfiles(), account.getProfiles())){
            List<Profile> profiles = profileRepository.findProfileByByAccountId(id);
            if(!profiles.isEmpty()){

                for(Profile profile : profiles) {
                    profileRepository.deleteById(profile.getId());
                }
            }

            List<Profile> newProfiles = account.getProfiles();
            for(Profile profile : newProfiles) {
                profile.setAccount(foundAccount);
                profileRepository.save(profile);
            }


        }


    }

    @Transactional
    public void updateProfileByIdPut(Long id, String firstname, Boolean ageRestricted, String imageUrl) {
        Profile profile = profileRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Profile doesnt not exists"
        ));


        if(firstname !=null && firstname.length() >0 &&
                !Objects.equals(profile.getFirstname(), firstname)){
            profile.setFirstname(firstname);
        }

        if(ageRestricted !=null &&
                !Objects.equals(profile.getAgeRestricted(), ageRestricted)){
            profile.setAgeRestricted(ageRestricted);
        }

        if(imageUrl !=null && imageUrl.length() >0 &&
                !Objects.equals(profile.getImageUrl(), imageUrl)){
            profile.setImageUrl(imageUrl);
        }

    }
    @Transactional
    public void updateProfileByIdPatch(Profile profile, Long id) {
        Profile foundProfile = profileRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Profile doesnt not exists"
        ));


        if(profile.getFirstname() !=null && profile.getFirstname().length() >0 &&
                !Objects.equals(foundProfile.getFirstname(), profile.getFirstname())){
            foundProfile.setFirstname(profile.getFirstname());
        }

        if(profile.getAgeRestricted() !=null &&
                !Objects.equals(foundProfile.getAgeRestricted(), profile.getAgeRestricted())){
            foundProfile.setAgeRestricted(profile.getAgeRestricted());
        }

        if(profile.getImageUrl() !=null && profile.getImageUrl().length() >0 &&
                !Objects.equals(foundProfile.getImageUrl(), profile.getImageUrl())){
            foundProfile.setImageUrl(profile.getImageUrl());
        }
    }

    @Transactional
    public void updateCreditCardByIdPatch(CreditCard creditCard, Long id) {
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

    @Transactional
    public void updateAddressByIdPatch(Address address, Long id) {
        Address foundAddress = addressRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Address doesnt not exists"
        ));

        if(address.getStreetName() !=null && address.getStreetName().length() >0 &&
                !Objects.equals(foundAddress.getStreetName(), address.getStreetName())){
            foundAddress.setStreetName(address.getStreetName());
        }

        if(address.getStreetNo() !=null && address.getStreetNo().length() >0 &&
                !Objects.equals(foundAddress.getStreetNo(), address.getStreetNo())){
            foundAddress.setStreetNo(address.getStreetNo());
        }

        if(address.getPostalCode() !=null && address.getPostalCode().length() >0 &&
                !Objects.equals(foundAddress.getPostalCode(), address.getPostalCode())){
            foundAddress.setPostalCode(address.getPostalCode());
        }

        if(address.getCountry() !=null && address.getCountry().length() >0 &&
                !Objects.equals(foundAddress.getCountry(), address.getCountry())){
            foundAddress.setCountry(address.getCountry());
        }

        if(address.getProvince() !=null && address.getProvince().length() >0 &&
                !Objects.equals(foundAddress.getProvince(), address.getProvince())){
            foundAddress.setProvince(address.getProvince());
        }


    }

    public void login(Account account) {

        Optional<Account> accountExists = accountRepository.findAccountByEmail(account.getEmail());
        if(!accountExists.isPresent()){
            throw new IllegalStateException("The email or the password are incorrect");
        }

        if(!accountExists.get().getPassword().equals(account.getPassword())){
            throw new IllegalStateException("The email or the password are incorrect");
        }
    }

    public void register(Account account) {
        Optional<Account> accountExists = accountRepository.findAccountByEmail(account.getEmail());
        if(accountExists.isPresent()){
            throw new IllegalStateException("The email is in use");
        }

        account.getAddress()
                .forEach(a -> a.setAccount(account));
        account.getCreditCards()
                .forEach(c -> c.setAccount(account));

        Account emptyAccount = account;
        emptyAccount.setProfiles(Collections.emptyList()) ;

        emptyAccount.getProfiles().
                forEach(p -> p.setAccount(emptyAccount));


        //account.setCreationDate();
        //account.setSubscriptionDate(null);
        account.setSubscriptionType(SubscriptionType.NO_SUBSCRIPTION);
        accountRepository.save(account);
    }


    @Transactional
    public void subscribe(Long id, Account account) {
        Account foundAccount = accountRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Account doesnt not exists"
        ));

        if(foundAccount.getCreditCards()==null || foundAccount.getCreditCards().isEmpty()){
            throw new IllegalStateException("The account does not have any valid credit cards");
        }

        if(foundAccount.getAddress()==null || foundAccount.getAddress().isEmpty()){
            throw new IllegalStateException("The account does not have any valid billing addresses");
        }

        if(!account.getSubscriptionType().equals(SubscriptionType.NO_SUBSCRIPTION) &&
                !account.getSubscriptionType().equals(SubscriptionType.BASIC) &&
                !account.getSubscriptionType().equals(SubscriptionType.STANDARD)&&
                !account.getSubscriptionType().equals(SubscriptionType.PREMIUM)
        ){
            throw new IllegalStateException("Not a valid plan");
        }

        foundAccount.setSubscriptionType(account.getSubscriptionType());

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
        payment.setAmount(account.getSubscriptionType().getPrice());
        payment.setSubscriptionType(account.getSubscriptionType());
        payment.setAccount(foundAccount);
        payment.setCreditCard(foundAccount.getCreditCards().get(0));
        payment.setAddress(foundAccount.getAddress().get(0));

        paymentRepository.save(payment);
    }

    //endregion
}
