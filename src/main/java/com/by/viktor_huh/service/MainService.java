package com.by.viktor_huh.service;

import com.by.viktor_huh.model.Room;

import java.util.List;

public interface MainService {
    void light(int id);

    Room save(Room room);

    List<Room> findAll();

    Room getOne(int id);
}
