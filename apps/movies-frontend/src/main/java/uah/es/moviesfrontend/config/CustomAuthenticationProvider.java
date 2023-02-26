package uah.es.moviesfrontend.config;

import uah.es.moviesfrontend.model.Role;
import uah.es.moviesfrontend.model.User;
import uah.es.moviesfrontend.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private IUsersService usersService;

    public CustomAuthenticationProvider() {
        super();
    }

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {

        final String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        User loggedUser = usersService.login(email, password);
        if (loggedUser != null) {
            final List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
            for (Role role : loggedUser.getRoles()) {
                grantedAuths.add(new SimpleGrantedAuthority(role.getAuthority()));
            }
            final UserDetails principal = new org.springframework.security.core.userdetails.User(email, password, grantedAuths);
            final Authentication auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
            return auth;
        }
        return null;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean supports(final Class authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
