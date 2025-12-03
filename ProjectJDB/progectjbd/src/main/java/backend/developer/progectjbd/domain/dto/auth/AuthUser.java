package backend.developer.progectjbd.domain.dto.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import backend.developer.progectjbd.domain.model.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthUser implements UserDetails{

    private final User user;
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authority = new ArrayList<>();
        user.getRoles().forEach(role -> authority.add(new SimpleGrantedAuthority(role.name())));
        return authority;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

}
