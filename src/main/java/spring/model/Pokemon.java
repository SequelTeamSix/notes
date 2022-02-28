package spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*Lombok will automatically generate getter/setter methods and constructors
using reflection and annotations at runtime
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Pokemon {
    private String name;
}
