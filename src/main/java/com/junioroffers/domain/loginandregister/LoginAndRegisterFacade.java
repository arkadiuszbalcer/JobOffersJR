package com.junioroffers.domain.loginandregister;

import com.junioroffers.domain.loginandregister.dto.RegistrationResultDto;
import com.junioroffers.domain.loginandregister.dto.RegisterUserDto;
import com.junioroffers.domain.loginandregister.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class LoginAndRegisterFacade {
    private static final String USER_NOT_FOUND = "User not found";
    private final LoginRepository loginRepository;



    public RegistrationResultDto register(RegisterUserDto registrationUserDto){
        final User user = User.builder()
                .username(registrationUserDto.username())
                .password(registrationUserDto.password())
                .build();
        User savedUser = loginRepository.save(user);
        return new RegistrationResultDto(savedUser.id(),true, user.username());

        }

        public UserDto findByUsername(String username) {
            return loginRepository.findByUsername(username)
                    .map(user -> new UserDto(user.id(), user.username(),user.password()))
                    .orElseThrow(() -> new BadCredentialsException(USER_NOT_FOUND));
        }
        }


