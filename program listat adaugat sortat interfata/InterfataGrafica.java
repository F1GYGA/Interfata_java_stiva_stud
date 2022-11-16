import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import poo.test1.util.ExceptieStivaGoala;
import poo.test1.util.ExceptieStivaPlina;
import poo.test1.util.SortareListaGoala;
import poo.test1.util.StivaDeComparabile;

public class InterfataGrafica extends JFrame {

    private JLabel labelNume = new JLabel("Nume:");
    private JLabel labelPrezenta = new JLabel("Prezenta:");
    private JLabel labelContinut = new JLabel("Continut stiva studenti:");
    private JButton buttonAdauga = new JButton("Adauga");
    private JButton buttonSterge = new JButton("Sterge");
    private JButton buttonSorteaza = new JButton("Sorteaza");
    private JTextField textNume = new JTextField("", 10);
    private JTextField textPrezenta = new JTextField("", 10);
    private JTextArea textContinut = new JTextArea("", 10, 50);

    StivaDeComparabile stiva = new StivaDeComparabile(5);

    public InterfataGrafica() {
        buttonAdauga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eAdauga) { // cod pentru buton adauga
                String id = ((JButton) eAdauga.getSource()).getText();

                if (id.equals("Adauga")) {
                    try {

                        stiva.adaugareElement(
                                new Student(textNume.getText(), Integer.parseInt(textPrezenta.getText())));
                        textContinut.setText(stiva.getStringElemente());

                    } catch (ExceptieStivaPlina stivaPlina) {
                        JOptionPane.showMessageDialog(InterfataGrafica.this, "Lista de studenti este plina", "Atentie",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        buttonSorteaza.addActionListener(new ActionListener() { // cod pentru buton sorteaza
            public void actionPerformed(ActionEvent eSorteaza) {
                String id = ((JButton) eSorteaza.getSource()).getText();

                if (id.equals("Sorteaza")) {
                    try {

                        stiva.sortareElemente();
                        textContinut.setText(stiva.getStringElemente());

                    } catch (SortareListaGoala exstivaGoala) { 
                        JOptionPane.showMessageDialog(InterfataGrafica.this, "Nu sunt elemente de sortat", "Atentie",
                                JOptionPane.INFORMATION_MESSAGE);
                    }

                }
            }
        });
        buttonSterge.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eSterge) { // cod pentur buton stergere
                String id = ((JButton) eSterge.getSource()).getText();

                if (id.equals("Sterge")) {
                    try {
                        stiva.eliminareElement();
                        textContinut.setText(stiva.getStringElemente());
                    } catch (ExceptieStivaGoala stivaGoala) {
                        JOptionPane.showMessageDialog(InterfataGrafica.this, "Lista de studenti este goala", "Atentie",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        // labels Nume si prezenta
        Box bhNume = Box.createHorizontalBox();
        bhNume.add(labelNume);
        bhNume.add(Box.createHorizontalStrut(10));
        bhNume.add(textNume);
        bhNume.add(Box.createHorizontalStrut(10));
        bhNume.add(Box.createHorizontalGlue());

        Box bhPrezenta = Box.createHorizontalBox();
        bhPrezenta.add(labelPrezenta);
        bhPrezenta.add(Box.createHorizontalStrut(10));
        bhPrezenta.add(textPrezenta);
        bhPrezenta.add(Box.createHorizontalStrut(10));
        bhPrezenta.add(Box.createHorizontalGlue());

        // sectiune afisare studenti
        Box bhText = Box.createHorizontalBox();
        bhText.add(labelContinut);
        bhText.add(Box.createHorizontalStrut(10));
        bhText.add(Box.createHorizontalGlue());

        Box bhAfisareText = Box.createHorizontalBox();
        bhAfisareText.add(textContinut);
        bhAfisareText.add(Box.createHorizontalStrut(10));
        bhAfisareText.add(Box.createHorizontalGlue());
        // lipire sectiuni nume prezenta + textarea
        Box bv1 = Box.createVerticalBox();
        bv1.add(Box.createVerticalStrut(10));
        bv1.add(bhNume);
        bv1.add(Box.createVerticalStrut(10));
        bv1.add(bhPrezenta);
        bv1.add(Box.createVerticalStrut(10));
        bv1.add(bhText);
        bv1.add(Box.createVerticalStrut(10));
        bv1.add(bhAfisareText);
        bv1.add(Box.createVerticalStrut(10));
        bv1.add(Box.createVerticalGlue());

        // butoane

        // butonul adauga
        Box bhAdauga = Box.createVerticalBox();
        bhAdauga.add(Box.createVerticalStrut(10));
        bhAdauga.add(buttonAdauga);
        bhAdauga.add(Box.createVerticalGlue());

        // butonul2 sterge
        Box bhSterge = Box.createVerticalBox();
        bhSterge.add(Box.createVerticalStrut(10));
        bhSterge.add(buttonSterge);
        bhSterge.add(Box.createVerticalGlue());

        // butonul sorteaza
        Box bhSorteaza = Box.createVerticalBox();
        bhSorteaza.add(Box.createVerticalStrut(10));
        bhSorteaza.add(buttonSorteaza);
        bhSorteaza.add(Box.createVerticalGlue());
        // lipire butoane intre ele
        Box bv2 = Box.createVerticalBox();
        bv2.add(Box.createVerticalStrut(10));
        bv2.add(bhAdauga);
        bv2.add(Box.createVerticalStrut(10));
        bv2.add(bhSterge);
        bv2.add(Box.createVerticalStrut(10));
        bv2.add(bhSorteaza);
        bv2.add(Box.createVerticalStrut(10));
        bv2.add(Box.createVerticalGlue());
        // concatenarea elementelor verticale
        Box bh6 = Box.createHorizontalBox();
        bh6.add(Box.createHorizontalStrut(10));
        bh6.add(bv1);
        bh6.add(Box.createHorizontalStrut(50));
        bh6.add(bv2);
        bh6.add(Box.createHorizontalStrut(10));
        bh6.add(Box.createHorizontalStrut(10));
        bh6.add(Box.createHorizontalGlue());

        Container cp = getContentPane();
        cp.add(BorderLayout.CENTER, bh6);

    }

    public static void main(String[] args) {
        InterfataGrafica ig = new InterfataGrafica();

        ig.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ig.setSize(500, 250);

        ig.setVisible(true);

    }
}
