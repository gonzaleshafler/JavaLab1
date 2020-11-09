import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Main main=new Main();
        main.run();
    }
    public void run()
    {
        Calculate prog = new Calculate();
        prog.calcY(prog.a, prog.b, prog.x);
        prog.calcD(prog.a, prog.b, prog.x);
        prog.showAll();
        prog.showTime();
        prog.calculateSomeFunc();
    }
}

class Calculate
{
    double a=3.2;
    double b=17.5;
    double x=-4.8;

    public void input()                                                         //Метод введення данних
    {
        Scanner input=new Scanner(System.in);
        System.out.println("a: ");
        a=input.nextDouble();
        System.out.println("b: ");
        b=input.nextDouble();
        System.out.println("x: ");
        x=input.nextDouble();
    }
    public double calcY(double a, double b, double x)                         //Рахуємо значення y
    {
        return  b*(Math.tan(x)*Math.tan(x))-a/(Math.sin(x/a)* Math.sin(x/a));
    }
    public double calcD(double a, double b, double x)                         //Рахуємо значення d
    {
        return  a*Math.exp(-Math.sqrt(a))*Math.cos((b*x)/a);      //2.71828  приблизне значення експоненти
    }
    public void showInputData()                                               //Показати вхідні данні(данні котрі зберігаються в полях класу)
    {
        System.out.println("Входные данные:\na="+a+"\nb="+b+"\nx="+x);
    }
    public void showAll()                                                     //Показати все(Показати вхідні данні та результати підрахунку)
    {
        showInputData();
        System.out.println("Y ");
        showResult(calcY(a,b,x));
        System.out.println("D ");
        showResult(calcD(a,b,x));
    }
    public  void showResult(double result)                                    //Показати результат розрахунків
    {
        System.out.println("Результат:"+result);
    }

    public void showTime()                                                    //Показати час в форматі заданому варіантом
    {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("MM/dd/u  E  G  a")));
    }

    public  void calculateSomeFunc()                                         //Розрахувати і вивести обрану формулу
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Что считать?(введи y или d):");
        char c =input.next().charAt(0);

        input();

        if (c=='y'||c=='Y')
        {
            showInputData();

            showResult(calcY(a,b,x));
        }
        else if (c=='d'||c=='D')
        {
            showInputData();

            showResult(calcD(a,b,x));
        }
        else
        {
            System.out.println("Глупенький как воробушек");
        }
    }
}

