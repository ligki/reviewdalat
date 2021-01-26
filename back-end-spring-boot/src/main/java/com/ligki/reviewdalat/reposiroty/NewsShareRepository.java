package com.ligki.reviewdalat.reposiroty;

import com.ligki.reviewdalat.model.entity.NewsShare;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NewsShareRepository extends PagingAndSortingRepository<NewsShare, String> {

    @Query(value = "SELECT * FROM news_share WHERE active = 1 ORDER BY created ASC LIMIT 10 OFFSET :offset", nativeQuery = true)
    List<NewsShare> findAll(@Param("offset") int offset);

    Optional<NewsShare> findById(String id);
}
