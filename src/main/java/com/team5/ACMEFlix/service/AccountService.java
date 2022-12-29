package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.Account;
import com.team5.ACMEFlix.domain.Address;
import com.team5.ACMEFlix.domain.CreditCard;
import com.team5.ACMEFlix.domain.Profile;
import com.team5.ACMEFlix.repository.AccountRepository;
import com.team5.ACMEFlix.repository.AddressRepository;
import com.team5.ACMEFlix.repository.CreditCardRepository;
import com.team5.ACMEFlix.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    //region Read
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }
    //endregion

    //region Create
    public void addAccount(Account account) {
        account.getAddress()
                .forEach(c -> c.setAccount(account));
        account.getCreditCards()
                .forEach(c -> c.setAccount(account));
        account.getProfiles()
                .forEach(p -> p.setAccount(account));
       accountRepository.save(account);
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
    }
    //endregion
}
