package com.barclay.hackathon.controllers;

import com.barclay.SwaggerCodgen.api.BookApi;
import com.barclay.SwaggerCodgen.model.BookDto;
import com.barclay.hackathon.mappers.BookMapper;
import com.barclay.hackathon.services.BookService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BookController implements BookApi {

    @Autowired
    private BookService bookService;

    private final BookMapper bookMapper = Mappers.getMapper(BookMapper.class);

    @Override
    public ResponseEntity<List<BookDto>> getBooks(Integer page, Integer limit) {
        return  ResponseEntity.ok(bookMapper.toListDto(bookService.getBooks(page, limit)));
    }

}
