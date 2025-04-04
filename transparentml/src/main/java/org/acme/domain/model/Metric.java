package org.acme.domain.model;

import lombok.*;
import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Metric {
    private UUID id;
    private String experimentId;
    private String name;
    private double value;
    private Instant timestamp;
}

