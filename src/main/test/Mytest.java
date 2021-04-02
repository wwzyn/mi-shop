import com.utils.JedisUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class Mytest {
    @Test
    public void redis(){
        Jedis jedis = JedisUtils.getJedis();
        jedis.set("zhangsan","张三");
        String zhangsan = jedis.get("zhangsan");
        System.out.println(zhangsan);
    }
    @Test
    public void redis2(){
        Jedis jedis = new Jedis("106.15.37.114",6379);
        jedis.set("ljx","李金祥");
        System.out.println(jedis.get("ljx"));
    }
}
