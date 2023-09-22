package com.amnil.microserviceuserservice.Service;

import com.amnil.microserviceuserservice.dto.ResponseDto;
import com.amnil.microserviceuserservice.enitity.User;


public interface UserService {
    User saveUser(User user);

    ResponseDto getUser(Long userId);
}
