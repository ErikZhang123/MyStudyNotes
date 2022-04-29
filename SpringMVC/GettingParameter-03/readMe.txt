
1. 处理器方法通过两种方式获取请求的参数值

2. 在web.xml中设置过滤器，防止post乱码。实际上源码还是通过request和response包来设置的。
一般直接设置request和response为同一类编码。