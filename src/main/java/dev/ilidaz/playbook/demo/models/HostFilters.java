package dev.ilidaz.playbook.demo.models;

import dev.ilidaz.playbook.base.filtering.models.IntegerFilters;
import dev.ilidaz.playbook.base.filtering.models.StringFilters;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HostFilters implements Serializable {
    private IntegerFilters id;
    private StringFilters name;
    private List<@NotNull HostFilters> and;
    private List<@NotNull HostFilters> or;
}
