package com.findsquad.api.FindSquad_API.repository;

import com.findsquad.api.FindSquad_API.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Long> {
}
