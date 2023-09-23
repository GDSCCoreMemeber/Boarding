package GDSC.GDSC;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
public class BoardRequsetDto {

    private String context;
    private String writer;

    public Board toEntity(){
        return Board.builder()
                .context(context)
                .writer(writer)
                .build();
    }
}
