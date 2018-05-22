package com.avvarga.events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.avvarga.events.models.Message;

@Repository
public interface MessageRepo extends CrudRepository<Message, Long> {
}
