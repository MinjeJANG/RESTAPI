package mj.project.eatgo.application;

import mj.project.eatgo.application.ReviewSerivce;
import mj.project.eatgo.domain.Review;
import mj.project.eatgo.domain.ReviewRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
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
    public void addReivew() {

        Review review = Review.builder()
                .name("JOKER")
                .score(3)
                .description("mat-tang")
                .build();

        reviewSerivce.addReview(1004L, review);

        verify(reviewRepository).save(any());

    }

}