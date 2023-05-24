package ma.enset.infraction;

import ma.enset.infraction.entities.Infraction;
import ma.enset.infraction.feign.ImmatriculationRestClient;
import ma.enset.infraction.feign.RadarRestClient;
import ma.enset.infraction.model.Proprietaire;
import ma.enset.infraction.model.Radar;
import ma.enset.infraction.model.Vehicule;
import ma.enset.infraction.repository.InfractionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class InfractionApplication {


    public static void main(String[] args) {
        SpringApplication.run(InfractionApplication.class, args);
    }

    @Bean
    CommandLineRunner start(InfractionRepository infractionRepository,
                            ImmatriculationRestClient immatriculationRestClient,
                            RadarRestClient radarRestClient
    ){
        return args -> {
//            Vehicule vehicule = immatriculationRestClient.getVehiculeById(1L);
//            Radar radar = radarRestClient.getRadarById(1L);
//            infractionRepository.save(
//                    new Infraction().builder()
//                            .date(new Date())
//                            .vehicule_id(vehicule.getId())
//                            .radar_id(radar.getId())
//                            .vitesseMax(120)
//                            .vitesse_vehicule(130)
//                            .vehicule(vehicule)
//                            .radar(radar)
//                            .montant(600)
//                            .build()
//            );

        };
    }


}
