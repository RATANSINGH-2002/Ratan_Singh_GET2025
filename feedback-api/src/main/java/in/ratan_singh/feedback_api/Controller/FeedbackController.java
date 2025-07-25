package in.ratan_singh.feedback_api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import in.ratan_singh.feedback_api.Model.Feedback;
import in.ratan_singh.feedback_api.Service.FeedbackService;
import jakarta.validation.Valid;

/** Has following features:
    Provides RESTful API endpoints for feedback submission and retrieval.
    Controller for handling feedback-related API requests.
    Uses REST endpoints for feedback submission and retrieval.
    Returns appropriate HTTP responses and logs errors.
    Prints debug statements for key actions.
 */

@RestController
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    // Endpoint to handle the root path.
    @GetMapping("/")
    public String home() {
        System.out.println("Home endpoint accessed.");
        return "Welcome to feedback application";
    }

    // Endpoint to submit feedback.
    @PostMapping("/feedback")
    public ResponseEntity<?> createFeedback(@Valid @RequestBody Feedback feedback) {
        System.out.println("Received feedback: " + feedback);
        try {
            Feedback savedFeedback = feedbackService.saveFeedback(feedback);
            System.out.println("Feedback saved: " + savedFeedback);
            return ResponseEntity.ok(savedFeedback);
        } catch (Exception e) {
            System.err.println("Failed to save feedback: " + e.getMessage());
            return ResponseEntity.badRequest().body("Error saving feedback: " + e.getMessage());
        }
    }

    // Endpoint to get all feedbacks.
    @GetMapping("/feedbacks")
    public ResponseEntity<?> getAllFeedbacks() {
        System.out.println("Fetching all feedbacks.");
        try {
            List<Feedback> feedbackList = feedbackService.getAllFeedbacks();
            System.out.println("Feedbacks fetched: " + feedbackList.size());
            return ResponseEntity.ok(feedbackList);
        } catch (Exception e) {
            System.err.println("Failed to fetch feedbacks: " + e.getMessage());
            return ResponseEntity.internalServerError().body("Error fetching feedbacks: " + e.getMessage());
        }
    }
}