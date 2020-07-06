package Finite_state.tests;

import Finite_state.Code.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

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
        s2.setFollow(s0);
        s2.setFollow(s1);
        s3.setFollow(s3);
        s3.setFollow(s2);

        ToDo.add(1);
        ToDo.add(1);
        ToDo.add(0);

        expected.add("s0");
        expected.add("s3");
        expected.add("s2");
        expected.add("s0");

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
        s2.setFollow(s0);
        s2.setFollow(s1);
        s3.setFollow(s3);
        s3.setFollow(s2);

        ToDo.add(1);
        ToDo.add(1);
        ToDo.add(0);

        expected.add("s0");
        expected.add("s3");
        expected.add("s2");
        expected.add("s0");

        assertEquals(expected, s0.getFollow(s0, ToDo));
    }

    @Test
    void setFollow() {
        Node g2 = new Node("g2");
        Node g6 = new Node("g6");

        Node e6 = new Node("eind-6");

        g6.setFollow(g2);
        g6.setFollow(e6);

        //ik kijk hier of de method de goeie arraylist met transities aanmaakt.
        assertEquals(g6.Follows.get(0), g2);
        assertEquals(g6.Follows.get(1), e6);
    }

    @Test
    void getFollow_2() {
        Node g0 = new Node("g0");
        Node g1 = new Node("g1");
        Node g2 = new Node("g2");

        Node e1 = new Node("eind-1");
        Node e2 = new Node("eind-2");

        g0.setFollow(g1);
        g0.setFollow(g2);
        g1.setFollow(g0);
        g1.setFollow(e1);
        g2.setFollow(g0);
        g2.setFollow(e2);

        ArrayList<String> need = g0.getFollow_2(g0);
        String exp = need.get(need.size() - 1);
        //hier kijk ik of wat er uit komt niet g0, g1, g2 is of iets dat niet eind bevat.
        assertNotEquals(g0, exp);
        assertNotEquals(g1, exp);
        assertNotEquals(g2, exp);
        assertEquals(6, exp.length());
    }

    @Test
    void testGetFollow_2() {
        // deze test is precies dezelfde als de test hierboven, dit omdat deze methode er alleen voor bestemd is om het begin op de juiste manier te laten verlopen, dit betekent dat dit precies hetzelfde returned als de getfollow hierboven.
        Node g0 = new Node("g0");
        Node g1 = new Node("g1");
        Node g2 = new Node("g2");

        Node e1 = new Node("eind-1");
        Node e2 = new Node("eind-2");

        g0.setFollow(g1);
        g0.setFollow(g2);
        g1.setFollow(g0);
        g1.setFollow(e1);
        g2.setFollow(g0);
        g2.setFollow(e2);

        ArrayList<String> need = g0.getFollow_2(g0);
        String exp = need.get(need.size() - 1);
        //hier kijk ik of wat er uit komt niet g0, g1, g2 is of iets dat niet eind bevat.
        assertNotEquals(g0, exp);
        assertNotEquals(g1, exp);
        assertNotEquals(g2, exp);
        assertEquals(6, exp.length());
    }
}