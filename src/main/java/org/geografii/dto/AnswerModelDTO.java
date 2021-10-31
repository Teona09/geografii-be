package org.geografii.dto;

import java.util.Objects;

public class AnswerModelDTO {
    private Long answerId;
    private String text;
    private boolean isCorrectAnswer;

    public AnswerModelDTO() {
    }

    public AnswerModelDTO(Long answerId, String text, boolean isCorrectAnswer) {
        this.answerId = answerId;
        this.text = text;
        this.isCorrectAnswer = isCorrectAnswer;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrectAnswer() {
        return isCorrectAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        isCorrectAnswer = correctAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerModelDTO that = (AnswerModelDTO) o;
        return isCorrectAnswer == that.isCorrectAnswer && Objects.equals(answerId, that.answerId) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerId, text, isCorrectAnswer);
    }

    @Override
    public String toString() {
        return "AnswerModel{" +
                "answerId=" + answerId +
                ", text='" + text + '\'' +
                ", isCorrectAnswer=" + isCorrectAnswer +
                '}';
    }
}
