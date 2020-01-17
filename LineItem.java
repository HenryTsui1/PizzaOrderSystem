import java.io.Serializable;

public class LineItem implements Comparable<LineItem>, Serializable {
	
	private static final long serialVersionUID = -7246389778796085677L;

	public int numPizza;
	private Pizza pizza;
	
	/**
	 * @param numPizza Number of pizza
	 * @param pizza Pizza object with it's attributes
	 * @throws IllegalPizza if arguments are illegal
	 */
	public LineItem(int numPizza, final Pizza pizza) throws IllegalPizza {
		if (pizza == null) throw new IllegalPizza("Illegal pizza");
		this.pizza = pizza;
		setNumber(numPizza);
	}
		
	/**
	 * @param pizza Contains the pizza object
	 * @throws IllegalPizza if pizza object is null, throws the exception
	 */
	public LineItem(final Pizza pizza) throws IllegalPizza{
		if(pizza == null) throw new IllegalPizza("Illegal pizza");
		this.pizza = pizza;
		setNumber(1);
	}
	
	/**
	 * @param numPizza number of pizza orders
	 * @throws IllegalPizza if number of pizza is less than 1 or bigger than 100, throws the exception
	 */
	public void setNumber(int numPizza) throws IllegalPizza {
		if(numPizza < 1 || numPizza > 100) {
			throw new IllegalPizza("Illegal number of pizza: " + pizza);
		}
		this.numPizza = numPizza;
	}
	
	/**
	 * @return number of pizza
	 */
	public int getNumber() {
		return numPizza;
	}
	
	/**
	 * @return pizza
	 */
	public Pizza getPizza() {
		return pizza;
	}

	/**
	 * @return the discount of the pizza, if num of pizza is between 10-20, discount off 10%.  If num of pizza > 20, discount off 20%
	 */
	public double getCost() {
		double cost;
		cost = (pizza.getCost()*numPizza);
		if(numPizza > 9 && numPizza < 21) {
			cost *= 0.90d;
		}
		else if(numPizza > 20) {
			cost *= 0.85d;
		}
		return cost;
	}

	/**
	 * @return if number of pizza is less than 10 lines up so that order is displayed
	 */
	public String toString() {
		String order;
		if (numPizza < 10) {
			order =  " " + numPizza + " " + this.pizza.toString();
		}
		else {
			order = numPizza + " " + this.pizza.toString();
		}
		return order;
}
	
	@Override
	/**
	 * @return compares and rearranges pizza from highest cost to lowest cost
	 */
	public int compareTo(LineItem object) {
		if ((this.getCost() > object.getCost())) {
			return -1;
		}
		else if((this.getCost() < object.getCost())) {
			return 1;
		}
		else if((this.getCost() - object.getCost()) < 1) {
			return 0;
		}
		return -1;
	}
	
	} //end of LineItem


