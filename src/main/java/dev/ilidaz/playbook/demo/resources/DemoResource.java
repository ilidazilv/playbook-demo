package dev.ilidaz.playbook.demo.resources;

import dev.ilidaz.playbook.demo.models.DemoFilters;
import dev.ilidaz.playbook.demo.models.DemoModel;
import dev.ilidaz.playbook.demo.repos.DemoRepo;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
@ApplicationScoped
@RequiredArgsConstructor
public class DemoResource {
    private final DemoRepo demoRepo;

    @Query
    public List<DemoModel> find(DemoFilters filters, Integer page, Integer size) {
        return demoRepo.playbookFind(filters, page, size).stream().map(i -> DemoModel.builder()
                .id(i.getId())
                .name(i.getName())
                .build()
        ).toList();
    }

    @Query
    public Long count(DemoFilters filters) {
        return demoRepo.playbookCount(filters);
    }
}
