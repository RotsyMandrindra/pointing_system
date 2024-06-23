package hei.school.pointingsystem;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Person {
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
}
