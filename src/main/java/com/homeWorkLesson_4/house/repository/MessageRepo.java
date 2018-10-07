package com.homeWorkLesson_4.house.repository;

import com.homeWorkLesson_4.house.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {

       List <Message> findByNumberOfRooms(Integer numberOfRooms);

       List <Message> findByAreaGreaterThan(Double area);

}
