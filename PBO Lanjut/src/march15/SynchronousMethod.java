package march15;

public class SynchronousMethod extends Thread{
	public SynchronousMethod(String name) {
		super(name);
	}
	public static synchronized void print(String name) {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name + " run " + i + " time");
		}
	}
	public void run() {
		print(getName());
	}
	public static void main(String[] args) {
		Thread honda = new Thread(new SynchronousMethod("Honda"));
		Thread toyota = new Thread(new SynchronousMethod("Toyota"));
		honda.start();
		toyota.start();
	}
	
}
