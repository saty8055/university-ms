package com.hss.ums.entity.bean;

import com.hss.ums.entity.BaseEntity;
import com.hss.ums.entity.Booking;
import com.hss.ums.entity.Room;
import com.hss.ums.entity.User;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class BookingDto extends BaseEntity {

    private String bookingId;

    private Date bookingFrom, bookingTo;

    private Boolean cancelled;

    private UserDto user;

    private RoomDto room;

    public BookingDto() {}

    public BookingDto(Booking booking) {
        BeanUtils.copyProperties(booking, this);
    }

    public BookingDto(Booking booking, User user, Room room){
        BeanUtils.copyProperties(booking, this);
        this.setUser(new UserDto(user));
        this.setRoom(new RoomDto(room));
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Date getBookingFrom() {
        return bookingFrom;
    }

    public void setBookingFrom(Date bookingFrom) {
        this.bookingFrom = bookingFrom;
    }

    public Date getBookingTo() {
        return bookingTo;
    }

    public void setBookingTo(Date bookingTo) {
        this.bookingTo = bookingTo;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public RoomDto getRoom() {
        return room;
    }

    public void setRoom(RoomDto room) {
        this.room = room;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }
}
