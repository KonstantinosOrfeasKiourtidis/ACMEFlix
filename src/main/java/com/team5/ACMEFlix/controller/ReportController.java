package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.mapper.ContentMapper;
import com.team5.ACMEFlix.service.ReportService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.AccountResourceViewingHistory;
import com.team5.ACMEFlix.transfer.resource.AccountViewingHours;
import com.team5.ACMEFlix.transfer.resource.ContentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/report")
public class ReportController {


    private final ReportService reportService;
    private final ContentMapper contentMapper;

    @Autowired
    private ReportController(ReportService reportService, ContentMapper contentMapper) {
        this.reportService = reportService;
        this.contentMapper = contentMapper;
    }

    @GetMapping("findTop10HighestRatedContent")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findTop10HighestRatedContent(){
        return  new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentMapper.toResources(reportService.findTop10HighestRatedContent())).build(), HttpStatus.OK);
    }

    @GetMapping("findTop10MostViewedContents")
    public ResponseEntity<ApiResponse<List<ContentResource>>> findTop10MostViewedContent(){
        return new ResponseEntity<>(ApiResponse.<List<ContentResource>>builder().data(contentMapper.toResources(reportService.findTop10MostViewedContent())).build(), HttpStatus.OK);
    }

    @GetMapping("findTop5MostPopularGenres")
    public ResponseEntity<ApiResponse<List<String>>> findTop5MostPopularGenres(){
        return new ResponseEntity<>(ApiResponse.<List<String>>builder().data(reportService.findTop5MostPopularGenres()).build(), HttpStatus.OK);
    }

    @GetMapping("findViewingHoursByAccountId/{id}")
    public ResponseEntity<ApiResponse<AccountViewingHours>> findViewingHoursByAccountId(@PathVariable("id") Long id){
        return new ResponseEntity<>(ApiResponse.<AccountViewingHours>builder().data(reportService.findViewingHoursByAccountId(id)).build(), HttpStatus.OK);
    }

    @GetMapping("findAllViewingHistory")
    public ResponseEntity<ApiResponse<List<AccountResourceViewingHistory>>> findAllViewingHistory() {
        return new ResponseEntity<>(ApiResponse.<List<AccountResourceViewingHistory>>builder().data(reportService.findAllViewingHistory()).build(), HttpStatus.OK);
    }
}
