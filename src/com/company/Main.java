package com.company;

import com.company.Exceptions.BankAccountException;
import com.company.Exceptions.ClientAccountException;

public class Main {

    public static void main(String[] args) {

        Client client = new Client("name","congoms", "88888888a");



        CompteEstalvi ce1 = new CompteEstalvi("compte1");
        CompteEstalvi ce2 = new CompteEstalvi("compte2");

        CompteEstalvi ce3 = new CompteEstalvi("");


        try {
            ce1.treure(10);
        } catch (BankAccountException e) {
            e.printStackTrace();
        }

        ce1.addUser(client);

        try {
            ce1.removeUser("88888888a");
        } catch (BankAccountException e) {
            e.printStackTrace();
        }

        try {
            client.transferencia(ce1, ce2, 10);
        } catch (BankAccountException e) {
            e.printStackTrace();
        } catch (ClientAccountException e) {
            e.printStackTrace();
        }


    }
}
