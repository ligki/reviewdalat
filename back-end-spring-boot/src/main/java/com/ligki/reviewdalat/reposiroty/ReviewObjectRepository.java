package com.ligki.reviewdalat.reposiroty;

import com.ligki.reviewdalat.model.entity.ReviewObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewObjectRepository extends PagingAndSortingRepository<ReviewObject, String> {
    Page<ReviewObject> findAllByType(String type, Pageable pageable);

    /**
     * Find top 10 review_object by type and sort by avr desc
     *
     * @param type refer ReviewObjectType
     * @return
     */
    @Query(value = "SELECT *, (r.rating1*1+r.rating2*2+r.rating3*3+r.rating4*4+r.rating5*5)/(rating1+rating2+rating3+rating4+rating5) as avr FROM review_object r WHERE type=:type AND active=1 ORDER BY avr DESC LIMIT 10 OFFSET :offset", nativeQuery = true)
    List<ReviewObject> findBestReviewObjectByType(@Param("type") int type, @Param("offset") int offset);

    /**
     * Find top 10 review_object by type and sort by avr asc
     *
     * @param type type refer ReviewObjectType
     * @return
     */
    @Query(value = "SELECT *, (r.rating1*1+r.rating2*2+r.rating3*3+r.rating4*4+r.rating5*5)/(rating1+rating2+rating3+rating4+rating5) as avr FROM review_object r WHERE type=:type AND active=1 ORDER BY avr ASC LIMIT 10 OFFSET :offset", nativeQuery = true)
    List<ReviewObject> findWorstReviewObjectByType(@Param("type") int type, @Param("offset") int offset);

    @Query(value = "SELECT name FROM review_object WHERE id = :id", nativeQuery = true)
    String findNameById(@Param("id") String id);

    @Query(value = "SELECT type FROM review_object WHERE id = :id", nativeQuery = true)
    String findTypeById(@Param("id") String id);

    Optional<ReviewObject> findById(String id);

    List<ReviewObject> findTop10ByNameContainingIgnoreCase(String query);

    int countByType(String type);
}
