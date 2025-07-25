package in.ratan_singh.feedback_api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.ratan_singh.feedback_api.Model.Feedback;
import in.ratan_singh.feedback_api.Repository.FeedbackRepository;

/**
    Service class for feedback business logic.
    Uses Spring's @Service annotation for service layer.
    Handles feedback persistence and retrieval.
    Catches exceptions and prints debug/error statements.
 */

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    // Saves a feedback entry to the database.

    public Feedback saveFeedback(Feedback feedback) {
        try {
            System.out.println("Saving feedback: " + feedback);
            Feedback saved = feedbackRepository.save(feedback);
            System.out.println("Feedback saved: " + saved);
            return saved;
        } catch (Exception e) {
            System.err.println("Error saving feedback: " + e.getMessage());
            throw e;
        }
    }

    //Retrieves all feedback entries from the database.
    public List<Feedback> getAllFeedbacks() {
        try {
            System.out.println("Retrieving all feedbacks.");
            List<Feedback> feedbackList = feedbackRepository.findAll();
            System.out.println("Number of feedbacks retrieved: " + feedbackList.size());
            return feedbackList;
        } catch (Exception e) {
            System.err.println("Error retrieving feedbacks: " + e.getMessage());
            throw e; 
        }
    }
}