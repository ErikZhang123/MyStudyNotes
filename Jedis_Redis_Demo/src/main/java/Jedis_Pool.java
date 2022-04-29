import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Jedis_Pool {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 6379;

        JedisPool pool = null;
        Jedis jedis = null;

        try{
            pool = Pool.open(host,port);
            //从pool中获取jedis
            jedis =  pool.getResource(); //返回jedis

            jedis.set("lunch","noodles");
            String value = jedis.get("lunch");
            System.out.println("我今天午饭吃啥？" + value);
        }catch( Exception e){
            System.out.println("出错了很抱歉");
        }finally
        {
            //只是让线程池将对象收回，并非消除对象
            Pool.close();
        }


    }
}
