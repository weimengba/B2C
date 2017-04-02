public class 单例测试 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		
		Runtime rc = Runtime.getRuntime();
		
		
		
		
		
		System.out.println(1);
		Thread.sleep(3000);
		System.out.println(2);
		Singleton s1;
		Singleton s2;
		System.out.println(3);
		Thread.sleep(3000);
		System.out.println(4);
		s1 = Singleton.getInstance();
		System.out.println(5);
		s2 = Singleton.getInstance();
	}

}

class Singleton {
	{
		System.out.println("Singleton静态初始化！");			
	}
	
	private static class LazyHolder {
		{
			System.out.println("LazyHolder静态初始化！");			
		}
		private static final Singleton INSTANCE = new Singleton();
	}

	private Singleton() {
		System.out.println("单例实例化！");
	}

	public static final Singleton getInstance() {
		return LazyHolder.INSTANCE;
	}
}