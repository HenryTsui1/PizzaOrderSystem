import java.io.Serializable;

public class Pizza implements Serializable {

	private static final long serialVersionUID = 5446910998350454432L;
	
	private String size;
	private String cheese;
	private String pineapple;
	private String greenpepper;
	private String ham;
	
	/**
	 * 5 parameter Constructor
	 * @param size Size of the Pizza
	 * @param cheese Number of cheese on the Pizza
	 * @param pineapple Pineapple or no pineapple on the Pizza
	 * @param greenpepper Green pepper or no green pepper on the Pizza
	 * @param ham Ham or no ham on the pizza
	 * @throws IllegalPizza if arguments are illegal
	 */
	public Pizza(String size, String cheese, String pineapple, String greenpepper, String ham) throws IllegalPizza {
		setSize(size);
		setCheese(cheese);
		setHam(ham);
		setPineapple(pineapple);
		setGreenPepper(greenpepper);
	} //end constructor Pizza
	
	//Second Constructor for a default pizza
	public Pizza() {
		size = "small";
		cheese = "single";
		pineapple = "none";
		greenpepper ="none";
		ham = "single";
	}//Second Constructor
	
	/**
	 * @param size of pizza
	 * @throws IllegalPizza if the size is not either small, medium or large
	 */
	public void setSize(String size) throws IllegalPizza {
		//if(size == "small" || size == "medium" || size == "large")
		if (size == null || size.matches("")) throw new IllegalPizza("Illegal Pizza: " + size);
		else if(!size.matches("small|Small") && !size.matches("medium|Medium") && !size.matches("large|Large"))	
			throw new IllegalPizza("Illegal size: " + size);
		this.size = size;	
	} //end setSize
	
	/**
	 * @param cheese number of cheese on the pizza
	 * @throws IllegalPizza if the number of cheese is not single, double or triple
	 */
	public void setCheese(String cheese) throws IllegalPizza {
		if(cheese == null || cheese.matches("")) throw new IllegalPizza("Illegal cheese");
		else if (!cheese.matches("single|Single") && !cheese.matches("double|Double") && !cheese.matches("triple|Triple"))
			throw new IllegalPizza("Illegal cheese: " + cheese);
		this.cheese = cheese;
	}//end setCheese
	
	/**
	 * @param ham Ham or no ham on the pizza
	 * @throws IllegalPizza if ham is neither single or none
	 */
	
	public void setHam(String ham) throws IllegalPizza {
		if(ham == null || ham.matches(""))
			throw new IllegalPizza("Illegal ham");
		else if (!ham.matches("none|None") && !ham.matches("single|Single"))
			throw new IllegalPizza("Illegal number of ham: " + ham);
		this.ham = ham;
	}//end setHam
	
	/**
	 * @param pineapple Pineapple or no pineapple on the pizza
	 * @throws IllegalPizza when Pineapple is not none or single or there is no ham
	 */
	public void setPineapple(String pineapple) throws IllegalPizza {
	
		if((pineapple == null) || pineapple.matches(""))
			throw new IllegalPizza("Illegal pizza");
		else if (pineapple.matches("single|Single") && ham.matches("none|None"))
			throw new IllegalPizza("Illegal pizza");
		else if(!pineapple.matches("none|None") && !pineapple.matches("single|Single")) 
			throw new IllegalPizza("Illegal number of pineapple " + pineapple);
		this.pineapple = pineapple;
		
	}//end setPineapple
	
	/**
	 * @param greenpepper
	 * @throws IllegalPizza
	 */
	public void setGreenPepper(String greenpepper) throws IllegalPizza {
		if((greenpepper == null) || greenpepper.matches("") || (greenpepper.matches("single|Single") && ham.matches("none|None")))
			throw new IllegalPizza("Illegal pizza");
		else if(!greenpepper.matches("none|None") && !greenpepper.matches("single|Single")) 
			throw new IllegalPizza("Illegal number of pineapple " + greenpepper);
		this.greenpepper = greenpepper;
		
	}//end setGreenPepper
	
	/**
	 * @return cost of the Pizza
	 */
	public double getCost() {
		double cost = 0d;
		double subcost = 0d;
		
		if(size.matches("small|Single")) cost += 7d;
		else if(size.matches("medium|Medium")) cost += 9d;
		else cost += 11d;
		
		if(pineapple.matches("single|Single")) subcost += 1.5d;
		
		if(ham.matches("single|Single")) subcost += 1.5d;

		if(greenpepper.matches("single|Single")) subcost += 1.5d;

		if(cheese.matches("double|Double")) subcost += 1.5d;
		
		else if(cheese.matches("triple|Triple")) subcost += 3d;
		
		return cost + subcost;	
	}//end getCost
	
	@Override
	/**
	 * @returns the string output of the order of the pizza
	 */
	public String toString() {
	    	String output = "";
	    	String s = "";
	    	String c = "";
	    	String pa = "";
	    	String gp = "";
	    	String h = "";
	   
	    	if(size.matches("small|Single")) {
	    		s += ("small pizza");}
	    	
	    	else if(size.matches("medium|Medium")) s += ("medium pizza");
	    	else s += ("large pizza");
	   
	    	if(cheese.matches("single|Single")) c += (", single cheese");
	    	else if(cheese.matches("double|Double")) c += (", double cheese");
	    	else c += (", triple cheese");
	    	
	    	if(ham.matches("single|Single")) h += (", ham");
	    	if(pineapple.matches("single|Single")) pa += (", pineapple");
	      
	       	if(greenpepper.matches("single|Single"))  gp += (", green pepper");
	    	
	    	String cost = String.format(" Cost: $%.2f", getCost());

	    	output = s + c + pa + gp + h + "." + cost + " each.";

	    	return output;
	    } //end of toString
	
	@Override
	public boolean equals(Object otherObject) {
		if (otherObject instanceof Pizza) {
			Pizza otherPizza = (Pizza) otherObject;
			return this.toString().matches(otherPizza.toString());
		}
		return false;
	}
	
	@Override
	/**
	 * Clone of pizza object
	 * @return clone
	 */
	public Pizza clone() {
		Pizza copy = null;
		try {
			copy = new Pizza(size, cheese, pineapple, greenpepper, ham);
		} catch (IllegalPizza e) {
			return null; //should not reach here
		} 
		return copy;
	}
	
} //end of class Pizza


