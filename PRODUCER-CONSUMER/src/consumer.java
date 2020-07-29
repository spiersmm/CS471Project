import java.util.concurrent.locks.ReentrantLock;

public class consumer extends Thread{ 
	
	ProducerConsumer items; 
	int sleepTime = ProducerConsumerPatrons.sleepTime;
	
	public consumer(ProducerConsumer items) { 
		
		this.items = items; 
		
	} 
	
	// Establish monitor lock
	ReentrantLock lock = new ReentrantLock();
	
	
	public void run(){
		
		// Initial lock
		lock.lock();
		
		try {
		
			while(true){ 
				
				
				// If food bank is empty, wait until its not
				if(items.items < 0) {
					
					try {
						wait();
					} catch (InterruptedException e) {
						
					}
					System.out.println("Waiting to get items.");
				}
					
				else {
					
					try{
						// If food bank is not empty, get it going
						notify();
					} catch (IllegalMonitorStateException e) {
						
					}
					
					// If there's enough food in the bank to take away the desired amount, do so
					if(items.items >= 1){ 
						
						items.removeItem(); 
						try {
							Thread.sleep(sleepTime); 
						}
						catch(InterruptedException e) {
							Thread.currentThread().interrupt();
						}
					}
					else{ 
						// If there's not enough to take away the desired amount, state the problem
						System.out.println("Not enough items to take an item. Current balance is " + items.items + " items."); 
						try {
							Thread.sleep(sleepTime);
						}
						catch(InterruptedException e) {
							Thread.currentThread().interrupt();
						}
					} 
				}
				
			} 
		} finally {
			// disable lock
			lock.unlock();
		}
	} 
}