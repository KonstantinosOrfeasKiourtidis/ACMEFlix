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

    @GetMapping("findById/{id}")
    public Optional<Account> getAccountById(@PathVariable("id") Long id){
        return accountService.getAccountById(id);
    }

    @GetMapping("findByEmail/{email}")
    public Optional<Account> getAccountByEmail(@PathVariable("email") String email){
        return accountService.getAccountByEmail(email);
    }

    @PostMapping(path = "addAccount")
    public void addAccount(@RequestBody Account account){

        accountService.addAccount(account);
    }

    @PostMapping(path = "addAccounts")
    public void addAccounts(@RequestBody Account... accounts){

        accountService.addAccounts(accounts);
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

    @DeleteMapping(path = "deleteAccounts/{ids}")
    public void deleteAccounts(@PathVariable("ids") Long[] ids){
        accountService.deleteAccounts(ids);
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

    @PutMapping(path = "updateProfile/{id}")
    public void updateProfileByIdPut(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) Boolean ageRestricted,
            @RequestParam(required = false) String imageUrl
    ){
        accountService.updateProfileByIdPut(id, firstname, ageRestricted, imageUrl);
    }

    @PatchMapping(path = "updateProfile/{id}")
    public void updateProfileByIdPatch(
            @RequestBody Profile profile,
            @PathVariable("id") Long id
    ){
        accountService.updateProfileByIdPatch(profile, id);
    }

    @PatchMapping(path = "updateCreditCard/{id}")
    public void updateCreditCardByIdPatch(
            @RequestBody CreditCard creditCard,
            @PathVariable("id") Long id
    ){
        accountService.updateCreditCardByIdPatch(creditCard, id);
    }

    @PatchMapping(path = "updateAddress/{id}")
    public void updateAddressByIdPatch(
            @RequestBody Address address,
            @PathVariable("id") Long id
    ){
        accountService.updateAddressByIdPatch(address, id);
    }

    @PostMapping(path = "login")
    public void login(@RequestBody Account account){
        accountService.login(account);
    }

    @PostMapping(path = "register")
    public void register(@RequestBody Account account){
        accountService.register(account);
    }

    @PatchMapping(path = "subscribe/{id}")
    public void subscribe(@PathVariable Long id,
                          @RequestBody Account account){
        accountService.subscribe(id, account);
    }

}
