package gdsc.board.repository;

import gdsc.board.domain.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBoardRepository extends JpaRepository<Data, Long> {
}