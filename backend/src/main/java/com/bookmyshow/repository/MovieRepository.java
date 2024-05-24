package com.bookmyshow.repository;

import com.bookmyshow.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "select * from movies order by created_at desc", nativeQuery = true)
    List<Movie> findAll();

    @Modifying
    @Transactional
    @Query(value = "delete from movies where id = :id", nativeQuery = true)
    void deleteById(Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from movies", nativeQuery = true)
    void deleteAll(Long id);

//
//
//
//
//    @Query(value = "select * from batches b where b.batch_name = :name and b.is_active is true and b.is_deleted is false limit 1", nativeQuery = true)
//    Batches findByBatchName(String name);
//
//
//
//

//    @Modifying
//    @Transactional
//    @Query(value = "update batches set is_deleted = true where id IN (:ids)", nativeQuery = true)
//    void deleteByIdIn(List<Long> ids);
//
//    @Modifying
//    @Transactional
//    @Query(value = "update batches set is_deleted = true where branch_id = :branchId", nativeQuery = true)
//    void deleteByBranchId(Long branchId);
//
//    @Modifying
//    @Transactional
//    @Query(value = """
//            update batches set is_deleted = true
//            WHERE branch_id IN
//                  (SELECT id FROM branches WHERE organization_id = :organizationId)
//          """, nativeQuery = true)
//    void deleteByOrganizationId(Long organizationId);
//
//    @Query(value = "select * from batches b where b.branch_id in (:branchIds) and b.is_active is true and b.is_deleted is false", nativeQuery = true)
//    List<Batches> findAllByBranchIdIn(Set<Long> branchIds);

}
