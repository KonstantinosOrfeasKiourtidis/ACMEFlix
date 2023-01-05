package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/account/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    private AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<List<Address>> findAllAddresses(){
        return new ResponseEntity<>(addressService.findAllAddresses(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Address> findAddressById(@PathVariable("id") Long id){
        return addressService.findAddressById(id);
    }

    @GetMapping("findAllAddressesByAccountId/{id}")
    public ResponseEntity<List<Address>> findAllAddressesByAccountId(@PathVariable("id") Long id){
        return new ResponseEntity<>(addressService.findAllAddressesByAccountId(id), HttpStatus.OK);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addAddressByAccountId/{id}")
    public void addAddressByAccountId(@RequestBody Address address, @PathVariable("id") Long id){

        addressService.addAddressByAccountId(address, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addAddressesByAccountId/{id}")
    public void addAddressesByAccountId(@RequestBody Address[] addresses, @PathVariable("id") Long id){

        addressService.addAddressesByAccountId(addresses, id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteAddressById/{id}")
    public void deleteAddressById(@PathVariable("id") Long id){
        addressService.deleteAddressById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteAddressesByIds/{ids}")
    public void deleteAddressesByIds(@PathVariable("ids") Long[] ids){
        addressService.deleteAddressesByIds(ids);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateAddressById/{id}")
    public void updateAddressById(
            @RequestBody Address address,
            @PathVariable("id") Long id
    ){
        addressService.updateAddressById(address, id);
    }
}
