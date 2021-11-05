package org.geografii.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

@Entity
@Table(name = "user_model")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", length = 24)
    private String password;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_level", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "level_id"))
    private Set<LevelModel> levelModels = new HashSet<>();
    @Column(name = "usable_points", nullable = false)
    private Long usablePoints;

    public UserModel() {
    }

    public UserModel(Long userId, String firstName, String lastName, String email, String password, Set<LevelModel> levelModels, Long usablePoints) {
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

    public Set<LevelModel> getLevelModels() {
        return levelModels;
    }

    public void setLevelModels(Set<LevelModel> levelModels) {
        this.levelModels = levelModels;
    }

    public Long getUsablePoints() {
        return usablePoints;
    }

    public void setUsablePoints(Long usablePoints) {
        this.usablePoints = usablePoints;
    }

    public void addLevel(LevelModel level) {
        levelModels.add(level);
    }

    public void removeLevel(LevelModel level) {
        levelModels.remove(level);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
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
