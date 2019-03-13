package com.by.viktor_huh.service;

import com.by.viktor_huh.model.Room;
import com.by.viktor_huh.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MainServiceImpl implements MainService {
    private final RoomRepository roomRepository;

    public MainServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void light(int id) {
        Room room = roomRepository.getOne(id);
        if (!room.isLight()) {
            room.setLight(true);
        } else if (room.isLight()) {
            room.setLight(false);
        }
        roomRepository.save(room);
    }

    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room getOne(int id) {
        return roomRepository.getOne(id);
    }
}
