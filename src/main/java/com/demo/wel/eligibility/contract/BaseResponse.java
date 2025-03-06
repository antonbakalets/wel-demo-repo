package com.demo.wel.eligibility.contract;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
abstract class BaseResponse {

    private final String status;

}
