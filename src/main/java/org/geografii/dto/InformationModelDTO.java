package org.geografii.dto;

import java.util.Objects;

public class InformationModelDTO {
    private Long informationId;
    private String imageUrl;
    private String text;

    public InformationModelDTO() {
    }

    public InformationModelDTO(Long informationId, String imageUrl, String text) {
        this.informationId = informationId;
        this.imageUrl = imageUrl;
        this.text = text;
    }

    public Long getInformationId() {
        return informationId;
    }

    public void setInformationId(Long informationId) {
        this.informationId = informationId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InformationModelDTO that = (InformationModelDTO) o;
        return Objects.equals(informationId, that.informationId) && Objects.equals(imageUrl, that.imageUrl) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(informationId, imageUrl, text);
    }

    @Override
    public String toString() {
        return "InformationModel{" +
                "informationId=" + informationId +
                ", imageUrl='" + imageUrl + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
