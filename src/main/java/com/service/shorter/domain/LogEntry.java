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
@ToString
public class LogEntry extends BaseEntity implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
      Long id;
      String time;
      String remote_addr;
      String remote_user;
      String request;
      String status;
      String body_bytes_sent;
      String http_referer;
      String http_user_agent;
      String request_time;
      String upstream_response_time;
      String upstream_addr;
      String http_x_forwarded_for;
      String server_name;
      String host;
}
