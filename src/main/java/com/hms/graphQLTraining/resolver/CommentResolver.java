package com.hms.graphQLTraining.resolver;

import com.hms.graphQLTraining.domain.Comment;
import com.hms.graphQLTraining.repository.CommentRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
class CommentQueryResolver implements GraphQLQueryResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentQueryResolver.class);

    private final CommentRepository commentRepository;

    public CommentQueryResolver(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> findCommentList() {
        LOGGER.info("Request all the comments");
        final List<Comment> commentList = commentRepository.findCommentList();
        LOGGER.info("Requested all the comments [{}]", commentList.size());
        return commentList;
    }

}


@Component
class CommentMutationResolver implements GraphQLMutationResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentMutationResolver.class);

    private final CommentRepository commentRepository;

    public CommentMutationResolver(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Boolean saveComment(Long id, String title, LocalDateTime createdAt) {
        LOGGER.info("Saving [ id: {}, title: {}, createdAt: {}]", id, title, createdAt);
        return commentRepository.saveComment(new Comment(id, title, createdAt));
    }
}
