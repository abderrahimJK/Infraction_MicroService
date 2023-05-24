package ma.enset.infraction.mappers;

import ma.enset.infraction.entities.Infraction;
import ma.enset.infraction.web.grpc.stub.InfractionOuterClass;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class InfractionMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public InfractionOuterClass.Infraction fromClient(Infraction radar){
        return modelMapper.map(radar, InfractionOuterClass.Infraction.Builder.class).build();
    }
}
