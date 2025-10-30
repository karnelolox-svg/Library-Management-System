package org.hogwarts;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        Scanner First_scanner = new Scanner(System.in);

        try (BufferedReader reader = new BufferedReader(new FileReader("library.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length == 3) {
                    String author = parts[0];
                    String title = parts[1];
                    String isbn = parts[2];

                    Book loadedBook = new Book(author, title, isbn);
                    books.add(loadedBook);
                }
            }
            System.out.println("Library was successful loaded: " + books.size());

        } catch (java.io.FileNotFoundException e) {
            System.out.println("File library.txt was not founded");
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }

        boolean IDK = true;
        while (IDK) {
            System.out.println("If you want to add a books(write 'add')\n" +
                    "if you want to check list of a books(write 'list'\n" +
                    "if you want to remove a book(write 'remove' + isbn of a book)\n" +
                    "if you want to find a specific book(write 'find' + Author + Title\n" +
                    "if u want to exit (write 'exit')\n");
            String task = First_scanner.nextLine();
            String[] splitTask = task.split(" ");

            if (splitTask[0].equals("exit")) {

                try {

                    FileWriter writer = new FileWriter("library.txt");


                    for (Book b : books) {

                        writer.write(b.toString() + "\n");

                    }
                    writer.close();


                    System.out.println("The library was successful saved ");
                }catch (IOException e){
                    System.out.println("File was not saved");
                    e.printStackTrace();
                }

                IDK = false;

            } else if (splitTask[0].equals("add")) {

                System.out.println("Write author of the book: ");
                String author = First_scanner.nextLine();

                System.out.println("Write title of the book: ");
                String title = First_scanner.nextLine();

                System.out.println("Write isbn of the book: ");
                String isbn = First_scanner.nextLine();


                Book newbooks = new Book(author, title, isbn);
                addBook(newbooks);
            } else if (splitTask[0].equals("list")) {


                System.out.println(books);

            } else if (splitTask[0].equals("remove")) {


                    String isbn = splitTask[1];

                  removeBook(isbn);

            } else if (splitTask[0].equals("find")) {

                findBook(splitTask[1]);

            }
        }
    }

    public static void removeBook(String ISBNtoRemove){

        Book BooktoRemove = null;
        for(Book b : books){

            String currentISBN = b.getISBN();

            if(currentISBN.equals(ISBNtoRemove)){
                BooktoRemove = b;

                break;
            }
        }

        if(BooktoRemove != null){

            books.remove(BooktoRemove);
            System.out.println("The book was successfully  deleted");
        }else {
            System.out.println("The book with this isbn was not founded");
        }
    }

    public static void findBook(String ISBNtoFind){

        Book BooktoFind = null;
        for(Book b : books){

            String currentISBN = b.getISBN();

            if(currentISBN.equals(ISBNtoFind)){

                BooktoFind = b;
                System.out.println("The book was successfully founded");

                break;
            }
        }


        if(BooktoFind != null){
            System.out.println(BooktoFind);
        }else {
            System.out.println("The book with this isbn was not founded");
        }
    }

    public static void addBook(Book b){

        books.add(b);

    }


}