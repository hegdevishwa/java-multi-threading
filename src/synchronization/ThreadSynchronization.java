package synchronization;

public class ThreadSynchronization extends Thread {

	private StringBuffer sb = new StringBuffer();

	public ThreadSynchronization(StringBuffer sb) {
		this.sb = sb;

	}

	@Override
	public void run() {
		synchronized (sb) {
			System.out.println(Thread.currentThread().getName() + " holds lock? " + Thread.holdsLock(sb));
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + " " + i + " " + sb.toString());
				sb.toString();

			}
			sb.append("xyz");
			System.out.println(Thread.currentThread().getName() + " " + sb.toString());

		}

	}

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("abc");

		ThreadSynchronization t1 = new ThreadSynchronization(sb);
		ThreadSynchronization t2 = new ThreadSynchronization(sb);
		ThreadSynchronization t3 = new ThreadSynchronization(sb);
		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");
		t1.start();
		t2.start();
		t3.start();

	}

}
