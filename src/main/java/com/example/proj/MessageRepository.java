package com.example.proj;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
