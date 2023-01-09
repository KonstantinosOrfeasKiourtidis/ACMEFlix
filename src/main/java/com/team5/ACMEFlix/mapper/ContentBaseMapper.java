package com.team5.ACMEFlix.mapper;

import java.util.List;

public interface ContentBaseMapper<CD, CR, MD, TD>{

    //Content
    CD resourceToDomain(CR contentResource);

    CR domainToResource(CD contentDomain);

    List<CR> domainToResources(List<CD> contentDomains);
    List<CD> resourceToDomains(List<CR> contentResources);


    //Movie
    MD contentResourceToMovie(CR contentResource);

    CR movieToContentResource(MD movieDomain);

    List<CR> moviesToContentResources(List<MD> movieDomains);
    List<MD> contentResourcesToMovies(List<CR> contentResources);




    //TV Series

    TD contentResourceToTVSerie(CR contentResource);

    CR tvSerieToContentResource(TD tvSeriesDomains);

    List<CR> tvSeriesToContentResources(List<TD> tvSeriesDomains);
    List<TD> contentResourcesToTVSeries(List<CR> contentResources);

}
