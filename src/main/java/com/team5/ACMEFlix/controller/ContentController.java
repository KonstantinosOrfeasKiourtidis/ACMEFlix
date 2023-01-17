package com.team5.ACMEFlix.controller;



import com.team5.ACMEFlix.mapper.ContentMapper;
import com.team5.ACMEFlix.service.ContentService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.ContentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.*;


@RestController
@RequestMapping(path = "api/v1/content")
public class ContentController {

    private final ContentService contentService;
    private final ContentMapper contentMapper;



    @Autowired
    private ContentController(ContentService contentService, ContentMapper contentMapper) {
        this.contentService = contentService;
        this.contentMapper = contentMapper;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ContentResource>>> findAllContents(){
        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentMapper.domainToResources(contentService.findAllContents())).build(), HttpStatus.OK);
    }


    @GetMapping("advncedSearch")
    public ResponseEntity<ApiResponse<List<ContentResource>>> advancedSearch(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                             @RequestParam(defaultValue = "2") Integer pageSize,
                                                                             @RequestParam(value = "search", required = false) String search,
                                                                             @RequestParam(value = "genres", required = false) String[] genres,
                                                                             @RequestParam(value = "year", required = false) String year,
                                                                             @RequestParam(value = "isAgeRestricted", required = false) Boolean isAgeRestricted,
                                                                             @RequestParam(value = "language", required = false) String language,
                                                                             @RequestParam(value = "contentType", required = false) String contentType){
        return new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentMapper.domainToResources(contentService.advancedSearch(pageNo, pageSize, search, genres, year, isAgeRestricted, language, contentType))).build(), HttpStatus.OK);
    }

    @GetMapping("alternative")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findAllContentsAlternative(){
        return new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentService.findAllContentsAlternative()).build(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<ContentResource>> findContentById(@PathVariable("id") Long id){
        return new ResponseEntity<>(ApiResponse.<ContentResource>builder().data(contentMapper.domainToResource(contentService.findContentById(id).get())).build(), HttpStatus.OK);
    }
    @GetMapping("findContentByIdAlternative/{id}")
    public ResponseEntity<ApiResponse<ContentResource>> findContentByIdAlternative(@PathVariable("id") Long id){

        return new ResponseEntity<>(ApiResponse.<ContentResource>builder().data(contentService.findContentByIdAlternative(id)).build(), HttpStatus.OK);
    }

    @GetMapping("findAllContentsByFamilyFriendly")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findAllContentsByFamilyFriendly(){

        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentService.findAllContentsByFamilyFriendly()).build(), HttpStatus.OK);
    }

    @GetMapping("findAllContentsByFamilyFriendlyAlternative")
    public ResponseEntity<ApiResponse<List<ContentResource>>>findAllContentsByFamilyFriendlyAlternative(){
        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentMapper.domainToResources(contentService.findAllContentsByFamilyFriendlyAlternative())).build(), HttpStatus.OK);
    }

    @GetMapping("findAllContentsByTitle")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findAllContentsByTitle(@Param("search") String search){
        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentMapper.domainToResources(contentService.findAllContentsByTitle(search))).build(), HttpStatus.OK);

    }

    @GetMapping("findAllContentsByTitleAlternative")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findAllContentsByTitleAlternative(@Param("search") String search){


        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentService.findAllContentsByTitleAlternative(search)).build(), HttpStatus.OK);

    }

    @GetMapping("findAllContentsByNameOrByEpisodeName")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findAllContentsByNameOrByEpisodeName(@Param("search") String search){


        return new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentService.findAllContentsByTitleOrEpisodeName(search)).build(), HttpStatus.OK);
    }

    @GetMapping("findAllContentByGenres")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findAllContentByGenres(@Param("genre") String[] genre){




        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentService.findAllContentByGenres(genre)).build(), HttpStatus.OK);

    }

    @GetMapping("findAllContentByActors")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findAllContentByActors(@Param("actor") String[] actor){



        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentService.findAllContentByActors(actor)).build(), HttpStatus.OK);

    }

    @GetMapping("findAllContentByLanguage")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findAllContentByLanguage(@Param("language") String language){


        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentService.findAllContentByLanguage(language)).build(), HttpStatus.OK);
    }

    @GetMapping("findAllContentByYear")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findAllContentByYear(@Param("year") String year){


        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentService.findAllContentByYear(year)).build(), HttpStatus.OK);
    }

    @GetMapping("findTop10HighestRatedContent")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findTop10HighestRatedContent(){



        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentService.findTop10HighestRatedContent()).build(), HttpStatus.OK);
    }

    @PostMapping(path = "addContent")
    public ResponseEntity<ApiResponse<ContentResource>> addContent(@Valid @RequestBody ContentResource contentResource){


        return new ResponseEntity<>(ApiResponse.<ContentResource>builder().data(contentService.addContent(contentResource)).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addContents")
    public ResponseEntity<ApiResponse<List<ContentResource>>> addContents(@Valid @RequestBody List<ContentResource> contentResources){


        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentService.addContents(contentResources)).build(), HttpStatus.CREATED);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteContentById/{id}")
    public void deleteContentById(@PathVariable("id") Long id){
        contentService.deleteContentById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteContentsByIds/{ids}")
    public void deleteContentsByIds(@PathVariable("ids") List<Long> ids){
        contentService.deleteContentsByIds(ids);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateContentById/{id}")
    public void updateContentById(
            @PathVariable("id") Long id,
            @Valid @RequestBody ContentResource content
    ){
        contentService.updateContentById(id, contentMapper.resourceToDomain(content));
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateContentByIdAlternative/{id}")
    public void updateContentByIdAlternative(
            @PathVariable("id") Long id,
            @Valid @RequestBody ContentResource contentResource
    ){
        contentService.updateContentByIdAlternative(id, contentResource);
    }

}
