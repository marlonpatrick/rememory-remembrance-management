package io.mpwtech.randommemories.memoriesmanagement.memory;

import org.springframework.stereotype.Service;
import io.mpwtech.randommemories.memoriesmanagement.memory.MemoryDomainDTOs.CreateMemoryRequestModel;
import io.mpwtech.randommemories.memoriesmanagement.memory.MemoryDomainDTOs.CreateMemoryResponseModel;

@Service
public class MemoryAppService {

    private MemoryRepository memoryRepository;

    public MemoryAppService(MemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;
    }

    public CreateMemoryResponseModel createMemory(CreateMemoryRequestModel memoryReqModel) {
        CreateMemoryUseCase useCase = new CreateMemoryUseCase(memoryRepository);
        Memory memory = useCase.execute(memoryReqModel);
        return new CreateMemoryResponseModel(memory.getId(), memory.getCreatedAt(),
                memory.getText());
    }
}
