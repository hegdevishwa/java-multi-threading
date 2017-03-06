package synchronization;

public class Deadlock {

	public static void main(String[] args) {

		StringBuffer sb1 = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("def");

		System.out.println("Before thread start");
		Runnable runnable1 = () -> {
			for (int i = 0; i < 100; i++) {

				synchronized (sb1) {
					System.out.println(Thread.currentThread().getName() + " has lock on sb1?" + Thread.holdsLock(sb1));
					System.out.println(sb1.toString());
					synchronized (sb2) {
						System.out.println(
								Thread.currentThread().getName() + " has lock on sb2?" + Thread.holdsLock(sb2));
						System.out.println(sb2.toString());
					}
				}

			}

		};

		Runnable runnable2 = () -> {
			for (int i = 0; i < 100; i++) {

				// if in the below code sb2 is synchronized first it'll go into
				// deadlock
				synchronized (sb1) {
					System.out.println(Thread.currentThread().getName() + " has lock on sb1?" + Thread.holdsLock(sb1));
					System.out.println(sb1.toString());
					synchronized (sb2) {
						System.out.println(
								Thread.currentThread().getName() + " has lock on sb2?" + Thread.holdsLock(sb2));
						System.out.println(sb2.toString());
					}
				}

			}

		};

		// We always need thread instances to run the thread. its a thread of
		// execution
		Thread t1 = new Thread(runnable1);
		Thread t2 = new Thread(runnable2);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();

		t2.start();

		System.out.println("After thread start");

	}

}
