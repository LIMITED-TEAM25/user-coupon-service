package com.sparta.limited.user_coupon_service.infrastructure.redis;

import lombok.Getter;

@Getter
public enum RedisScriptKey {
    CREATE_ISSUE_COUPON("lua/createIssueCoupon.lua"),
    ;

    private final String luaScripName;

    RedisScriptKey(
        String luaScripName
    ) {
        this.luaScripName = luaScripName;
    }

}
