package com.service.shorter.repository;

 import com.service.shorter.domain.Link;
 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 import java.util.Optional;

@Repository
public interface LinksRepository extends JpaRepository<Link,Long> {
    Optional<Link> findByGeneratedCode(String generatedCode);

    Optional<Link> findByHashedCode(int hashedCode);


}
