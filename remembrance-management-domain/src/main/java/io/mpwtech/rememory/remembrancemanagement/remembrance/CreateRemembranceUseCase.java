package io.mpwtech.rememory.remembrancemanagement.remembrance;

import java.time.ZonedDateTime;
import java.util.UUID;
import org.springframework.stereotype.Service;
import io.mpwtech.rememory.remembrancemanagement.remembrance.RemembranceEvents.RemembranceCreatedEvent;

@Service
public class CreateRemembranceUseCase {

    private RemembranceRepository remembranceRepository;

    CreateRemembranceUseCase(RemembranceRepository remembranceRepository) {
        this.remembranceRepository = remembranceRepository;
    }

    public CreateRemembranceUCResponse execute(
            CreateRemembranceUCRequest createRemembranceUCRequest) {

        Remembrance remembrance = createRemembranceUCRequest.toRemembrance();
        remembrance.setCreatedAt(ZonedDateTime.now());

        remembrance.addOutboxMessage(RemembranceCreatedEvent.from(remembrance));

        remembrance = this.remembranceRepository.insert(remembrance);

        return CreateRemembranceUCResponse.from(remembrance);
    }

    public record CreateRemembranceUCRequest(String text) {

        private Remembrance toRemembrance() {
            return Remembrance.builder().text(this.text).build();
        }
    }


    public record CreateRemembranceUCResponse(UUID id, ZonedDateTime createdAt, String text) {

        private static CreateRemembranceUCResponse from(Remembrance remembrance) {
            return new CreateRemembranceUCResponse(remembrance.getId(), remembrance.getCreatedAt(),
                    remembrance.getText());
        }
    }
}
