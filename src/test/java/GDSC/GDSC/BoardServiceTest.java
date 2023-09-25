package GDSC.GDSC;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class BoardServiceTest {
    @Autowired
    BoardRepository boardRepository;

    @BeforeEach
    public void deleteAll() {
        boardRepository.deleteAll();
    }

    @Test
    public void 글_등록하기() throws Exception {
        //given
        Board board = createBoardAndSave();

        //then
        Assertions.assertThat("lee").isEqualTo(board.getWriter());
        Assertions.assertThat("test").isEqualTo(board.getContext());
    }

    @Test
    public void 글_수정하기() throws Exception {
        //given
        Board board = createBoardAndSave();
        //when
        board.setWriter("jun");
        board.setContext("modifyTest");
        //then
        Assertions.assertThat("jun").isEqualTo(board.getWriter());
        Assertions.assertThat("modifyTest").isEqualTo(board.getContext());
    }

    @Test
    public void 게시글_목록출력() throws Exception {
        //given
        Board board1 = createBoardAndSave();
        Board board2 = createBoardAndSave();
        //when
        List<Board> boardList = boardRepository.findAll();
        //then
        Assertions.assertThat(2).isEqualTo(boardList.size());
    }

    public Board createBoardAndSave() {
        Board board = new Board();
        board.setId(1L);
        board.setWriter("lee");
        board.setContext("test");
        boardRepository.save(board);
        return board;
    }
}