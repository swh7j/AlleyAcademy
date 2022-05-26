package app.Repository;

import app.Entity.AcademyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AcademyRepository extends JpaRepository<AcademyEntity, Long> {

    public final static String SELECT_AC_LIST_PAGED = ""
            + "SELECT "
            + "*"
            + " FROM academy WHERE 0 < id "
            + "ORDER BY id ASC LIMIT ?1, ?2";

    @Query(value = SELECT_AC_LIST_PAGED, nativeQuery = true)
    List<AcademyEntity> findFromTo(
            final Integer objectStartNum,
            final Integer objectEndNum
    );




}