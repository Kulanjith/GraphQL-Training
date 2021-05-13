package com.hms.graphQLTraining.subscription;


import com.hms.graphQLTraining.domain.Comment;
import com.hms.graphQLTraining.repository.CommentRepository;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class CommentSubscriptionResolver implements GraphQLSubscriptionResolver {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentSubscriptionResolver(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    public Publisher<List<Comment>> comments(){
        return subscriber ->  Executors.newScheduledThreadPool(1).scheduleAtFixedRate(()->{
            List<Comment> comments = commentRepository.findCommentList();
            subscriber.onNext(comments);
            subscriber.onComplete();
        },0,2, TimeUnit.SECONDS);
    }

}
