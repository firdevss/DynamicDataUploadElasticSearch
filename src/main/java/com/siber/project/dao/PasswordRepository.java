package com.siber.project.dao;

import com.siber.project.entity.Password;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PasswordRepository extends ElasticsearchRepository<Password, String> {
    Optional<String> findByName(@Param("name") String name);
}
