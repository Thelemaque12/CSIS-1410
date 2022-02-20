package phones;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Testing class – describes 
 * the efficiency of the code, 
 * and allows us to find errors.
 * 
 * @author Jefson S
 */
public class TestClient {

	public static void main(String[] args) {
		RotaryPhone rotaryPhone = new RotaryPhone("Model 500", new Dimension(143, 208, 119), Voltage.V110);
	    PushButtonPhone pushButtonPhone = new PushButtonPhone("Cortelco 2500",new Dimension(178, 228, 127), Voltage.DUAL);
	    SmartPhone smartPhone1 = new SmartPhone("Pixel3",new Dimension(145.6, 68.2, 7.9), 128);
	    SmartPhone smartPhone2 = new SmartPhone("iPhone8",new Dimension(138.4, 67.3, 7.3), 64);
	    
	    System.out.println("Various Phones:");
	    
	    System.out.println(rotaryPhone);
	    System.out.println(pushButtonPhone);
	    System.out.println(smartPhone1);
	    System.out.println(smartPhone2);
	    
	    System.out.println();
	    rotaryPhone.plugIn();
	    pushButtonPhone.plugIn();

	    System.out.println();
	    
	    rotaryPhone.plugIn();
	    pushButtonPhone.plugIn();
	    
	    List<DeskPhone> list = new ArrayList<>();
	    list.add(rotaryPhone);
	    list.add(pushButtonPhone);
	    Random rand = new Random();
	    list.get(rand.nextInt(list.size())).unplug();

	    Phone[] phoneArr = {rotaryPhone, pushButtonPhone, smartPhone1, smartPhone2};
	    System.out.println("Array Elements:");
	    
	    for(Phone el: phoneArr) {
	    	System.out.println(el);
	    	System.out.println(el.call(8019574111L));
	    	
	    	if(el instanceof SmartPhone) {
	    		System.out.println(((SmartPhone) el).browse());
	            System.out.println(((SmartPhone) el).takePicture());
	    	}
	    	System.out.println();
	    }

	}

	
}
