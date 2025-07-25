package in.ratan_singh.feedback_api.ServiceTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import in.ratan_singh.feedback_api.Model.Feedback;
import in.ratan_singh.feedback_api.Service.FeedbackService;
import in.ratan_singh.feedback_api.Repository.FeedbackRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class FeedbackServiceTest {

    @Mock
    private FeedbackRepository feedbackRepository;

    @InjectMocks
    private FeedbackService feedbackService;

    @Test
    void testSaveFeedback() {

        // Test case to verify that saveFeedback method works correctly
        Feedback feedback = new Feedback();
        feedback.setName("John Doe");
        feedback.setEmail("john@example.com");
        feedback.setMessage("This is a feedback message.");

        when(feedbackRepository.save(any(Feedback.class))).thenReturn(feedback);

        // call the method under test
        Feedback saved = null;
        try {
            saved = feedbackService.saveFeedback(feedback);
        } catch (Exception e) {
            fail("Exception thrown during saveFeedback: " + e.getMessage());
        }

        // Assertion to verify the feedback was saved correctly
        assertNotNull(saved, "Saved feedback should not be null");
        assertEquals("John Doe", saved.getName(), "Name should match input");
        assertEquals("john@example.com", saved.getEmail(), "Email should match input");
        assertEquals("This is a feedback message.", saved.getMessage(), "Message should match input");
        verify(feedbackRepository, times(1)).save(feedback);

        // Debuging output
        System.out.println("Saved feedback: " + saved);
    }
}