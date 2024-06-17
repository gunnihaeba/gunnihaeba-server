package com.gunni.gunnihaeba.domain.dto;

import com.gunni.gunnihaeba.domain.domain.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO {

    private Long id;

    private String userId;

    private String password;

    private String name;

    public static UserVO of(UserEntity userEntity) {
        return UserVO.builder()
                .id(userEntity.getId())
                .userId(userEntity.getUserId())
                .password(userEntity.getPassword())
                .name(userEntity.getName()).build();
    }

}
