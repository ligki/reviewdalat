package com.ligki.reviewdalat.reposiroty;

import com.ligki.reviewdalat.model.entity.ReviewObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewObjectRepository extends CrudRepository<ReviewObject, String> {
    List<ReviewObject> findTop10ByTypeOrderByLastUpdateDesc(String type);
}
