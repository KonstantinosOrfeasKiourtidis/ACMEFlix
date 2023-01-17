package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.mapper.CreatorMapper;
import com.team5.ACMEFlix.service.CreatorService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.CreatorResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/content/tvseries/creator")
public class  CreatorController {

    private final CreatorService creatorService;
    private final CreatorMapper creatorMapper;
    @Autowired
    private CreatorController(CreatorService creatorService, CreatorMapper creatorMapper) {
        this.creatorService = creatorService;
        this.creatorMapper = creatorMapper;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CreatorResource>>> findAllCreators(){
        return  new ResponseEntity<>(ApiResponse.<List<CreatorResource>>builder().data(creatorMapper.toResources(creatorService.findAllCreators())).build(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<CreatorResource>> findCreatorById(@PathVariable("id") Long id){
        return new ResponseEntity<>(ApiResponse.<CreatorResource>builder().data(creatorMapper.toResource(creatorService.findCreatorById(id).get())).build(), HttpStatus.OK);
    }

    @GetMapping("findAllCreatorsByContentId/{id}")
    public ResponseEntity<ApiResponse<List<CreatorResource>>>findAllCreatorsByContentId(@PathVariable("id") Long id){
        return new ResponseEntity<>(ApiResponse.<List<CreatorResource>>builder().data(creatorMapper.toResources(creatorService.findAllCreatorsByContentId(id))).build(), HttpStatus.OK);
    }

    @PostMapping(path = "addCreatorByContentId/{id}")
    public ResponseEntity<ApiResponse<CreatorResource>> addCreatorByContentId(@PathVariable("id") Long id, @Valid @RequestBody CreatorResource creator){
        return new ResponseEntity<>(ApiResponse.<CreatorResource>builder().data(creatorMapper.toResource(creatorService.addCreatorByContentId(id, creatorMapper.toDomain(creator)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addCreatorsByContentId/{id}")
    public ResponseEntity<ApiResponse<List<CreatorResource>>> addCreatorsByContentId(@PathVariable("id") Long id, @Valid @RequestBody List<CreatorResource> creators){
        return  new ResponseEntity<>(ApiResponse.<List<CreatorResource>>builder().data(creatorMapper.toResources(creatorService.addCreatorsByContentId(id, creatorMapper.toDomains(creators)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addCreatorByTVSeriesId/{id}")
    public ResponseEntity<ApiResponse<CreatorResource>> addCreatorByTVSeriesId(@PathVariable("id") Long id, @Valid @RequestBody CreatorResource creator){
        return new ResponseEntity<>(ApiResponse.<CreatorResource>builder().data(creatorMapper.toResource(creatorService.addCreatorByTVSeriesId(id, creatorMapper.toDomain(creator)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addCreatorsByTVSeriesId/{id}")
    public ResponseEntity<ApiResponse<List<CreatorResource>>> addCreatorsByTVSeriesId(@PathVariable("id") Long id, @Valid @RequestBody List<CreatorResource> creators){
        return  new ResponseEntity<>(ApiResponse.<List<CreatorResource>>builder().data(creatorMapper.toResources(creatorService.addCreatorsByTVSeriesId(id, creatorMapper.toDomains(creators)))).build(), HttpStatus.CREATED);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteCreatorById/{id}")
    public void deleteCreatorById(@PathVariable("id") Long id){
        creatorService.deleteCreatorById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteCreatorsByIds/{ids}")
    public void deleteCreatorsByIds(@PathVariable("ids") List<Long> ids){
        creatorService.deleteCreatorsByIds(ids);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateCreatorById/{id}")
    public void updateCreatorById(
            @PathVariable("id") Long id,
            @Valid @RequestBody CreatorResource creator
    ){
        creatorService.updateCreatorById(id, creatorMapper.toDomain(creator));
    }
}
