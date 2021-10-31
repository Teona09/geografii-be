package org.geografii.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

public class UserModelDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<LevelModelDTO> levelModels = new HashSet<>();
    private Long usablePoints;

    public UserModelDTO() {
    }

    public UserModelDTO(Long userId, String firstName, String lastName, String email, String password, Set<LevelModelDTO> levelModels, Long usablePoints) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.levelModels = levelModels;
        this.usablePoints = usablePoints;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<LevelModelDTO> getLevelModels() {
        return levelModels;
    }

    public void setLevelModels(Set<LevelModelDTO> levelModels) {
        this.levelModels = levelModels;
    }

    public Long getUsablePoints() {
        return usablePoints;
    }

    public void setUsablePoints(Long usablePoints) {
        this.usablePoints = usablePoints;
    }

    public void addLevel(LevelModelDTO level) {
        levelModels.add(level);
    }

    public void removeLevel(LevelModelDTO level) {
        levelModels.remove(level);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModelDTO userModel = (UserModelDTO) o;
        return Objects.equals(userId, userModel.userId) && Objects.equals(firstName, userModel.firstName) && Objects.equals(lastName, userModel.lastName) && Objects.equals(email, userModel.email) && Objects.equals(password, userModel.password) && Objects.equals(levelModels, userModel.levelModels) && Objects.equals(usablePoints, userModel.usablePoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, email, password, levelModels, usablePoints);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", levelModels=" + levelModels +
                ", usablePoints=" + usablePoints +
                '}';
    }
}
