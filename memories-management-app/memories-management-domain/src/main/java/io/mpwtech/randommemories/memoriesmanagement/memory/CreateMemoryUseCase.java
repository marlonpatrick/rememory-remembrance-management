package io.mpwtech.randommemories.memoriesmanagement.memory;

import io.mpwtech.randommemories.memoriesmanagement.memory.MemoryDomainDTOs.CreateMemoryRequestModel;

class CreateMemoryUseCase {

    private MemoryRepository memoryRepository;

    CreateMemoryUseCase(MemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;
    }

    Memory execute(CreateMemoryRequestModel memoryReqModel) {
        Memory memory = Memory.builder().text(memoryReqModel.text()).build();

        return this.memoryRepository.create(memory);
    }

}
