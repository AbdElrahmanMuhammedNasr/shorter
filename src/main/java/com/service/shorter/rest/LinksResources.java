package com.service.shorter.rest;

 import com.service.shorter.domain.dto.LinkDTO;
 import com.service.shorter.service.LinksService;
import com.service.shorter.vm.request.LinkVm;
 import jakarta.servlet.http.HttpServletResponse;
 import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;

 import java.io.IOException;

@RestController
@RequestMapping("/v1/api/links")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LinksResources {

    LinksService linksService;

    @PostMapping("/generate")
    public ResponseEntity<LinkDTO> generateShortLink(@RequestBody LinkVm link) {
        return  ResponseEntity.ok(linksService.generateLink(link));
    }

    @GetMapping("/{code}")
    public void redrict(@PathVariable("code") String code ,  HttpServletResponse response) throws IOException {
        LinkDTO linkDTO = linksService.returnLink(code);
        response.sendRedirect(linkDTO.getOriginalLink());
    }
}
