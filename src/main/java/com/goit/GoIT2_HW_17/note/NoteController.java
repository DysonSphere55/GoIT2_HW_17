package com.goit.GoIT2_HW_17.note;

import com.goit.GoIT2_HW_17.note.dto.NoteDTO;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@RequiredArgsConstructor
@RequestMapping("/note")
@Controller
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/list")
    public ModelAndView listAll() {
        ModelAndView modelAndView = new ModelAndView("note/list");
        modelAndView.addObject("notes", noteService.listAll());
        return modelAndView;
    }


    @GetMapping("/delete")
    public void deleteById(@RequestParam(name = "id") int id, HttpServletResponse resp) {
        noteService.deleteById(id);
        try {
            resp.sendRedirect("/note/list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/edit/{id}")
    public ModelAndView getEditById(@PathVariable(name = "id") int id) {
        Note note = noteService.getById(id);
        ModelAndView modelAndView = new ModelAndView("/note/edit");
        modelAndView.addObject("id", id);
        modelAndView.addObject("title", note.getTitle());
        modelAndView.addObject("content", note.getContent());
        return modelAndView;
    }


    @PostMapping("/edit")
    public void postEditById(@RequestParam(name = "noteId") int id, @RequestParam(name = "noteTitle") String title,
                             @RequestParam(name = "noteContent") String content, HttpServletResponse resp) {

        NoteDTO noteDTO = NoteDTO.builder().id(id).title(title).content(content).build();
        noteService.update(NoteDTO.fromDTO(noteDTO));

        try {
            resp.sendRedirect("/note/list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/create")
    public ModelAndView getCreate() {
        Note note = new Note();
        noteService.add(note);
        long id = note.getId();
        ModelAndView modelAndView = new ModelAndView("/note/create");
        modelAndView.addObject("id", id);
        return modelAndView;
    }


    @PostMapping("/create")
    public void postCreate(@RequestParam(name = "noteId") int id, @RequestParam(name = "noteTitle") String title,
                             @RequestParam(name = "noteContent") String content, HttpServletResponse resp) {

        NoteDTO noteDTO = NoteDTO.builder().id(id).title(title).content(content).build();
        noteService.update(NoteDTO.fromDTO(noteDTO));

        try {
            resp.sendRedirect("/note/list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @GetMapping()
    public ModelAndView idle() {
        return new ModelAndView("note/index");
    }



}
