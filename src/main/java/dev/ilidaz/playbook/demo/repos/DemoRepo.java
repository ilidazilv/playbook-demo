package dev.ilidaz.playbook.demo.repos;

import dev.ilidaz.playbook.demo.entities.DemoEntity;
import dev.ilidaz.playbook.demo.models.DemoFilters;
import dev.ilidaz.playbook.postgresql.global.repos.PlaybookRepo;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DemoRepo extends PlaybookRepo<DemoEntity, Long, DemoFilters> {
}
