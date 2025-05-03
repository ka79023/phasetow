
package phasetwo;

import java.io.File;
import java.util.Scanner;

public class BookStore {
    static Scanner input = new Scanner(System.in);
    static Library library = new Library("Sama Library", 1);

    public static void main(String[] args) {
        File f1 = new File("books.dat");
        File f2 = new File("members.dat");

        if (f1.exists() && f2.exists()) {
            library.loadInfo(); // تحميل البيانات
        } else {
            System.out.println("new information will be added to system");

            Book b1 = new Fiction("Fiction Book 1", "Author A", false, "Fantasy World");
            Book b2 = new Novel("Novel Book 1", "Author B", false, "Historical World");
            Book b3 = new Romantic("Romantic Book 1", "Author C", false, true);

            library.addBook(b1);
            library.addBook(b2);
            library.addBook(b3);
        }

        int choice;
        do {
            System.out.println("\n***** Menu *****");
            System.out.println("1- Register Member");
            System.out.println("2- Borrow Book");
            System.out.println("3- Return Book");
            System.out.println("4- List Available Books");
            System.out.println("5- View All Members");
            System.out.println("6- View All Books");
            System.out.println("7- Exit");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter member name: ");
                    String name = input.nextLine();
                    System.out.print("Enter member ID: ");
                    int id = input.nextInt();
                    input.nextLine();
                    Member m = new Member(name, id,3);
                    library.registerMember(m);
                    break;

                case 2:
                    System.out.print("Enter member ID: ");
                    int borrowID = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter book title: ");
                    String borrowTitle = input.nextLine();
                    library.borrowBook(borrowID, borrowTitle);
                    break;

                case 3:
                    System.out.print("Enter member ID: ");
                    int returnID = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter book title: ");
                    String returnTitle = input.nextLine();
                    library.returnBook(returnID, returnTitle);
                    break;

                case 4:
                    System.out.println(library.listAvailableBooks());
                    break;

                case 5:
                    library.displayAllMembers(); // تأكد أن هذه موجودة
                    break;

                case 6:
                    library.displayAllBooks(); // تأكد أن هذه موجودة
                    break;

                case 7:
                    System.out.println("***** Good bye *****");
                    break;

                default:
                    System.out.println("invalid input");
            }
        } while (choice != 7);

        library.saveInfo(); // حفظ قبل الخروج
    }
}
