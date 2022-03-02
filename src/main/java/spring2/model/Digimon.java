package spring2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Digimon")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Digimon {
    @Id
    private int digimonID;
    @Column
    private String name;
    @Column
    private int power;

}
