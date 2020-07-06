package Finite_state.Code;

import java.util.ArrayList;
import java.util.Random;

public class Node {
    private String Current;
    //de aankomende 3 lists zijn mijn lists voor het eerste gedeelte(getFollow).
    private ArrayList<Node> done = new ArrayList<>();
    public ArrayList<Node> Follows = new ArrayList<>();
    private ArrayList<String> str_done = new ArrayList<>();

    //de aankomende 2 lists zijn mijn lists voor het tweede gedeelte(getFollow_2).
    private ArrayList<Node> done_2 = new ArrayList<>();
    private ArrayList<String> str_gedaan = new ArrayList<>();

    //de current gebruik ik overal om te zien in welke node ik op het moment zit.
    public Node(String cr) {
        this.Current = cr;
    }

    //in deze methode zorg ik ervoor dat het goede pad wordt gevolgd en alles overal aan toegevoegd word.
    public ArrayList<Node> getFollow(Node at, ArrayList<Integer> ToDo, ArrayList<Node> done, ArrayList<String> str_done) {
        done.add(at);
        str_done.add(Current);
        if (ToDo.size() != 0) {
            if (!Current.contains("None")) {
                //hier zorg ik dat de 1e van de lijst die afgelopen moet worden apart wordt genomen zodat ik vervolgens die eerste kan verwijderen om deze lijst weer mee te geven naar de volgende node.
                Node nxt = Follows.get(ToDo.get(0));
                ToDo.remove(0);
                nxt.getFollow(nxt, ToDo, done, str_done);
            } else {
                //hier zorg ik ervoor dat als velen paden 2 transities hebben en 1 node bijvoorbeeld 1 transitie heeft dat de code niet vastloopt omdat er een none wordt gekozen.
                ToDo.remove(0);
                at.getFollow(at, ToDo, done, str_done);
            }
        } else {
            return done;
        }
        return done;
    }

    //in deze methode zorg ik dat het begin en eind goed verloopt. Deze functie returned hetzelfde als de functie hier boven returned.
    public ArrayList<String> getFollow(Node at, ArrayList<Integer> ToDo) {
        getFollow(at, ToDo, done, str_done);
        return str_done;
    }

    //in deze functie zorg ik ervoor dat er een arraylist per node onstaat waarin de transities staan per node.
    public void setFollow(Node val_nd) {
        Follows.add(val_nd);
    }


    //in deze methode wordt er gezorgd dat het goede pad wordt gevold en alles goed aangepast word.
    public ArrayList<Node> getFollow_2(Node Now, ArrayList<Node> done, ArrayList<String> str_gedaan) {
        done.add(Now);
        str_gedaan.add(Current);

        if (!Current.contains("eind")) {
            //hier maak ik een random aan naar de lengte van hoeveel transities er zijn. zijn er 2 mogelijke transities dan zal er 0 of 1 gekozen worden en zijn er 8 mogelijke overgangen zullen er van 0 tot 8 mogelijke getallen uitkomen.
            //zo zorg ik ervoor dat de code reusable is en de kans om een pad te volgen niet altijd 50/50 is.
            Random rand = new Random();
            int nmr = rand.nextInt(Follows.size());
            Node nxt = Follows.get(nmr);
            //hier pak ik de transitie die gekozen is door de random en roep met die transitie weer een nieuwe getFollow aan.
            Follows.get(nmr).getFollow_2(nxt, done, str_gedaan);
        } else {
            return done;
        }
        return done;
    }

    //in deze methode zorg ik dat het begin en eind goed verloopt. Deze functie returned hetzelfde als de functie hier boven returned.
    public ArrayList<String> getFollow_2(Node Now) {
        getFollow_2(Now, done_2, str_gedaan);
        return str_gedaan;
    }
}