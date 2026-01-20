package dev.ilidaz.playbook.demo.models;

import dev.ilidaz.playbook.base.filtering.annotations.FieldConfig;
import dev.ilidaz.playbook.base.filtering.annotations.FilterConfig;
import dev.ilidaz.playbook.base.filtering.enums.RelationType;
import dev.ilidaz.playbook.base.filtering.models.EnumFilters;
import dev.ilidaz.playbook.base.filtering.models.IntegerFilters;
import dev.ilidaz.playbook.base.filtering.models.StringFilters;
import dev.ilidaz.playbook.demo.entities.DemoEntity;
import dev.ilidaz.playbook.demo.enums.DemoType;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FilterConfig(entityClass = DemoEntity.class)
public class DemoFilters implements Serializable {
    private StringFilters name;
    private IntegerFilters id;
    private AddressFilters address;
    @FieldConfig(path = "address.singleLine")
    private StringFilters singleLine;
    @FieldConfig(path = "type")
    private EnumFilters<DemoType> typeValue;
    @FieldConfig(relationType = RelationType.MULTIPLE)
    private HostFilters hosts;
    private List<@NotNull DemoFilters> and;
    private List<@NotNull DemoFilters> or;
}
