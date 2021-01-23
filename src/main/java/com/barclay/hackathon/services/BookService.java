package com.barclay.hackathon.services;

import com.tej.JooQDemo.jooq.sample.model.Tables;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Book;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    DSLContext context;

    public List<Book> getBooks(int page, int limit){
        return context
                .selectFrom(Tables.BOOK)
                .orderBy((Tables.BOOK.BOOKID))
                .seek(page*limit)
                .limit(limit)
                .fetchInto(Book.class);
    }
}
