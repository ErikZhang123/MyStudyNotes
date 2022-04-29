package JavaseStudy.homework.Weapon;

public class Army {
    private Weapon[] w;
    private int MAX_NUMBER;
    int i;
    public Army(int MAX_NUMBER) {
        this.MAX_NUMBER = MAX_NUMBER;
         w =new Weapon[this.MAX_NUMBER];
    }

    public void addweapon(Weapon weapon)
    {
            if(null==this.w[i])
            {
                w[i]=weapon;
                System.out.println("武器添加成功");
                i++;
            }
    }
    public void AttackAll() {
//        for(int j=0;j<i;j++)            该代码无法实现遍历所有元素，因为在trycatch中捕捉异常后，后面的代码并不会执行
//        {                                 当涉及到异常的时候，在方法中就尽量不要使用循环
//            if(!w[j].attack)               以防止抛出异常后方法直接跳出
//            {                             但是可以通过在方法中try...catch的方法来使循环继续，具体看move方法
//                throw new CannotAttackException("警告：该武器已发射，无弹药");
//            }
//            else if(w[j].attack)
//            {
//                System.out.println("已将武器发射成功");
//            }
//        }
        for(int j=0;j<i;j++)
        {
            if(!w[j].attack)
            {
                System.out.println("警告："+w[j].name+"该武器已发射，无弹药");
            }
            else if(w[j].attack)
            {
                System.out.println("已将"+w[j].name+"发射成功");
            }
        }
    }

    public void MoveAll()  {
        for(int j=0;j<i;j++)                    // 同attackall不能使用循环的原理
        {                                         //但是可以通过在方法中使用try...catch来使循环继续
                if(w[j].moveable)
                    System.out.println(w[j].name+"已移动");
                try {
                    if(!w[j].moveable)
                    throw new CannotMoveException("警告："+w[j].name+"无法移动");
                } catch (CannotMoveException ex) {
                    System.out.println(ex.getMessage());
                }
        }
    }
//        for(int j=0;j<i;j++)
//        {
//            if(!w[j].attack)
//            {
//                System.out.println("警告："+w[j].name+"无法移动");
//            }
//            else if(w[j].attack)
//            {
//                System.out.println(w[j].name+"已移动");
//            }
//        }
    }