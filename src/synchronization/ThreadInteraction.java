package synchronization;

public class ThreadInteraction {

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer("abc");
		ThreadInteraction threadI = new ThreadInteraction();
		ThreadSample t = threadI.new ThreadSample(sb);
		t.start();

		System.out.println(sb.toString());

		synchronized (sb) {
			System.out.println("Waiting for b to complete...");
			try {
				System.out.println(sb.toString());
				sb.wait();
				sb.append("ghi");
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		System.out.println(sb.toString());
	}

	class ThreadSample extends Thread {
		StringBuffer sb;

		public ThreadSample(StringBuffer sb) {
			this.sb = sb;
		}

		public void run() {
			System.out.println("thread started ");
			synchronized (sb) {
				for (int i = 0; i < 100; i++) {
					System.out.println(Thread.currentThread().getName() + " " + sb.toString());
				}
				sb.append("def");
				sb.notify();
			}

		}
	}

}
