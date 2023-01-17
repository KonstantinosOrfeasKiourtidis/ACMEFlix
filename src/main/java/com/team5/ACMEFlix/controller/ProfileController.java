package com.team5.ACMEFlix.controller;


import com.team5.ACMEFlix.mapper.ProfileMapper;
import com.team5.ACMEFlix.service.ProfileService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.ProfileResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path = "api/v1/account/profile")
public class ProfileController {

    private final ProfileService profileService;
    private final ProfileMapper profileMapper;

    @Autowired
    private ProfileController(ProfileService profileService, ProfileMapper profileMapper) {
        this.profileService = profileService;
        this.profileMapper = profileMapper;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProfileResource>>> findAllProfiles(){
        return new ResponseEntity<>(ApiResponse.<List<ProfileResource>>builder().data(profileMapper.toResources(profileService.findAllProfiles())).build(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<ProfileResource>> findProfileById(@PathVariable("id") Long id){
        return new ResponseEntity<>(ApiResponse.<ProfileResource>builder().data(profileMapper.toResource(profileService.findProfileById(id).get())).build(), HttpStatus.OK);
    }

    @GetMapping("findProfileByAccountId/{id}")
    public ResponseEntity<ApiResponse<ProfileResource>> findProfileByAccountId(@PathVariable("id") Long id){
        return new ResponseEntity<>(ApiResponse.<ProfileResource>builder().data(profileMapper.toResource(profileService.findProfileByAccountId(id).get())).build(), HttpStatus.OK);
    }

    @GetMapping("findAllProfilesByAccountId/{id}")
    public ResponseEntity<ApiResponse<List<ProfileResource>>> findAllProfilesByAccountId(@PathVariable("id") Long id){
        return new ResponseEntity<>(ApiResponse.<List<ProfileResource>>builder().data(profileMapper.toResources(profileService.findAllProfilesByAccountId(id))).build(), HttpStatus.OK);
    }

    @PostMapping(path = "addProfileByAccountId/{id}")
    public ResponseEntity<ApiResponse<ProfileResource>> addProfileByAccountId(@PathVariable("id") Long id, @Valid @RequestBody ProfileResource profile){
        return new ResponseEntity<>(ApiResponse.<ProfileResource>builder().data(profileMapper.toResource(profileService.addProfileByAccountId(id, profileMapper.toDomain(profile)))).build(), HttpStatus.CREATED);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addProfilesByAccountId/{id}")
    public ResponseEntity<ApiResponse<List<ProfileResource>>> addProfilesByAccountId(@PathVariable("id") Long id, @Valid @RequestBody List<ProfileResource> profiles){
        return new ResponseEntity<>(ApiResponse.<List<ProfileResource>>builder().data(profileMapper.toResources(profileService.addProfilesByAccountId(id, profileMapper.toDomains(profiles)))).build(), HttpStatus.CREATED);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteProfileById/{id}")
    public void deleteProfileById(@PathVariable("id") Long id){
        profileService.deleteProfileById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteProfilesByIds/{ids}")
    public void deleteProfilesByIds(@PathVariable("ids") List<Long> ids){
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
            @PathVariable("id") Long id,
            @Valid @RequestBody ProfileResource profile
    ){
        profileService.updateProfileByIdPatch(id, profileMapper.toDomain(profile));
    }

}
