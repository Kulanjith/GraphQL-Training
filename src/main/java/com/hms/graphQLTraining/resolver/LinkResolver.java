package com.hms.graphQLTraining.resolver;

import com.hms.graphQLTraining.domain.Link;
import com.hms.graphQLTraining.repository.LinkRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
class LinkQueryResolver implements GraphQLQueryResolver {

    private final LinkRepository linkRepository;

    public LinkQueryResolver(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public List<Link> findLinkList() {
        return linkRepository.getLinkList();
    }
}


@Component
class LinkMutationResolver implements GraphQLMutationResolver {

    private final LinkRepository linkRepository;

    public LinkMutationResolver(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public Boolean saveLink(long id, String url, String description) {
        return linkRepository.saveLink(new Link(id, url, description));
    }
}