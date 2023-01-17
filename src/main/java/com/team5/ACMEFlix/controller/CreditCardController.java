package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.mapper.CreditCardMapper;
import com.team5.ACMEFlix.service.CreditCardService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.CreditCardResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping(path = "api/v1/account/creditcard")
public class CreditCardController {

    private final CreditCardService creditCardService;
    private final CreditCardMapper creditCardMapper;

    @Autowired
    private CreditCardController(CreditCardService creditCardService, CreditCardMapper creditCardMapper) {
        this.creditCardService = creditCardService;
        this.creditCardMapper = creditCardMapper;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CreditCardResource>>> findAllCreditCards(){
        return new ResponseEntity<>(ApiResponse.<List<CreditCardResource>>builder().data(creditCardMapper.toResources(creditCardService.findAllCreditCards())).build(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<CreditCardResource>> findCreditCardById(@PathVariable("id") Long id){
        return new ResponseEntity<>(ApiResponse.<CreditCardResource>builder().data(creditCardMapper.toResource(creditCardService.findCreditCardById(id).get())).build(), HttpStatus.OK);
    }

    @GetMapping("findAllCreditCardsByAccountId/{id}")
    public ResponseEntity<ApiResponse<List<CreditCardResource>>> findAllCreditCardsByAccountId(@PathVariable("id") Long id){
        return new ResponseEntity<>(ApiResponse.<List<CreditCardResource>>builder().data(creditCardMapper.toResources(creditCardService.findAllCreditCardsByAccountId(id))).build(), HttpStatus.OK);
    }
    @PostMapping(path = "addCreditCardByAccountId/{id}")
    public ResponseEntity<ApiResponse<CreditCardResource>> addCreditCardByAccountId(@PathVariable("id") Long id, @Valid @RequestBody CreditCardResource creditCard){
        return new ResponseEntity<>(ApiResponse.<CreditCardResource>builder().data(creditCardMapper.toResource(creditCardService.addCreditCardByAccountId(id, creditCardMapper.toDomain(creditCard)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addCreditCardsByAccountId/{id}")
    public ResponseEntity<ApiResponse<List<CreditCardResource>>> addCreditCardsByAccountId(@PathVariable("id") Long id, @Valid @RequestBody List<CreditCardResource> creditCards){
        return new ResponseEntity<>(ApiResponse.<List<CreditCardResource>>builder().data(creditCardMapper.toResources(creditCardService.addCreditCardsByAccountId(id, creditCardMapper.toDomains(creditCards)))).build(), HttpStatus.CREATED);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteCreditCardById/{id}")
    public void deleteCreditCardById(@PathVariable("id") Long id){
        creditCardService.deleteCreditCardById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteCreditCardsByIds/{ids}")
    public void deleteCreditCardsByIds(@PathVariable("ids") List<Long> ids){
        creditCardService.deleteCreditCardsByIds(ids);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateCreditCardById/{id}")
    public void updateCreditCardById(
            @PathVariable("id") Long id,
            @Valid @RequestBody CreditCardResource creditCard
    ){
        creditCardService.updateCreditCardById(id, creditCardMapper.toDomain(creditCard));
    }


}
