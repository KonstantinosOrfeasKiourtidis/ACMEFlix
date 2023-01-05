package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.domain.CreditCard;
import com.team5.ACMEFlix.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "api/v1/account/creditcard")
public class CreditCardController {

    private final CreditCardService creditCardService;

    @Autowired
    private CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping
    public ResponseEntity<List<CreditCard>> findAllCreditCards(){
        return new ResponseEntity<>(creditCardService.findAllCreditCards(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CreditCard> findCreditCardById(@PathVariable("id") Long id){
        return creditCardService.findCreditCardById(id);
    }

    @GetMapping("findAllCreditCardsByAccountId/{id}")
    public ResponseEntity<List<CreditCard>> findAllCreditCardsByAccountId(@PathVariable("id") Long id){
        return new ResponseEntity<>(creditCardService.findAllCreditCardsByAccountId(id), HttpStatus.OK);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addCreditCardByAccountId/{id}")
    public void addCreditCardByAccountId(@RequestBody CreditCard creditCard, @PathVariable("id") Long id){

        creditCardService.addCreditCardByAccountId(creditCard, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addCreditCardsByAccountId/{id}")
    public void addCreditCardsByAccountId(@RequestBody CreditCard[] creditCards, @PathVariable("id") Long id){

        creditCardService.addCreditCardsByAccountId(creditCards, id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteCreditCardById/{id}")
    public void deleteCreditCardById(@PathVariable("id") Long id){
        creditCardService.deleteCreditCardById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteCreditCardsByIds/{ids}")
    public void deleteCreditCardsByIds(@PathVariable("ids") Long[] ids){
        creditCardService.deleteCreditCardsByIds(ids);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateCreditCardById/{id}")
    public void updateCreditCardById(
            @RequestBody CreditCard creditCard,
            @PathVariable("id") Long id
    ){
        creditCardService.updateCreditCardById(creditCard, id);
    }


}
