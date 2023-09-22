package com.amnil.microserviceuserservice.Service;

import com.amnil.microserviceuserservice.dto.DepartmentDto;
import com.amnil.microserviceuserservice.dto.ResponseDto;
import com.amnil.microserviceuserservice.dto.UserDto;
import com.amnil.microserviceuserservice.enitity.User;
import com.amnil.microserviceuserservice.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {
    private UserRepo userRepo;
    private RestTemplate restTemplate;
    private WebClient webClient;



    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public ResponseDto getUser(Long userId) {
        ResponseDto responseDto = new ResponseDto();
        User user = userRepo.findById(userId).get();
        UserDto userDto = mapToUser(user);

        ResponseEntity<DepartmentDto> responseEntity = restTemplate
                .getForEntity("http://localhost:8080/api/departments/"
                        + user.getDepartmentId(), DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();

//        DepartmentDto departmentDto = webClient.get()
//                        .uri("http://localhost:8080/api/departments/"+user.getDepartmentId())
//                                .retrieve()
//                                        .bodyToMono(DepartmentDto.class)
//                                                .block();

      //  System.out.println(responseEntity.getStatusCode());
        responseDto.setUser(userDto);
        responseDto.setDepartment(departmentDto);

        return responseDto;
    }

    private UserDto mapToUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
