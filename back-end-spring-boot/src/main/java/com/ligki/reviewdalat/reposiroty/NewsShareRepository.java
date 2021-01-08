package com.ligki.reviewdalat.reposiroty;

import com.ligki.reviewdalat.model.entity.NewsShare;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsShareRepository extends CrudRepository<NewsShare, Integer> {
    List<NewsShare> findTop10ByOrderByCreatedAsc();
}
