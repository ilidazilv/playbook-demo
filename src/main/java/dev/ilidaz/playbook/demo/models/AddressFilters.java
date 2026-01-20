package dev.ilidaz.playbook.demo.models;

import dev.ilidaz.playbook.base.filtering.annotations.FieldConfig;
import dev.ilidaz.playbook.base.filtering.annotations.FilterConfig;
import dev.ilidaz.playbook.base.filtering.enums.RelationType;
import dev.ilidaz.playbook.base.filtering.models.DoubleListFilters;
import dev.ilidaz.playbook.base.filtering.models.IntegerFilters;
import dev.ilidaz.playbook.base.filtering.models.StringFilters;
import dev.ilidaz.playbook.demo.entities.AddressEntity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FilterConfig(entityClass = AddressEntity.class)
public class AddressFilters implements Serializable {
    private IntegerFilters id;
    private StringFilters singleLine;
    private DoubleListFilters apartmentsNo;
    @FieldConfig(relationType = RelationType.MULTIPLE)
    private DemoFilters demos;
    private List<@NotNull AddressFilters> and;
    private List<@NotNull AddressFilters> or;
}
