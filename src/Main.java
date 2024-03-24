import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0, r = 0;
        System.out.println("Input с пробелами:");
        String example = in.nextLine().trim();
        //in.close();
        String[] elements = example.split(" ");
        if(elements.length != 3){
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Надо вводить математическую операцию a + b через пробел");
                }
            }else {
             try {
                    int i = Integer.parseInt(elements[0]);
                }catch (NumberFormatException exception) {
                    n = 1;
                }
             try {
                    int i = Integer.parseInt(elements[2]);
                }catch (NumberFormatException exception) {
                    n = 1;
                }
             try {
                 int rom1 = Roman_number.valueOf(elements[0]).getArab();  //преобразование римских чисел в арабские
             }catch (IllegalArgumentException exception) {
                 r = 1;
             }
             try {
                    int rom1 = Roman_number.valueOf(elements[2]).getArab();  //преобразование римских чисел в арабские
                }catch (IllegalArgumentException exception) {
                    r = 1;
                }

             if(n == 1 && r == 1 ) {
                 System.out.println("Введите либо римские, либо арабские целые числа!");
             }else {
                 if(n != 1){
                     Element element1 = new Element(Integer.parseInt(elements[0]), Integer.parseInt(elements[2]), elements[1]);
                     int answer = element1.calculation();
                     System.out.println("Output:\n" + answer);
                 }
                 if(r != 1){
                     int rom1 = Roman_number.valueOf(elements[0]).getArab();  //преобразование римских чисел в арабские
                     int rom2 = Roman_number.valueOf(elements[2]).getArab();
                     Element element2 = new Element(rom1, rom2, elements[1]);
                     int answer = element2.calculation();
                     if (answer < 1){
                         try {
                             throw new ArithmeticException();
                         } catch (ArithmeticException e) {
                             System.out.println("Ответ римскими числами не может быть меньше 1");
                             System.exit(0);
                         }
                     }
                     String answerInRom = Roman_number.getRom(answer);
                     System.out.println("Output:\n" + answer + " in Rom = " + answerInRom);
                 }
             }
        }
    }
}
class Element {
    public Element(int a, int b, String el) {
        this.a = a;
        this.b = b;
        this.el = el;
        if(!(a >= 1 && a <= 10 && b >= 1 && b <= 10)){
            try {
                throw new IOException() ;
            } catch (IOException e) {
                System.out.println("Ввод только от 1 до 10");
                System.exit(0);
            }
        }
    }
    int a;
    int b;
    String el;
    int calculation() {
        int result = 0;
        switch (el) {
            case ("+"):
                result = a + b;
                break;
            case ("-"):
                result = a - b;
                break;
            case ("*"):
                result = a * b;
                break;
            case ("/"):
                result = a / b;
                break;
            default:
                try {
                    throw new IOException() ;
                } catch (IOException e) {
                    System.out.println("Не найден элемент + - * /");
                    System.exit(0);
                }
                break;
        }
        return result;
    }
}