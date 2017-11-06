package site.nebulas.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Autowired
  private RedisTemplate redisTemplate;

  @Test
  public void test() {
    stringRedisTemplate.opsForValue().set("aaa", "111");

    //stringRedisTemplate.opsForList().leftPush("mail", "11");
    System.out.print(stringRedisTemplate.opsForList().leftPop("mail"));

    ValueOperations<String, String> operations = redisTemplate.opsForValue();
    operations.set("ccc", "222");
    System.out.print("输出：" + operations.get("ccc") + "\n");
  }
}
