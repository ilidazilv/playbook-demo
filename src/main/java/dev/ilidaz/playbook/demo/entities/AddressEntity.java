package dev.ilidaz.playbook.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class AddressEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "single_line")
    private String singleLine;

    @Column(name = "apartments_no")
    @JdbcTypeCode(SqlTypes.ARRAY)
    private Double[] apartmentsNo;
}
