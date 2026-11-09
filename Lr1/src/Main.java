import java.util.Math;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    System.out.print("Введите задание от 1 до 3 ");
    Scanner in = new Scanner(System.in);
    int h= in.nextInt();
    switch (h){
        case 1:{
    System.out.print("Введите метры ");
    int b= in.nextInt();
    int a=b*10;
    System.out.println("Итого: " + a + " cm");} break;
        case 2:{
            System.out.print("Введите первое число ");
            int a1 = in.nextInt();
            System.out.print("Введите второе число ");
            int a2 = in.nextInt();
            System.out.print("Введите третье число ");
            int a3 = in.nextInt();
            if((a1>=0)&&(a2>=0)&&(a3>=0)){
                System.out.print("Колимчество положительных чисел = 3 ");
            }
            else if ((a1>=0)&&(a2<0)&&(a3>=0)) {
                System.out.print("Колимчество положительных чисел = 2 ");
            }
            else if ((a1>=0)&&(a2>=0)&&(a3<0)) {
                System.out.print("Колимчество положительных чисел = 2 ");
            }
            else if ((a1<0)&&(a2>=0)&&(a3>=0)) {
                System.out.print("Колимчество положительных чисел = 2 ");
            }
            else if ((a1>=0)&&(a2<0)&&(a3<0)) {
                System.out.print("Колимчество положительных чисел = 1 ");
            }
            else if ((a1<0)&&(a2>=0)&&(a3<0)) {
                System.out.print("Колимчество положительных чисел = 1 ");
            }
            else if ((a1<0)&&(a2<0)&&(a3>=0)) {
                System.out.print("Колимчество положительных чисел = 1 ");
            }
            else {
                System.out.print("Колимчество положительных чисел = 0 ");
            }

        }break;
        case 3:{
            long a = 12;
            long b = 18;


            long x = a, y = b;
            while (y != 0) {
                long temp = y;
                y = x % y;
                x = temp;
            }
            long gcd = x;


            long lcm = Math.abs(a / gcd * b);

            System.out.println("НОК = " + lcm);
        }
    }

}
