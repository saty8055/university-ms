package com.hss.ums.repo;

import com.hss.ums.entity.Booking;
import com.hss.ums.entity.Room;
import com.hss.ums.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, String> {

    Page<Booking> findAll(Pageable pageable);

    Page<Booking> findByUser(User user, Pageable pageable);

    List<Booking> findByRoom(Room room);



}
