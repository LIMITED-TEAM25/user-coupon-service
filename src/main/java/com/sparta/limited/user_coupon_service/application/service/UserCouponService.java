package com.sparta.limited.user_coupon_service.application.service;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCouponService {

    private final RedisCouponIssueService redisCouponIssueService;

    public void creatUserCoupon(
        UUID couponId,
        Long userId
    ) {
        redisCouponIssueService.createIssueCoupon(couponId, userId);
    }
}
