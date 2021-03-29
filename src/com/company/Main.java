package com.company;

public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer(-1, true);

        // case 1 - fill ink with 10 - see results.
        // case 2 - fill ink with 60 - see 100 on results.
        // case 3 - Printer is duplex w/ toner - send duplex file.
        // case 4 - Printer is NOT-duplex w/ toner - send duplex file.
        // case 5 - set toner = 0 -> without/ toner - send file.
        // case 6 - Show printed pages.


        printer.fillToner(10); //C1
        System.out.println("toner level: " + printer.getTonerLevel());

        printer.fillToner(60); //C2
        System.out.println("toner level: " + printer.getTonerLevel());

        printer.printPage(7, 480, "Document1.txt", true); //C3

        printer.setDuplexPrintingCapability(false); //C4
        printer.printPage(6, 60, "Document2.txt", true);

        printer.setTonerLevel(0); //C5
        printer.printPage(50, 3500, "Document3.txt", true);

        System.out.println("Total printed pages: " + printer.getNumberOfPagesPrinted()); //C6



    }
}
