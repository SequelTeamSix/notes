package spring.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*Lombok will automatically generate getter/setter methods and constructors
using reflection and annotations at runtime
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
//@Entity
//@Table
public class Pokemon {
//    @Id
//    @NonNull
//    private int pokeId;
//    @Column
    private String name;
}
