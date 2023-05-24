package ma.enset.infraction.web;

import ma.enset.infraction.entities.Infraction;
import ma.enset.infraction.feign.ImmatriculationRestClient;
import ma.enset.infraction.feign.RadarRestClient;
import ma.enset.infraction.model.Radar;
import ma.enset.infraction.model.Vehicule;
import ma.enset.infraction.repository.InfractionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class InfractionRestController {


    InfractionRepository infractionRepository;
    RadarRestClient radarRestClient;
    ImmatriculationRestClient immatriculationRestClient;

    public InfractionRestController(InfractionRepository infractionRepository, RadarRestClient radarRestClient, ImmatriculationRestClient immatriculationRestClient) {
        this.infractionRepository = infractionRepository;
        this.radarRestClient = radarRestClient;
        this.immatriculationRestClient = immatriculationRestClient;
    }

    @GetMapping("/infractions")
    public List<Infraction> getInfractions(){
        List<Infraction> list = infractionRepository.findAll();
        for (Infraction inf : list){
            Vehicule vehicule = immatriculationRestClient.getVehiculeById(inf.getVehicule_id());
            System.out.println(vehicule.getProprietaire().getNom());
//            vehicule.setProprietaire(immatriculationRestClient.getProprietaireById());
            inf.setRadar(radarRestClient.getRadarById(inf.getRadar_id()));
            inf.setVehicule(immatriculationRestClient.getVehiculeById(inf.getVehicule_id()));
        }

        return list;
    }

    @PostMapping("/infractions")
    public Infraction save(@RequestBody Infraction infraction){
        return infractionRepository.save(infraction);
    }

    @DeleteMapping("/infractions/{id}")
    public void DeleteInfraction(@PathVariable Long id){
        infractionRepository.deleteById(id);
    }

}
