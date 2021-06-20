package entity;

public class ProductsEntity extends BaseEntity{
	
	private int idProducts;
	private String name;
	private int idAdministrators;
	private String type;
	
	/**
	 * @return the idProducts
	 */
	public int getIdProducts() {
		return idProducts;
	}
	/**
	 * @param idProducts the idProducts to set
	 */
	public void setIdProducts(int idProducts) {
		this.idProducts = idProducts;
	}
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
	 * @return the idAdministrators
	 */
	public int getIdAdministrators() {
		return idAdministrators;
	}
	/**
	 * @param idAdministrators the idAdministrators to set
	 */
	public void setIdAdministrators(int idAdministrators) {
		this.idAdministrators = idAdministrators;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
}
