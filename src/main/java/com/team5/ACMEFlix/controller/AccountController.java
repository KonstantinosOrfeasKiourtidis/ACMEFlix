package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.domain.Account;
import com.team5.ACMEFlix.domain.Address;
import com.team5.ACMEFlix.domain.CreditCard;
import com.team5.ACMEFlix.domain.Profile;
import com.team5.ACMEFlix.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/account")
public class AccountController {


    private final AccountService accountService;

    @Autowired
    private AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("{id}")
    public Optional<Account> getAccountById(@PathVariable("id") Long id){
        return accountService.getAccountById(id);
    }

    @PostMapping(path = "addAccount")
    public void addAccount(@RequestBody Account account){

        accountService.addAccount(account);
    }

    @PutMapping(path = "addProfile/{id}")
    public void addProfileByAccountId(@RequestBody Profile profile, @PathVariable("id") Long id){

        accountService.addProfileByAccountId(profile, id);
    }

    @PutMapping(path = "addCreditCard/{id}")
    public void addCreditByAccountId(@RequestBody CreditCard creditCard, @PathVariable("id") Long id){

        accountService.addCreditByAccountId(creditCard, id);
    }

    @PutMapping(path = "addAddress/{id}")
    public void addAddressByAccountId(@RequestBody Address address, @PathVariable("id") Long id){

        accountService.addAddressByAccountId(address, id);
    }

    @DeleteMapping(path = "deleteAccount/{id}")
    public void deleteAccountById(@PathVariable("id") Long id){
        accountService.deleteAccountById(id);
    }

    @DeleteMapping(path = "deleteProfile/{id}")
    public void deleteProfileById(@PathVariable("id") Long id){
        accountService.deleteProfileById(id);
    }

    @DeleteMapping(path = "deleteCreditCard/{id}")
    public void deleteCreditCardById(@PathVariable("id") Long id){
        accountService.deleteCreditCardById(id);
    }

    @DeleteMapping(path = "deleteAddress/{id}")
    public void deleteAddressById(@PathVariable("id") Long id){
        accountService.deleteAddressById(id);
    }

    @PutMapping(path = "updateAccount/{id}")
    public void updateAccountByIdPut(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String phoneNo,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password
    ){
        accountService.updateAccountByIdPut(id, email, firstname, lastname, phoneNo, username, password);
    }

    @PatchMapping(path = "updateAccount/{id}")
    public void updateAccountByIdPatch(
            @RequestBody Account account,
            @PathVariable("id") Long id
    ){
        accountService.updateAccountByIdPatch(account, id);
    }
}
