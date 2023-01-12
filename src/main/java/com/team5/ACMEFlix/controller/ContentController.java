package com.team5.ACMEFlix.controller;


import com.team5.ACMEFlix.domain.Movie;
import com.team5.ACMEFlix.domain.enumeration.ContentType;
import com.team5.ACMEFlix.mapper.ContentMapper;
import com.team5.ACMEFlix.mapper.MovieMapper;
import com.team5.ACMEFlix.mapper.TVSeriesMapper;
import com.team5.ACMEFlix.repository.ContentRepository;
import com.team5.ACMEFlix.service.ContentService;
import com.team5.ACMEFlix.service.EpisodeService;
import com.team5.ACMEFlix.service.MovieService;
import com.team5.ACMEFlix.service.TVSeriesService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.ContentResource;
import com.team5.ACMEFlix.transfer.resource.MovieResource;
import com.team5.ACMEFlix.transfer.resource.TVSeriesResource;
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
    //TODO
    //move services to content service
    private final ContentService contentService;
    private final MovieService movieService;
    private final TVSeriesService tvSeriesService;
    private final ContentMapper contentMapper;
    private final MovieMapper movieMapper;
    private final TVSeriesMapper tvSeriesMapper;
    private final EpisodeService episodeService;


    @Autowired
    private ContentController(ContentService contentService, ContentMapper contentMapper, MovieService movieService, TVSeriesService tvSeriesService, MovieMapper movieMapper, TVSeriesMapper tvSeriesMapper,
                              EpisodeService episodeService) {
        this.contentService = contentService;
        this.contentMapper = contentMapper;
        this.movieService = movieService;
        this.tvSeriesService = tvSeriesService;
        this.movieMapper = movieMapper;
        this.tvSeriesMapper = tvSeriesMapper;
        this.episodeService = episodeService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ContentResource>>> findAllContents(){
        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentMapper.domainToResources(contentService.findAllContents())).build(), HttpStatus.OK);
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
        List<ContentResource> contentResources = new ArrayList<>();
        contentResources.addAll(contentMapper.moviesToContentResources(movieService.findAllMoviesFamilyFriendly()));
        contentResources.addAll(contentMapper.tvSeriesToContentResources(tvSeriesService.findAllTVSeriesFamilyFriendly()));
        Collections.shuffle(contentResources);
        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentResources).build(), HttpStatus.OK);
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
        List<ContentResource> contentResourcesSearchResult = contentMapper.domainToResources(contentService.findAllContentsByTitleAlternative(search));
        List<MovieResource>  movieResources = new ArrayList<>();
        List<TVSeriesResource>  tvSeriesResources = new ArrayList<>();
        for (ContentResource contentResource: contentResourcesSearchResult){
            if(contentResource.getContentType().equals(ContentType.MOVIE)){

                movieResources.add(movieMapper.toResource(movieService.findMovieByContentId(contentResource.getId()).get()));

            }
            else if(contentResource.getContentType().equals(ContentType.TV_SERIES)){
                tvSeriesResources.add(tvSeriesMapper.toResource(tvSeriesService.findTVSeriesByContentId(contentResource.getId()).get()));
            }
        }

        List<ContentResource> contentResourcesReturn = new ArrayList<>();
        contentResourcesReturn.addAll(contentMapper.tvSeriesToContentResources(tvSeriesMapper.toDomains(tvSeriesResources)));
        contentResourcesReturn.addAll(contentMapper.moviesToContentResources(movieMapper.toDomains(movieResources)));

        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentResourcesReturn).build(), HttpStatus.OK);

    }

    @GetMapping("findAllContentsByNameOrByEpisodeName")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findAllContentsByNameOrByEpisodeName(@Param("search") String search){
        List<ContentResource> contentResourcesSearchResult = contentMapper.domainToResources(contentService.findAllContentsByTitleAlternative(search));
        List<MovieResource>  movieResources = new ArrayList<>();
        List<TVSeriesResource>  tvSeriesResources = new ArrayList<>();
        List<Long> contentIds = new ArrayList<>();
        for (ContentResource contentResource: contentResourcesSearchResult){

            contentIds.add(contentResource.getId());
        }


        List<Long> episodeContentIds = episodeService.findAllEpisodesByEpisodeName(search, contentIds);

        List<ContentResource> newContentResource = contentMapper.domainToResources(contentService.findAllById(episodeContentIds));
        for (ContentResource contentResource: newContentResource){
            if(contentResource.getContentType().equals(ContentType.MOVIE)){

                movieResources.add(movieMapper.toResource(movieService.findMovieByContentId(contentResource.getId()).get()));


            }
            else if(contentResource.getContentType().equals(ContentType.TV_SERIES)){
                tvSeriesResources.add(tvSeriesMapper.toResource(tvSeriesService.findTVSeriesByContentId(contentResource.getId()).get()));
            }
        }



        List<ContentResource> contentResourcesReturn = new ArrayList<>();


        contentResourcesReturn.addAll(contentMapper.moviesToContentResources(movieMapper.toDomains(movieResources)));

        contentResourcesReturn.addAll(contentMapper.tvSeriesToContentResources(tvSeriesMapper.toDomains(tvSeriesResources)));

        return new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentResourcesReturn).build(), HttpStatus.OK);
    }

    @GetMapping("findAllContentByGenres")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findAllContentByGenres(@Param("genre") String[] genre){


        List<ContentResource> contentResources = contentMapper.domainToResources(contentService.findAllContentsById(contentService.findAllContentByGenres(genre)));
        List<MovieResource> movies = new ArrayList<>();
        List<TVSeriesResource> tvSeries = new ArrayList<>();
        for (ContentResource content: contentResources){


            if(content.getContentType().equals(ContentType.MOVIE)){
                movies.add(movieMapper.toResource(movieService.findMovieByContentId(content.getId()).get()));
            }
            else if(content.getContentType().equals(ContentType.TV_SERIES)){
                tvSeries.add(tvSeriesMapper.toResource(tvSeriesService.findTVSeriesByContentId(content.getId()).get()));
            }
            else{

            }
        }

        List<ContentResource> contentResourcesReturn = new ArrayList<>();
        contentResourcesReturn.addAll(contentMapper.moviesToContentResources(movieMapper.toDomains(movies)));
        contentResourcesReturn.addAll(contentMapper.tvSeriesToContentResources(tvSeriesMapper.toDomains(tvSeries)));

        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentResourcesReturn).build(), HttpStatus.OK);

    }

    @GetMapping("findAllContentByActors")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findAllContentByActors(@Param("actor") String[] actor){
        List<ContentResource> contents = contentMapper.domainToResources(contentService.findAllContentsById(contentService.findAllContentByActors(actor)));
        List<MovieResource> movies = new ArrayList<>();
        List<TVSeriesResource> tvSeries = new ArrayList<>();
        for (ContentResource content: contents){
            if(content.getContentType().equals(ContentType.MOVIE)){
                movies.add(movieMapper.toResource(movieService.findMovieByContentId(content.getId()).get()));
            }
            else if(content.getContentType().equals(ContentType.TV_SERIES)){
                tvSeries.add(tvSeriesMapper.toResource(tvSeriesService.findTVSeriesByContentId(content.getId()).get()));
            }
            else{

            }
        }

        List<ContentResource> contentResourcesReturn = new ArrayList<>();
        contentResourcesReturn.addAll(contentMapper.moviesToContentResources(movieMapper.toDomains(movies)));
        contentResourcesReturn.addAll(contentMapper.tvSeriesToContentResources(tvSeriesMapper.toDomains(tvSeries)));


        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentResourcesReturn).build(), HttpStatus.OK);

    }

    @GetMapping("findAllContentByLanguage")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findAllContentByLanguage(@Param("language") String language){
        List<ContentResource> contentResources = contentMapper.domainToResources(contentService.findAllContentByLanguage(language));
        List<MovieResource> movies = new ArrayList<>();
        List<TVSeriesResource> tvSeries = new ArrayList<>();
        for (ContentResource content: contentResources){
            if(content.getContentType().equals(ContentType.MOVIE)){
                movies.add(movieMapper.toResource(movieService.findMovieByContentId(content.getId()).get()));
            }
            else if(content.getContentType().equals(ContentType.TV_SERIES)){
                tvSeries.add(tvSeriesMapper.toResource(tvSeriesService.findTVSeriesByContentId(content.getId()).get()));
            }
            else{

            }
        }

        List<ContentResource> contentResourcesReturn = new ArrayList<>();
        contentResourcesReturn.addAll(contentMapper.moviesToContentResources(movieMapper.toDomains(movies)));
        contentResourcesReturn.addAll(contentMapper.tvSeriesToContentResources(tvSeriesMapper.toDomains(tvSeries)));

        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentResourcesReturn).build(), HttpStatus.OK);
    }

    @GetMapping("findAllContentByYear")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findAllContentByYear(@Param("year") String year){
        List<ContentResource> contentResources = contentMapper.domainToResources(contentService.findAllContentByYear(year));

        List<MovieResource> movies = new ArrayList<>();
        List<TVSeriesResource> tvSeries = new ArrayList<>();
        for (ContentResource content: contentResources){
            if(content.getContentType().equals(ContentType.MOVIE)){
                movies.add(movieMapper.toResource(movieService.findMovieByContentId(content.getId()).get()));
            }
            else if(content.getContentType().equals(ContentType.TV_SERIES)){
                tvSeries.add(tvSeriesMapper.toResource(tvSeriesService.findTVSeriesByContentId(content.getId()).get()));
            }
            else{

            }
        }
        List<ContentResource> contentResourcesReturn = new ArrayList<>();
        contentResourcesReturn.addAll(contentMapper.moviesToContentResources(movieMapper.toDomains(movies)));
        contentResourcesReturn.addAll(contentMapper.tvSeriesToContentResources(tvSeriesMapper.toDomains(tvSeries)));

        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentResourcesReturn).build(), HttpStatus.OK);
    }

    @GetMapping("findTop10HighestRatedContent")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findTop10HighestRatedContent(){

        List<Long> contentIds = contentService.findTop10HighestRatedContent();

        List<ContentResource> contents = contentMapper.domainToResources(contentService.findAllById(contentIds));

        List<MovieResource> movies = new ArrayList<>();
        List<TVSeriesResource> tvSeries = new ArrayList<>();
        for (ContentResource content: contents){
            if(content.getContentType().equals(ContentType.MOVIE)){
                movies.add(movieMapper.toResource(movieService.findMovieByContentId(content.getId()).get()));
            }
            else if(content.getContentType().equals(ContentType.TV_SERIES)){
                tvSeries.add(tvSeriesMapper.toResource(tvSeriesService.findTVSeriesByContentId(content.getId()).get()));
            }
            else{

            }
        }

        List<ContentResource> contentResourcesReturn = new ArrayList<>();
        contentResourcesReturn.addAll(contentMapper.moviesToContentResources(movieMapper.toDomains(movies)));
        contentResourcesReturn.addAll(contentMapper.tvSeriesToContentResources(tvSeriesMapper.toDomains(tvSeries)));

        Collections.sort(contentResourcesReturn, new Comparator<ContentResource>() {
            public int compare(ContentResource cr1, ContentResource cr2) {

                int result = Float.compare(cr2.getRating(), cr1.getRating());
                return result;
            }
        });


        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentResourcesReturn).build(), HttpStatus.OK);
    }

    @PostMapping(path = "addContent")
    public ResponseEntity<ApiResponse<ContentResource>> addContent(@Valid @RequestBody ContentResource contentResource){
        if(contentResource.getContentType().equals(ContentType.TV_SERIES)){
            TVSeriesResource tvSerie = tvSeriesMapper.toResource(contentMapper.contentResourceToTVSerie(contentResource));

            tvSeriesService.addTVSerie(tvSeriesMapper.toDomain(tvSerie));
        }
        else if(contentResource.getContentType().equals(ContentType.MOVIE)){
            MovieResource movie = movieMapper.toResource(contentMapper.contentResourceToMovie(contentResource));

            movieService.addMovie(movieMapper.toDomain(movie));
        }
        else{
            throw new IllegalStateException("Not a Movie or a TV Series");
        }

        return new ResponseEntity<>(ApiResponse.<ContentResource>builder().data(contentResource).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addContents")
    public ResponseEntity<ApiResponse<List<ContentResource>>> addContents(@Valid @RequestBody List<ContentResource> contentResources){
        for(ContentResource contentResource : contentResources){
            if(contentResource.getContentType().equals(ContentType.TV_SERIES)){
                TVSeriesResource tvSerie = tvSeriesMapper.toResource(contentMapper.contentResourceToTVSerie(contentResource));

                tvSeriesService.addTVSerie(tvSeriesMapper.toDomain(tvSerie));
            }
            else if(contentResource.getContentType().equals(ContentType.MOVIE)){
                MovieResource movie = movieMapper.toResource(contentMapper.contentResourceToMovie(contentResource));

                movieService.addMovie(movieMapper.toDomain(movie));
            }
            else{
                throw new IllegalStateException("Not a Movie or a TV Series");
            }
        }

        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentResources).build(), HttpStatus.CREATED);
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
