package com.example.shopbackend.DTO;

public class UserReviewBondDTO {

    private UserEntityDTO user;
    private ReviewEntityDTO review;

    protected UserReviewBondDTO() {
    }

    public UserReviewBondDTO(UserEntityDTO user, ReviewEntityDTO review) {
        this.user = user;
        this.review = review;
    }

    public UserEntityDTO getUser() {
        return user;
    }

    public void setUser(UserEntityDTO user) {
        this.user = user;
    }

    public ReviewEntityDTO getReview() {
        return review;
    }

    public void setReview(ReviewEntityDTO review) {
        this.review = review;
    }
}
