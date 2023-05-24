package ma.enset.infraction.web;

import ma.enset.infraction.entities.Infraction;
import ma.enset.infraction.repository.InfractionRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class InfractionGraphQLController {

    InfractionRepository infractionRepository;

    public InfractionGraphQLController(InfractionRepository infractionRepository) {
        this.infractionRepository = infractionRepository;
    }

    @QueryMapping
    public List<Infraction> infractions(){
        return infractionRepository.findAll();
    }
}
