package com.service.shorter.domain;

import com.service.shorter.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;
import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "links")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Link extends BaseEntity implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(name = "original_link")
    String originalLink;

    @Column(name = "short_link")
    String shortLink;

    @Column(name = "generated_code")
    String generatedCode;

    @Column(name = "generated_link")
    String generatedLink;

    String uuid;

    int iterations;
    @Column(name = "hashed_code")
    int hashedCode;
}
