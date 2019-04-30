package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Player {
    public String name;
    public int playerNum;
    public int age;
    public String gender;
    public String clanName;
}
