package com.company;

import com.company.Exceptions.BankAccountException;
import com.company.Exceptions.ClientAccountException;
import com.company.Exceptions.ExceptionMessage;

public class Client {
    private String Nom;
    private String Cognoms;
    private String DNI;

    public Client(String nom, String cognoms, String DNI) {
        Nom = nom;
        Cognoms = cognoms;
        try {
            if (OperacionsBanc.verifyDNI(DNI)) this.DNI = DNI;
        }catch (BankAccountException e){
            e.printStackTrace();
        }

    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getCognoms() {
        return Cognoms;
    }

    public void setCognoms(String cognoms) {
        Cognoms = cognoms;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        try {
            if (OperacionsBanc.verifyDNI(DNI)) this.DNI = DNI;
        }catch (BankAccountException e){
            e.printStackTrace();
        }
    }

    public void transferencia(CompteEstalvi font, CompteEstalvi desti, double suma) throws BankAccountException, ClientAccountException {

        if (font==null || desti == null){
            throw new BankAccountException(ExceptionMessage.ACCOUNT_NOT_FOUND);
        }else {
            if (suma<0){
                throw new ClientAccountException(ExceptionMessage.TRANSFER_ERROR);
            }else if (font.getSaldo() < suma){
                throw new BankAccountException(ExceptionMessage.ACCOUNT_OVERDRAFT);
            }else {
                font.treure(suma);
                desti.ingressar(suma);

            }
        }

    }

}