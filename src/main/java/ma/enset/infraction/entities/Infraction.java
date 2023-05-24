package ma.enset.infraction.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.infraction.model.Radar;
import ma.enset.infraction.model.Vehicule;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Infraction {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Long radar_id;
    private Long vehicule_id;
    private double vitesse_vehicule;
    private double vitesseMax;
    private double montant;
    private boolean state;
    @Transient
    private Vehicule vehicule;
    @Transient
    private Radar radar;
}
