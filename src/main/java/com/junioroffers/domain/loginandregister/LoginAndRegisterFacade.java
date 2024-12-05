package com.junioroffers.domain.loginandregister;

import com.junioroffers.domain.loginandregister.dto.RegistrationResultDto;
import com.junioroffers.domain.loginandregister.dto.RegistrationUserDto;
import com.junioroffers.domain.loginandregister.dto.UserDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginAndRegisterFacade {
    private static final String USER_NOT_FOUND = "User not found";
    private final LoginRepository loginRepository;



    public RegistrationResultDto register(RegistrationUserDto registrationUserDto){
        final User user = User.builder()
                .username(registrationUserDto.username())
                .surname(registrationUserDto.surname())
                .email(registrationUserDto.email())
                .password(registrationUserDto.password())
                .build();
        User savedUser = loginRepository.save(user);
        return new RegistrationResultDto(savedUser.id(),true, user.username(), user.surname());

        }

        public UserDto findByUsername(String username) {
            return loginRepository.findByUsername(username)
                    .map(user -> new UserDto(user.id(), user.username(), user.surname(), user.email(), user.password()))
                    .orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND));
        }
        }


