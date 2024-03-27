package com.springwithmongo.basicspringmongo.Mongo;

import com.springwithmongo.basicspringmongo.Entities.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskMongoDb extends MongoRepository<Task, Long> {
}
