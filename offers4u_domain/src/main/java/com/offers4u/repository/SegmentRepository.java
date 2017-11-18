package com.offers4u.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.offers4u.entity.Segment;

@Repository
public interface SegmentRepository extends JpaRepository<Segment, String> {

}
