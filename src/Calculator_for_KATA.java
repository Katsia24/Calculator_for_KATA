import java.io.IOException;
import java.util.Scanner;

public class Calculator_for_KATA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input:");
        System.out.println("Output:\n" + calc(in.nextLine().trim()));
        in.close();
    }
    public static String calc (String input){
        int n = 0, r = 0;
        String[] elements = input.split(" ");
        if(elements.length != 3){
            try {
                throw new IOException();
            } catch (IOException e) {
                return "throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";
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
                return "throws Exception //т.к. используются одновременно разные системы счисления";
            }else {
                if(n != 1){
                    Element element1 = new Element(Integer.parseInt(elements[0]), Integer.parseInt(elements[2]), elements[1]);
                    int answer = element1.calculation();
                    return String.valueOf(answer);
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
                            return "throws Exception //т.к. в римской системе нет отрицательных чисел";
                        }
                    }
                    String answerInRom = Roman_number.getRom(answer);
                    return answerInRom;
                }
            }
        }
        return "throws Exception";
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