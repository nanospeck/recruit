package com.heavenhr.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heavenhr.recruit.model.Application;

@Repository
public interface ApplicationsRepository extends JpaRepository<Application, Long> {

	List<Application> findByRelatedOffer(long id);

}