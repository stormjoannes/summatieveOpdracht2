package Finite_state.Code;

import java.util.ArrayList;
import java.util.Scanner;

public class  Main {
    public static void main(String[] arg) {

        //hier maak ik mijn nodes aan die ik in mijn schema heb staan: 1, 2, 3 en 4.
        Node s0 = new Node("s0");
        Node s1 = new Node("s1");
        Node s2 = new Node("s2");
        Node s3 = new Node("s3");

        //hier zet ik de transitie per node neer naar waar die zou moeten kunnen gaan.
        s0.setFollowingNodes(s1);
        s0.setFollowingNodes(s3);
        s1.setFollowingNodes(s1);
        s1.setFollowingNodes(s3);
        s2.setFollowingNodes(s0);
        s2.setFollowingNodes(s1);
        s3.setFollowingNodes(s3);
        s3.setFollowingNodes(s2);

        //hier zet je je input neer, hoe hoger de letters die je plaatst hoe hogere connecties je moet maken. als je dus 0 en 1 plaatst heb je dus 2 connecties. als je ergens een 7 plaatst moet je dus zorgen dat je 7 connecties hebt bij je nodes.


        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the configuration: ");
        String inputWord = myObj.nextLine();

//        nogNietVerwerkteNodes.add(1);
//        nogNietVerwerkteNodes.add(1);
//        nogNietVerwerkteNodes.add(0);

        //hier print ik mijn resultaat
        System.out.println("A: " + s0.getNextStepAanroepen(s0, inputWord.toLowerCase()));

        //hier maak ik weer al mijn nodes aan volgens het schema.
        Node g0 = new Node("g0");
        Node g1 = new Node("g1");
        Node g2 = new Node("g2");
        Node g3 = new Node("g3");
        Node g4 = new Node("g4");
        Node g5 = new Node("g5");
        Node g6 = new Node("g6");
        Node g7 = new Node("g7");
        Node g8 = new Node("g8");
        Node g9 = new Node("g9");

        //hier maak ik de dobbelsteen ogen aan.
        Node e1 = new Node("eind-1");
        Node e2 = new Node("eind-2");
        Node e3 = new Node("eind-3");
        Node e4 = new Node("eind-4");
        Node e5 = new Node("eind-5");
        Node e6 = new Node("eind-6");
        Node e7 = new Node("eind-7");
        Node e8 = new Node("eind-8");
        Node e9 = new Node("eind-9");
        Node e10 = new Node("eind-10");

        //hier zet ik weer per node alle transities.
        g0.setFollowingNodes(g1);
        g0.setFollowingNodes(g2);
        g0.setFollowingNodes(g3);

        g1.setFollowingNodes(g4);
        g1.setFollowingNodes(g5);


        g2.setFollowingNodes(g6);
        g2.setFollowingNodes(g7);

        g3.setFollowingNodes(g8);
        g3.setFollowingNodes(g9);

        g4.setFollowingNodes(g1);
        g4.setFollowingNodes(e1);

        g5.setFollowingNodes(e2);
        g5.setFollowingNodes(e3);

        g6.setFollowingNodes(e4);
        g6.setFollowingNodes(e5);

        g7.setFollowingNodes(e6);
        g7.setFollowingNodes(e7);

        g8.setFollowingNodes(e8);
        g8.setFollowingNodes(e9);

        g9.setFollowingNodes(g3);
        g9.setFollowingNodes(e10);

        //hier print ik weer het eindresultaat
        System.out.println("B: " + g0.getVolgendeWorpAanroepen(g0));
    }
}