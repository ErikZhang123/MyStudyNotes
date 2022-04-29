import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Pool {
    private  static JedisPool pool;

    //创建pool对象
    public static JedisPool open(String host,int port){
        if(pool==null){
        //创建JedisPool,给config设置连接池信息。使用config对象创建JedisPoll
            JedisPoolConfig config = new JedisPoolConfig();

            //设置连接池最大线程数量,一个线程对应一个Jedis对象
            config.setMaxTotal(10);

            //设置最大空闲数，最多保留两个备用的对象，如果已经没有Jedis对象可用，
            //则会使用备用的空闲对象，接收请求
            config.setMaxIdle(2);

            //设置检查项为true，保证从线程池中获取的对象一定是经过检查可用的
            config.setTestOnBorrow(true);

            //创建pool
//            pool = new JedisPool(poolconfig,host,port,timeout,password);
            /**  1.poolconfig 是前面的config对象
             *  2,timeout： 连接Redis的超时 时间 ，超过则报错，无法连接。单位是毫秒
             *  其他你要看不懂你就是傻逼
             * */
            pool = new JedisPool(config,host,port,6000,"123456");
        }
        return pool;
    }
    //关闭池
    public static void close(){
        if(pool !=null){
            pool.close();
        }
    }
}
