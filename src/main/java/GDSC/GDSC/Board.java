package GDSC.GDSC;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.lang.annotation.Target;

@Entity
@Table(name = "board")
@Data
@Builder
@NoArgsConstructor
public class Board extends BaseTimeEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String context;

    private String writer;

    @Builder
    public Board(Long id, String context, String writer) {
        this.id = id;
        this.context = context;
        this.writer = writer;
    }

    public void update(BoardRequsetDto requsetDto) {
        this.writer= requsetDto.getWriter();
        this.context=requsetDto.getContext();
    }
}
