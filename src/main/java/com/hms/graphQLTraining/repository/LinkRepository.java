package com.hms.graphQLTraining.repository;

import com.hms.graphQLTraining.domain.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository {
    private final List<Link> linkList;

    public LinkRepository() {
        this.linkList = new ArrayList<>();

        linkList.add(new Link(1, "http://howtographql.com", "Your favorite GraphQL page"));
        linkList.add(new Link(2, "http://graphql.org/learn/", "The official docks"));
    }


    public List<Link> getLinkList() {
        return linkList;
    }

    public boolean saveLink(Link link) {
        return linkList.add(link);

//        SchemaParser.newParser()
//                .file
//                .resolvers()
//                .build()
    }
}
