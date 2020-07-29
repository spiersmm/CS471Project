import java.util.Scanner;


public class ProducerConsumerPatrons {
	
		public static void main(String[] args) {
			
			Scanner scnr = new Scanner(System.in);
			Boolean flag = true;
			while (flag) {
				try {	
					System.out.println("Enter only a postive integer for each prompt as it appears below");
					System.out.print("Enter the desired # of producer threads: ");
					String numProducers = scnr.nextLine();
					System.out.print("Enter the desired # of consumer threads: ");
					String numConsumers = scnr.nextLine();
					System.out.print("Enter the desired sleep time: ");
					String sleepTime = scnr.nextLine();
					if (Integer.parseInt(numProducers) > 0) {
					
						if (Integer.parseInt(numConsumers) > 0) {
							
							if (Integer.parseInt(sleepTime) > 0) {
								
								flag = false;
								System.out.println();
							
							}
						
						}
						
					}
					else {
						System.out.println("Enter only a postive integer for each prompt");
					}
					
				}
				catch (Exception e) {
					System.out.println("Enter only a postive integer for each prompt");
				}
				
				finally {
					System.out.println();
				}
			}
			
			
			
			
			
			scnr.close();
			

			ProducerConsumer itemBank = new ProducerConsumer();

			producer itemProducer = new producer(itemBank);
			
			

			consumer itemConsumer = new consumer(itemBank);
			
			consumer itemConsumer2 = new consumer(itemBank);
			
			consumer itemConsumer3 = new consumer(itemBank);
			
			
			
			
			
			itemProducer.start();
			
			
			

			try {
				Thread.sleep(1);
			}
			catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			
			itemConsumer.start();
			
			try {
				Thread.sleep(1);
			}
			catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			
			itemConsumer2.start();
			
			try {
				Thread.sleep(1);
			}
			catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			
			itemConsumer3.start();


		}
}
