package abstractClass;

/**
 * Displays information about the printers, 
 * and demonstrates how the cartridge/toner 
 * change as the printers print and refill.
 * 
 * @author Jefson S
 */
public class PrinterApp {

	public static void main(String[] args) {

		InkjetPrinter Inkjet = new InkjetPrinter("Canon TS202");
		LaserPrinter laser = new LaserPrinter("Samsung Xpress");
		
		
		Printer[] printers = {Inkjet, laser};
		
		for(Printer printer: printers) {
			System.out.println(printer);
			for(int i = 0; i < 11; i++) {
				printer.print();
			}
			System.out.println();	
		}
		

		((InkjetPrinter)Inkjet).refillCartridge();
		((LaserPrinter)laser).refillToner();

	    
	    for(Printer printer: printers) {
	    	if(printer instanceof InkjetPrinter) {
	    		System.out.println("Remaining cartridge after refilling: "+ ((InkjetPrinter)printer).getRemainingCartridge()+"%");
	    	}
	    	
	    	else {
	    		System.out.println("Remaining toner after refilling: " + ((LaserPrinter)printer).getRemainingToner()+"%");
	    	}
	    }

	}

}
