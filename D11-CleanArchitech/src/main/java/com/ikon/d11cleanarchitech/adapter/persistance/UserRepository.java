package com.ikon.d11cleanarchitech.adapter.persistance;

import com.ikon.d11cleanarchitech.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
