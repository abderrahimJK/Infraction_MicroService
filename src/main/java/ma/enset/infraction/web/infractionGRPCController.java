package ma.enset.infraction.web;

import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import ma.enset.infraction.entities.Infraction;
import ma.enset.infraction.mappers.InfractionMapper;
import ma.enset.infraction.repository.InfractionRepository;
import ma.enset.infraction.web.grpc.stub.InfractionGrpcServiceGrpc;
import ma.enset.infraction.web.grpc.stub.InfractionOuterClass;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;
import java.util.stream.Collectors;

@GrpcService
@AllArgsConstructor
public class infractionGRPCController extends InfractionGrpcServiceGrpc.InfractionGrpcServiceImplBase {

    InfractionRepository infractionRepository;
    InfractionMapper infractionMapper;

    @Override
    public void getListInfractions(InfractionOuterClass.GetAllInfractionsRequest request, StreamObserver<InfractionOuterClass.GetAllInfractionsResponse> responseObserver) {
        List<Infraction> radarList = infractionRepository.findAll();
        InfractionOuterClass.GetAllInfractionsResponse.Builder radarBuilder = InfractionOuterClass.GetAllInfractionsResponse.newBuilder();
        List<InfractionOuterClass.Infraction> infractions = radarList.stream().map(infractionMapper::fromClient).collect(Collectors.toList());
        radarBuilder.addAllInfractions(infractions);
        responseObserver.onNext(radarBuilder.build());
        responseObserver.onCompleted();
    }
}
