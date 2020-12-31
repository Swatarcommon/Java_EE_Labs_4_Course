package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Reference {
    int id;
    String url;
    String description;
    int minus;
    int plus;
}
