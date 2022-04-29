package JavaseStudy.homework.Weapon;
/*开放型题目，随意发挥:
写一个类Army，代表一支军队，这个类有一个属性Weapon数组w（用来存储该军队所拥有的所有武器）
该类还提供一个构造方法，在构造方法里通过传一个int类型的参数来限定该类所能拥有的最大武器数量并用这一大小来初始化数组w.
该类还提供一个方法addWeapon(Weapon wa),表示把参数wa所代表的武器加入到数组w中。
以及在这个类中还定义两个方法attackAll()让w数组中的所有武器攻击;
以及moveAll()让w数组中的所有可移动的武器移动。
一个主方法去测试以上程序-
 * */
/*————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————*/
/*该方法存在bug，该循环在抛出异常后方法会立即停止，无法继续遍历后面的元素
*  public void AttackAll(Weapon weapon) throws CannotAttackException {
//        for(int j=0;j<=i;j++)            该代码无法实现遍历所有元素，因为在try...catch中捕捉异常后，后面的代码并不会执行
//        {                                 当涉及到异常的时候，在方法中就尽量不要使用循环
//            if(!w[j].attack)               以防止抛出异常后方法直接跳出
//            {
//                throw new CannotAttackException("警告：该武器已发射，无弹药");
//            }
//            else if(w[j].attack)
//            {
//                System.out.println("已将武器发射成功");
//            }
//        }*/
public class Tips {

}
