import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws HzException{
        Calc("imput");
    }
    public static String Calc (String imput) throws HzException{

        int valueA1=0;
        int valueA2 =0;
        int valueR1 =0;
        int valueR2 =0;
        int resultA=0;
        int resultR=0;
        String result;

        String[] Roman = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите выражение типа а+в арабскими или римскими цифрами, доступный диапазон чисел от 0 до 10, доступные знаки: +,-,*,/");
        String input = scan.nextLine();

        int index1 = input.indexOf("+");
        int index2 = input.indexOf("-");
        int index3 = input.indexOf("*");
        int index4 = input.indexOf("/");
        if((index1>0)||(index2>0)||(index3>0)||(index4>0)) {
            String[] numbers = input.split("[-+/*]");
            String number1 = numbers[0].trim();// убрали пробелы
            String number2 = numbers[1].trim();
            //
            //  System.out.println("number1 = "+number1);
            //  System.out.println("number2 = "+number2);


            //проверяем числа
            char check = number1.charAt(0);
            if ((check == '0') || (check == '1') || (check == '2') || (check == '3') || (check == '4') || (check == '5') || (check == '6') || (check == '7') || (check == '8') || (check == '9')) {
                int i = Integer.parseInt(number1);//перевели строку в инт
                if ((i > 10) || (i < 0)) {
                    throw new HzException("Первое арабское число вне допустимого диапазона");
                }
                valueA1 = i; //значение первого числа

                char check2 = number2.charAt(0);
                if ((check2 == '0') || (check2 == '1') || (check2 == '2') || (check2 == '3') || (check2 == '4') || (check2 == '5') || (check2 == '6') || (check2 == '7') || (check2 == '8') || (check2 == '9')) {
                    int j = Integer.parseInt(number2);// String -->int
                    if ((j > 10) || (j <= 0)) {
                        throw new HzException("Второе арабское число вне допустимого диапазона");
                    }
                    valueA2 = j;

                    if (index1 > 0) {
                        resultA = valueA1 + valueA2;
                    }
                    if (index2 > 0) {
                        resultA = valueA1 - valueA2;
                    }
                    if (index3 > 0) {
                        resultA = valueA1 * valueA2;
                    }
                    if (index4 > 0) {
                        resultA = valueA1 / valueA2;
                    }
                    System.out.println("Результат операции равен "+resultA);
                    result = String.valueOf(resultA);
                } else if ((check2 == 'I') || (check2 == 'X') || (check2 == 'V') || (check2 == 'Х')) {
                    throw new HzException("Второе число римское, введите оба числа одного формата");
                }else throw new HzException("Второе число не совсем число :)");
            }else if((check == 'I')||(check == 'X')||(check == 'V')||(check == 'Х')) {
                //переводим римские стринг в арабские инт
                switch (number1) {
                    case "I": valueR1 = 1;break;
                    case "II": valueR1 = 2;break;
                    case "III": valueR1 = 3;break;
                    case "IV": valueR1 = 4;break;
                    case "V": valueR1 = 5;break;
                    case "VI": valueR1 = 6;break;
                    case "VII": valueR1 = 7;break;
                    case "VIII": valueR1 = 8;break;
                    case "IX": valueR1 = 9;break;
                    case "X": valueR1 = 10;break;
                    case "IХ": valueR1 = 9;break;//русская Х
                    case "Х": valueR1 = 10;break;
                    default:
                        throw new HzException("Первое римское число вне допустимого диапазона");
                }/////////проверяем второе число
                char check3 = number2.charAt(0);
                if ((check3 == 'I') || (check3 == 'X') || (check3 == 'V') || (check3 == 'Х')) {
                    //переводим римские в арабские
                    switch (number2) {
                        case "I": valueR2 = 1;break;
                        case "II": valueR2 = 2;break;
                        case "III": valueR2 = 3;break;
                        case "IV": valueR2 = 4;break;
                        case "V": valueR2 = 5;break;
                        case "VI": valueR2 = 6;break;
                        case "VII": valueR2 = 7;break;
                        case "VIII": valueR2 = 8;break;
                        case "IX": valueR2 = 9;break;
                        case "X": valueR2 = 10;break;
                        case "IХ": valueR2 = 9;break;
                        case "Х": valueR2 = 10;break;
                        default: throw new HzException("Второе римское число вне допустимого диапазона");
                    }
                    if (index1 > 0) {
                        resultR = valueR1 + valueR2;

                    }
                    if (index2 > 0) {
                        resultR = valueR1 - valueR2;
                    }
                    if (index3 > 0) {
                        resultR = valueR1 * valueR2;
                    }
                    if (index4 > 0) {
                        resultR = valueR1 / valueR2;
                    }if (resultR<=0) throw new HzException("Результат операций с римскими числами не может быть меньше 0");
                    System.out.println("Результат операции равен "+Roman[(resultR-1)]);
                    result = Roman[(resultR-1)];
                }
                else if ((check3 == '0') || (check3 == '1') || (check3 == '2') || (check3 == '3') || (check3 == '4') || (check3 == '5') || (check3 == '6') || (check3 == '7') || (check3 == '8') || (check3 == '9')) {
                    throw new HzException("Второе число арабское, оба числа должны быть одного формата");
                } else throw new HzException("Недопустимое значение второго числа");
            }else throw new HzException("Ты точно ввел число?)");

        } else throw new HzException("Вы не ввели знак");
        return result;
    }
}
