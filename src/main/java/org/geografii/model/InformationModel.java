package org.geografii.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "information_model")
public class InformationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "information_id")
    private Long informationId;
    @Column(name = "image_url", nullable = false)
    private String imageUrl;
    @Column(name = "text", nullable = false)
    private String text;

    public InformationModel() {
    }

    public InformationModel(Long informationId, String imageUrl, String text) {
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
        InformationModel that = (InformationModel) o;
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
