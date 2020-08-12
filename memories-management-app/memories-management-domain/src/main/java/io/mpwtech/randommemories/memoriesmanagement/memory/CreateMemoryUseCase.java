package io.mpwtech.randommemories.memoriesmanagement.memory;

import java.time.ZonedDateTime;
import java.util.UUID;
import org.springframework.stereotype.Service;
import io.mpwtech.randommemories.memoriesmanagement.memory.MemoryEvents.MemoryCreatedEvent;

@Service
public class CreateMemoryUseCase {

    private MemoryRepository memoryRepository;

    CreateMemoryUseCase(MemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;
    }

    public CreateMemoryUCResponse execute(CreateMemoryUCRequest createMemoryUCRequest) {
        Memory memory = createMemoryUCRequest.toMemory();
        memory.setCreatedAt(ZonedDateTime.now());

        memory.addOutboxMessage(MemoryCreatedEvent.outboxMessage(memory));

        memory = this.memoryRepository.insert(memory);

        return CreateMemoryUCResponse.from(memory);
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
