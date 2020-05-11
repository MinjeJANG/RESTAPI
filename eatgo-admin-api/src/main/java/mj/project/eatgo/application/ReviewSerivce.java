package mj.project.eatgo.application;

import mj.project.eatgo.domain.Review;
import mj.project.eatgo.domain.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewSerivce {

    private ReviewRepository reivewRepository;

    @Autowired
    public ReviewSerivce(ReviewRepository reivewRepository) {
        this.reivewRepository = reivewRepository;
    }

    public List<Review> getReviews() {
        return reivewRepository.findAll();
    }
}
