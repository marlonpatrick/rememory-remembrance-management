package io.mpwtech.randommemories.memoriesmanagement.memory;

import java.time.ZonedDateTime;
import java.util.UUID;

public class CreateMemoryUseCase {

    private MemoryRepository memoryRepository;

    CreateMemoryUseCase(MemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;
    }

    public CreateMemoryUCResponse execute(CreateMemoryUCRequest createMemoryUCRequest) {
        Memory memory = Memory.builder().text(createMemoryUCRequest.text()).build();

        memory = this.memoryRepository.create(memory);

        return new CreateMemoryUCResponse(memory.getId(), memory.getCreatedAt(), memory.getText());
    }

    public record CreateMemoryUCRequest(String text) {
    }


    public record CreateMemoryUCResponse(UUID id, ZonedDateTime createdAt, String text) {
    }
}
