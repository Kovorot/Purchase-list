package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    public static List<String> list = new ArrayList<>();

    @Test
    void testAddMethod() {
        String text = "Бутерброд";
        String result = Main.add(text);
        Assertions.assertEquals(text, result);
    }

    @Test
    void testSearchMethod() {
        String text = "Банан";
        //Main.list.add(text);
        String result = Main.search(text);
        Assertions.assertEquals(result, text.toLowerCase());
    }

    @Test
    void testShowListMethod() {
        list.add("Булочка");
        //list.clear();
        boolean isEmpty = true;
        boolean result = Main.showList(list);
        Assertions.assertEquals(isEmpty, result);
    }
}