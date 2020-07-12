package Finite_state.Code;

import java.util.ArrayList;
import java.util.Random;

public class Node {
    private String Current;
    //de aankomende 3 lists zijn mijn lists voor het eerste gedeelte(functie:getNextStep).
    private ArrayList<Node> afgelopenStappenInNodes = new ArrayList<>();
    public ArrayList<Node> gelinkteNodes = new ArrayList<>();
    private ArrayList<String> afgelopenStappenInStrings = new ArrayList<>();
 
    //de aankomende 2 lists zijn mijn lists voor het tweede gedeelte(functie: getVolgendeWorp).
    private ArrayList<Node> voorgaandeWorpenInNodes = new ArrayList<>();
    private ArrayList<String> voorgaandeWorpenInStrings = new ArrayList<>();

    //de current gebruik ik overal om te zien in welke node ik op het moment zit als string.
    public Node(String cr) {
        this.Current = cr;
    }

    //in deze functie zorg ik ervoor dat er een arraylist per node onstaat waarin alle mogelijke transities per node staan.
    public void setFollowingNodes(Node val_nd) {
        gelinkteNodes.add(val_nd);
    }

    //functie getNextStep aanroepen met juiste waardes.
    public ArrayList<String> getNextStepAanroepen(Node at, String inputWord) {
        ArrayList<Integer> nogNietVerwerkteNodes = new ArrayList<>();
        String alphabet = "abcdefghijklmnopqrstuvwqyz";

        //Verkrijgen index in alfabet van iedere ingevoerde letter .
        int index = 0;
        while (index < inputWord.length()) {
            for (int i = 0; i < alphabet.length(); i++) {
                if (alphabet.charAt(i) == inputWord.charAt(index)) {
                    nogNietVerwerkteNodes.add(i);
                }
            }
            index += 1;
        }
        getNextStep(at, nogNietVerwerkteNodes, afgelopenStappenInNodes, afgelopenStappenInStrings);
        return afgelopenStappenInStrings;
    }

    //in deze methode zorg ik ervoor dat het goede pad wordt gevolgd.
    public ArrayList<Node> getNextStep(Node at, ArrayList<Integer> nogNietVerwerkteNodes, ArrayList<Node> afgelopenStappenInNodes, ArrayList<String> afgelopenStappenInStrings) {
        try {
            //beide lijsten toevoegen in welke node je nu bent zowel als node en als string.
            afgelopenStappenInNodes.add(at);
            afgelopenStappenInStrings.add(Current);
            if (nogNietVerwerkteNodes.size() != 0) {
                //verwijderen van de Node die verwerkt is en de volgende node aanroepen
                Node nextNode = gelinkteNodes.get(nogNietVerwerkteNodes.get(0));
                nogNietVerwerkteNodes.remove(0);
                nextNode.getNextStep(nextNode, nogNietVerwerkteNodes, afgelopenStappenInNodes, afgelopenStappenInStrings);
            }
            return afgelopenStappenInNodes;
        } catch (Exception e) {
            //voor als er een letter is zonder die niet gekoppeld kan worden aan een stap
            afgelopenStappenInStrings.add("None");
            return afgelopenStappenInNodes;
        }
    }

    //in deze methode zorg ik dat de functie getVolgendeWorp word aangeroepen met de juiste waardes.
    public ArrayList<String> getVolgendeWorpAanroepen(Node Now) {
        getVolgendeWorp(Now, voorgaandeWorpenInNodes, voorgaandeWorpenInStrings);
        return voorgaandeWorpenInStrings;
    }

    //in deze methode wordt er gezorgd dat het goede pad wordt gevold.
    public ArrayList<Node> getVolgendeWorp(Node Now, ArrayList<Node> voorgaandeWorpenInNodes, ArrayList<String> voorgaandeWorpenInStrings) {
        voorgaandeWorpenInNodes.add(Now);
        voorgaandeWorpenInStrings.add(Current);

        if (!Current.contains("eind")) {
            //hier maak ik een random aan naar de lengte van hoeveel transities er zijn. zijn er 2 mogelijke transities dan zal er 0 of 1 gekozen worden en zijn er 8 mogelijke overgangen zullen er van 0 tot 8 mogelijke getallen uitkomen.
            //zo zorg ik ervoor dat de code reusable is en de kans om een pad te volgen niet altijd 50/50 is.
            Random randomWorp = new Random();
            int nmr = randomWorp.nextInt(gelinkteNodes.size());
            Node volgendeNode = gelinkteNodes.get(nmr);
            //hier pak ik de transitie die gekozen is door de random en roep met die transitie weer een nieuwe getFollow aan.
            gelinkteNodes.get(nmr).getVolgendeWorp(volgendeNode, voorgaandeWorpenInNodes, voorgaandeWorpenInStrings);
        } else {
            return voorgaandeWorpenInNodes;
        }
        return voorgaandeWorpenInNodes;
    }
}