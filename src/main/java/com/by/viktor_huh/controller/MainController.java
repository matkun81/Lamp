package com.by.viktor_huh.controller;

import com.by.viktor_huh.model.Room;
import com.by.viktor_huh.service.MainServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    private final MainServiceImpl mainServiceImpl;

    public MainController(MainServiceImpl mainServiceImpl) {
        this.mainServiceImpl = mainServiceImpl;
    }

    @GetMapping
    public String main(Model model) {
        List<Room> roomList = mainServiceImpl.findAll();
        model.addAttribute("roomList", roomList);
        return "main";
    }

    @PostMapping
    public String addNewRoom(Room room) {
        mainServiceImpl.save(room);
        return "redirect:/main";
    }

    @GetMapping("/{roomId}/edit")
    public String goToTheRoom(@PathVariable("roomId") Integer roomId, Model model) {
        Room room = mainServiceImpl.getOne(roomId);
        if (room.isLight()) {
            model.addAttribute("text", "ONLight");
        }
        if (!room.isLight()) {
            model.addAttribute("text", "OFFLight");
        }
        model.addAttribute(room);
        return "room";
    }

    @PostMapping("/{roomId}/edit")
    public String tumbler(@PathVariable("roomId") Integer roomId) {
        mainServiceImpl.light(roomId);
        return "redirect:/{roomId}/edit";
    }
}

