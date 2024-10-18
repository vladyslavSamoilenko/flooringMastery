package com.samoilenko.project.controller.imp;

import com.samoilenko.project.controller.Controller;
import com.samoilenko.project.dao.impl.OrderDaoImpl;
import com.samoilenko.project.model.Order;
import com.samoilenko.project.model.Product;
import com.samoilenko.project.model.Tax;
import com.samoilenko.project.service.impl.FlooringOrderService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainController implements Controller {
    private OrderController orderController;
    private ProductsController productsController;
    private FlooringOrderService service;
    private Order model;
    private OrderDaoImpl orderDao;

    public MainController(OrderController orderController, ProductsController productsController, FlooringOrderService service, OrderDaoImpl orderDao) {
        this.orderController = orderController;
        this.productsController = productsController;
        this.service = service;
        this.orderDao = orderDao;
    }

    public void start() {
        boolean isRun = true;
        while (isRun) {
            showDisplay();

            Scanner scanner = new Scanner(System.in);
            int choise = scanner.nextInt();

            if (choise == 1){
                displayOrders();
            }
            else if (choise == 2) {
                addAnOrder();
            }
            else if (choise == 3) {
                editAnOrder();
            }
            else if(choise == 4){
                removeAnOrder();
            }
            else if (choise == 5) {
                exportAllData();
            }
            else if (choise == 6) {
                quit();
            }
            else {
                System.out.println("Unknown choise");
            }
        }

    }

    private void exportAllData() {
        List<Order> allOrders = orderDao.getAllOrders();
        // Logic to export data, e.g., write to a file
        for (Order order : allOrders) {
            System.out.println(order); // Example output
        }
    }

    public void displayOrders () {
        orderController.displayeOrders();
    }

    public void addAnOrder() {
        int orderNumber = inputOrderNumber();
        String customerName = clientName();
        String orderDate = orderDate();
        Tax tax = chooseTheState();
        String state = tax.getStateName();
        BigDecimal taxRate = tax.getTaxRate();
        Product product = chooseTheProduct();
        String productType = product.getProductType();
        BigDecimal area = inputArea();
        BigDecimal laborCostPerSquareFoot = product.getLaborCostPerSquareRoot();
        BigDecimal costPerSquareFoot = product.getCostPerSquareFoot();


        // Create the Order object
        model = new Order(orderNumber, customerName, state, taxRate, productType,
                area, costPerSquareFoot, laborCostPerSquareFoot, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, orderDate());

        // Inject the created order into FlooringOrderService
        service = new FlooringOrderService(model, tax);

        // Now you can calculate the costs using the service
        BigDecimal materialCost = service.materialCost();
        BigDecimal laborCost = service.laborCost();
        BigDecimal mainTax = service.tax(tax);
        BigDecimal total = service.calculateTotalCost();

        // Set calculated values in the order
        model.setMaterialCost(materialCost);
        model.setLaborCost(laborCost);
        model.setTax(mainTax);
        model.setTotal(total);

        // Add the order using the controller
        orderController.addOrder(model);
    }

    private int inputOrderNumber() {
        System.out.println("input the order Number: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private Tax chooseTheState() { // service
        Tax mainTax = null;
        while (true) {
            System.out.println("Choose the state from list: ");
            System.out.println("1.Texas \n 2.Washington \n 3.Kentuky \n 4.California");
            Scanner scanner1 = new Scanner(System.in);
            int stateNum = scanner1.nextInt();
            if (stateNum == 1){
                mainTax = new Tax("TX", "Texas", new BigDecimal(4.45));
            } else if (stateNum == 2) {
                mainTax = new Tax("WA", "Washington", new BigDecimal(9.25));
            }else if (stateNum == 3){
                mainTax = new Tax("KY", "Kentucky", new BigDecimal(6.00));
            } else if (stateNum == 4) {
                mainTax = new Tax("CA", "California", new BigDecimal(25.00));
            }else {
                System.out.println("Wrong state");
            }
            return mainTax;
        }
    }

    public String clientName() {
        System.out.print("Input client name: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String orderDate() {
        System.out.println("Fill the fields");

        LocalDate date = LocalDate.now();
        return date.toString();
    }

    public Product chooseTheProduct(){
        System.out.println("Choose the product");
        productsController.display();

        System.out.println("enter the number of product");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        return productsController.getTheProductById(choose);
    }

    public BigDecimal inputArea(){
        System.out.println("Input the area: ");
        Scanner scanner = new Scanner(System.in);
        double area = scanner.nextDouble();
        return new BigDecimal(area);
    }

    public void editAnOrder() {
        showEditMenuDisplay();
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        if (choose == 1){
            System.out.println("Input new customer name: ");
            Scanner scanner1 = new Scanner(System.in);
            String newName = scanner1.nextLine();
            model.setCustomerName(newName);
        }else if(choose == 2){
            Tax newTax  = chooseTheState();
            model.setState(newTax.getStateName());
            model.setTaxRate(newTax.getTaxRate());

        }else if(choose == 3){
            Product newProduct = chooseTheProduct();
            model.setProductType(newProduct.getProductType());
            model.setCostPerSquareFoot(newProduct.getCostPerSquareFoot());
            model.setLaborCostPerSquareFoot(newProduct.getLaborCostPerSquareRoot());
        }
        else if(choose == 4){
            Scanner scanner1 = new Scanner(System.in);
            double newArea = scanner1.nextInt();
            model.setArea(new BigDecimal(newArea));
        }
        else{
            System.out.println("Incorrect choose");
        }

        orderController.setOrder(model);

    }

    public void removeAnOrder() {
        System.out.print("Enter the order number to remove: ");
        Scanner scanner = new Scanner(System.in);
        int orderNumber = scanner.nextInt();
        orderController.deleteOrderById(orderNumber);
    }

    public void quit () {
        System.out.println("Finish");
        System.exit(1);
    }

    public void showDisplay(){
        System.out.println("<<Flooring Program>>");
        System.out.println("1. Display Orders");
        System.out.println("2. Add an Order");
        System.out.println("3. Edit an Order");
        System.out.println("4. Remove an Order");
        System.out.println("5. Export All Data");
        System.out.println("6. Quit");
    }

    public void showEditMenuDisplay(){
        System.out.println("What do you want to change:");
        System.out.println("1. CustomerName");
        System.out.println("2. State");
        System.out.println("3. ProductType");
        System.out.println("4. Area");
    }

    @Override
    public void display() {

    }
}
