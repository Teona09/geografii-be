package org.geografii.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

@Entity
@Table(name = "question_model")
public class QuestionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId;
    @Column(name = "text", nullable = false)
    private String text;
    @Column(name = "hint", nullable = false)
    private String hint;
    @Column(name = "points", nullable = false)
    private Integer points;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "question_answer", joinColumns = @JoinColumn(name = "question_id"), inverseJoinColumns = @JoinColumn(name = "answer_id"))
    private Set<AnswerModel> answerModels = new HashSet<>();

    public QuestionModel() {
    }

    public QuestionModel(Long questionId, String text, String hint, Integer points, Set<AnswerModel> answers) {
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

    public Set<AnswerModel> getAnswerModels() {
        return answerModels;
    }

    public void setAnswerModels(Set<AnswerModel> answerModels) {
        this.answerModels = answerModels;
    }

    public void addAnswer(AnswerModel answer) {
        answerModels.add(answer);
    }

    public void removeAnswer(AnswerModel answer) {
        answerModels.remove(answer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionModel that = (QuestionModel) o;
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
