System.out.println("Welcome to QuickChat.");

boolean running = true;

while (running) {
    System.out.println("\nChoose an option:");
    System.out.println("1) Send Messages");
    System.out.println("2) Show recently sent messages");
    System.out.println("3) Quit");

    int choice = input.nextInt();
    input.nextLine();

    switch (choice) {
        case 1:
            System.out.print("How many messages would you like to send? ");
            int numberOfMessages = input.nextInt();
            input.nextLine();

            for (int i = 1; i <= numberOfMessages; i++) {
                System.out.println("\nMessage " + i);

                System.out.print("Enter recipient cell number: ");
                String recipient = input.nextLine();

                System.out.print("Enter your message: ");
                String messageText = input.nextLine();

                Message message = new Message(i, recipient, messageText);

                System.out.println(message.checkRecipientCell());
                System.out.println(message.checkMessageLength());

                if (!message.checkRecipientCell().equals("Cell phone number successfully captured.")
                        || !message.checkMessageLength().equals("Message ready to send.")) {
                    System.out.println("Message could not be processed.");
                    continue;
                }

                System.out.println("\nWhat would you like to do?");
                System.out.println("1) Send Message");
                System.out.println("2) Disregard Message");
                System.out.println("3) Store Message to send later");

                int sendChoice = input.nextInt();
                input.nextLine();

                System.out.println(message.sentMessage(sendChoice));

                if (sendChoice == 1 || sendChoice == 3) {
                    System.out.println("\n" + message.printMessage());
                }
            }

            System.out.println("Total messages sent: " + Message.returnTotalMessages());
            break;

        case 2:
            System.out.println("Coming Soon.");
            break;

        case 3:
            running = false;
            System.out.println("Goodbye.");
            break;

        default:
            System.out.println("Invalid option. Please try again.");
    }
}
