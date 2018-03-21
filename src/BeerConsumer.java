import java.util.Random;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Thread.sleep;

/**
 * Created by Yo on 19/3/2018.
 */
public class BeerConsumer implements IBuyier, Runnable {

    private String name;
    private BeerHouse bar;
    private int drikedBeers;
    private int timeToDrink;
    private AtomicBoolean running = new AtomicBoolean(true);

    public BeerConsumer(String name, BeerHouse bar,int max , int min) {
        this.name = name;
        this.bar = bar;
        this.drikedBeers = drikedBeers;
        this.timeToDrink = this.aleatorio(min,max);
    }

    private int aleatorio(int min,int max){
        Random r = new Random();
        int result = r.nextInt(max-min) + min;
        return result;
    }

    @Override
    public void run() {
        while (this.running.get()) {
            this.buyBeer(bar.sellBeer(), name);
            try {
                sleep(timeToDrink);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void buyBeer(Beer b, String n) {
        if(!b.isAnEmptyGlass()) {
            this.drikedBeers++;
            System.out.println("El borrachin " + n + " ya se chupo " + this.drikedBeers + " birras");
            System.out.println(" ");
        }else {
            this.running.set(false);
        }
    }
}
