package com.service.shorter.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LinkDTO {
    String originalLink;
    String shortLink;
    String generatedCode;
    String generatedLink;
}
