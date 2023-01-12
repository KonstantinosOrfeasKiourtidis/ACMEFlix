package com.team5.ACMEFlix.mapper;


import com.team5.ACMEFlix.domain.*;
import com.team5.ACMEFlix.service.RatingService;
import com.team5.ACMEFlix.transfer.resource.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContentMapperImpl implements ContentMapper{

    @Autowired
    private RatingService ratingService;
    
    @Override
    public Content resourceToDomain(ContentResource contentResource) {
        if ( contentResource == null ) {
            return null;
        }

        Content.ContentBuilder<?, ?> content = Content.builder();

        content.id( contentResource.getId() );
        content.title( contentResource.getTitle() );
        content.description( contentResource.getDescription() );
        content.spokenLanguage( contentResource.getSpokenLanguage() );
        content.releaseDate( contentResource.getReleaseDate() );
        content.imageUrl( contentResource.getImageUrl() );
        content.trailerUrl( contentResource.getTrailerUrl() );
        content.isAgeRestricted( contentResource.getIsAgeRestricted() );
        content.genres( genreResourceListToGenreList(contentResource.getGenres()) );
        content.actors( actorResourceListToActorList(contentResource.getActors()) );
        content.contentType( contentResource.getContentType() );
        content.runtime( contentResource.getRuntime() );

        return content.build();
    }

    @Override
    public ContentResource domainToResource(Content contentDomain) {
        if ( contentDomain == null ) {
            return null;
        }

        ContentResource contentResource = new ContentResource();

        contentResource.setId( contentDomain.getId() );
        contentResource.setTitle( contentDomain.getTitle() );
        contentResource.setDescription( contentDomain.getDescription() );
        contentResource.setSpokenLanguage( contentDomain.getSpokenLanguage() );
        contentResource.setReleaseDate( contentDomain.getReleaseDate() );
        contentResource.setImageUrl( contentDomain.getImageUrl() );
        contentResource.setTrailerUrl( contentDomain.getTrailerUrl() );
        contentResource.setIsAgeRestricted( contentDomain.getIsAgeRestricted() );
        contentResource.setGenres( genreListToGenreResourceList( contentDomain.getGenres() ) );
        contentResource.setActors( actorListToActorResourceList( contentDomain.getActors() ) );
        contentResource.setContentType( contentDomain.getContentType() );
        contentResource.setRuntime( contentDomain.getRuntime() );
        return contentResource;
    }

    protected GenreResource genreToGenreResource(Genre genre) {
        if ( genre == null ) {
            return null;
        }

        GenreResource genreResource = new GenreResource();

        genreResource.setId( genre.getId() );
        genreResource.setName( genre.getName() );

        return genreResource;
    }

    protected List<GenreResource> genreListToGenreResourceList(List<Genre> list) {
        if ( list == null ) {
            return null;
        }

        List<GenreResource> list1 = new ArrayList<GenreResource>( list.size() );
        for ( Genre genre : list ) {
            list1.add( genreToGenreResource( genre ) );
        }

        return list1;
    }


    protected Genre genreResourceToGenre(GenreResource genreResource) {
        if ( genreResource == null ) {
            return null;
        }

        Genre.GenreBuilder<?, ?> genre = Genre.builder();

        genre.id( genreResource.getId() );
        genre.name( genreResource.getName() );

        return genre.build();
    }

    protected List<Genre> genreResourceListToGenreList(List<GenreResource> list) {
        if ( list == null ) {
            return null;
        }

        List<Genre> list1 = new ArrayList<Genre>( list.size() );
        for ( GenreResource genreResource : list ) {
            list1.add( genreResourceToGenre( genreResource ) );
        }

        return list1;
    }




    protected ActorResource actorToActorResource(Actor actor) {
        if ( actor == null ) {
            return null;
        }

        ActorResource actorResource = new ActorResource();

        actorResource.setId( actor.getId() );
        actorResource.setFullname( actor.getFullname() );
        actorResource.setImageUrl( actor.getImageUrl() );

        return actorResource;
    }

    protected List<ActorResource> actorListToActorResourceList(List<Actor> list) {
        if ( list == null ) {
            return null;
        }

        List<ActorResource> list1 = new ArrayList<ActorResource>( list.size() );
        for ( Actor actor : list ) {
            list1.add( actorToActorResource( actor ) );
        }

        return list1;
    }


    protected Actor actorResourceToActor(ActorResource actorResource) {
        if ( actorResource == null ) {
            return null;
        }

        Actor.ActorBuilder<?, ?> actor = Actor.builder();

        actor.id( actorResource.getId() );
        actor.fullname( actorResource.getFullname() );
        actor.imageUrl( actorResource.getImageUrl() );

        return actor.build();
    }

    protected List<Actor> actorResourceListToActorList(List<ActorResource> list) {
        if ( list == null ) {
            return null;
        }

        List<Actor> list1 = new ArrayList<Actor>( list.size() );
        for ( ActorResource actorResource : list ) {
            list1.add( actorResourceToActor( actorResource ) );
        }

        return list1;
    }












    @Override
    public List<ContentResource> domainToResources(List<Content> contentDomains) {
        if ( contentDomains == null ) {
            return null;
        }

        List<ContentResource> list = new ArrayList<ContentResource>( contentDomains.size() );
        for ( Content content : contentDomains ) {
            list.add( domainToResource( content ) );
        }

        return list;
    }

    @Override
    public List<Content> resourceToDomains(List<ContentResource> contentResources) {
        if ( contentResources == null ) {
            return null;
        }

        List<Content> list = new ArrayList<Content>( contentResources.size() );
        for ( ContentResource contentResource : contentResources ) {
            list.add( resourceToDomain( contentResource ) );
        }

        return list;
    }

    @Override
    public Movie contentResourceToMovie(ContentResource contentResource) {
        if ( contentResource == null ) {
            return null;
        }

        Movie.MovieBuilder<?, ?> movie = Movie.builder();
        Content.ContentBuilder<?, ?> content = Content.builder();

        movie.id( contentResource.getId() );
        movie.directors( directorResourceListToDirectorList(contentResource.getDirectors()) );
        movie.writers( writerResourceListToWriterList(contentResource.getWriters()) );


        content.id( contentResource.getId() );
        content.title( contentResource.getTitle() );
        content.description( contentResource.getDescription() );
        content.spokenLanguage( contentResource.getSpokenLanguage() );
        content.releaseDate( contentResource.getReleaseDate() );
        content.imageUrl( contentResource.getImageUrl() );
        content.trailerUrl( contentResource.getTrailerUrl() );
        content.isAgeRestricted( contentResource.getIsAgeRestricted() );
        content.genres( genreResourceListToGenreList(contentResource.getGenres()) );
        content.actors( actorResourceListToActorList(contentResource.getActors()) );
        content.contentType( contentResource.getContentType() );
        content.runtime( contentResource.getRuntime() );

        movie.content( content.build() );

        return movie.build();
    }

    @Override
    public ContentResource movieToContentResource(Movie movieDomain) {
        if ( movieDomain == null ) {
            return null;
        }

        ContentResource contentResource = new ContentResource();

        contentResource.setId( movieDomain.getContent().getId() );
        contentResource.setTitle( movieDomain.getContent().getTitle() );
        contentResource.setDescription( movieDomain.getContent().getDescription() );
        contentResource.setSpokenLanguage( movieDomain.getContent().getSpokenLanguage() );
        contentResource.setReleaseDate( movieDomain.getContent().getReleaseDate() );
        contentResource.setImageUrl( movieDomain.getContent().getImageUrl() );
        contentResource.setTrailerUrl( movieDomain.getContent().getTrailerUrl() );
        contentResource.setIsAgeRestricted( movieDomain.getContent().getIsAgeRestricted() );
        contentResource.setGenres( genreListToGenreResourceList( movieDomain.getContent().getGenres() ) );
        contentResource.setActors( actorListToActorResourceList( movieDomain.getContent().getActors() ) );
        contentResource.setContentType( movieDomain.getContent().getContentType() );
        contentResource.setRuntime( movieDomain.getContent().getRuntime() );
        contentResource.setDirectors( directorListToDirectorResourceList(movieDomain.getDirectors() ));
        contentResource.setWriters( writerListToWriterResourceList (movieDomain.getWriters() ));


        List<Rating> ratings = ratingService.findRatings(movieDomain.getContent().getId());
        float rating = 0;
        for (Rating onlyRating: ratings){
            rating += onlyRating.getRating();
        }

        if(Float.isNaN(rating) || !(rating > 0 || rating <=10) || rating == 0){
            contentResource.setRating(0F);
        }
        else {
            contentResource.setRating(rating/ratings.size());
        }


        contentResource.setProfileNo(ratings.size());



        return contentResource;
    }







    protected DirectorResource directorToDirectorResource(Director director) {
        if ( director == null ) {
            return null;
        }

        DirectorResource directorResource = new DirectorResource();

        directorResource.setId( director.getId() );
        directorResource.setFullname( director.getFullname() );
        directorResource.setImageUrl( director.getImageUrl() );

        return directorResource;
    }

    protected List<DirectorResource> directorListToDirectorResourceList(List<Director> list) {
        if ( list == null ) {
            return null;
        }

        List<DirectorResource> list1 = new ArrayList<DirectorResource>( list.size() );
        for ( Director director : list ) {
            list1.add( directorToDirectorResource( director ) );
        }

        return list1;
    }


    protected Director directorResourceToDirector(DirectorResource directorResource) {
        if ( directorResource == null ) {
            return null;
        }

        Director.DirectorBuilder<?, ?> director = Director.builder();

        director.id( directorResource.getId() );
        director.fullname( directorResource.getFullname() );
        director.imageUrl( directorResource.getImageUrl() );

        return director.build();
    }

    protected List<Director> directorResourceListToDirectorList(List<DirectorResource> list) {
        if ( list == null ) {
            return null;
        }

        List<Director> list1 = new ArrayList<Director>( list.size() );
        for ( DirectorResource directorResource : list ) {
            list1.add( directorResourceToDirector( directorResource ) );
        }

        return list1;
    }








    protected WriterResource writerToWriterResource(Writer writer) {
        if ( writer == null ) {
            return null;
        }

        WriterResource writerResource = new WriterResource();

        writerResource.setId( writer.getId() );
        writerResource.setFullname( writer.getFullname() );
        writerResource.setImageUrl( writer.getImageUrl() );

        return writerResource;
    }

    protected List<WriterResource> writerListToWriterResourceList(List<Writer> list) {
        if ( list == null ) {
            return null;
        }

        List<WriterResource> list1 = new ArrayList<WriterResource>( list.size() );
        for ( Writer writer : list ) {
            list1.add( writerToWriterResource( writer ) );
        }

        return list1;
    }


    protected Writer writerResourceToWriter(WriterResource writerResource) {
        if ( writerResource == null ) {
            return null;
        }

        Writer.WriterBuilder<?, ?> writer = Writer.builder();

        writer.id( writerResource.getId() );
        writer.fullname( writerResource.getFullname() );
        writer.imageUrl( writerResource.getImageUrl() );

        return writer.build();
    }

    protected List<Writer> writerResourceListToWriterList(List<WriterResource> list) {
        if ( list == null ) {
            return null;
        }

        List<Writer> list1 = new ArrayList<Writer>( list.size() );
        for ( WriterResource writerResource : list ) {
            list1.add( writerResourceToWriter( writerResource ) );
        }

        return list1;
    }
















    @Override
    public List<ContentResource> moviesToContentResources(List<Movie> movieDomains) {
        if ( movieDomains == null ) {
            return null;
        }

        List<ContentResource> list = new ArrayList<ContentResource>( movieDomains.size() );
        for ( Movie movie : movieDomains ) {
            list.add(  movieToContentResource( movie ) );
        }

        return list;
    }

    @Override
    public List<Movie> contentResourcesToMovies(List<ContentResource> contentResources) {
        if ( contentResources == null ) {
            return null;
        }

        List<Movie> list = new ArrayList<Movie>( contentResources.size() );
        for ( ContentResource contentResource : contentResources ) {
            list.add( contentResourceToMovie( contentResource ) );
        }

        return list;
    }















    @Override
    public TVSeries contentResourceToTVSerie(ContentResource contentResource) {
        if ( contentResource == null ) {
            return null;
        }

        TVSeries.TVSeriesBuilder<?, ?> tvSeries = TVSeries.builder();
        Content.ContentBuilder<?, ?> content = Content.builder();

        tvSeries.id( contentResource.getId() );
        tvSeries.tvSeriesStatusType(contentResource.getTvSeriesStatusType());
        tvSeries.creators( creatorResourceListToCreatorList(contentResource.getCreators()) );
        tvSeries.seasons( seasonResourceListToSeasonList(contentResource.getSeasons()) );



        content.title( contentResource.getTitle() );
        content.description( contentResource.getDescription() );
        content.spokenLanguage( contentResource.getSpokenLanguage() );
        content.releaseDate( contentResource.getReleaseDate() );
        content.imageUrl( contentResource.getImageUrl() );
        content.trailerUrl( contentResource.getTrailerUrl() );
        content.isAgeRestricted( contentResource.getIsAgeRestricted() );
        content.genres( genreResourceListToGenreList(contentResource.getGenres()) );
        content.actors( actorResourceListToActorList(contentResource.getActors()) );
        content.contentType( contentResource.getContentType() );
        content.runtime( contentResource.getRuntime() );

        tvSeries.content( content.build() );

        return tvSeries.build();
    }

    @Override
    public ContentResource tvSerieToContentResource(TVSeries tvSeriesDomains) {
        if ( tvSeriesDomains == null ) {
            return null;
        }

        ContentResource contentResource = new ContentResource();

        contentResource.setId( tvSeriesDomains.getContent().getId() );
        contentResource.setTitle( tvSeriesDomains.getContent().getTitle() );
        contentResource.setDescription( tvSeriesDomains.getContent().getDescription() );
        contentResource.setSpokenLanguage( tvSeriesDomains.getContent().getSpokenLanguage() );
        contentResource.setReleaseDate( tvSeriesDomains.getContent().getReleaseDate() );
        contentResource.setImageUrl( tvSeriesDomains.getContent().getImageUrl() );
        contentResource.setTrailerUrl( tvSeriesDomains.getContent().getTrailerUrl() );
        contentResource.setIsAgeRestricted( tvSeriesDomains.getContent().getIsAgeRestricted() );
        contentResource.setGenres( genreListToGenreResourceList( tvSeriesDomains.getContent().getGenres() ) );
        contentResource.setActors( actorListToActorResourceList( tvSeriesDomains.getContent().getActors() ) );
        contentResource.setContentType( tvSeriesDomains.getContent().getContentType() );
        contentResource.setRuntime( tvSeriesDomains.getContent().getRuntime() );
        contentResource.setTvSeriesStatusType( tvSeriesDomains.getTvSeriesStatusType() );
        contentResource.setCreators( creatorListToCreatorResourceList(tvSeriesDomains.getCreators() ));
        contentResource.setSeasons( seasonListToSeasonResourceList (tvSeriesDomains.getSeasons() ));


        List<Rating> ratings = ratingService.findRatings(tvSeriesDomains.getContent().getId());
        float rating = 0;
        for (Rating onlyRating: ratings){
            rating += onlyRating.getRating();
        }

        if(Float.isNaN(rating) || !(rating > 0 || rating <=10) || rating == 0){
            contentResource.setRating(0F);
        }
        else {
            contentResource.setRating(rating/ratings.size());
        }


        contentResource.setProfileNo(ratings.size());



        return contentResource;
    }


    protected CreatorResource creatorToCreatorResource(Creator creator) {
        if ( creator == null ) {
            return null;
        }

        CreatorResource creatorResource = new CreatorResource();

        creatorResource.setId( creator.getId() );
        creatorResource.setFullname( creator.getFullname() );
        creatorResource.setImageUrl( creator.getImageUrl() );

        return creatorResource;
    }

    protected List<CreatorResource> creatorListToCreatorResourceList(List<Creator> list) {
        if ( list == null ) {
            return null;
        }

        List<CreatorResource> list1 = new ArrayList<CreatorResource>( list.size() );
        for ( Creator creator : list ) {
            list1.add( creatorToCreatorResource( creator ) );
        }

        return list1;
    }


    protected Creator creatorResourceToCreator(CreatorResource creatorResource) {
        if ( creatorResource == null ) {
            return null;
        }

        Creator.CreatorBuilder<?, ?> creator = Creator.builder();

        creator.id( creatorResource.getId() );
        creator.fullname( creatorResource.getFullname() );
        creator.imageUrl( creatorResource.getImageUrl() );

        return creator.build();
    }

    protected List<Creator> creatorResourceListToCreatorList(List<CreatorResource> list) {
        if ( list == null ) {
            return null;
        }

        List<Creator> list1 = new ArrayList<Creator>( list.size() );
        for ( CreatorResource creatorResource : list ) {
            list1.add( creatorResourceToCreator( creatorResource ) );
        }

        return list1;
    }


    //------------------------------Season------------------------------//
    protected SeasonResource seasonToSeasonResource(Season season) {
        if ( season == null ) {
            return null;
        }

        SeasonResource seasonResource = new SeasonResource();

        seasonResource.setId( season.getId() );
        seasonResource.setSeasonNo( season.getSeasonNo() );
        seasonResource.setEpisodes( episodeListToEpisodeResourceList(season.getEpisodes() ) );


        return seasonResource;
    }

    protected List<SeasonResource> seasonListToSeasonResourceList(List<Season> list) {
        if ( list == null ) {
            return null;
        }

        List<SeasonResource> list1 = new ArrayList<SeasonResource>( list.size() );
        for ( Season season : list ) {
            list1.add( seasonToSeasonResource( season ) );
        }

        return list1;
    }


    protected Season seasonResourceToSeason(SeasonResource seasonResource) {
        if ( seasonResource == null ) {
            return null;
        }

        Season.SeasonBuilder<?, ?> season = Season.builder();

        season.id( seasonResource.getId() );
        season.seasonNo( seasonResource.getSeasonNo() );
        season.episodes( episodeResourceListToEpisodeList(seasonResource.getEpisodes()));

        return season.build();
    }

    protected List<Season> seasonResourceListToSeasonList(List<SeasonResource> list) {
        if ( list == null ) {
            return null;
        }

        List<Season> list1 = new ArrayList<Season>( list.size() );
        for ( SeasonResource seasonResource : list ) {
            list1.add( seasonResourceToSeason( seasonResource ) );
        }

        return list1;
    }















    //------------------------------Episode------------------------------//
    protected EpisodeResource episodeToEpisodeResource(Episode episode) {
        if ( episode == null ) {
            return null;
        }

        EpisodeResource episodeResource = new EpisodeResource();

        episodeResource.setId( episode.getId() );
        episodeResource.setEpisodeNo( episode.getEpisodeNo() );
        episodeResource.setTitle( episode.getTitle() );
        episodeResource.setDescription( episode.getDescription() );
        episodeResource.setReleaseDate( episode.getReleaseDate() );
        episodeResource.setImageUrl( episode.getImageUrl() );
        return episodeResource;
    }

    protected List<EpisodeResource> episodeListToEpisodeResourceList(List<Episode> list) {
        if ( list == null ) {
            return null;
        }

        List<EpisodeResource> list1 = new ArrayList<EpisodeResource>( list.size() );
        for ( Episode episode : list ) {
            list1.add( episodeToEpisodeResource( episode ) );
        }

        return list1;
    }


    protected Episode episodeResourceToEpisode(EpisodeResource episodeResource) {
        if ( episodeResource == null ) {
            return null;
        }

        Episode.EpisodeBuilder<?, ?> episode = Episode.builder();

        episode.id( episodeResource.getId() );
        episode.episodeNo( episodeResource.getEpisodeNo() );
        episode.title(episodeResource.getTitle());
        episode.description(episodeResource.getDescription());
        episode.releaseDate(episodeResource.getReleaseDate());
        episode.imageUrl(episodeResource.getImageUrl());

        return episode.build();
    }

    protected List<Episode> episodeResourceListToEpisodeList(List<EpisodeResource> list) {
        if ( list == null ) {
            return null;
        }

        List<Episode> list1 = new ArrayList<Episode>( list.size() );
        for ( EpisodeResource episodeResource : list ) {
            list1.add( episodeResourceToEpisode( episodeResource ) );
        }

        return list1;
    }






















    @Override
    public List<ContentResource> tvSeriesToContentResources(List<TVSeries> tvSeriesDomains) {
        if ( tvSeriesDomains == null ) {
            return null;
        }

        List<ContentResource> list = new ArrayList<ContentResource>( tvSeriesDomains.size() );
        for ( TVSeries tvSeries : tvSeriesDomains ) {
            list.add(  tvSerieToContentResource( tvSeries ) );
        }

        return list;
    }

    @Override
    public List<TVSeries> contentResourcesToTVSeries(List<ContentResource> contentResources) {
        if ( contentResources == null ) {
            return null;
        }

        List<TVSeries> list = new ArrayList<TVSeries>( contentResources.size() );
        for ( ContentResource contentResource : contentResources ) {
            list.add( contentResourceToTVSerie( contentResource ) );
        }

        return list;
    }
}
