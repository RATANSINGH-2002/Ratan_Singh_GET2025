package in.ratan_singh.feedback_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import in.ratan_singh.feedback_api.Model.Feedback;

/**
Repository interface for Feedback entity.
Extends JpaRepository to provide CRUD operations.
No need to implement methods; Spring Data JPA provides them.
 */

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    
}
