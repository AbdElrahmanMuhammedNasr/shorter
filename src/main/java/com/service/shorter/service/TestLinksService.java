package com.service.shorter.service;

import com.service.shorter.domain.dto.LinkDTO;
import com.service.shorter.vm.request.LinkVm;

public interface TestLinksService {
    LinkDTO generateLink(LinkVm link);



}
