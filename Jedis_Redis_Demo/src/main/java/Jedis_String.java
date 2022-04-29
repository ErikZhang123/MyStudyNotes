import redis.clients.jedis.Jedis;

public class Jedis_String {
    public static void main(String[] args) {
        //创建Jedis对象，指定redis服务器的ip和端口
        /**String host： redis ip地址
         * int port：    redis 端口号
         * */
        String host = "127.0.0.1";
        int port = 6379;
        Jedis jedis = new Jedis(host,port);
        //设置访问密码
        jedis.auth("123456");
        //调用Jedis对象方法操作Redis数据
        jedis.set("breakfast","面包");
        String value =jedis.get("breakfast");
        System.out.println( "这个是value："+value);
    }
}
