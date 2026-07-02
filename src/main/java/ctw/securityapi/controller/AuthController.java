package ctw.securityapi.controller;

import ctw.securityapi.dto.AuthRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.username(), request.password()
        ));

        return ResponseEntity.ok().body("success");
    }
}
