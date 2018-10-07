package com.heavenhr.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heavenhr.recruit.model.Offer;

@Repository
public interface OffersRepository extends JpaRepository<Offer, Long> {

}