package com.sparta.limited.user_coupon_service.infrastructure.repository;

import com.sparta.limited.user_coupon_service.domain.model.UserCoupon;
import com.sparta.limited.user_coupon_service.domain.repository.UserCouponRepository;
import com.sparta.limited.user_coupon_service.infrastructure.persistence.JpaUserCouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserCouponRepositoryImpl implements UserCouponRepository {

    private final JpaUserCouponRepository jpaUserCouponRepository;

    @Override
    public void save(UserCoupon userCoupon) {
        jpaUserCouponRepository.save(userCoupon);
    }
}
