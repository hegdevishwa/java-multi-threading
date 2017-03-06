
public class RunnableLamda {

	public static void main(String[] args) {

		System.out.println("Before thread start");
		Runnable runnable1 = () -> {
			for (int i = 0; i < 100; i++) {
				if (i % 10 == 0) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread() + " " + i);
			}

		};

		Runnable runnable2 = () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread() + " " + i);
			}

		};

		// We always need thread instances to run the thread. its a thread of
		// execution
		Thread t1 = new Thread(runnable1);
		Thread t2 = new Thread(runnable2);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		try {
			t1.join(); // Its like saying the main thread to join after t1
						// completes (dies)

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("After thread start");
	}

}
