package io.mpwtech.randommemories.memoriesmanagement.memory;

import java.time.ZonedDateTime;
import java.util.UUID;

public class MemoryDomainDTOs {

    public record CreateMemoryRequestModel(String text) {
    }


    public record CreateMemoryResponseModel(UUID id, ZonedDateTime createdAt, String text) {
    }
}
