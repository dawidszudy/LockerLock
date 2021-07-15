package pl.pp.LockerLock;

import javax.swing.*;

import static pl.pp.LockerLock.Utils.resultCode;
import static pl.pp.LockerLock.Utils.resultLock;

public class Button extends JButton {

    private static String allCode = "";
    private static String code1 = "";
    private static String code2 = "";
    private static String unlockCode = "";
    private static int digitNumber;
    private static String sign;


    public Button(String sign) {
        super(sign);

        addActionListener(actionEvent -> {
            Button.sign = sign;
            resultCode.setText(resultCode.getText() + sign);

            setCode();

            setLock();

            checkCode();

            infoConsole();

        });

    }

    private static void infoConsole() {
        System.out.println();
        System.out.println("allCode: " + allCode);
        System.out.println("code1: " + code1);
        System.out.println("code2: " + code2);
        System.out.println("unlockCode: " + unlockCode);
        System.out.println("numberDigit: " + digitNumber);
    }

    private static void setLock() {
        if ( resultLock.getText().equals(PositionMechanism.LOCKED.getPosition())
                || resultLock.getText()
                .equals(PositionMechanism.FAILUREUNLOCKED.getPosition()) ) {
            unlockCode += sign;
            digitNumber = unlockCode.length();

            if ( unlockCode.length() == 4 ) {
                if ( unlockCode.equals(code2) && unlockCode.equals(code1) ) {
                    resultLock.setText(PositionMechanism.UNLOCKED.getPosition());
                    resultCode.setText("");
                    unlockCode = "";
                    allCode = "";
                    code1 = "";
                    code2 = "";
                } else {
                    resultLock.setText(PositionMechanism.FAILUREUNLOCKED.getPosition());
                    resultCode.setText("");
                    unlockCode = "";
                }
            }
        }
    }

    private static void checkCode() {
        if ( allCode.length() == 8 ) {
            code1 = allCode.substring(0, 4);
            code2 = allCode.substring(4, 8);
            allCode = "";
            if ( code1.equals(code2) ) {
                resultCode.setText("");
                resultLock.setText(PositionMechanism.LOCKED.getPosition());
            } else {
                resultCode.setText("");
                resultLock.setText(PositionMechanism.FAILURE.getPosition());
                code1 = "";
                code2 = "";
            }
        }
    }

    private static void setCode() {
        if ( allCode.length() <= 8 && code1.length() != 4 && code2.length() != 4 ) {
            allCode += sign;
            if ( digitNumber == 4 ) {
                digitNumber = 0;
            }
            digitNumber++;
        }
    }

}
