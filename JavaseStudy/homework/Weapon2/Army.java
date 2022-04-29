package JavaseStudy.homework.Weapon2;

/*
* //该方法存在bug，该循环在抛出异常后方法会立即停止，无法继续遍历后面的元素
* */
public class Army {
    private  int max_number = 0;
    private Weapon[] w;

    public Army(int max_number) {
        this.max_number = max_number;
        w=new Weapon[this.max_number];
    }
    public void AddWeapon(Weapon weapon) throws AddBeyoundBoundaryException {
        for(int i=0;i<w.length;i++)
        {
            if(null==w[i])
            {
                w[i]=weapon;
                System.out.println("武器添加成功");
                return;
            }
        }
        throw new AddBeyoundBoundaryException("武器添加已达上限");
    }
    public void MoveAll() throws CannotMoveException {
        for(int i=0;i<w.length;i++)//该方法存在bug，该循环在抛出异常后方法会立即停止，无法继续遍历后面的元素
        {
            if(w[i]!=null&&w[i]instanceof Moveable)
            {
                Moveable m = (Moveable)w[i];//将其元素强制转换为对应的接口
                m.move();//用m的move方法就相当于用对应实现类的move方法。
            }
            else
                throw new CannotMoveException("编号为"+i+"的武器无法移动");
        }
    }
    public void AttackAll()
    {
        for(int i=0;i<w.length;i++)
        {
            if(w[i]!=null&&w[i]instanceof Attack)
            {
                Attack a = (Attack) w[i];
                a.attack();
            }
        }
    }

}
