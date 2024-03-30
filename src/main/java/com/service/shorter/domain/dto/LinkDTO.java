package com.service.shorter.domain.dto;

import lombok.Builder;

@Builder
public class LinkDTO {
    String originalLink;
    String shortLink;
    String generatedCode;
    String generatedLink;


}
