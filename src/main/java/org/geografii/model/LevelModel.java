package org.geografii.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

@Entity
@Table(name = "level_model")
public class LevelModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_id")
    private Long levelId;
    @Column(name = "region", nullable = false)
    private String region;
    @Column(name = "maximum_points", nullable = false)
    private Integer maximumPoints;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "level_information", joinColumns = @JoinColumn(name = "level_id"), inverseJoinColumns = @JoinColumn(name = "information_id"))
    private Set<InformationModel> informationModels = new HashSet<>();
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "level_question", joinColumns = @JoinColumn(name = "level_id"), inverseJoinColumns = @JoinColumn(name = "question_id"))
    private Set<QuestionModel> questionModels = new HashSet<>();

    public LevelModel() {
    }

    public LevelModel(Long levelId, String region, Integer maximumPoints, Set<InformationModel> informationModels, Set<QuestionModel> questionModels) {
        this.levelId = levelId;
        this.region = region;
        this.maximumPoints = maximumPoints;
        this.informationModels = informationModels;
        this.questionModels = questionModels;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getMaximumPoints() {
        return maximumPoints;
    }

    public void setMaximumPoints(Integer maximumPoints) {
        this.maximumPoints = maximumPoints;
    }

    public Set<InformationModel> getInformationModels() {
        return informationModels;
    }

    public void setInformationModels(Set<InformationModel> informationModels) {
        this.informationModels = informationModels;
    }

    public Set<QuestionModel> getQuestionModels() {
        return questionModels;
    }

    public void setQuestionModels(Set<QuestionModel> questionModels) {
        this.questionModels = questionModels;
    }

    public void addInformation(InformationModel information) {
        informationModels.add(information);
    }

    public void removeInformation(InformationModel information) {
        informationModels.remove(information);
    }

    public void addAnswer(QuestionModel question) {
        questionModels.add(question);
    }

    public void removeAnswer(QuestionModel question) {
        questionModels.remove(question);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LevelModel that = (LevelModel) o;
        return Objects.equals(levelId, that.levelId) && Objects.equals(region, that.region) && Objects.equals(maximumPoints, that.maximumPoints) && Objects.equals(informationModels, that.informationModels) && Objects.equals(questionModels, that.questionModels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(levelId, region, maximumPoints, informationModels, questionModels);
    }

    @Override
    public String toString() {
        return "LevelModel{" +
                "levelId=" + levelId +
                ", region='" + region + '\'' +
                ", maximumPoints=" + maximumPoints +
                ", informationModels=" + informationModels +
                ", questionModels=" + questionModels +
                '}';
    }
}
