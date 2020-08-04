package io.mpwtech.randommemories.memoriesmanagement.memory;

import java.time.ZonedDateTime;
import java.util.UUID;
import org.springframework.stereotype.Service;
import io.mpwtech.randommemories.memoriesmanagement.common.Outbox;
import io.mpwtech.randommemories.memoriesmanagement.event.DomainMessagePublisher;
import io.mpwtech.randommemories.memoriesmanagement.memory.MemoryEvents.MemoryCreatedEvent;

@Service
public class CreateMemoryUseCase {

    private MemoryRepository memoryRepository;

    private DomainMessagePublisher messagePublisher;

    CreateMemoryUseCase(DomainMessagePublisher eventPublisher, MemoryRepository memoryRepository) {
        this.messagePublisher = eventPublisher;
        this.memoryRepository = memoryRepository;
    }

    public CreateMemoryUCResponse execute(CreateMemoryUCRequest createMemoryUCRequest) {
        Memory memory = createMemoryUCRequest.toMemory();

        memory = this.memoryRepository.save(memory);

        CreateMemoryUCResponse createMemoryUCResponse = CreateMemoryUCResponse.from(memory);

        this.messagePublisher.publish(Outbox.event(memory, MemoryCreatedEvent.from(memory)));

        return createMemoryUCResponse;
    }

    public record CreateMemoryUCRequest(String text) {

        private Memory toMemory() {
            return Memory.builder().text(this.text).build();
        }
    }


    public record CreateMemoryUCResponse(UUID id, ZonedDateTime createdAt, String text) {

        private static CreateMemoryUCResponse from(Memory memory) {
            return new CreateMemoryUCResponse(memory.getId(), memory.getCreatedAt(),
                    memory.getText());
        }
    }
}
