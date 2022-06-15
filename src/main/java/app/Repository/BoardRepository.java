package app.Repository;

import app.Entity.AcademyEntity;
import app.Entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    public final static String SELECT_AC_LIST_PAGED = ""
            + "SELECT "
            + "*"
            + " FROM board "
            + "ORDER BY bid ASC LIMIT ?1, ?2";

    @Query(value = SELECT_AC_LIST_PAGED, nativeQuery = true)
    List<BoardEntity> findFromTo(
            final Integer objectStartNum,
            final Integer objectEndNum
    );
}