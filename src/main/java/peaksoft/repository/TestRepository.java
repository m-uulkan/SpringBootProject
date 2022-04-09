package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.model.Test;

public interface TestRepository extends JpaRepository<Test,Long> {
}
