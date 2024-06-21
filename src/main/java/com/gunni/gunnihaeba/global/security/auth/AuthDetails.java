package com.gunni.gunnihaeba.global.security.auth;

import com.gunni.gunnihaeba.domain.dto.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
public class AuthDetails implements UserDetails {

    private final User userVO;

    public AuthDetails(final User userVO) {
        this.userVO = userVO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.userVO.getPassword();
    }

    @Override
    public String getUsername() {
        return this.userVO.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
