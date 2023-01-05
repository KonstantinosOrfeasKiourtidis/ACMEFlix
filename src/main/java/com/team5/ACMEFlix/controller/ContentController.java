package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.domain.*;
import com.team5.ACMEFlix.helpers.ContentFactory;
import com.team5.ACMEFlix.helpers.RatingForm;
import com.team5.ACMEFlix.service.ContentService;
import com.team5.ACMEFlix.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/content")
public class ContentController {
    private final ContentService contentService;

    @Autowired
    private ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping
    public ResponseEntity<List<Content>> findAllContents(){
        return new ResponseEntity<>(contentService.findAllContents(), HttpStatus.OK);
    }

    @GetMapping("alternative")
    public ResponseEntity<List<ContentFactory>>findAllContentsAlternative(){
        return new ResponseEntity<>(contentService.findAllContentsAlternative(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Content> findContentById(@PathVariable("id") Long id){
        return contentService.findContentById(id);
    }
    @GetMapping("findContentByIdAlternative/{id}")
    public ContentFactory findContentByIdAlternative(@PathVariable("id") Long id){
        return contentService.findContentByIdAlternative(id);
    }

    @GetMapping("findAllContentsByFamilyFriendly")
    public ResponseEntity<List<ContentFactory>> findAllContentsByFamilyFriendly(){
        return new ResponseEntity<>(contentService.findAllContentsByFamilyFriendly(), HttpStatus.OK);
    }

    @GetMapping("findAllContentsByFamilyFriendlyAlternative")
    public ResponseEntity<List<Content>>findAllContentsByFamilyFriendlyAlternative(){
        return new ResponseEntity<>(contentService.findAllContentsByFamilyFriendlyAlternative(), HttpStatus.OK);
    }

    @GetMapping("findAllContentsByTitle")
    public ResponseEntity<List<Content>> findAllContentsByTitle(@Param("search") String search){
        return new ResponseEntity<>(contentService.findAllContentsByTitle(search), HttpStatus.OK);
    }

    @GetMapping("findAllContentsByTitleAlternative")
    public ResponseEntity<List<ContentFactory>> findAllContentsByTitleAlternative(@Param("search") String search){
        return new ResponseEntity<>(contentService.findAllContentsByTitleAlternative(search), HttpStatus.OK);
    }

    @GetMapping("findAllContentsByNameOrByEpisodeName")
    public ResponseEntity<List<ContentFactory>> findAllContentsByNameOrByEpisodeName(@Param("search") String search){
        return new ResponseEntity<>(contentService.findAllContentsByNameOrByEpisodeName(search), HttpStatus.OK);
    }

    @GetMapping("findAllContentByGenres")
    public ResponseEntity<List<ContentFactory>> findAllContentByGenres(@Param("genre") String[] genre){
        return new ResponseEntity<>(contentService.findAllContentByGenres(genre), HttpStatus.OK);
    }

    @GetMapping("findAllContentByActors")
    public ResponseEntity<List<ContentFactory>> findAllContentByActors(@Param("actor") String[] actor){
        return new ResponseEntity<>(contentService.findAllContentByActors(actor), HttpStatus.OK);
    }

    @GetMapping("findAllContentByLanguage")
    public ResponseEntity<List<ContentFactory>> findAllContentByLanguage(@Param("language") String language){
        return new ResponseEntity<>(contentService.findAllContentByLanguage(language), HttpStatus.OK);
    }

    @GetMapping("findAllContentByYear")
    public ResponseEntity<List<ContentFactory>> findAllContentByYear(@Param("year") String year){
        return new ResponseEntity<>(contentService.findAllContentByYear(year), HttpStatus.OK);
    }

    @GetMapping("findTop10HighestRatedContent")
    public ResponseEntity<List<ContentFactory>> findTop10HighestRatedContent(){
        return new ResponseEntity<>(contentService.findTop10HighestRatedContent(), HttpStatus.OK);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addContent")
    public void addContent(@RequestBody ContentFactory contentFactory){

        contentService.addContent(contentFactory);

    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addContents")
    public void addContents(@RequestBody ContentFactory... contentFactories){

        contentService.addContents(contentFactories);

    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteContentById/{id}")
    public void deleteContentById(@PathVariable("id") Long id){
        contentService.deleteContentById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteContentsByIds/{ids}")
    public void deleteContentsByIds(@PathVariable("ids") Long[] ids){
        contentService.deleteContentsByIds(ids);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateContentById/{id}")
    public void updateContentById(
            @RequestBody Content content,
            @PathVariable("id") Long id
    ){
        contentService.updateContentById(content, id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateContentByIdAlternative/{id}")
    public void updateContentByIdAlternative(
            @RequestBody ContentFactory contentFactory,
            @PathVariable("id") Long id
    ){
        contentService.updateContentByIdAlternative(contentFactory, id);
    }

}
