package com.igate.igateapi.model.network;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@AllArgsConstructor
public enum Message {

//    READ_COMPLETE(""),

    CREATE_COMPLETE("고객 정보 등록 성공", HttpStatus.CREATED),

    UPDATE_COMPLETE("고객 정보 갱신 성공", HttpStatus.OK),

    DELETE_COMPLETE("고객 정보 삭제 성공", HttpStatus.OK),
    NO_INFO("고객 정보 없음", HttpStatus.NO_CONTENT);

    private String description;

    private HttpStatus httpStatus;
















}
