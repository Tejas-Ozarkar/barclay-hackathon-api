package com.barclay.hackathon.mappers;

import com.barclay.SwaggerCodgen.model.AuthResponse;
import com.barclay.SwaggerCodgen.model.BookDto;
import com.barclay.SwaggerCodgen.model.UserDto;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Book;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    BookDto toDto(Book book);
    Book toEntity(BookDto dto);
    List<BookDto> toListDto(List<Book> books);
    List<Book> toListEntity(List<BookDto> books);

}
