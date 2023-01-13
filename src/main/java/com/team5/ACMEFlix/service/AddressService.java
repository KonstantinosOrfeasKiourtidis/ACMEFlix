package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.Account;
import com.team5.ACMEFlix.domain.Address;
import com.team5.ACMEFlix.repository.AccountRepository;
import com.team5.ACMEFlix.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Transactional(readOnly = true)
    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Address> findAddressById(Long id) {
        return addressRepository.findById(id);
    }


    @Transactional(readOnly = true)
    public List<Address> findAllAddressesByAccountId(Long id) {
        return addressRepository.findAddressesByAccountId(id);
    }


    @Transactional
    public Address addAddressByAccountId(Long id, Address address) {
        Optional<Account> accountExists = accountRepository.findById(id);
        if(!accountExists.isPresent()){
            throw new NoSuchElementException("Account does not exist");
        }
        else{
            address.setAccount(accountExists.get());
            addressRepository.save(address);
        }
        return address;
    }

    @Transactional
    public List<Address> addAddressesByAccountId(Long id, List<Address> addresses) {
        Optional<Account> accountExists = accountRepository.findById(id);
        if(!accountExists.isPresent()){
            throw new NoSuchElementException("Account does not exist");
        }
        else{
            for(Address address : addresses) {
                address.setAccount(accountExists.get());
                addressRepository.save(address);
            }
        }
        return addresses;
    }

    @Transactional
    public void deleteAddressById(Long id) {
        boolean exists = addressRepository.existsById(id);
        if(!exists){
            throw new NoSuchElementException("Address does not exist");
        }
        else{
            addressRepository.deleteById(id);
        }
    }

    @Transactional
    public void deleteAddressesByIds(List<Long> ids) {
        for(Long id : ids) {
            boolean exists = addressRepository.existsById(id);
            if (!exists) {
                throw new NoSuchElementException("Address does not exist");
            } else {
                addressRepository.deleteById(id);
            }
        }
    }

    @Transactional
    public void updateAddressById(Long id, Address address) {
        Address foundAddress = addressRepository.findById(id).orElseThrow(() -> new NoSuchElementException(
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
}
