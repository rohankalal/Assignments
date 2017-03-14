
public class InterProcess {
int queue;
boolean checkAvailability=false;	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 InterProcess a=new InterProcess();
         Produce p=new Produce(a);
         Consume c=new Consume(a);
         Thread t1=new Thread(p);
         Thread t2=new Thread(c);
         t1.start();
         t2.start();
	}
	public synchronized int get()
	{
		while(checkAvailability == false)
		{
			try{
				wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		checkAvailability = false;
		notifyAll();
		return queue;
	}

	
	public synchronized void put(int value)
	{
		while(checkAvailability == true)
		{
			try{
				wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		queue=value;
		checkAvailability=true;
		notifyAll();
	}
}
class Consume implements Runnable
{
InterProcess cs;

	public Consume(InterProcess cs) {
	super();
	this.cs = cs;
}
    
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++)
		{
			int val= cs.get();
			System.out.println("Consumer got "+ val);
		}
	}
	
}
class Produce implements Runnable
{
InterProcess pr;
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++)
		{
			pr.put(i);
			System.out.println("Prdoucer put " + i);
		}
	}
	public Produce(InterProcess pr) {
		super();
		this.pr = pr;
	}
	
}
