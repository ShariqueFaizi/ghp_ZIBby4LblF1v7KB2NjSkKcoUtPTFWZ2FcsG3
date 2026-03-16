package com.codepathway.api.repository;

import com.codepathway.api.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findBySheetIdOrderByOrderIndex(Long sheetId);
}
