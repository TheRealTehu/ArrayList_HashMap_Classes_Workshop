package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //1. Feladat
        //Egy Harry Potter rajongónak van egy listája a könyveiről. Szeretné megtudni hány könyv van meg neki a sorozatból.
        //Mivel mindenki tudja róla, hogy nagy könyv rajongó így előfordul hogy többen is ugyanazt a könyvet veszik meg neki karácsonyra.
        // kapunk egy listát könyvekről ami tartalmazhatja többször is ugyanazt a könyvet. Írjuk ki hány különböző könyv van a listában.

        List<String> bookTitles1 = new ArrayList<>() {{
            add("Harry Potter és a bölcsek köve");
            add("Harry Potter és a Titkok Kamrája");
            add("Harry Potter és az azkabani fogoly");
        }};

        List<String> bookTitles2 = new ArrayList<>() {{
            add("Harry Potter és a bölcsek köve");
            add("Harry Potter és a bölcsek köve");
            add("Harry Potter és a Titkok Kamrája");
            add("Harry Potter és a Titkok Kamrája");
            add("Harry Potter és az azkabani fogoly");
        }};


        List<String> bookTitles3 = new ArrayList<>();

        List<String> bookTitles4 = new ArrayList<>() {{
            add("Harry Potter és a bölcsek köve");
            add("Harry Potter és a bölcsek köve");
            add(null);
            add("Harry Potter és a Titkok Kamrája");
            add("Harry Potter és az azkabani fogoly");
        }};

        System.out.println("Number of distinct books: " + countDifferentBooks(bookTitles1));
        System.out.println("Number of distinct books: " + countDifferentBooks(bookTitles2));
        System.out.println("Number of distinct books: " + countDifferentBooks(bookTitles3));
        System.out.println("Number of distinct books: " + countDifferentBooks(bookTitles4));

        //2. Feladat - Ha az első lassan van meg, akkor HÁZI
        // Harry és Ron kiváncsi milyen olyan tárgyak vannak amikből mindketten rendelkeznek legalább eggyel.
        // Adtak neked egy egy listát a személyes tárgyaikról
        // írj egy programot ami kiprinteli hogy milyen tárgyak azok amivel mindketten rendelkeznek.
        // Egy embernek lehet a listában többször szerepel egy tárgy de nekünk csak 1-szer kell kiírni
        List<String> harrysItems = new ArrayList<>() {{
            add("Varázspálca");
            add("Láthatatlanná tévő köpeny");
            add("Mindenízű Drazsé");
            add("Nimbus 2000");

        }};

        List<String> ronsItems = new ArrayList<>() {{
            add("Varázspálca");
            add("Varázslósakk");
            add("Mindenízű Drazsé");
            add("Mindenízű Drazsé");
            add("Mindenízű Drazsé");
        }};

        checkCommonItems(harrysItems, ronsItems);

        //3. Feladat
        //Szánoljuk meg, melyik karakter hányszor szerepel egy adott Stringben.
        //Térjünk vissza egy Array-el, ahol az adott karakter ASCII értékének megfelelő indexen az látszik,
        //hogy hányszor szerepelt az adott karakter a szövegben.
        //
        //Példa: Ha a bemenő String: "a" akkor visszatérünk egy array-el, aminek minden indexén 0 szerepel, kivéve
        //a 97-es indexet, ahol 1 található.
        //A printCharacterOccurrence function kiírja, hogy melyik karakterből hány darab van.
        //Csak azokat a mezőket írja ki, ahol az előfordulás több mint 0!
        String wordForOccurrenceCounting = "ABBAz Edda aCdC!";
        int[] arrayWithOccurrences = characterOccurrenceArray(wordForOccurrenceCounting);

        arrayPrintCharacterOccurrence(arrayWithOccurrences);

        //4. Feladat
        //Írjuk meg a 3. feladatot HashMap használatával!
        Map<Integer, Integer> mapWithOccurrences = characterOccurrenceMap(wordForOccurrenceCounting);

        mapPrintCharacterOccurrence(mapWithOccurrences);


        //HÁZI Feladat:
        //Egy videójátékban a hős lovag egy nagy csata után egy String Array-be gyűjti össze válogatás nélkül
        //az eldobált dolgokat. A mi feladatunk ezeket valahogy a táskájában tárolni.
        //A cél, hogy bármikor gyorsan meg lehessen mondani, hogy egy adott tárgyból hány darabbal rendelkezik a lovag.

        String[] items = new String[]{
                "kard", "pajzs", "arany", "arany", "arany", "arany", "arany", "arany", "pajzs", "goblin koponya",
                "arany", "arany", "arany", "pajzs", "pajzs", "kopjafa", "folyékony jeti", "pajzs", "kard",
                "arany kard", "pallos", "folyadék", "arany", "arany", "arany", "arany", "kard", "kard", "koponya",
                "szendvics", "pajzs", "kard", "arany kard", "kard", "koponya", "arany", "arany", "arany", "arany"
        };

        Map<String, Integer> inventory = sortInventory(items);

        showInventory(inventory);

        //BOOK CLASS DOLGAI:
        Book book1 = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979);
        Book book2 = new Book("The Long Dark Tea-Time of the Soul", "Douglas Adams", 1988);
        Book book3 = new Book("Matilda", "Roald Dahl", 1988);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        //Milyen című könyveket írt Douglas Adams?
        findBooksByAuthor(books, "Douglas Adams");

        //Milyen című könyveink vannak 1979-ből?
        findBooksByYearOfPublication(books, 1979);

        //Mely könyvek jöttek ki ugyanabban az évben, mint az adott könyv?
        findBooksFromSameYear(books, "Matilda");

        //Hány darab könyvünk van egy adott írótól?
        System.out.println(countBooksFromAuthor(books, "Douglas Adams"));
    }

    private static int countBooksFromAuthor(List<Book> books, String author) {
        int counter = 0;
        for (Book book: books) {
            if(book.getAuthor().equals(author)){
                counter++;
            }
        }
        return counter;
    }

    private static void findBooksFromSameYear(List<Book> books, String title) {
        System.out.println("Books from the same year as: " +  title);

        int year = getBooksPublicationYearFromTitle(books, title);

        for (Book book: books) {
            if(book.getYearOfPublication() == year && !book.getTitle().equals(title)){
                System.out.println(book.getTitle());
            }
        }
    }

    private static int getBooksPublicationYearFromTitle(List<Book> books, String title) {
        for (Book book: books) {
            if(book.getTitle().equals(title)){
                return book.getYearOfPublication();
            }
        }
        return -1;
    }

    private static void findBooksByYearOfPublication(List<Book> books, int year) {
        System.out.println("Books written in " +  year + ": ");
        for (Book book: books) {
            if(book.getYearOfPublication() == year){
                System.out.println(book.getTitle());
            }
        }
    }

    private static void findBooksByAuthor(List<Book> books, String author) {
        System.out.println("Books written by " + author + ": ");
        for (Book book: books) {
            if(book.getAuthor().equals(author)){
                System.out.println(book.getTitle());
            }
        }
    }

    private static void showInventory(Map<String, Integer> inventory) {
        for (Map.Entry<String, Integer> entry: inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static Map<String, Integer> sortInventory(String[] items) {
        Map<String, Integer> inventory= new HashMap<>();
        for (String item: items) {
            if(inventory.containsKey(item)){
                inventory.put(item, inventory.get(item) + 1);
            } else {
                inventory.put(item, 1);
            }
        }
        return inventory;
    }

    private static void mapPrintCharacterOccurrence(Map<Integer, Integer> mapWithOccurrences) {
        for (Map.Entry<Integer, Integer> entry: mapWithOccurrences.entrySet()) {
            System.out.println("A(z) " + entry.getKey() + ". karakterből " + entry.getValue() + " darab van.");
        }
    }

    private static Map<Integer, Integer> characterOccurrenceMap(String wordForOccurrenceCounting) {
        Map<Integer, Integer> occurrences = new HashMap<>();

        for (Character c: wordForOccurrenceCounting.toCharArray()) {  //SOKSZOR CASTOLJUK INT-RE C-T. LEHETNE
                                                                        //KÜLÖN VÁLTOZÓBAN
            if(occurrences.containsKey((int) c)){
                occurrences.put((int) c, occurrences.get((int) c) + 1);
            } else {
                occurrences.put((int) c, 1);
            }
        }
        return occurrences;
    }

    private static void arrayPrintCharacterOccurrence(int[] arrayWithOccurrences) {
        for (int i = 0; i < arrayWithOccurrences.length; i++) {
            if(arrayWithOccurrences[i] > 0){
                System.out.println("A(z) " + i + ". karakterből " + arrayWithOccurrences[i] + " darab van.");
            }
        }
    }

    private static int[] characterOccurrenceArray(String wordToArray) {
        int[] occurrenceArray = new int[127];
        for (Character c: wordToArray.toCharArray()) {
            occurrenceArray[(int) c]++;
        }

        return occurrenceArray;
    }

    private static void checkCommonItems(List<String> harrysItems, List<String> ronsItems) {
        Set<String> commonItems = new HashSet<>();

        commonItems.addAll(harrysItems);

        commonItems.addAll(ronsItems);

        harrysItems.removeAll(ronsItems); //FIGYELJÜNK, HOGY A KÜLSŐ LISTET IS VÁLTOZTATJA, LEHET SZEBB KÜLÖN LISTÁBA
        //TENNI ÉS OTT REMOVEOLNI

        commonItems.removeAll(harrysItems);

        ronsItems.removeAll(harrysItems);

        commonItems.addAll(ronsItems);

        for (String item : commonItems) {
            System.out.println(item);
        }
    }

    private static int countDifferentBooks(List<String> bookTitles) {
        //return (int) bookTitles.stream().distinct().count();

        int counter = 0;
        List<String> countedBook = new ArrayList<>();
        for (String title : bookTitles) {
            if (/*title != null && */!countedBook.contains(title)) { // KÜLÖN NÉZZÜK MEG A NULL ESETÉN MI LEGYEN
                counter++;
                countedBook.add(title);
            }
        }
        return counter;
    }
}