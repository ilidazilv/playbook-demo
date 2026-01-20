package dev.ilidaz.playbook.demo.models;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link dev.ilidaz.playbook.demo.entities.AddressEntity}
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressModel implements Serializable {
    private Long id;
    private String singleLine;
    private Double[] apartmentsNo;
}