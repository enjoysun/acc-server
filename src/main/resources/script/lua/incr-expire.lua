-- 设置incr并expire 保证原子性
-- cli执行命令: eval "local tag=redis.call('incr', KEYS[1]) redis.call('expire', KEYS[1], ARGV[1]) return tag" 1 test-lua 2000
local key = KEYS[1]
local expire = ARGV[1]
local tag = redis.call("incr", key)
redis.call("expire", key, expire)
return tag