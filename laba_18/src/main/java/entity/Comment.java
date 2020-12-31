package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class Comment {
    int id;
    int refId;
    String sessionId;
    String user;
    Date stamp;
    String comment;
}
