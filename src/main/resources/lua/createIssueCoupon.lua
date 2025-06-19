-- KEYS[1]=coupon:{id}:quantity
-- KEYS[2]=coupon:{id}:users
-- KEYS[3]=user-coupon:queue
-- KEYS[4]=coupon-quantity-decrease:queue
-- ARGV[1]=userId
-- ARGV[2]=couponId

local remain = redis.call("DECR", KEYS[1])
if not remain or remain < 0 then
  redis.call("INCR", KEYS[1])
  return "OUT_OF_STOCK"
end

if redis.call("SADD", KEYS[2], ARGV[1]) == 0 then
  redis.call("INCR", KEYS[1])
  return "DUPLICATED"
end

redis.call("XADD", KEYS[3], "*",
"userId", ARGV[1],
"couponId", ARGV[2]
)

redis.call("RPUSH", KEYS[4], ARGV[2])
return {ok=tostring(remain)}