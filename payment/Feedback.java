/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payment;

/**
 *
 * @author USer
 */
public class Feedback {
    public String feedbackName;
    public String feedbackComment;
    public String feedbackRating;

    public Feedback(String feedbackName, String feedbackComment, String feedbackRating) {
        this.feedbackName = feedbackName;
        this.feedbackComment = feedbackComment;
        this.feedbackRating = feedbackRating;
    }

    public String getFeedbackName() {
        return feedbackName;
    }

    public String getFeedbackComment() {
        return feedbackComment;
    }

    public String getFeedbackRating() {
        return feedbackRating;
    }

    public void setFeedbackName(String feedbackName) {
        this.feedbackName = feedbackName;
    }

    public void setFeedbackComment(String feedbackComment) {
        this.feedbackComment = feedbackComment;
    }

    public void setFeedbackRating(String feedbackRating) {
        this.feedbackRating = feedbackRating;
    }

    @Override
    public String toString() {
        return "Feedback{" + "feedbackName=" + feedbackName + ", feedbackComment=" + feedbackComment + ", feedbackRating=" + feedbackRating + '}';
    }
    
    
}
