package com.ligki.reviewdalat.reposiroty;

import com.ligki.reviewdalat.model.entity.ReviewObject;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewObjectRepository extends CrudRepository<ReviewObject, String> {
    List<ReviewObject> findTop10ByTypeOrderByLastUpdateDesc(String type);

    /**
     * Find top 10 review_object by type and sort by avr desc
     *
     * @param type refer ReviewObjectType
     * @return
     */
    @Query(value = "SELECT *, (r.rating1*1+r.rating2*2+r.rating3*3+r.rating4*4+r.rating5*5)/(rating1+rating2+rating3+rating4+rating5) as avr FROM review_object r WHERE type=:type AND active=1 ORDER BY avr DESC LIMIT 10", nativeQuery = true)
    List<ReviewObject> findBestReviewObjectByType(@Param("type") String type);

    /**
     * Find top 10 review_object by type and sort by avr asc
     *
     * @param type type refer ReviewObjectType
     * @return
     */
    @Query(value = "SELECT *, (r.rating1*1+r.rating2*2+r.rating3*3+r.rating4*4+r.rating5*5)/(rating1+rating2+rating3+rating4+rating5) as avr FROM review_object r WHERE type=:type AND active=1 ORDER BY avr ASC LIMIT 10", nativeQuery = true)
    List<ReviewObject> findWorstReviewObjectByType(@Param("type") String type);
}
