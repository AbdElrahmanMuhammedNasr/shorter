package com.service.shorter.service;

import com.service.shorter.domain.dto.LinkDTO;
import com.service.shorter.vm.request.LinkVm;

public interface LinksService {
    LinkDTO getLink(LinkVm link);
}
