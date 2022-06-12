import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String readData;

        System.out.println("Введите математическое выражение вида a + b, допускается использовать следующие математические операции +, -, /, *. Используйте римские или арабские числа. Числа от 1 до 10, запрещено использовать обновременно римские и арабские цифры.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
        readData = scanner.nextLine();
        try {
            System.out.println(calc(readData));
        }   catch (IOException e) {
            System.out.println("throws Exception");
        }
        }

    }
    public static String calc(String input) throws IOException {

        //определим математический оператор и их число
        int firsIndexOfMultip = input.indexOf("*");
        int firsIndexOfDivision = input.indexOf("/");
        int firsIndexOfMinus = input.indexOf("-");
        int firsIndexOfPlus = input.indexOf("+");

        int lastIndexOfMathOp;

        double firstNumberInt;
        double secondNumberInt;
        String firstNumber;
        String secondNumber;

        String result = "0";
        char mathOperator;

        if ((firsIndexOfMultip>0)&&(firsIndexOfDivision==-1)&&(firsIndexOfMinus==-1)&&(firsIndexOfPlus==-1))
        {
            lastIndexOfMathOp = input.lastIndexOf("*");
            if (firsIndexOfMultip != lastIndexOfMathOp) {
                throw new IOException();
            } else {
                char[] buffChar1 =new char[firsIndexOfMultip];
                input.getChars(0, firsIndexOfMultip, buffChar1, 0);
                firstNumber = String.valueOf(buffChar1);
                firstNumber = firstNumber.trim();
                char[] buffChar2 =new char[input.length()-firsIndexOfMultip-1];
                input.getChars(firsIndexOfMultip+1, input.length(), buffChar2, 0);
                secondNumber = String.valueOf(buffChar2);
                secondNumber = secondNumber.trim();
                try {
                    firstNumberInt = Integer.parseInt(firstNumber);
                    secondNumberInt = Integer.parseInt(secondNumber);
                    if ((firstNumberInt>0)&&(firstNumberInt<11)&&(secondNumberInt>0)&&(secondNumberInt<11))
                    {
                    result = String.valueOf(firstNumberInt * secondNumberInt);}
                    else {throw new IOException();}
                }
                catch (Exception e) {
                    RomanDigits firstNumberRom = ArabicToRoman(firstNumber);
                    RomanDigits secondNumberRom = ArabicToRoman(secondNumber);
                    RomanDigits resultNumberRom = RomanDigits.XXI;
                if ((firstNumberRom != RomanDigits.CI)&&(secondNumberRom != RomanDigits.CI)){
                    resultNumberRom = RomanDigits.values()[(firstNumberRom.ordinal()+1)*(secondNumberRom.ordinal()+1)-1];
                    result = resultNumberRom.name();}
                else {
                    throw new IOException();
                }
                }
            }
        }
        else
        {
            if ((firsIndexOfMultip==-1)&&(firsIndexOfDivision>0)&&(firsIndexOfMinus==-1)&&(firsIndexOfPlus==-1))
            {
                lastIndexOfMathOp = input.lastIndexOf("/");
                if (firsIndexOfDivision != lastIndexOfMathOp) {
                    throw new IOException();
                } else {
                    char[] buffChar1 =new char[firsIndexOfDivision];
                    input.getChars(0, firsIndexOfDivision, buffChar1, 0);
                    firstNumber = String.valueOf(buffChar1);
                    firstNumber = firstNumber.trim();
                    char[] buffChar2 =new char[input.length()-firsIndexOfDivision-1];
                    input.getChars(firsIndexOfDivision+1, input.length(), buffChar2, 0);
                    secondNumber = String.valueOf(buffChar2);
                    secondNumber = secondNumber.trim();
                    try {
                        firstNumberInt = Integer.parseInt(firstNumber);
                        secondNumberInt = Integer.parseInt(secondNumber);
                        if ((firstNumberInt>0)&&(firstNumberInt<11)&&(secondNumberInt>0)&&(secondNumberInt<11)){
                        result = String.valueOf((firstNumberInt / secondNumberInt));}
                        else {throw new IOException();}
                    }
                    catch (Exception e) {
                        RomanDigits firstNumberRom = ArabicToRoman(firstNumber);
                        RomanDigits secondNumberRom = ArabicToRoman(secondNumber);
                        RomanDigits resultNumberRom = RomanDigits.XXI;
                        if ((firstNumberRom != RomanDigits.CI)&&(secondNumberRom != RomanDigits.CI)){
                            resultNumberRom = RomanDigits.values()[Math.round((firstNumberRom.ordinal()+1)/(secondNumberRom.ordinal()+1)-1)];
                            result = resultNumberRom.name();}
                        else {
                            throw new IOException();
                        }
                    }
                }
            }
            else
            {
                if ((firsIndexOfMultip==-1)&&(firsIndexOfDivision==-1)&&(firsIndexOfMinus>0)&&(firsIndexOfPlus==-1))
                {
                    lastIndexOfMathOp = input.lastIndexOf("-");
                    if (firsIndexOfMinus != lastIndexOfMathOp) {
                        throw new IOException();
                    } else {
                        char[] buffChar1 =new char[firsIndexOfMinus];
                        input.getChars(0, firsIndexOfMinus, buffChar1, 0);
                        firstNumber = String.valueOf(buffChar1);
                        firstNumber = firstNumber.trim();
                        char[] buffChar2 =new char[input.length()-firsIndexOfMinus-1];
                        input.getChars(firsIndexOfMinus+1, input.length(), buffChar2, 0);
                        secondNumber = String.valueOf(buffChar2);
                        secondNumber = secondNumber.trim();
                        try {
                            firstNumberInt = Integer.parseInt(firstNumber);
                            secondNumberInt = Integer.parseInt(secondNumber);//if (()
                            if ((firstNumberInt > secondNumberInt)&&(firstNumberInt>0)&&(firstNumberInt<11)&&(secondNumberInt>0)&&(secondNumberInt<11)) {
                            result = String.valueOf((firstNumberInt - secondNumberInt));}
                            else {throw new IOException();}
                        }
                        catch (Exception e) {
                            RomanDigits firstNumberRom = ArabicToRoman(firstNumber);
                            RomanDigits secondNumberRom = ArabicToRoman(secondNumber);
                            RomanDigits resultNumberRom = RomanDigits.XXI;
                            if ((firstNumberRom != RomanDigits.CI)&&(secondNumberRom != RomanDigits.CI)&&(firstNumberRom.ordinal()>secondNumberRom.ordinal())){
                                resultNumberRom = RomanDigits.values()[Math.round((firstNumberRom.ordinal()+1) - (secondNumberRom.ordinal()+1)-1)];
                                result = resultNumberRom.name();}
                            else {
                                throw new IOException();
                            }
                        }
                    }
                }
                else {

                        lastIndexOfMathOp = input.lastIndexOf("+");
                        if (firsIndexOfPlus != lastIndexOfMathOp) {
                            throw new IOException();
                        } else {
                            char[] buffChar1 =new char[firsIndexOfPlus];
                            input.getChars(0, firsIndexOfPlus, buffChar1, 0);
                            firstNumber = String.valueOf(buffChar1);
                            firstNumber = firstNumber.trim();
                            char[] buffChar2 =new char[input.length()-firsIndexOfPlus-1];
                            input.getChars(firsIndexOfPlus+1, input.length(), buffChar2, 0);
                            secondNumber = String.valueOf(buffChar2);
                            secondNumber = secondNumber.trim();
                            try {
                                firstNumberInt = Integer.parseInt(firstNumber);
                                secondNumberInt = Integer.parseInt(secondNumber);
                                if ((firstNumberInt>0)&&(firstNumberInt<11)&&(secondNumberInt>0)&&(secondNumberInt<11)){
                                result = String.valueOf(firstNumberInt + secondNumberInt);}
                                else {throw new IOException();}
                            }
                            catch (Exception e) {
                                RomanDigits firstNumberRom = ArabicToRoman(firstNumber);
                                RomanDigits secondNumberRom = ArabicToRoman(secondNumber);
                                RomanDigits resultNumberRom = RomanDigits.XXI;
                                if ((firstNumberRom != RomanDigits.CI)&&(secondNumberRom != RomanDigits.CI)){
                                    resultNumberRom = RomanDigits.values()[(firstNumberRom.ordinal()+1)+(secondNumberRom.ordinal()+1)-1];
                                    result = resultNumberRom.name();}
                                else {
                                    throw new IOException();
                                }
                            }
                        }
                    }


            }
        }

        return result;
    }

    static RomanDigits ArabicToRoman(String myString) {
        RomanDigits numberRom;
        switch (myString)
        {
            case "I": numberRom = RomanDigits.I;
            break;
            case "II": numberRom = RomanDigits.II;
                break;
            case "III": numberRom = RomanDigits.III;
                break;
            case "IV": numberRom = RomanDigits.IV;
                break;
            case "V": numberRom = RomanDigits.V;
                break;
            case "VI": numberRom = RomanDigits.VI;
                break;
            case "VII": numberRom = RomanDigits.VII;
                break;
            case "VIII": numberRom = RomanDigits.VIII;
                break;
            case "IX": numberRom = RomanDigits.IX;
                break;
            case "X": numberRom = RomanDigits.X;
                break;
            default: numberRom = RomanDigits.CI;
        }
        return numberRom;
    }
}
