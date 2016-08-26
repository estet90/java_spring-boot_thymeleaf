package ru.pianotest.stackexchangeApiClient.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Ответ, содержащий запросы на сайте
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StackExchangeResponseItems {

    @JsonProperty(value = "items")
    private List<StackExchangeResponse> responses;
    @JsonProperty(value = "has_more")
    private boolean hasMore;
    @JsonProperty(value = "quota_max")
    private Long quotaMax;
    @JsonProperty(value = "quota_remaining")
    private Long quotaRemaining;

    public List<StackExchangeResponse> getResponses() {
        return responses;
    }

    public void setResponses(List<StackExchangeResponse> responses) {
        this.responses = responses;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public Long getQuotaMax() {
        return quotaMax;
    }

    public void setQuotaMax(Long quotaMax) {
        this.quotaMax = quotaMax;
    }

    public Long getQuotaRemaining() {
        return quotaRemaining;
    }

    public void setQuotaRemaining(Long quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
    }
}
