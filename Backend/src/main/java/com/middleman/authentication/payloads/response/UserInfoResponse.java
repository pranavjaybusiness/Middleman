package com.middleman.authentication.payloads.response;

import java.time.LocalDateTime;
import java.util.List;

public class UserInfoResponse {
    private String id;
    private String email;
    private String profilePicture;
    private Boolean isVerified;
    private LocalDateTime createdAt;
    private int numberOfInterviews;
    private List<String> interviewedWith;
    private List<Integer> interviewScores;
    private String resume;
    private List<String> videoLinks;
    private List<String> roles;

    public UserInfoResponse(
        String id, String email, String profilePicture, Boolean isVerified,
        LocalDateTime createdAt, int numberOfInterviews, List<String> interviewedWith,
        List<Integer> interviewScores, String resume, List<String> videoLinks, List<String> roles
    ) {
        this.id = id;
        this.email = email;
        this.profilePicture = profilePicture;
        this.isVerified = isVerified;
        this.createdAt = createdAt;
        this.numberOfInterviews = numberOfInterviews;
        this.interviewedWith = interviewedWith;
        this.interviewScores = interviewScores;
        this.resume = resume;
        this.videoLinks = videoLinks;
        this.roles = roles;
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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
