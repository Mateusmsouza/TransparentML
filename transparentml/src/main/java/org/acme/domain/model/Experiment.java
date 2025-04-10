package org.acme.domain.model;

import lombok.*;
import java.util.List;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Experiment {
    private String name;
    private String user;
    private String description;
    private List<String> tags;
    private Instant createdAt;
}