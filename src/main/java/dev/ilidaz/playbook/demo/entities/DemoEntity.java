package dev.ilidaz.playbook.demo.entities;

import dev.ilidaz.playbook.demo.enums.DemoType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "demo")
public class DemoEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    private DemoType type;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;
}
