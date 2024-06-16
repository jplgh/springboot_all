package com.all.payment.service;

import com.all.payment.common.JsonResult;
import com.all.payment.response.SignCountResponse;

import java.util.List;

public interface SignService {

    JsonResult sign(String type);

    JsonResult<SignCountResponse> count(String type);

    JsonResult<List<Integer>> countMonth(String type);
}