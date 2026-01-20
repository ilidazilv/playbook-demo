package dev.ilidaz.playbook.demo.models;

import dev.ilidaz.playbook.demo.enums.DemoType;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link dev.ilidaz.playbook.demo.entities.DemoEntity}
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DemoModel implements Serializable {
    private Long id;
    private String name;
    private DemoType type;
    private List<HostModel> hosts;
    private AddressModel address;
}