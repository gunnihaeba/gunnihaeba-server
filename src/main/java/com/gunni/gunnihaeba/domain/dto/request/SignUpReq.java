package com.gunni.gunnihaeba.domain.dto.request;

import com.gunni.gunnihaeba.domain.domain.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpReq {

    private String userId;
    private String password;
    private String name;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .userId(this.userId)
                .password(this.password)
                .name(this.name).build();
    }

}
