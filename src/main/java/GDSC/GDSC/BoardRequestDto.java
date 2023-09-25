package GDSC.GDSC;

import lombok.Getter;

@Getter
public class BoardRequestDto {

    private String context;
    private String writer;

    public Board toEntity(){
        return Board.builder()
                .context(context)
                .writer(writer)
                .build();
    }
}
