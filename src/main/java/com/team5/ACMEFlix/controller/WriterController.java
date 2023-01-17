package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.mapper.WriterMapper;
import com.team5.ACMEFlix.service.WriterService;
import com.team5.ACMEFlix.transfer.ApiResponse;
import com.team5.ACMEFlix.transfer.resource.WriterResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path = "api/v1/content/movie/writer")
public class WriterController {

    private final WriterService writerService;
    private final WriterMapper writerMapper;
    @Autowired
    private WriterController(WriterService writerService, WriterMapper writerMapper) {
        this.writerService = writerService;
        this.writerMapper = writerMapper;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<WriterResource>>> findAllWriters(){
        return  new ResponseEntity<>(ApiResponse.<List<WriterResource>>builder().data(writerMapper.toResources(writerService.findAllWriters())).build(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<WriterResource>> findWriterById(@PathVariable("id") Long id){
        return  new ResponseEntity<>(ApiResponse.<WriterResource>builder().data(writerMapper.toResource(writerService.findWriterById(id).get())).build(), HttpStatus.OK);
    }

    @GetMapping("findAllWritersByContentId/{id}")
    public ResponseEntity<ApiResponse<List<WriterResource>>> findAllWritersByContentId(@PathVariable("id") Long id){
        return  new ResponseEntity<>(ApiResponse.<List<WriterResource>>builder().data(writerMapper.toResources(writerService.findAllWritersByContentId(id))).build(), HttpStatus.OK);
    }

    @PostMapping(path = "addWriterByContentId/{id}")
    public ResponseEntity<ApiResponse<WriterResource>> addWriterByContentId(@PathVariable("id") Long id, @Valid @RequestBody WriterResource writer){
        return  new ResponseEntity<>(ApiResponse.<WriterResource>builder().data(writerMapper.toResource(writerService.addWriterByContentId(id, writerMapper.toDomain(writer)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addWritersByContentId/{id}")
    public ResponseEntity<ApiResponse<List<WriterResource>>> addWritersByContentId(@PathVariable("id") Long id, @Valid @RequestBody List<WriterResource> writers){
        return  new ResponseEntity<>(ApiResponse.<List<WriterResource>>builder().data(writerMapper.toResources(writerService.addWritersByContentId(id, writerMapper.toDomains(writers)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addWriterByMovieId/{id}")
    public ResponseEntity<ApiResponse<WriterResource>> addWriterByMovieId(@PathVariable("id") Long id, @Valid @RequestBody WriterResource writer){
        return  new ResponseEntity<>(ApiResponse.<WriterResource>builder().data(writerMapper.toResource(writerService.addWriterByMovieId(id, writerMapper.toDomain(writer)))).build(), HttpStatus.CREATED);
    }

    @PostMapping(path = "addWritersByMovieId/{id}")
    public ResponseEntity<ApiResponse<List<WriterResource>>> addWritersByMovieId(@PathVariable("id") Long id, @Valid @RequestBody List<WriterResource> writers ){
        return  new ResponseEntity<>(ApiResponse.<List<WriterResource>>builder().data(writerMapper.toResources(writerService.addWritersByMovieId(id, writerMapper.toDomains(writers)))).build(), HttpStatus.CREATED);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteWriterById/{id}")
    public void deleteWriterById(@PathVariable("id") Long id){
        writerService.deleteWriterById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteWritersByIds/{ids}")
    public void deleteWritersByIds(@PathVariable("ids") List<Long> ids){
        writerService.deleteWritersByIds(ids);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateWriterById/{id}")
    public void updateWriterById(
            @PathVariable("id") Long id,
            @Valid @RequestBody WriterResource writer
    ){
        writerService.updateWriterById(id, writerMapper.toDomain(writer));
    }
}
