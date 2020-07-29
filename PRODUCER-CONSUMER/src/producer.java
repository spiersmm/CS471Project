import java.util.concurrent.locks.ReentrantLock;

public class producer extends Thread {

	ProducerConsumer items;
	
	int sleepTime = ProducerConsumerPatrons.sleepTime;

	public producer(ProducerConsumer items) {

		this.items = items;

	}
	
	// Establish monitor lock
	ReentrantLock lock = new ReentrantLock();

	public void run(){
		
		// Initial lock
		lock.lock();

		try {
			while(true) {
	
				
	
				
				items.insertItem();
				
				
				/*******************************************/
				/* I had to change my sleep time to longer */
				/* or else my messages got jack up using   */
				/* multiple consumers.                     */
				/*******************************************/
				try {
					Thread.sleep(sleepTime);
				}
				catch(InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		} finally {
			// disable lock
			lock.unlock();
		}
		
	}

}