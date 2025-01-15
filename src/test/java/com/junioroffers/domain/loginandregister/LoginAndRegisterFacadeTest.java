package com.junioroffers.domain.loginandregister;

import com.junioroffers.domain.loginandregister.dto.RegisterUserDto;
import com.junioroffers.domain.loginandregister.dto.RegistrationResultDto;
import com.junioroffers.domain.loginandregister.dto.UserDto;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.BadCredentialsException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertAll;

class LoginAndRegisterFacadeTest {
     LoginAndRegisterFacade loginAndRegisterFacade = new LoginAndRegisterFacade(new InMemoryLoginRepositoryTest());


     @Test
     public void should_register_user() {
         //given
         RegisterUserDto registrationUserDto = new RegisterUserDto(
                 "username",
                 "password"
         );
         //when
         RegistrationResultDto registrationResultDto = loginAndRegisterFacade.register(registrationUserDto);

         //then
         assertAll(
                 () -> assertThat(registrationResultDto.created()).isTrue(),
                 () -> assertThat(registrationResultDto.username()).isEqualTo("username")
         );
     }

     @Test
     public void should_find_user_by_user_name() {
         //given
         RegisterUserDto registrationUserDto = new RegisterUserDto(
                 "username",
                 "password"
         );
         RegistrationResultDto registrationResultDto = loginAndRegisterFacade.register(registrationUserDto);
         //when
         UserDto userDto = loginAndRegisterFacade.findByUsername(registrationResultDto.username());
         //Then
         assertThat(userDto).isEqualTo(new UserDto(registrationResultDto.id(), "username",
                 "password"));
     }

     @Test
     public void should_throw_exception_when_user_not_found() {
         //given
         String username = "some username";
         //when
         Throwable thrown = catchThrowable(()-> loginAndRegisterFacade.findByUsername(username));
         //then
         AssertionsForClassTypes.assertThat(thrown)
                 .isInstanceOf(BadCredentialsException.class)
                 .hasMessage("User not found");

     }
 }