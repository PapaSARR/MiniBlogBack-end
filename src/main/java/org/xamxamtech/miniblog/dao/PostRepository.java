package org.xamxamtech.miniblog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.xamxamtech.miniblog.entities.Post;


@CrossOrigin("*")
@RepositoryRestResource
public interface PostRepository extends JpaRepository<Post,Long> {
    @RestResource(path = "/article")
    Post findOneByName(@Param("pn") String post_name);
}
