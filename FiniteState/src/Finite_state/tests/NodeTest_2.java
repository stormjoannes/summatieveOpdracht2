package Finite_state.tests;

import Finite_state.Code.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest_2 {

    @Test
    void getFollow() {
        Node s0 = new Node("s0");
        Node s1 = new Node("s1");
        Node s2 = new Node("s2");
        Node s3 = new Node("s3");
        ArrayList<Integer> ToDo = new ArrayList<>();
        ArrayList<String> expected = new ArrayList<>();

        s0.setFollow(s1);
        s0.setFollow(s3);
        s1.setFollow(s1);
        s1.setFollow(s3);
        s2.setFollow(s1);
        s3.setFollow(s3);
        s3.setFollow(s2);

        ToDo.add(0);
        ToDo.add(0);
        ToDo.add(1);

        expected.add("s0");
        expected.add("s1");
        expected.add("s1");
        expected.add("s3");

        assertEquals(expected, s0.getFollow(s0, ToDo));
    }

    @Test
    void testGetFollow() {
        // deze test is precies dezelfde als de test hierboven, dit omdat deze methode er alleen voor bestemd is om het begin op de juiste manier te laten verlopen, dit betekent dat dit precies hetzelfde returned als de getfollow hierboven.
        Node s0 = new Node("s0");
        Node s1 = new Node("s1");
        Node s2 = new Node("s2");
        Node s3 = new Node("s3");
        ArrayList<Integer> ToDo = new ArrayList<>();
        ArrayList<String> expected = new ArrayList<>();

        s0.setFollow(s1);
        s0.setFollow(s3);
        s1.setFollow(s1);
        s1.setFollow(s3);
        s2.setFollow(s1);
        s3.setFollow(s2);

        ToDo.add(0);
        ToDo.add(0);
        ToDo.add(1);

        expected.add("s0");
        expected.add("s1");
        expected.add("s1");
        expected.add("s3");

        assertEquals(expected, s0.getFollow(s0, ToDo));
    }

    @Test
    void setFollow() {
        Node g1 = new Node("g2");
        Node g4 = new Node("g6");

        Node e1 = new Node("eind-6");

        g4.setFollow(g1);
        g4.setFollow(e1);

        //ik kijk hier of de method de goeie arraylist met transities aanmaakt.
        assertEquals(g4.Follows.get(0), g1);
        assertEquals(g4.Follows.get(1), e1);
    }

    @Test
    void getFollow_2() {
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

        g0.setFollow(g1);
        g0.setFollow(g2);
        g0.setFollow(g3);

        g1.setFollow(g4);
        g1.setFollow(g5);


        g2.setFollow(g6);
        g2.setFollow(g7);

        g3.setFollow(g8);
        g3.setFollow(g9);

        g4.setFollow(g1);
        g4.setFollow(e1);

        g5.setFollow(e2);
        g5.setFollow(e3);

        g6.setFollow(e4);
        g6.setFollow(e5);

        g7.setFollow(e6);
        g7.setFollow(e7);

        g8.setFollow(e8);
        g8.setFollow(e9);

        g9.setFollow(g3);
        g9.setFollow(e10);

        ArrayList<String> need = g0.getFollow_2(g0);
        String exp = need.get(need.size() - 1);
        //hier kijk ik of wat er uit komt niet g0, g1, g2, g3, g4, g5, g6, g7, g8, g9 is of iets dat niet eind bevat.
        assertNotEquals(g0, exp);
        assertNotEquals(g1, exp);
        assertNotEquals(g2, exp);
        assertNotEquals(g3, exp);
        assertNotEquals(g4, exp);
        assertNotEquals(g5, exp);
        assertNotEquals(g6, exp);
        assertNotEquals(g7, exp);
        assertNotEquals(g8, exp);
        assertNotEquals(g9, exp);
        assertEquals(6, exp.length());
    }

    @Test
    void testGetFollow_2() {
        // deze test is precies dezelfde als de test hierboven, dit omdat deze methode er alleen voor bestemd is om het begin op de juiste manier te laten verlopen, dit betekent dat dit precies hetzelfde returned als de getfollow hierboven.
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

        g0.setFollow(g1);
        g0.setFollow(g2);
        g0.setFollow(g3);

        g1.setFollow(g4);
        g1.setFollow(g5);


        g2.setFollow(g6);
        g2.setFollow(g7);

        g3.setFollow(g8);
        g3.setFollow(g9);

        g4.setFollow(g1);
        g4.setFollow(e1);

        g5.setFollow(e2);
        g5.setFollow(e3);

        g6.setFollow(e4);
        g6.setFollow(e5);

        g7.setFollow(e6);
        g7.setFollow(e7);

        g8.setFollow(e8);
        g8.setFollow(e9);

        g9.setFollow(g3);
        g9.setFollow(e10);

        ArrayList<String> need = g0.getFollow_2(g0);
        String exp = need.get(need.size() - 1);
        //hier kijk ik of wat er uit komt niet g0, g1, g2, g3, g4, g5, g6, g7, g8, g9 is of iets dat niet eind bevat.
        assertNotEquals(g0, exp);
        assertNotEquals(g1, exp);
        assertNotEquals(g2, exp);
        assertNotEquals(g3, exp);
        assertNotEquals(g4, exp);
        assertNotEquals(g5, exp);
        assertNotEquals(g6, exp);
        assertNotEquals(g7, exp);
        assertNotEquals(g8, exp);
        assertNotEquals(g9, exp);
        assertEquals(6, exp.length());
    }
}