package mj.project.eatgo.application;

import mj.project.eatgo.domain.Review;
import mj.project.eatgo.domain.ReviewRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class ReviewSerivceTest {


    private ReviewSerivce reviewSerivce;

    @Mock
    private ReviewRepository reviewRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        reviewSerivce = new ReviewSerivce(reviewRepository);
    }

    @Test
    public void getReviews() {
        List<Review> mockreviews = new ArrayList<>();
        mockreviews.add(Review.builder().description("Cool").build());
        given(reviewRepository.findAll()).willReturn(mockreviews);

        List<Review> reviews = reviewSerivce.getReviews();

        Review review = reviews.get(0);

        assertThat(review.getDescription(), is("Cool"));
    }

}