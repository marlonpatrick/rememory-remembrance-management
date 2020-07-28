package io.mpwtech.randommemories.memoriesmanagement.rest.memory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.mpwtech.randommemories.memoriesmanagement.memory.MemoryAppService;
import io.mpwtech.randommemories.memoriesmanagement.memory.MemoryDomainDTOs.CreateMemoryResponseModel;

@RestController
@RequestMapping("memories")
public class MemoryRestController {

    @Autowired
    private MemoryAppService memoryAppService;

    @PostMapping
    public CreateMemoryRespBody createMemory(@RequestBody CreateMemoryReqBody memoryBody) {
        CreateMemoryResponseModel domainResponseModel =
                this.memoryAppService.createMemory(memoryBody.toDomainRequestModel());
        return new CreateMemoryRespBody(domainResponseModel);
    }

}
