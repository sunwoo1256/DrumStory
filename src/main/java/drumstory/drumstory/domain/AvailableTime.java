package drumstory.drumstory.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "available_time")
@Getter
@NoArgsConstructor
public class AvailableTime {
    @Id
    private int Id;
    private String ava_time;
}
