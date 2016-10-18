package ru.kononov.stackexchangeApiClient.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * автор запроса
 */
public class StackExchangeOwner {

    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("user_type")
    private String userType;
    @JsonProperty("accept_rate")
    private Long acceptRate;
    @JsonProperty("reputation")
    private Long reputation;
    @JsonProperty("profile_image")
    private String profileImage;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("link")
    private String link;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Long getAcceptRate() {
        return acceptRate;
    }

    public void setAcceptRate(Long acceptRate) {
        this.acceptRate = acceptRate;
    }

    public Long getReputation() {
        return reputation;
    }

    public void setReputation(Long reputation) {
        this.reputation = reputation;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
