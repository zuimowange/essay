package com.wgg.essay.service.user;

import org.springframework.stereotype.Service;
import com.wgg.essay.dto.user.UserDto;

@Service
public interface UserService{

	boolean login(UserDto dto);

	Integer reg(UserDto dto);
	
}