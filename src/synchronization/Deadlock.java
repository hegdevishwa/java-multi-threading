package synchronization;

public class Deadlock {

	public static void main(String[] rgs) {
		String s1 = "abc";
		String s2 = "def";

		Runnable r1 = () -> {
			synchronized (s1) {

				System.out.println("T1 Synchronized s1");

				synchronized (s2) {
					System.out.println("T1 Synchronized s1");
				}
			}
		};

		Runnable r2 = () -> {
			synchronized (s2) {

				System.out.println("T2 Synchronized s2");

				synchronized (s1) {
					System.out.println("T2 Synchronized s1");
				}
			}
		};

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();

	}

}
