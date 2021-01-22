package com.ligki.reviewdalat.reposiroty;

import com.ligki.reviewdalat.model.entity.NewsShare;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NewsShareRepository extends CrudRepository<NewsShare, String> {
    List<NewsShare> findTop10ByOrderByCreatedAsc();

    Optional<NewsShare> findById(String id);
}
