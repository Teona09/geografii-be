package org.geografii.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

public class UserModelDTO {
    private Long userId;
    @NotBlank
    @Size(min = 3, max = 30)
    private String firstName;
    @NotBlank
    @Size(min = 3, max = 30)
    private String lastName;
    @NotBlank
    @Size(min = 3, max = 45)
    @Email
    private String email;
    private String password;
    private Set<LevelModelDTO> levelModels = new HashSet<>();
    private Long usablePoints = Long.parseLong("0");
    private String roleModel;

    public UserModelDTO() {
    }

    public UserModelDTO(Long userId, @NotBlank @Size(min = 3, max = 30) String firstName, @NotBlank @Size(min = 3, max = 30) String lastName, @NotBlank @Size(min = 3, max = 45) @Email String email, @NotBlank @Size(min = 8, max = 30) String password, Set<LevelModelDTO> levelModels, Long usablePoints, String roleModel) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.levelModels = levelModels;
        this.usablePoints = usablePoints;
        this.roleModel = roleModel;
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

    public String getRoleModel() {
        return roleModel;
    }

    public void setRoleModel(String roleModels) {
        this.roleModel = roleModels;
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
        UserModelDTO that = (UserModelDTO) o;
        return Objects.equals(userId, that.userId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(levelModels, that.levelModels) && Objects.equals(usablePoints, that.usablePoints) && Objects.equals(roleModel, that.roleModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, email, password, levelModels, usablePoints, roleModel);
    }

    @Override
    public String toString() {
        return "UserModelDTO{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", levelModels=" + levelModels +
                ", usablePoints=" + usablePoints +
                ", roleModel='" + roleModel + '\'' +
                '}';
    }
}
