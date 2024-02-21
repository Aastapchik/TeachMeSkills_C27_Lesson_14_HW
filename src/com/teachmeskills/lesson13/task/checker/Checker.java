package com.teachmeskills.lesson13.task.checker;

import com.teachmeskills.lesson13.task.consts.Consts;

import java.io.FileWriter;
import java.io.IOException;
/*
The method of this class performs a number of the following functions:
1. Checks whether the length of the string is equal to STR_CONST. If not, it terminates the program and writes a log.
2. Checks whether the string begins with docnum or contract character set. If not, it terminates the program and writes a log.
3. Checks suitable files to see if their names contain service characters. If contained, the program ends with a corresponding entry in the log.
4. Suitable files with the docnum are written to the log_docnum file, with the name contract - to the file log_contract
 */
public class Checker {

    public static void checkDoc(String s, String s1, String s2, String filePathErr, String filePathDoc, String filePathContract) throws IOException {

        FileWriter fileWriterErr = new FileWriter(filePathErr, true);
        FileWriter fileWriterDoc = new FileWriter(filePathDoc, true);
        FileWriter fileWriterContract = new FileWriter(filePathContract, true);
        try {
            if(s.isEmpty()) return;
            if (s.length() != Consts.STR_LEN) {
                fileWriterErr.write("Длина строки должна быть равна " + Consts.STR_LEN + ". Была введена строка " + s +  " длиной "+ s.length() + ".\n");
                return;
            }
            char[] chars = s.toCharArray();
            if(!s.startsWith(s1) && !s.startsWith(s2)) fileWriterErr.write("Строка " + s + " не является валидной. Начало документа не соответствует требованиям.\n");
            else if (s.startsWith(s1)) {
                for (int i = 0; i < s.length(); i++) {
                    if (!Character.isDigit(chars[i]) && !Character.isLetter(chars[i])) {
                        fileWriterErr.write("Строка " + s + " не является валидной. Присутствует служебный символ.\n");
                        return;
                    }
                }
                fileWriterDoc.write("Подходящий номер документа: " + s+ "\n");
            } else if (s.startsWith(s2)) {
                for (int i = 0; i < s.length(); i++) {
                    if (!Character.isDigit(chars[i]) && !Character.isLetter(chars[i])) {
                        fileWriterErr.write("Строка " + s + " не является валидной. Присутствует служебный символ.\n");
                        return;
                    }
                }
                fileWriterContract.write("Подходящий номер контракта: " + s + "\n");
            }
        } catch (IOException e)
        {
            fileWriterErr.write("При обработке строки " + s + "произошла непредвиденная ошибка.\n");
            System.out.println("Произошла непредвиденная ошибка");
        } catch (Exception e){
            fileWriterErr.write("При обработке строки " + s + "произошла критическая ошибка.\n");
            System.out.println("Произошла еще более непредвиденная ошибка.");
        }
        finally {
            fileWriterErr.close();
            fileWriterDoc.close();
            fileWriterContract.close();
        }
    }
}
