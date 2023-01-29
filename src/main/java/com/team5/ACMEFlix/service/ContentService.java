package com.team5.ACMEFlix.service;

import com.team5.ACMEFlix.domain.*;
import com.team5.ACMEFlix.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class ContentService {
    @Autowired
    private ContentRepository contentRepository;

    @Transactional(readOnly = true)
    public List<Content> findAllContents() {
        return contentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Content> findContentById(Long id) {
        return contentRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Content> advancedSearch (Integer pageNo, Integer pageSize, String search, String[] genres, String year, Boolean isAgeRestricted, String language, String contentType) {
        List<Content> contents = new ArrayList<>();
        Pageable paging = PageRequest.of(pageNo, pageSize);

        Page<Content> pageContents;


        if(isAgeRestricted == null && (genres==null || Arrays.stream(genres).toList().isEmpty()) )
            pageContents = contentRepository.findContentsByEverythingNoGenresAndNoIsAgeRestricted(search, year,  language, contentType, paging);
        else if(isAgeRestricted == null)
            pageContents = contentRepository.findContentsByEverythingNoIsAgeRestricted(search, genres, year,  language, contentType, paging);
        else if((genres==null || Arrays.stream(genres).toList().isEmpty()))
            pageContents = contentRepository.findContentsByEverythingNoGenre(search, year, isAgeRestricted, language, contentType, paging);
        else
            pageContents = contentRepository.findContentsByEverything(search, genres, year, isAgeRestricted, language, contentType, paging);

        contents = pageContents.getContent();
        return contents;
    }



}
