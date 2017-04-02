
public class 组合模式 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Menu m1 = new Menu();
		m1.setId("0");
		m1.setLevel(0);
		m1.setName("rootMenu");
		m1.setParentMenu(null);
		
	}

}

class Menu{
	String id;
	String name;
	int level;
	Menu parentMenu;
	
	
	
	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", level=" + level
				+ ", parentMenu=" + parentMenu + "]";
	}
	public Menu() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Menu getParentMenu() {
		return parentMenu;
	}
	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}	
}