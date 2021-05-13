package com.hms.graphQLTraining.repository;

import com.hms.graphQLTraining.domain.Comment;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class CommentRepository {

    private final List<Comment> commentList;

    public CommentRepository() {
        this.commentList = new ArrayList<>();
        commentList.add(new Comment(1, "This is good", LocalDateTime.now()));
        commentList.add(new Comment(1, "This is even better", LocalDateTime.now()));
        commentList.add(new Comment(2, "This is awesome", LocalDateTime.now()));
        commentList.add(new Comment(3, "This is not good", LocalDateTime.now()));
        commentList.add(new Comment(4, "This is wonderful", LocalDateTime.now()));
        commentList.add(new Comment(5, "This is somewhat good", LocalDateTime.now()));


    }


    public  List<Comment> findCommentList() {
        return Collections.unmodifiableList(commentList);
    }

    public Boolean saveComment(Comment comment) {
        return commentList.add(comment);
    }
}
