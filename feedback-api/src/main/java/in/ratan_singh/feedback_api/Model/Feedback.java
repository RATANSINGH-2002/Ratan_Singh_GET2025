package in.ratan_singh.feedback_api.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

/**
    Entity representing user feedback.
    Uses JPA annotations for ORM mapping and validation annotations for input constraints.
    Fields:
    - id: Primary key, auto-generated.
    - name: Required, minimum 3 characters.
    - email: Required, must be a valid email format.
    - message: Required, minimum 10 characters.
    - createdAt: Timestamp of feedback creation.
 */

@Entity
@Data // Lombok: Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor // Lombok: Generates a no-args constructor
@AllArgsConstructor // Lombok: Generates a constructor with all fields
public class Feedback {

    /** Primary key for Feedback entity */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Name of the user submitting feedback (required, min 3 chars) */
    @NotBlank(message = "Name is required")
    @Size(min = 3, message = "Name must be at least 3 characters")
    private String name;

    /** Email of the user (required, must be valid format) */
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    /** Feedback message (required, min 10 chars) */
    @NotBlank(message = "Message is required")
    @Size(min = 10, message = "Message must be at least 10 characters")
    private String message;

    /** Timestamp when feedback was created */
    private LocalDateTime createdAt = LocalDateTime.now();
}