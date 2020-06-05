package mj.project.eatgo.interfaces;

import mj.project.eatgo.application.SessionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class SessionController {

    @PostMapping("/session")

    public ResponseEntity<SessionDto> create() throws URISyntaxException {

        String accessToken = "ACCESSTOKEN";

        String url = "/session";

        return ResponseEntity.created(new URI(url))
                .body(SessionDto.builder()
                                .accessToken(accessToken)
                                .build());
    }


}
