package com.sparta.limited.user_coupon_service.application.service;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserCouponService {

    private final RedisCouponIssueService redisCouponIssueService;

    @Transactional
    public void creatUserCoupon(
        UUID couponId,
        Long userId
    ) {
        redisCouponIssueService.quantityAndDuplicate(couponId, userId);

        redisCouponIssueService.userCouponCreateEvent(couponId, userId);

        redisCouponIssueService.decreaseCouponQuantityEvent(couponId);

    }
}
