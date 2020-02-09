
package com.example.mysofra.data.model.clientAddCommit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientAddCommitData {

    @SerializedName("review")
    @Expose
    private ClientAddCommitReview review;

    public ClientAddCommitReview getReview() {
        return review;
    }

    public void setReview(ClientAddCommitReview review) {
        this.review = review;
    }

}
