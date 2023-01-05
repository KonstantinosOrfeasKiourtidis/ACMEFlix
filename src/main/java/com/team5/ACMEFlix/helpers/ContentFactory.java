package com.team5.ACMEFlix.helpers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.team5.ACMEFlix.domain.*;
import com.team5.ACMEFlix.domain.enumeration.TVSeriesStatusType;
import com.team5.ACMEFlix.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class ContentFactory {

    private Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Season> seasons;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Creator> creators;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TVSeriesStatusType tvSeriesStatusType;
    private Content content;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Writer> writers;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Director> directors;
    private Float rating;
    private Integer profileNo;

    @Autowired
    private RatingRepository ratingRepository;

    public ContentFactory() {
    }

    public ContentFactory(Long id, List<Season> seasons, List<Creator> creators, TVSeriesStatusType tvSeriesStatusType, Content content, List<Writer> writers, List<Director> directors, Float rating, Integer profileNo) {
        this.id = id;
        this.seasons = seasons;
        this.creators = creators;
        this.tvSeriesStatusType = tvSeriesStatusType;
        this.content = content;
        this.writers = writers;
        this.directors = directors;
        this.rating = rating;
        this.profileNo = profileNo;
    }

    public Integer getProfileNo() {
        return profileNo;
    }

    public void setProfileNo(Integer profileNo) {
        this.profileNo = profileNo;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Content getContent() {
        return content;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public List<Creator> getCreators() {
        return creators;
    }

    public TVSeriesStatusType getTvSeriesStatusType() {
        return tvSeriesStatusType;
    }

    public List<Writer> getWriters() {
        return writers;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

    public void setCreators(List<Creator> creators) {
        this.creators = creators;
    }

    public void setTvSeriesStatusType(TVSeriesStatusType tvSeriesStatusType) {
        this.tvSeriesStatusType = tvSeriesStatusType;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public void setWriters(List<Writer> writers) {
        this.writers = writers;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public static Movie toMovie(ContentFactory contentFactory ) {
        Movie movie = new Movie();
        movie.setId(contentFactory.getId());
        movie.setDirectors(contentFactory.getDirectors());
        movie.setWriters(contentFactory.getWriters());
        movie.setContent(contentFactory.getContent());
        return movie;
    }

    public static TVSeries toTVSeries(ContentFactory contentFactory ) {
        TVSeries tvSeries = new TVSeries();
        tvSeries.setId(contentFactory.getId());
        tvSeries.setCreators(contentFactory.getCreators());
        tvSeries.setSeasons(contentFactory.getSeasons());
        tvSeries.setContent(contentFactory.getContent());
        tvSeries.setTvSeriesStatusType(contentFactory.getTvSeriesStatusType());
        return tvSeries;
    }

    //TODO
    //ADD Rating
    public  ContentFactory movieToContentFactory(Movie movie ) {
        ContentFactory contentFactory = new ContentFactory();
        contentFactory.setId(movie.getContent().getId());
        contentFactory.setContent(movie.getContent());
        contentFactory.setDirectors(movie.getDirectors());
        contentFactory.setWriters(movie.getWriters());
        List<Rating> ratings = ratingRepository.findRatingByContentId(movie.getContent().getId());
        float rating = 0;
        for (Rating onlyRating: ratings){
            rating += onlyRating.getRating();
        }

        if(Float.isNaN(rating) || !(rating > 0 || rating <=10)){
            contentFactory.setRating(0F);
        }
        else {
            contentFactory.setRating(rating/ratings.size());
        }


        contentFactory.setProfileNo(ratings.size());
        return contentFactory;
    }

    //TODO
    //ADD Rating
    public  ContentFactory tvSerieToContentFactory(TVSeries tvSerie ) {
        ContentFactory contentFactory = new ContentFactory();
        contentFactory.setId(tvSerie.getContent().getId());
        contentFactory.setContent(tvSerie.getContent());
        contentFactory.setCreators(tvSerie.getCreators());
        contentFactory.setSeasons(tvSerie.getSeasons());
        contentFactory.setTvSeriesStatusType(tvSerie.getTvSeriesStatusType());

        List<Rating> ratings = ratingRepository.findRatingByContentId(tvSerie.getContent().getId());
        float rating = 0;
        for (Rating onlyRating: ratings){
            rating += onlyRating.getRating();
        }

        if(Float.isNaN(rating) || !(rating > 0 && rating <=10)){
            contentFactory.setRating(0F);
        }
        else {
            contentFactory.setRating(rating/ratings.size());
        }

        contentFactory.setProfileNo(ratings.size());

        return contentFactory;
    }

    public  List<ContentFactory> moviesToContentFactoryList(List<Movie> movies){
        List<ContentFactory> contentFactories = new ArrayList<>();
        for(Movie movie : movies){
            contentFactories.add(movieToContentFactory(movie));
        }
        return contentFactories;
    }

    public  List<ContentFactory> tvSeriesToContentFactoryList(List<TVSeries> tvSeries){
        List<ContentFactory> contentFactories = new ArrayList<>();
        for(TVSeries tvSerie : tvSeries){
            contentFactories.add(tvSerieToContentFactory(tvSerie));
        }
        return contentFactories;
    }



}
