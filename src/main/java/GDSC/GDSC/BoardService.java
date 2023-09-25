package GDSC.GDSC;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;

    public Long write(BoardRequestDto requestDto) {
      return boardRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<BoardResponseDto> getList() {
       return boardRepository.findAll().stream()
               .map(BoardResponseDto::new)
               .collect(Collectors.toList());
    }

    public Long update(Long boardId, BoardRequestDto requestDto) {
        Board board= isError(boardId);
        board.update(requestDto);
        return board.getId();
    }

    public Board isError(Long boardId){
        return boardRepository.findById(boardId).orElseThrow(()
                ->new IllegalArgumentException("존재하지 않는 게시글"));
    }
}
