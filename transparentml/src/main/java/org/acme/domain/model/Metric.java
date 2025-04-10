package org.acme.domain.model;

import lombok.*;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Metric {
    private String experimentId;
    private String name;
    private double value;
    private int step;
    private Instant timestamp;
}

