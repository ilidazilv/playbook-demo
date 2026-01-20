package dev.ilidaz.playbook.demo.models;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link dev.ilidaz.playbook.demo.entities.HostEntity}
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HostModel implements Serializable {
    private Long id;
    private String name;
}