package entity;

public class ArticleEntity extends BaseEntity {
	private String name;
	private double weight;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * @param d the weight to set
	 */
	public void setWeight(double d) {
		this.weight = d;
	}
	

}
