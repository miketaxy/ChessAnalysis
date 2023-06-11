package org.miketaxy.chessanalysis.ChessAnalysis.repository;

import org.miketaxy.chessanalysis.ChessAnalysis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
