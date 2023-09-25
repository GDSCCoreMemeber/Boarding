package GDSC.GDSC;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "board")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    public void update(BoardRequestDto requestDto) {
        this.writer= requestDto.getWriter();
        this.context=requestDto.getContext();
    }

}
