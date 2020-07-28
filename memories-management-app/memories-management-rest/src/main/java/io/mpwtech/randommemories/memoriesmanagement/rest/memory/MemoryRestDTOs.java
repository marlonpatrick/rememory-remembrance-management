package io.mpwtech.randommemories.memoriesmanagement.rest.memory;

import java.time.ZonedDateTime;
import java.util.UUID;
import io.mpwtech.randommemories.memoriesmanagement.memory.MemoryDomainDTOs.CreateMemoryRequestModel;
import io.mpwtech.randommemories.memoriesmanagement.memory.MemoryDomainDTOs.CreateMemoryResponseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
class CreateMemoryReqBody {

    private String text;

    CreateMemoryRequestModel toDomainRequestModel() {
        return new CreateMemoryRequestModel(this.text);
    }
}


@Getter
@ToString
class CreateMemoryRespBody {

    private UUID id;

    private ZonedDateTime createdAt;

    private String text;

    CreateMemoryRespBody(CreateMemoryResponseModel domainResponseModel) {
        super();
        this.id = domainResponseModel.id();
        this.createdAt = domainResponseModel.createdAt();
        this.text = domainResponseModel.text();
    }
}
