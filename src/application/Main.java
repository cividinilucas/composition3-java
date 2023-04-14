package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enumer.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Email: ");
        String email = input.next();
        System.out.println("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(input.next());

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(input.next());

        Order order = new Order(new Date(), status, client);


        System.out.println("How many items to this order: ");
        int n = input.nextInt();

        for(int i = 0; i < n; i++){
            System.out.println("Enter #" + (i+1) + " item data: ");
            System.out.println("Product name: ");
            input.nextLine();
            String productName = input.nextLine();
            System.out.println("Enter product price: ");
            double productPrice = input.nextDouble();
            System.out.println("Enter quantity: ");
            int quantity = input.nextInt();

            /* Intanciacoes */

            Product product = new Product(productName, productPrice);

            OrderItem it = new OrderItem(quantity, productPrice, product);

            order.addItem(it);

        }
        System.out.println(order);




    }
}