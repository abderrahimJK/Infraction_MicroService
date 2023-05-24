package ma.enset.infraction.feign;

import ma.enset.infraction.model.Radar;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="RADAR-SERVICE")
public interface RadarRestClient {
    @GetMapping("/radars/{id}")
    Radar getRadarById(@RequestParam Long id);

}
