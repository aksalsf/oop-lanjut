package march15;

public class ThreadInterface implements Runnable{
	
	String name;
	
	public ThreadInterface(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread " + name + " at " + i);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread mobil = new Thread(new ThreadInterface("Mobil"));
		Thread pesawat = new Thread(new ThreadInterface("Pesawat"));
		
		// Priority Range 1 - 10
		mobil.setPriority(1);
		pesawat.setPriority(5);
		
		mobil.start();
		// Mobil run duluan 3000ms
		try {
			mobil.join(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pesawat.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Is Mobil thread active?");
		System.out.println(mobil.isAlive());
	}

}
