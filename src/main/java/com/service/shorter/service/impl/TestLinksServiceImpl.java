package com.service.shorter.service.impl;

import com.service.shorter.domain.Link;
import com.service.shorter.domain.dto.LinkDTO;
import com.service.shorter.repository.LinksRepository;
import com.service.shorter.service.TestLinksService;
import com.service.shorter.vm.request.LinkVm;
import jakarta.persistence.EntityManager;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TestLinksServiceImpl implements TestLinksService {
    LinksRepository linksRepository;
    EntityManager entityManager;

    private String getRandomString(LinkVm link){
        return  RandomStringUtils.randomAlphabetic(25);
    }
    private int gethash(LinkVm link){
        return link.getUrl().hashCode();
    }
    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
    public LinkDTO generateLink(LinkVm link) {


        String generateCode =getRandomString(link);
        int urlHashed = gethash(link);

        Optional<Link> linkOptional = linksRepository.findByGeneratedCode(generateCode);
        Optional<Link> linkOptional2 = linksRepository.findByGeneratedCode(generateCode);
//        if(!linkOptional.isPresent()) {
            Link buildLink = Link.builder()
                    .originalLink(link.getUrl())
                    .generatedCode(generateCode)
                    .generatedLink("http" + generateCode)
                    .uuid(UUID.randomUUID().toString())
                    .hashedCode(urlHashed)
                    .build();
            Link saveLink = linksRepository.save(buildLink);
            return LinkDTO.builder()
                    .originalLink(saveLink.getOriginalLink())
                    .shortLink(saveLink.getShortLink())
                    .generatedLink(saveLink.getGeneratedLink())
                    .generatedCode(saveLink.getGeneratedCode())
                    .build();
//        }
//        throw new CreateUrlException("Can Not Generate Link", HttpStatus.NOT_ACCEPTABLE);
    }

//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void test(){
//
//    }
}
