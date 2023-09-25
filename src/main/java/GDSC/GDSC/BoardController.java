package GDSC.GDSC;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
//등록, 수정, 삭제, 조회
@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @PostMapping("/board-write") //글 작성
    public Long completeWrite(@RequestBody BoardRequestDto requestDto){
       return boardService.write(requestDto);
    }

    @GetMapping("/board-list") //게시글 목록 출력
    public List<BoardResponseDto> getBoardList(ModelAndView mav){
      return boardService.getList();
    }

    @PatchMapping("/board-update/{id}") //게시글 수정
    public Long completeUpdate(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
       return boardService.update(id,requestDto);
    }

    @DeleteMapping("/delete-board/{boardId}") //게시글 삭제
    public String deleteBoard(@PathVariable Long boardId){
        boardRepository.deleteById(boardId);
        return "삭제완료";
    }
}
