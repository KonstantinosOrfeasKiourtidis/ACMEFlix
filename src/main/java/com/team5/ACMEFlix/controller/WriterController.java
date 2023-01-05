package com.team5.ACMEFlix.controller;

import com.team5.ACMEFlix.domain.Writer;
import com.team5.ACMEFlix.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/content/movie/writer")
public class WriterController {

    private final WriterService writerService;
    @Autowired
    private WriterController(WriterService writerService) {
        this.writerService = writerService;
    }

    @GetMapping
    public ResponseEntity<List<Writer> > findAllWriters(){
        return new ResponseEntity<>(writerService.findAllWriters(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Writer> findWriterById(@PathVariable("id") Long id){
        return writerService.findWriterById(id);
    }

    @GetMapping("findAllWritersByContentId/{id}")
    public ResponseEntity<List<Writer>> findAllWritersByContentId(@PathVariable("id") Long id){
        return new ResponseEntity<>(writerService.findAllWritersByContentId(id), HttpStatus.OK);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addWriterByContentId/{id}")
    public void addWriterByContentId(@RequestBody Writer writer, @PathVariable("id") Long id){



        writerService.addWriterByContentId(writer, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addWritersByContentId/{id}")
    public void addWritersByContentId(@RequestBody Writer[] writers, @PathVariable("id") Long id){



        writerService.addWritersByContentId(writers, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addWriterByMovieId/{id}")
    public void addWriterByMovieId(@RequestBody Writer writer, @PathVariable("id") Long id){



        writerService.addWriterByMovieId(writer, id);
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addWritersByMovieId/{id}")
    public void addWritersByMovieId(@RequestBody Writer[] writers, @PathVariable("id") Long id){



        writerService.addWritersByMovieId(writers, id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteWriterById/{id}")
    public void deleteWriterById(@PathVariable("id") Long id){
        writerService.deleteWriterById(id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "deleteWritersByIds/{ids}")
    public void deleteWritersByIds(@PathVariable("ids") Long[] ids){
        writerService.deleteWritersByIds(ids);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping(path = "updateWriterById/{id}")
    public void updateWriterById(
            @RequestBody Writer writer,
            @PathVariable("id") Long id
    ){
        writerService.updateWriterById(writer, id);
    }
}
