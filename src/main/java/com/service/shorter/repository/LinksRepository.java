package com.service.shorter.repository;

 import com.service.shorter.domain.Link;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.jpa.repository.Modifying;
 import org.springframework.data.jpa.repository.Query;
 import org.springframework.data.repository.query.Param;
 import org.springframework.stereotype.Repository;
 import org.springframework.transaction.annotation.Transactional;

 import java.math.BigInteger;
 import java.sql.Timestamp;
 import java.util.Optional;

@Repository
public interface LinksRepository extends JpaRepository<Link,Long> {
    Optional<Link> findByGeneratedCode(String generatedCode);

    Optional<Link> findByHashedCode(int hashedCode);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO links (id,original_link, short_link, generated_code, generated_link, uuid, iterations, hashed_code,created_at, created_by, updated_at, updated_by) " +
            "SELECT :id,:originalLink, :shortLink, :generatedCode, :generatedLink, :uuid, :iterations, :hashedCode,:createdAt, :createdBy, :updatedAt, :updatedBy " +
            "WHERE NOT EXISTS (SELECT 1 FROM links WHERE hashed_code = :hashedCode)",
            nativeQuery = true)
    void insertIfNotExists(
            @Param("id") BigInteger id,
            @Param("originalLink") String originalLink,
            @Param("shortLink") String shortLink,
            @Param("generatedCode") String generatedCode,
            @Param("generatedLink") String generatedLink,
            @Param("uuid") String uuid,
            @Param("iterations") Integer iterations,
            @Param("hashedCode") Integer hashedCode,
            @Param("createdAt") Timestamp createdAt,
            @Param("createdBy") String createdBy,
            @Param("updatedAt") Timestamp updatedAt,
            @Param("updatedBy") String updatedBy
    );

}
