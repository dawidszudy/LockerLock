package pl.pp.LockerLock;

import javax.swing.*;
import java.awt.*;

import static pl.pp.LockerLock.Utils.resultCode;
import static pl.pp.LockerLock.Utils.resultLock;

public class FrameLock extends JFrame {

    public FrameLock() {
        setTitle("Lock Gym");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocation(400, 200);

        resultCode = new JLabel("", JLabel.RIGHT);
        resultCode.setPreferredSize(new Dimension(0, 70));  //rozmiar okienka
        Font fontLabel = resultCode.getFont();                                  //stworzenie czcionki
        resultCode.setFont(new Font(fontLabel.getName(), Font.PLAIN, 40));  //rozmiar czcionki

        resultLock = new JLabel("unlocked", JLabel.RIGHT);
        resultLock.setPreferredSize(new Dimension(0, 70));  //rozmiar okienka
        resultLock.getFont();                                  //stworzenie czcionki
        resultLock.setFont(new Font(fontLabel.getName(), Font.PLAIN, 40));  //rozmiar czcionki

        JPanel panel = new JPanel();

        JButton button1 = new Button("1");
        JButton button2 = new Button("2");
        JButton button3 = new Button("3");
        JButton button4 = new Button("4");
        JButton button5 = new Button("5");
        JButton button6 = new Button("6");
        JButton button7 = new Button("7");
        JButton button8 = new Button("8");
        JButton button9 = new Button("9");
        JButton button0 = new Button("0");

        panel.setLayout(new GridLayout(5, 2));

        panel.add(button1);
        panel.add(button2);

        panel.add(button3);
        panel.add(button4);

        panel.add(button5);
        panel.add(button6);

        panel.add(button7);
        panel.add(button8);

        panel.add(button9);
        panel.add(button0);

        add(panel);
//        add(resultCode, BorderLayout.NORTH);
        add(resultLock, BorderLayout.SOUTH);
    }

}