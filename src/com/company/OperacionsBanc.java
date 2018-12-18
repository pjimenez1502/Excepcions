package com.company;

import com.company.Exceptions.BankAccountException;
import com.company.Exceptions.ClientAccountException;
import com.company.Exceptions.ExceptionMessage;

import java.util.List;

public class OperacionsBanc {


    public static boolean verifyDNI(String dni) throws BankAccountException{

        if (dni.matches("\\d{8}[a-z]"))
            return true;
        else
            throw new BankAccountException(ExceptionMessage.WRONG_DNI);
    }



}