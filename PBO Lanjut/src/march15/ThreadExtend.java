package march15;

public class ThreadExtend extends Thread{
	
	public ThreadExtend(String name) {
		super(name);
	}
	
	public void run() {
		for(int i=0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread " + getName() + " at " + i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadExtend vespa = new ThreadExtend("Vespa");
		ThreadExtend onthel = new ThreadExtend("Onthel");
		
		vespa.start();
		onthel.start();
		
		for(int i = 0;i<10;i++) {
			System.out.println("Synchronous running " + i + " time");
		}
	}

}
