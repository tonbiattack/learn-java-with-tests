package dev.learnjavawithtests.springsecurity.v1;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    public ProfileResponse profileFor(Authentication authentication) {
        List<String> authorities = authentication.getAuthorities().stream()
                .map(grantedAuthority -> grantedAuthority.getAuthority())
                .sorted()
                .toList();
        return new ProfileResponse(authentication.getName(), authorities);
    }
}
