package com.middleman.authentication.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

@Document(collection = "users")
public class User {
    @Id
    private String id;

    private String email;
    private String password;
    private String profilePicture; // URL to profile picture
    private Boolean isVerified; // Email verification status
    private LocalDateTime createdAt; // User account creation timestamp
    private int numberOfInterviews; // Number of interviews completed

    private List<String> interviewedWith; // Array of interviewer IDs
    private List<Integer> interviewScores; // Array of interview scores
    private String resume; // URL to the resume
    private List<String> videoLinks; // Array of URLs to recorded interviews

    @DBRef
    private Set<Role> roles = new HashSet<>();

    public User() {
        this.createdAt = LocalDateTime.now(); // Set registration time
        this.isVerified = false; // Default to false until verified
        this.numberOfInterviews = 0; // Default value
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.createdAt = LocalDateTime.now();
        this.isVerified = false;
        this.numberOfInterviews = 0;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getNumberOfInterviews() {
        return numberOfInterviews;
    }

    public void setNumberOfInterviews(int numberOfInterviews) {
        this.numberOfInterviews = numberOfInterviews;
    }

    public List<String> getInterviewedWith() {
        return interviewedWith;
    }

    public void setInterviewedWith(List<String> interviewedWith) {
        this.interviewedWith = interviewedWith;
    }

    public List<Integer> getInterviewScores() {
        return interviewScores;
    }

    public void setInterviewScores(List<Integer> interviewScores) {
        this.interviewScores = interviewScores;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public List<String> getVideoLinks() {
        return videoLinks;
    }

    public void setVideoLinks(List<String> videoLinks) {
        this.videoLinks = videoLinks;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
