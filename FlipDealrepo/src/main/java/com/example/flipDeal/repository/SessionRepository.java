package com.example.flipDeal.repository;

import com.example.flipDeal.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long> {

    @Override
     Session save(Session session);

    Optional<Session> findByToken(String token);
}
