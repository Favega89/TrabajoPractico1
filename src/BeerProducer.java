import static java.lang.Thread.sleep;

/**
 * Created by Yo on 19/3/2018.
 */
public class BeerProducer implements ISeller,Runnable{

    private String name;
    private Beer product;
    private BeerHouse client;
    private int productionTime;
    private int selledBeersNumber;

    public BeerProducer(String name, BeerHouse client, int productionTime) {
        this.name = name;
        this.product = new Beer();
        this.client = client;
        this.productionTime = productionTime;
        this.selledBeersNumber = 0;
    }

    @Override
    public Beer sellBeer(){
        this.selledBeersNumber ++;
        return new Beer();
    }

    @Override
    public void run() {
        while(true){
            client.buyBeer(this.sellBeer(),this.name);
            try {
                sleep(this.productionTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
