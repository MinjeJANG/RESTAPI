package mj.project.eatgo.application;

import mj.project.eatgo.domain.Review;
import mj.project.eatgo.domain.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewSerivce {

    private ReviewRepository reivewRepository;

    @Autowired
    public ReviewSerivce(ReviewRepository reivewRepository) {
        this.reivewRepository = reivewRepository;
    }

    public Review addReview(Long restaurantId, String name, Integer score, String description) {

        Review review = Review.builder()
                .restaurantId(restaurantId)
                .name(name)
                .score(score)
                .description(description)
                .build();

        return reivewRepository.save(review);
    }
}
