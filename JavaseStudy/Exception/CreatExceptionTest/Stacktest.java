package Exception.CreatExceptionTest;
/*
* 要求：该栈可以存储java中任何引用类型
*       提供push方法压栈（栈满时要有提示信息）
*       提供pop方法弹栈（栈空时要有提示信息）
*       编写程序，new对象，用push、pop方法来模拟压弹栈
*       假设默认初始化容量是10；（注意无参构造编写方法）
* */
public class Stacktest {
        //用一维数组模拟栈，Object对应要求的任何引用类型数据
        private Object[] stack;
        private int index = -1;//index=-1表示栈帧指向第0个元素

        //      private int index=0;表示栈帧指向第1个元素；
        public Stacktest()//无参构造方法，在对初始化有条件的时候需要编写出相应条件。
        {
            this.stack = new Object[10];
        }

        public Stacktest(Object[] stack) {
            this.stack = stack;
        }

        public Object[] getStack() {
            return stack;
        }

        public void setStack(Object[] stack) {
            this.stack = stack;
        }

        public void push(Object obj) throws PushIndexException//压栈
        {
            if(index>this.stack.length-2)
//                因为在main程序中我们需要让他先输出自定义的异常，然后接着执行出栈，所以此处需要-2而不是-1
//                否则在执行出栈之前就会报超出索引异常，就没法执行出栈操作了
            {
//                PushIndexException pushIE = new PushIndexException("栈已满");
//                throw pushIE;//手动抛异常。这里需要用到throw是因为当自己new了一个异常自己catch的话是无意义的
//                这条异常信息需要反馈到调用者。
                //或者更简便的写法
                throw new PushIndexException("栈已满");
            }
//            throw pushIE; 报错，因为PushIndexException继承Exception，所以应该用声明抛。
            this.index++;
            this.stack[this.index] = obj;
            System.out.println("push elements successful!");

        }

        public void pop() throws PopIndexException{
            if(this.index<0)
            {
                throw new PopIndexException("栈已空");
            }
            this.stack[this.index] = null;
            this.index--;
            System.out.println("index=" + this.index);
        }
}
