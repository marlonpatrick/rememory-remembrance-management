package io.mpwtech.randommemories.memoriesmanagement.rest.memory;

import java.time.ZonedDateTime;
import java.util.UUID;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.mpwtech.randommemories.memoriesmanagement.memory.CreateMemoryUseCase;
import io.mpwtech.randommemories.memoriesmanagement.memory.CreateMemoryUseCase.CreateMemoryUCRequest;
import io.mpwtech.randommemories.memoriesmanagement.memory.CreateMemoryUseCase.CreateMemoryUCResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@RestController
@RequestMapping("memories")
public class CreateMemoryRestController {

    private CreateMemoryUseCase createMemoryUseCase;

    public CreateMemoryRestController(CreateMemoryUseCase createMemoryUseCase) {
        this.createMemoryUseCase = createMemoryUseCase;
    }

    @PostMapping
    public CreateMemoryRestResponse createMemory(
            @RequestBody CreateMemoryRestRequest createMemoryRestRequest) {

        CreateMemoryUCResponse createMemoryUCResponse =
                this.createMemoryUseCase.execute(createMemoryRestRequest.toUseCaseRequest());

        return new CreateMemoryRestResponse(createMemoryUCResponse);
    }
}


@Getter
@Setter
@ToString
class CreateMemoryRestRequest {

    private String text;

    CreateMemoryUCRequest toUseCaseRequest() {
        return new CreateMemoryUCRequest(this.text);
    }
}


@Getter
@Setter
@ToString
class CreateMemoryRestResponse {

    private UUID id;

    private ZonedDateTime createdAt;

    private String text;

    CreateMemoryRestResponse(CreateMemoryUCResponse useCaseResponse) {
        super();
        this.id = useCaseResponse.id();
        this.createdAt = useCaseResponse.createdAt();
        this.text = useCaseResponse.text();
    }
}
