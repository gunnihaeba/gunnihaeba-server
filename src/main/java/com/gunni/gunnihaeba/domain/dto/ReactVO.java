package com.gunni.gunnihaeba.domain.dto;

import com.gunni.gunnihaeba.domain.domain.ReactEntity;
import com.gunni.gunnihaeba.domain.domain.enums.ReactType;
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
public class ReactVO {

    private Long id;

    private Long viewerId;

    private Long issueId;

    private ReactType reactType;

    public ReactEntity toEntity(){
        return ReactEntity.builder()
                .id(this.id)
                .viewerId(this.viewerId)
                .issueId(this.issueId)
                .reactType(this.reactType).build();
    }

}
