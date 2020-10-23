package io.mpwtech.rememory.remembrancemanagement.rest.remembrance;

import java.time.ZonedDateTime;
import java.util.UUID;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.mpwtech.rememory.remembrancemanagement.remembrance.CreateRemembranceUseCase;
import io.mpwtech.rememory.remembrancemanagement.remembrance.CreateRemembranceUseCase.CreateRemembranceUCRequest;
import io.mpwtech.rememory.remembrancemanagement.remembrance.CreateRemembranceUseCase.CreateRemembranceUCResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@RestController
@RequestMapping("remembrances")
public class CreateRemembranceRestController {

    private CreateRemembranceUseCase createRemembranceUseCase;

    public CreateRemembranceRestController(CreateRemembranceUseCase createRemembranceUseCase) {
        this.createRemembranceUseCase = createRemembranceUseCase;
    }

    @PostMapping
    public CreateRemembranceRestResponse createRemembrance(
            @RequestBody CreateRemembranceRestRequest createRemembranceRestRequest) {

        CreateRemembranceUCResponse createRemembranceUCResponse = this.createRemembranceUseCase
                .execute(createRemembranceRestRequest.toUseCaseRequest());

        return new CreateRemembranceRestResponse(createRemembranceUCResponse);
    }
}


@Getter
@Setter
@ToString
class CreateRemembranceRestRequest {

    private String text;

    CreateRemembranceUCRequest toUseCaseRequest() {
        return new CreateRemembranceUCRequest(this.text);
    }
}


@Getter
@Setter
@ToString
class CreateRemembranceRestResponse {

    private UUID id;

    private ZonedDateTime createdAt;

    private String text;

    CreateRemembranceRestResponse(CreateRemembranceUCResponse useCaseResponse) {
        super();
        this.id = useCaseResponse.id();
        this.createdAt = useCaseResponse.createdAt();
        this.text = useCaseResponse.text();
    }
}
