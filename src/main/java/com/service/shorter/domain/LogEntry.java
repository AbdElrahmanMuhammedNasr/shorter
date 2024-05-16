package com.service.shorter.domain;

import com.service.shorter.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "logs")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogEntry extends BaseEntity implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    private String time;
    private String remoteAddr;
    private String request;
    private int status;
    private String httpUserAgent;
}
