package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.domain.Account;
import com.team5.ACMEFlix.helpers.LoginForm;
import com.team5.ACMEFlix.helpers.RegisterForm;
import com.team5.ACMEFlix.helpers.SubscribeForm;
import com.team5.ACMEFlix.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/account")
public class AccountController {


    private final AccountService accountService;

    @Autowired
    private AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<Account>> findAllAccounts(){
        return  new ResponseEntity<>(accountService.findAllAccounts(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Account> findAccountById(@PathVariable("id") Long id){
        return accountService.findAccountById(id);
    }

    @GetMapping("findAccountByEmail/{email}")
    public ResponseEntity<Account> findAccountByEmail(@PathVariable("email") String email){
        return accountService.findAccountByEmail(email);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addAccount")
    public void addAccount(@RequestBody Account account){

        accountService.addAccount(account);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addAccounts")
    public void addAccounts(@RequestBody Account... accounts){

        accountService.addAccounts(accounts);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteAccountById/{id}")
    public void deleteAccountById(@PathVariable("id") Long id){
        accountService.deleteAccountById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteAccountsByIds/{ids}")
    public void deleteAccountsByIds(@PathVariable("ids") Long[] ids){
        accountService.deleteAccountsByIds(ids);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PutMapping(path = "updateAccountById/{id}")
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
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateAccountById/{id}")
    public void updateAccountByIdPatch(
            @RequestBody Account account,
            @PathVariable("id") Long id
    ){
        accountService.updateAccountByIdPatch(account, id);
    }
    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(path = "login")
    public void login(@RequestBody LoginForm loginForm){
        accountService.login(loginForm);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "register")
    public void register(@RequestBody RegisterForm registerForm){
        accountService.register(registerForm);
    }
    @ResponseStatus(code = HttpStatus.OK)
    @PatchMapping(path = "subscribe/{id}")
    public void subscribe(@PathVariable Long id,
                          @RequestBody SubscribeForm subscribeForm){
        accountService.subscribe(id, subscribeForm);
    }







}
