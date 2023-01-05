package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.domain.Profile;
import com.team5.ACMEFlix.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/account/profile")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    private ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public ResponseEntity<List<Profile>> findAllProfiles(){
        return new ResponseEntity<>(profileService.findAllProfiles(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Profile> findProfileById(@PathVariable("id") Long id){
        return profileService.findProfileById(id);
    }

    @GetMapping("findProfileByAccountId/{id}")
    public ResponseEntity<Profile> findProfileByAccountId(@PathVariable("id") Long id){
        return profileService.findProfileByAccountId(id);
    }

    @GetMapping("findAllProfilesByAccountId/{id}")
    public ResponseEntity<List<Profile>> findAllProfilesByAccountId(@PathVariable("id") Long id){
        return new ResponseEntity<>(profileService.findAllProfilesByAccountId(id) , HttpStatus.OK);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addProfileByAccountId/{id}")
    public void addProfileByAccountId(@RequestBody Profile profile, @PathVariable("id") Long id){

        profileService.addProfileByAccountId(profile, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addProfilesByAccountId/{id}")
    public void addProfilesByAccountId(@RequestBody Profile[] profiles, @PathVariable("id") Long id){

        profileService.addProfilesByAccountId(profiles, id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteProfileById/{id}")
    public void deleteProfileById(@PathVariable("id") Long id){
        profileService.deleteProfileById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteProfilesByIds/{ids}")
    public void deleteProfilesByIds(@PathVariable("ids") Long[] ids){
        profileService.deleteProfilesByIds(ids);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PutMapping(path = "updateProfileById/{id}")
    public void updateProfileByIdPut(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) Boolean ageRestricted,
            @RequestParam(required = false) String imageUrl
    ){
        profileService.updateProfileByIdPut(id, firstname, ageRestricted, imageUrl);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateProfileById/{id}")
    public void updateProfileByIdPatch(
            @RequestBody Profile profile,
            @PathVariable("id") Long id
    ){
        profileService.updateProfileByIdPatch(profile, id);
    }

}
