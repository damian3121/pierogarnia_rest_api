package jezowe.pierogarnia.controller.login;

import jezowe.pierogarnia.config.jwt.TokenProvider;
import jezowe.pierogarnia.dto.jwt.AuthTokenDTO;
import jezowe.pierogarnia.dto.jwt.LoginUserDTO;
import jezowe.pierogarnia.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AuthenticationController {
    private static final String TOKEN_PREFIX = "Bearer ";

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody LoginUserDTO loginUserDTO) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUserDTO.getUsername(),
                        loginUserDTO.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);

        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.HOUR_OF_DAY, 3);

        userService.updateTokenByUsername(loginUserDTO.getUsername(), token, calendar.getTime());
        return ResponseEntity.ok(new AuthTokenDTO(token));
    }
}