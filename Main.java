package project;

import java.util.Scanner;

class Video {
    String name;
    boolean checkout;
    int rating;

    Video(String name) {
        this.name = name;
        this.checkout = false;
        this.rating = 0;
    }

    String getName() {
        return name;
    }

    void doCheckout() {
        checkout = true;
    }

    void doReturn() {
        checkout = false;
    }

    void receiveRating(int rating) {
        this.rating = rating;
    }

    int getRating() {
        return rating;
    }

    boolean getCheckout() {
        return checkout;
    }
}

class VideoStore {
    Video[] store;

    VideoStore(int size) {
        store = new Video[size];
    }

    void addVideo(String name) {
        for (int i = 0; i < store.length; i++) {
            if (store[i] == null) {
                store[i] = new Video(name);
                return;
            }
        }
    }

    void doCheckout(String name) {
        for (Video video : store) {
            if (video != null && video.getName().equals(name)) {
                video.doCheckout();
                return;
            }
        }
    }

    void doReturn(String name) {
        for (Video video : store) {
            if (video != null && video.getName().equals(name)) {
                video.doReturn();
                return;
            }
        }
    }

    void receiveRating(String name, int rating) {
        for (Video video : store) {
            if (video != null && video.getName().equals(name)) {
                video.receiveRating(rating);
                return;
            }
        }
    }

    void listInventory() {
        for (Video video : store) {
            if (video != null) {
                System.out.println("Name: " + video.getName() + ", Checkout: " + video.getCheckout() + ", Rating: " + video.getRating());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        VideoStore store = new VideoStore(5);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMAIN MENU");
            System.out.println("1. Add Videos:");
            System.out.println("2. Check Out Video:");
            System.out.println("3. Return Video:");
            System.out.println("4. Receive Rating:");
            System.out.println("5. List Inventory:");
            System.out.println("6. Exit:");
            System.out.print("Enter your choice (1..6): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter video name: ");
                    String name = scanner.next();
                    store.addVideo(name);
                    break;
                case 2:
                    System.out.print("Enter video name: ");
                    name = scanner.next();
                    store.doCheckout(name);
                    break;
                case 3:
                    System.out.print("Enter video name: ");
                    name = scanner.next();
                    store.doReturn(name);
                    break;
                case 4:
                    System.out.print("Enter video name: ");
                    name = scanner.next();
                    System.out.print("Enter rating: ");
                    int rating = scanner.nextInt();
                    store.receiveRating(name, rating);
                    break;
                case 5:
                    store.listInventory();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}