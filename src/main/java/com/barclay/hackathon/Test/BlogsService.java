//package com.barclay.hackathon.Test;
//
//import com.tej.JooQDemo.jooq.sample.model.Blogs;
//import com.tej.JooQDemo.jooq.sample.model.Tables;
//import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Blog;
//import org.jooq.DSLContext;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.awt.print.Book;
//import java.util.List;
//
//@Service
//public class BlogsService {
//
//    @Autowired
//    DSLContext context;
//
//    public List<Blog> getBlogs(){
//        return context
//                .selectFrom(Tables.BLOG)
//                .fetchInto(Blog.class);
//    }
//}
