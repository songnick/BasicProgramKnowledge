public class ThreadTest{
	public static void main(String[] args) {
		final StringBuilder sb = new StringBuilder();
		final StringBuilder st = new StringBuilder();
		final Thread th1 = new Thread(new Runnable(){
			public void run(){
				try{
					synchronized (sb){
						for (; ; ) {
							System.out.println(" wait start: ");
							sb.wait();
							System.out.println(" wait end: " + sb.toString());
						}
					}
					
				}catch (Exception e) { 
					System.out.println(" wait Exception: " + e);
				}
			}
		});

		Thread th2 = new Thread(new Runnable(){
			public void run(){
				try{
					synchronized (sb){
						// for (; ; ) {
							System.out.println(" sleep start: ");
							Thread.sleep(4 * 1000);
							sb.append("I get synchronized");
							sb.notify();
							System.out.println(" sleep end: ");
						// }
						
					}
				}catch (Exception e) {
					System.out.println(" sleep Exception: " + e);
				}
			}
		});
		th1.start();
		th2.start();
		
		
	}


}