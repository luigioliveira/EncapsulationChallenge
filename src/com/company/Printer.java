package com.company;

public class Printer {
    private double tonerLevel;
    private double numberOfPagesPrinted;
    private double spoolStorage;
    private boolean duplexPrintingCapability;

    public Printer(double tonerLevel, boolean duplexPrintingCapability) {
        if (tonerLevel >= 0 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        } else {
            System.out.println("Invalid toner level. Code (-1)");
            this.tonerLevel = -1;
        }

        this.numberOfPagesPrinted = 0;
        this.spoolStorage = 0;
        this.duplexPrintingCapability = true;
    }

    public void fillToner(double inkAmount) {
        // case 1 : increment total toner.
        // case 2 : if tonerLevel is >100 -> keep 100.
        tonerLevel += inkAmount;
        if (tonerLevel > 100) tonerLevel = 100; // set max ink (%) to toner - 100%.
    }

    public void printPage(int pages, double sizeFile, String documentName, boolean isDuplexPrint) {
        // Code fix: duplex printing = 1 paper.
        // Case 1: printer prints documents. [ok]


        if (tonerLevel > pages) { // each 1 page = (equivalent) 1% toner

                    spoolStorage = sizeFile;
                    System.out.println("Printing doc: " + documentName);

                    // Internal Case A: Document is printing front and back, and printer has duplex printing capabilites.
                        if ((isDuplexPrint && duplexPrintingCapability)) {
                    System.out.println("Duplex print send!");
                        } else if ((isDuplexPrint) && !duplexPrintingCapability) { // Internal case B: Document is printing front and back and printer DOESN'T HAVE duplex printing capabilites.
                    System.out.println("Sorry, the printer is not duplex.");
                        } // Internal Case C : printing is not duplex - no action need.

                    if (isDuplexPrint && duplexPrintingCapability) {
                    numberOfPagesPrinted += ((pages / 2) + (pages % 2));
                    } else {
                        numberOfPagesPrinted += pages;
                    }

                    tonerLevel -= pages; // waste ink.
                    System.out.println("Beep! Done."); // Job completed.

        } else { //Case 2 : Printer hasn't sufficient toner to print.
            System.out.println("Insufficient toner to print document.");
        }
   }

    public double getSpoolStorage() {
       return spoolStorage;
    }

    public double getTonerLevel() {
        return tonerLevel;
    }

    public double getNumberOfPagesPrinted() {
        return numberOfPagesPrinted;
    }

    public boolean isDuplexPrintingCapability() {
        return duplexPrintingCapability;
    }

    public void setDuplexPrintingCapability(boolean duplexPrintingCapability) {
        this.duplexPrintingCapability = duplexPrintingCapability;
    }

    public void setTonerLevel(double tonerLevel) {
        this.tonerLevel = tonerLevel;
    }
}
