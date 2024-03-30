package com.service.shorter.rest;

 import com.service.shorter.domain.dto.LinkDTO;
 import com.service.shorter.service.LinksService;
import com.service.shorter.vm.request.LinkVm;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
  import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/links")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LinksResources {

    LinksService linksService;

    @PostMapping("/generate")
    public LinkDTO generateShortLink(@RequestBody LinkVm link) {
        return linksService.getLink(link);
    }
}
