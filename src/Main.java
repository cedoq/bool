/*Необходимо решить задачу расчета налога на недвижимость.
В общем случае налог рассчитывается по формуле S*taxK, где S - общая площадь недвижимости в квадратных метрах, taxK - налог на один квадратный метр недвижимости.

У вас есть 3 типа недвижимости: жилая, торговая, производственная.

Для жилой недвижимости необходимо учитывать субсидии хозяина недвижимости, которые выражаются в процентах от общей стоимости, которые ему надо заплатить.

Для торговой недвижимости учитывается выручка от торговли: если выручка меньше 100 грн то налог не взымается.

Для производственной недвижимости никаких льгот не предусмотрено.

﻿Создайте в программе по одному объекту каждой недвижимости и выведите на экран, кто сколько налогов заплатит.*/


class Tax{
    int S;
    float TaxK = 1.0f;
   float  Pay(){
        float pay = this.S*TaxK;
        return pay;
    }
}
class Self extends Tax{
   int sub;
    float tax;
    public Self(int S ,int Sub) {
        super.S = S;
        this.sub = Sub;
        tax = super.Pay();
    }

    @Override
    float Pay(){
    tax = tax - (tax / 100 * sub);
    return tax;
}}
class Shop extends Tax{
    float pay;
    int mpm;
    public Shop(int mpm,int S) {
        this.mpm = mpm;
        super.S = S;
    }
    @Override
    float Pay(){
        if(this.mpm <= 100){
            System.out.println("налога нет");
            return pay = 0;
        }
        else {
             pay = super.Pay();
             return pay;
        }
    }
}
class Maker extends Tax{
    public Maker(int S, float TaxK) {
        super.S = S;
        super.TaxK = TaxK;
    }

}


public class Main {
    public static void main(String[] args) {
    Self man = new Self(100, 10);
        System.out.println("налог на недвижемость уважаемого равен - " + man.Pay() + " $");
    Shop bazar = new Shop(1000, 500);
        System.out.println("налог на содержание  магазина равен -" + bazar.Pay() + " $");
    Maker ZAVOD = new Maker(1000, 1.1f); // поставил дополнительно измение кофициента налога для заводов
        System.out.println("налог на сожержание завода равен - " + ZAVOD.Pay() + " $");

    }
}