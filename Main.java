import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        LinkedList<String> NameLL = new LinkedList<String>();
        LinkedList<String> NumberLL = new LinkedList<String>();
        LinkedList<String> EmailLL = new LinkedList<String>();
        ListIterator<String> itNameLL = NameLL.listIterator();
        ListIterator<String> itNumberLL = NumberLL.listIterator();
        ListIterator<String> itEmailLL = EmailLL.listIterator();
        String menu, serProperty, search, quit;
        int index = 0, delIndex, serIndex, flag = 0, quitflag = 0;
        Scanner scanner = new Scanner(System.in);
        while (flag == 0) {
            System.out.println("*******************************\n(A)dd\n(D)elete\n(E)mail Search\n(P)rint List\n(S)earch\n(Q)uit\n*******************************\nPlease enter a command:");
            menu = scanner.next();
            switch (menu) {
                case "A":
                    System.out.println("Add an entry");
                    System.out.println("Please enter name.");
                    NameLL.add(scanner.next());
                    System.out.println("Please enter phone number.");
                    NumberLL.add(scanner.next());
                    System.out.println("Please enter email.");
                    EmailLL.add(scanner.next());
                    break;
                case "D":
                    itNameLL = NameLL.listIterator();
                    itNumberLL = NumberLL.listIterator();
                    itEmailLL = EmailLL.listIterator();
                    while (itNameLL.hasNext()) {
                        System.out.println(index + ": " + itNameLL.next() + " | " + itNumberLL.next() + " | " + itEmailLL.next());
                        index++;
                    }
                    index = 0;
                    System.out.println("Enter index to be deleted:");
                    delIndex = scanner.nextInt();
                    if (NameLL.size() - 1 < delIndex) {
                        System.out.println("Index not found.");
                    } else {
                        NameLL.remove(delIndex);
                        NumberLL.remove(delIndex);
                        EmailLL.remove(delIndex);
                        System.out.println("Successfully deleted.");
                    }
                    break;
                case "E":
                    itNameLL = NameLL.listIterator();
                    while (itNameLL.hasNext()) {
                        System.out.println(index + ": " + itNameLL.next());
                        index++;
                    }
                    index = 0;
                    System.out.println("Please enter index to be searched");
                    serIndex = scanner.nextInt();
                    if (NameLL.size() - 1 < serIndex) {
                        System.out.println("Index not found.");
                    } else {
                        System.out.println("Email: " + EmailLL.get(serIndex));
                    }
                    break;
                case "P":
                    itNameLL = NameLL.listIterator();
                    itNumberLL = NumberLL.listIterator();
                    itEmailLL = EmailLL.listIterator();
                    while (itNameLL.hasNext()) {
                        System.out.println(index + ": " + itNameLL.next() + " | " + itNumberLL.next() + " | " + itEmailLL.next());
                        index++;
                    }
                    index = 0;
                    break;
                case "S":
                    System.out.println("(N)ame\n(P)hone Number\n(E)mail\nEnter property to search:");
                    serProperty = scanner.next();
                    switch (serProperty) {
                        case "N":
                            System.out.println("Enter name:");
                            search = scanner.next();
                            if (!NameLL.contains(search)) {
                                System.out.println("Name not found, please try again.");
                            } else {
                                System.out.print(NameLL.get(NameLL.indexOf(search)) + " | " + NumberLL.get(NumberLL.indexOf(search)) + " | " + EmailLL.get(EmailLL.indexOf(search)) + "\n");
                            }
                            break;
                        case "P":
                            System.out.println("Enter phone number:");
                            search = scanner.next();
                            if (!NumberLL.contains(search)) {
                                System.out.println("Phone number not found, please try again.");
                            } else {
                                System.out.print(NameLL.get(NameLL.indexOf(search)) + " | " + NumberLL.get(NumberLL.indexOf(search)) + " | " + EmailLL.get(EmailLL.indexOf(search)) + "\n");
                            }
                            break;
                        case "E":
                            System.out.println("Enter email:");
                            search = scanner.next();
                            if (!EmailLL.contains(search)) {
                                System.out.println("Email not found, please try again.");
                            } else {
                                System.out.print(NameLL.get(NameLL.indexOf(search)) + " | " + NumberLL.get(NumberLL.indexOf(search)) + " | " + EmailLL.get(EmailLL.indexOf(search)) + "\n");
                            }
                            break;
                }
                    break;
                case "Q":
                    while (quitflag == 0) {
                        System.out.println("Are you sure you wanna quit?\n(Y)es\n(N)o");
                        quit = scanner.next();
                        if (Objects.equals(quit, "Y")) {
                            flag = 1;
                            quitflag = 1;
                            scanner.close();
                        } else if (Objects.equals(quit, "N")) {
                            quitflag = 1;
                        } else {
                            System.out.println("Unknown entry, please try again.");
                        }
                    }
                    quitflag = 0;
                    break;
                default:
                    System.out.println("Unknown entry");
                    break;
            }
        }
    }
}
