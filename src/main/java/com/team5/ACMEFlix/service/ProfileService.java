package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.Account;
import com.team5.ACMEFlix.domain.Profile;
import com.team5.ACMEFlix.repository.AccountRepository;
import com.team5.ACMEFlix.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Transactional(readOnly = true)
    public List<Profile> findAllProfiles() {
        return profileRepository.findAll();
    }
    @Transactional(readOnly = true)
    public ResponseEntity<Profile> findProfileById(Long id) {
        return profileRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @Transactional(readOnly = true)
    public ResponseEntity<Profile> findProfileByAccountId(Long id) {
        return profileRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Transactional(readOnly = true)
    public List<Profile> findAllProfilesByAccountId(Long id) {
        return profileRepository.findProfileByByAccountId(id);
    }

    @Transactional
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

    @Transactional
    public void addProfilesByAccountId(Profile[] profiles, Long id) {
        Optional<Account> accountExists = accountRepository.findById(id);
        if(!accountExists.isPresent()){
            throw new IllegalStateException("Account does not exist");
        }
        else {
            for (Profile profile : profiles){
                profile.setAccount(accountExists.get());
                profileRepository.save(profile);
            }
        }
    }

    @Transactional
    public void deleteProfileById(Long id) {
        boolean exists = profileRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Profile does not exist");
        }
        else{
            profileRepository.deleteById(id);
        }
    }

    @Transactional
    public void deleteProfilesByIds(Long[] ids) {
        for(Long id : ids) {
            boolean exists = profileRepository.existsById(id);
            if (!exists) {
                throw new IllegalStateException("Profile does not exist");
            } else {
                profileRepository.deleteById(id);
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



}
