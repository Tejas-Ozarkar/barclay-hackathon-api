package com.barclay.hackathon.jwt;


import com.barclay.SwaggerCodgen.api.AuthApi;
import com.barclay.SwaggerCodgen.model.AuthRequest;
import com.barclay.SwaggerCodgen.model.AuthResponse;
import com.barclay.SwaggerCodgen.model.GenericResponse;
import com.barclay.SwaggerCodgen.model.UserDto;
import com.barclay.hackathon.jwt.mappers.UserMapper;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.User;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController implements AuthApi {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    MyUserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtUtil;


    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);


    @Override
    public ResponseEntity<GenericResponse> signup(UserDto userDto) {
        userDetailsService.signupUser(userMapper.toEntity(userDto));
        return ResponseEntity.ok(new GenericResponse().message("User Created"));
    }

    @Override
    public ResponseEntity<AuthResponse> signin(AuthRequest authRequest) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        AuthResponse authResponse = userMapper.toAuthResponse(userDetailsService.findUserByUsername(authRequest.getUsername()));
        return ResponseEntity.ok(authResponse.jwt(jwt));
    }

    @Override
    public ResponseEntity<UserDto> getUserInfo() {
        User user = userDetailsService.getCurrentUserDetails();
        return ResponseEntity.ok(userMapper.toDto(user));
    }
}