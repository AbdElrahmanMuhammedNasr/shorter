package com.service.shorter.service.impl;

import com.service.shorter.config.LinksConfig;
import com.service.shorter.domain.Link;
import com.service.shorter.domain.dto.LinkDTO;
import com.service.shorter.domain.mapper.LinkMapper;
import com.service.shorter.repository.LinksRepository;
 import com.service.shorter.service.LinksService;
import com.service.shorter.vm.request.LinkVm;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LinksServiceImpl implements LinksService {

    LinksRepository linksRepository;
    LinksConfig linksConfig;
//    LinkMapper linkMapper;


    @Override
    public LinkDTO getLink(LinkVm link) {
        for (int i = 0; i < linksConfig.iteration(); i++) {
            String generateCode = RandomStringUtils.randomAlphabetic(linksConfig.length());
            int urlHashed = link.hashCode();
            linksRepository.findByHashedCode(urlHashed).ifPresent(foundLink -> {
                throw new RuntimeException("Link already exists");
            });

            Optional<Link> linkOptional = linksRepository.findByGeneratedCode(generateCode);
            if(!linkOptional.isPresent()) {
                Link buildLink = Link.builder()
                        .originalLink(link.getUrl())
                        .shortLink(linksConfig.shortHost())
                        .generatedCode(generateCode)
                        .generatedLink(linksConfig.shortHost() + generateCode)
                        .uuid(UUID.randomUUID().toString())
                        .iterations(i)
                        .hashedCode(urlHashed)
                        .build();
                Link saveLink = linksRepository.save(buildLink);
                return LinkDTO.builder()
                        .originalLink(saveLink.getOriginalLink())
                        .shortLink(saveLink.getShortLink())
                        .build();
            }

        }

        throw new RuntimeException("Can Not Generate Link");
    }
}
