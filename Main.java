import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

class UserObject {
    String bookTitle;
    String publicationYear;
    String author;
}

class Main {
    public static void main (String[] args) {
        ArrayList<UserObject> storage = new ArrayList<>();

        int count = 0;
        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book ");
            System.out.println("2. Display Book Details");
            System.out.println("3. List out all books");
            System.out.println("4. Return Book");
            System.out.println("5. Exit \n");


            Scanner myObj = new Scanner(System.in);
            count++;



            System.out.print("Input your choice: ");
            int userInput = myObj.nextInt();
//            System.out.println(userInput);

            if (userInput == 1) {
                System.out.println("ADD BOOK: ");

                try {
                    UserObject addNewBook = new UserObject();
                    System.out.println("-> Enter book title: ");
                    String newBook = myObj.next();
                    addNewBook.bookTitle = newBook;

                    System.out.println("-> Enter publication Year: ");
                    String publicationYear = myObj.next();
                    addNewBook.publicationYear = publicationYear;

                    System.out.println("-> Enter Author: ");
                    String author = myObj.next();
                    addNewBook.author = author;

                    storage.add(addNewBook);







                } catch (Exception e) {
                    throw new RuntimeException(e);
                }



                System.out.println("Book has been registered");
            } else if (userInput == 2) {
                System.out.println("Display book details");
                System.out.println("-> Input the title of the book: ");
                String searchBookTitle = myObj.next();

                for (UserObject user: storage) {
                    if (Objects.equals(user.bookTitle, searchBookTitle)) {
                        int indexNo = storage.indexOf(user);
                        IO.println("Details of searched book");
                        IO.println("Book Title -" + storage.get(indexNo).bookTitle);
                        IO.println("Publication Year -" + storage.get(indexNo).publicationYear);
                        IO.println("Book Author -" + storage.get(indexNo).author);
                    } else {
                        IO.println("Book not Available !!!");
                    }
                }



            } else if (userInput == 3) {
                if (!storage.isEmpty()) {
                    int num = 1;
                    for (UserObject user: storage) {
                        IO.println(num + " " + user.bookTitle);
                        num+=1;
                    }
                } else {
                    IO.println("No registered books");
                }
            } else if (userInput == 4) {
                System.out.println("No borrowed book");
            } else {
                System.out.println("Invalid Input");
            }




        }
        while (count<10);
//        myObj.close();




    }
}