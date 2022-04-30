package com.hss.ums.service.booking;

import com.hss.ums.config.exception.DataValidityException;
import com.hss.ums.config.exception.NoSuchPropertyException;
import com.hss.ums.entity.bean.BookingDto;
import org.springframework.data.domain.Page;

public interface BookingService {
    Page<BookingDto> findAll(Integer pageNumber, Integer pageSize, String sortDirection, String sortField);

    Page<BookingDto> findMy(Integer pageNumber, Integer pageSize, String sortDirection, String sortField);

    BookingDto add(BookingDto bookingDto) throws DataValidityException;

    BookingDto cancel(String bookingId) throws DataValidityException, NoSuchPropertyException;
}
