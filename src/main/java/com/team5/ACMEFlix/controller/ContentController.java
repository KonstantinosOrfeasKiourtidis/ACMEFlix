package com.team5.ACMEFlix.controller;



import com.team5.ACMEFlix.mapper.ContentMapper;
import com.team5.ACMEFlix.service.ContentService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.ContentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentMapper.toResources(contentService.findAllContents())).build(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<ContentResource>> findContentById(@PathVariable("id") Long id){
        return new ResponseEntity<>(ApiResponse.<ContentResource>builder().data(contentMapper.toResource(contentService.findContentById(id).get())).build(), HttpStatus.OK);
    }

    @GetMapping("advancedSearch")
    public ResponseEntity<ApiResponse<List<ContentResource>>> advancedSearch(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                             @RequestParam(defaultValue = "2") Integer pageSize,
                                                                             @RequestParam(value = "search", required = false) String search,
                                                                             @RequestParam(value = "genres", required = false) String[] genres,
                                                                             @RequestParam(value = "year", required = false) String year,
                                                                             @RequestParam(value = "isAgeRestricted", required = false) Boolean isAgeRestricted,
                                                                             @RequestParam(value = "language", required = false) String language,
                                                                             @RequestParam(value = "contentType", required = false) String contentType){
        return new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentMapper.toResources(contentService.advancedSearch(pageNo, pageSize, search, genres, year, isAgeRestricted, language, contentType))).build(), HttpStatus.OK);
    }


}
