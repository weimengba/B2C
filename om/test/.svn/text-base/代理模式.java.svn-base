import java.util.Date;

public class 代理模式 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Target target = new Proxy(new Target());

		// log.
		target.buyTicket();
	}

}

class Target {
	public int buyTicket() {
		System.out.println("BuyTicket !");
		return 100;
	}
}

class Proxy extends Target {
	Target target;

	public Proxy(Target target) {
		this.target = target;
	}

	public int buyTicket() {
		int money = 0;
		try {
			// startTraction();
			System.out.println("买票"+new Date());
			money = target.buyTicket();

			money = (int) (money * 0.8);
			// commit;
		} catch (Exception ex) {
			// rollback
		} finally {
			// connection.close;
		}
		return money;
	}
}