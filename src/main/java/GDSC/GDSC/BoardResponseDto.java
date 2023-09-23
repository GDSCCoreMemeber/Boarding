package GDSC.GDSC;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;

import java.sql.Timestamp;

@Getter
public class BoardResponseDto {
    private Long id;
    private String writer;
    private String context;
    private Timestamp createDate;
    private Timestamp modifyDate;

    @Builder
    public BoardResponseDto(Board board) {
        this.id=board.getId();
        this.writer = board.getWriter();
        this.context=board.getContext();
        this.createDate=board.getCreateDate();
        this.modifyDate=board.getModifyDate();
    }
}
