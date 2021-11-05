package org.geografii.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

public class LevelModelDTO {

    private Long levelId;
    private String region;
    private Integer maximumPoints;
    private Set<InformationModelDTO> informationModels = new HashSet<>();
    private Set<QuestionModelDTO> questionModels = new HashSet<>();

    public LevelModelDTO() {
    }

    public LevelModelDTO(Long levelId, String region, Integer maximumPoints, Set<InformationModelDTO> informationModels, Set<QuestionModelDTO> questionModels) {
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

    public Set<InformationModelDTO> getInformationModels() {
        return informationModels;
    }

    public void setInformationModels(Set<InformationModelDTO> informationModels) {
        this.informationModels = informationModels;
    }

    public Set<QuestionModelDTO> getQuestionModels() {
        return questionModels;
    }

    public void setQuestionModels(Set<QuestionModelDTO> questionModels) {
        this.questionModels = questionModels;
    }

    public void addInformation(InformationModelDTO information) {
        informationModels.add(information);
    }

    public void removeInformation(InformationModelDTO information) {
        informationModels.remove(information);
    }

    public void addAnswer(QuestionModelDTO question) {
        questionModels.add(question);
    }

    public void removeAnswer(QuestionModelDTO question) {
        questionModels.remove(question);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LevelModelDTO that = (LevelModelDTO) o;
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
