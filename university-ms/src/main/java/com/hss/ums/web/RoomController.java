package com.hss.ums.web;

import com.hss.ums.config.constants.Url;
import com.hss.ums.config.exception.NoSuchPropertyException;
import com.hss.ums.service.common.utils.UtilService;
import com.hss.ums.service.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@CrossOrigin
@RequestMapping(Url.SECURE_URL+Url.ROOM)
public class RoomController {

    @Autowired
    RoomService roomService;

    @Autowired
    UtilService utilService;

    @GetMapping
    public ResponseEntity<?> list(@RequestParam String sortBy, @RequestParam String sortDirection, @RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return ResponseEntity.ok(roomService.findAll(pageNumber, pageSize, sortDirection, sortBy));
    }

    @GetMapping("/query")
    public ResponseEntity<?> list(@RequestParam String from, @RequestParam String to) throws NoSuchPropertyException, ParseException {
        return ResponseEntity.ok(roomService.findAvailable(utilService.getDate(from, true), utilService.getDate(to, true)));
    }

}
