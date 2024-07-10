package com.example.LiquiStd.repository;

import java.util.List;

import com.example.LiquiStd.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAllBySchoolId(Long id);

    @Query("SELECT c FROM Course c " +
            "WHERE (:name IS NULL OR c.name LIKE %:name%) " +
            "AND (:fees IS NULL OR c.fees = :fees)")
    List<Course> searchCourse(@Param("name") String name, @Param("fees") Long fees);

}