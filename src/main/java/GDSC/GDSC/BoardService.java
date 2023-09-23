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

    public Long write(BoardRequsetDto requsetDto) {
      return boardRepository.save(requsetDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<BoardResponseDto> getList() {
        return boardRepository.findAll().stream()
                .map(BoardResponseDto::new)
                .collect(Collectors.toList());
    }

    public void update(Long boardId,BoardRequsetDto requsetDto) {
        Board board= isError(boardId);
        board.update(requsetDto);
    }

    public Board isError(Long boardId){
        return boardRepository.findById(boardId).orElseThrow(()
                ->new IllegalArgumentException("존재하지 않는 게시글"));
    }
}
