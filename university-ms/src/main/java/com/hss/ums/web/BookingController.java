package com.hss.ums.web;

import com.hss.ums.config.constants.Url;
import com.hss.ums.config.exception.DataValidityException;
import com.hss.ums.config.exception.NoSuchPropertyException;
import com.hss.ums.entity.bean.BookingDto;
import com.hss.ums.service.booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Url.SECURE_URL+Url.BOOKING)
@CrossOrigin
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping
    public ResponseEntity<?> book(@RequestBody  BookingDto booking) throws DataValidityException {
        return ResponseEntity.ok(bookingService.add(booking));
    }

    @GetMapping
    public ResponseEntity<?> list(@RequestParam String sortBy, @RequestParam String sortDirection, @RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return ResponseEntity.ok(bookingService.findAll(pageNumber, pageSize, sortDirection, sortBy));
    }

    @GetMapping("/mine")
    public ResponseEntity<?> mine(@RequestParam String sortBy, @RequestParam String sortDirection, @RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return ResponseEntity.ok(bookingService.findMy(pageNumber, pageSize, sortDirection, sortBy));
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<?> cancel(@PathVariable String bookingId) throws DataValidityException, NoSuchPropertyException {
        return ResponseEntity.ok(bookingService.cancel(bookingId));
    }

}
