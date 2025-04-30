package com.sparta.limited.user_coupon_service.infrastructure.persistence;

import com.sparta.limited.user_coupon_service.domain.model.UserCoupon;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserCouponRepository extends JpaRepository<UserCoupon, UUID> {

}
