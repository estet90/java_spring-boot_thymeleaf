package ru.pianotest.stackexchangeApiClient.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 * Запрос на сайте
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StackExchangeResponse {

    @JsonProperty("question_id")
    private Long questionId;
    @JsonProperty("is_answered")
    private boolean answered;
    @JsonProperty("view_count")
    private Long viewCount;
    @JsonProperty("accepted_answer_id")
    private Long acceptedAnswerId;
    @JsonProperty("answer_count")
    private Long answerCount;
    @JsonProperty("score")
    private Long score;
    @JsonProperty("last_activity_date")
    private Long lastActivityDate;
    @JsonProperty("creation_date")
    private Long creationDate;
    @JsonProperty("last_edit_date")
    private Long lastEditDate;
    @JsonProperty("link")
    private String link;
    @JsonProperty("title")
    private String title;
    @JsonProperty("owner")
    private StackExchangeOwner stackExchangeOwner;
    @JsonProperty("tags")
    private List<String> tags;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public Long getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public void setAcceptedAnswerId(Long acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }

    public Long getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Long answerCount) {
        this.answerCount = answerCount;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Long getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Long lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }

    public Long getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Long lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public StackExchangeOwner getStackExchangeOwner() {
        return stackExchangeOwner;
    }

    public void setStackExchangeOwner(StackExchangeOwner stackExchangeOwner) {
        this.stackExchangeOwner = stackExchangeOwner;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
