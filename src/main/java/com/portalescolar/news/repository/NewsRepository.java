package com.portalescolar.news.repository;

import com.portalescolar.news.entity.News;

import com.portalescolar.news.entity.NewsStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface NewsRepository extends JpaRepository<News, UUID> {

    Page<News> findAllByStatus(String status, Pageable pageable);

    Page<News> findAllByStatusOrderByPublishedAtDesc(String status, Pageable pageable);

    Optional<News> findAllByIdAndStatus(UUID id, NewsStatus status);
}
