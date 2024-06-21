package com.gunni.gunnihaeba.global.common.repository;

import com.gunni.gunnihaeba.domain.dto.User;
import com.gunni.gunnihaeba.global.security.auth.AuthDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UserSessionHolderImpl implements UserSessionHolder {

    @Override
    public User getUser() {
        return ((AuthDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal())
                .getUserVO();
    }

}
