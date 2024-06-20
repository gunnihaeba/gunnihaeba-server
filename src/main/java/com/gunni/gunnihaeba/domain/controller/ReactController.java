package com.gunni.gunnihaeba.domain.controller;

import com.gunni.gunnihaeba.domain.domain.enums.ReactType;
import com.gunni.gunnihaeba.domain.dto.response.CountReactRes;
import com.gunni.gunnihaeba.domain.service.ReactService;
import com.gunni.gunnihaeba.global.common.response.Response;
import com.gunni.gunnihaeba.global.common.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/react")
@RequiredArgsConstructor
public class ReactController {

    private final ReactService reactService;

    /**
     * 좋아요, 싫어요 수, 내가 누른거 확인
     * */
    @GetMapping("/{id}")
    public ResponseData<CountReactRes> countReact(
            @PathVariable Long id
    ){
        return reactService.countReact(id);
    }

    /**
     * 좋아요 or 싫어요 누르기
     * */
    @PostMapping("/{id}")
    public Response react(
            @PathVariable Long id,
            @RequestParam ReactType reactType
    ){
        return reactService.react(id,reactType);
    }


}
