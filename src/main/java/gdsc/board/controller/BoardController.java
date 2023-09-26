package gdsc.board.controller;

import gdsc.board.domain.Data;
import gdsc.board.repository.JpaBoardRepository;
import gdsc.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final JpaBoardRepository boardRepository;

    @GetMapping("/create")
    public String createBoard(){
        return "createBoard";
    }

    @GetMapping("list")
    public String dataList(Model model){
        model.addAttribute("list",boardService.findAll());
        return "list";
    }

    @PostMapping("/create")
    public String create(@RequestParam String name,String content,String title){
        Data data = new Data();
        data.setName(name);
        data.setContent(content);
        data.setTitle(title);
        boardService.submit(data);
        return "redirect:/";
    }

    @GetMapping("update/{id}")
    public String updateForm(@PathVariable Long id,Model model){
        Data data=boardRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("존재안함"));
        model.addAttribute("data",data);
        return "update";
    }

    @PostMapping("/update")
    public String updateBoard(@RequestParam Long id, String content){
        boardService.update(id,content);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteBoard(@PathVariable Long id){
        boardRepository.deleteById(id);
        return "redirect:/";
    }
}
