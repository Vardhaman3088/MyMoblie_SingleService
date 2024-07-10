package com.glo.app.repository;
import com.glo.app.entity.SimDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface SimDetailsRepository extends JpaRepository<SimDetails, Integer> {

    Optional<SimDetails> findByServiceNumberAndSimNumber(Long ServiceNumber, Long simNumber);

    @Transactional
    @Modifying
    @Query("UPDATE SimDetails s SET s.simStatus = 'active' WHERE s.simId = :simId")
    void updateSimStatusBySimId(Integer simId);
}
