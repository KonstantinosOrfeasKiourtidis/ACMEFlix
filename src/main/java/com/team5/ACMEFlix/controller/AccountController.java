package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.domain.Account;
import com.team5.ACMEFlix.helpers.LoginForm;
import com.team5.ACMEFlix.helpers.RegisterForm;
import com.team5.ACMEFlix.helpers.SubscribeForm;
import com.team5.ACMEFlix.mapper.AccountMapper;
import com.team5.ACMEFlix.service.AccountService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.AccountResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/account")
public class AccountController {


    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @Autowired
    private AccountController(AccountService accountService, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<AccountResource>>> findAllAccounts(){
        return  new ResponseEntity<>(ApiResponse.<List<AccountResource>>builder().data(accountMapper.toResources(accountService.findAllAccounts())).build(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<AccountResource>> findAccountById(@PathVariable("id") Long id){
        return new ResponseEntity<>(ApiResponse.<AccountResource>builder().data(accountMapper.toResource(accountService.findAccountById(id).get())).build(), HttpStatus.OK);
    }

    @GetMapping("findAccountByEmail/{email}")
    public ResponseEntity<ApiResponse<AccountResource>> findAccountByEmail(@PathVariable("email") String email){
        return new ResponseEntity<>(ApiResponse.<AccountResource>builder().data(accountMapper.toResource(accountService.findAccountByEmail(email).get())).build(), HttpStatus.OK);
    }

    @PostMapping(path = "addAccount")
    public ResponseEntity<ApiResponse<AccountResource>> addAccount(@Valid @RequestBody AccountResource account){
        return new ResponseEntity<>(ApiResponse.<AccountResource>builder().data(accountMapper.toResource(accountService.addAccount(accountMapper.toDomain(account)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addAccounts")
    public ResponseEntity<ApiResponse<List<AccountResource>>> addAccounts(@Valid @RequestBody List<AccountResource> accounts){

        return new ResponseEntity<>(ApiResponse.<List<AccountResource>>builder().data(accountMapper.toResources(accountService.addAccounts(accountMapper.toDomains(accounts)))).build(), HttpStatus.CREATED);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteAccountById/{id}")
    public void deleteAccountById(@PathVariable("id") Long id){
        accountService.deleteAccountById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteAccountsByIds/{ids}")
    public void deleteAccountsByIds(@PathVariable("ids") List<Long> ids){
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
            @PathVariable("id") Long id,
            @Valid @RequestBody AccountResource account
    ){
        accountService.updateAccountByIdPatch(id, accountMapper.toDomain(account));
    }

    @PostMapping(path = "login")
    public ResponseEntity<ApiResponse<Account>> login(@Valid @RequestBody LoginForm loginForm){
        return new ResponseEntity<>(ApiResponse.<Account>builder().data( accountService.login(loginForm).get()).build(), HttpStatus.OK);
    }

    @PostMapping(path = "register")
    public ResponseEntity<ApiResponse<Account>> register(@Valid @RequestBody RegisterForm registerForm){
        return new ResponseEntity<>(ApiResponse.<Account>builder().data( accountService.register(registerForm)).build(), HttpStatus.CREATED);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "subscribe/{id}")
    public void subscribe(@PathVariable Long id,
                         @Valid @RequestBody SubscribeForm subscribeForm){
        accountService.subscribe(id, subscribeForm);
    }







}
