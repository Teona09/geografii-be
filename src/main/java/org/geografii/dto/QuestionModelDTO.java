package org.geografii.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

public class QuestionModelDTO {
    private Long questionId;
    private String text;
    private String hint;
    private Integer points;
    private Set<AnswerModelDTO> answerModels = new HashSet<>();

    public QuestionModelDTO() {
    }

    public QuestionModelDTO(Long questionId, String text, String hint, Integer points, Set<AnswerModelDTO> answers) {
        this.questionId = questionId;
        this.text = text;
        this.hint = hint;
        this.points = points;
        this.answerModels = answers;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Set<AnswerModelDTO> getAnswerModels() {
        return answerModels;
    }

    public void setAnswerModels(Set<AnswerModelDTO> answerModels) {
        this.answerModels = answerModels;
    }

    public void addAnswer(AnswerModelDTO answer) {
        answerModels.add(answer);
    }

    public void removeAnswer(AnswerModelDTO answer) {
        answerModels.remove(answer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionModelDTO that = (QuestionModelDTO) o;
        return Objects.equals(questionId, that.questionId) && Objects.equals(text, that.text) && Objects.equals(hint, that.hint) && Objects.equals(points, that.points) && Objects.equals(answerModels, that.answerModels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, text, hint, points, answerModels);
    }

    @Override
    public String toString() {
        return "QuestionModel{" +
                "questionId=" + questionId +
                ", text='" + text + '\'' +
                ", hint='" + hint + '\'' +
                ", points=" + points +
                ", answerModels=" + answerModels +
                '}';
    }
}
