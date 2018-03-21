import java.util.Stack;

/**
 * Created by Yo on 19/3/2018.
 */
public class Main {

    public static void main(String[] args) {

        int c = 100;// ACA LA CANTIDAD DEL STOCK INICIAL **************************************************************

        Stack<Beer> beers = new Stack<Beer>();
        for(int i = 0 ; i < c ; i++){
            beers.push(new Beer());
        }

        BeerHouse beerHouse = new BeerHouse(beers);
        Thread beerProducer = new Thread(new BeerProducer("Antores",beerHouse,1000));

        // ACA LA CANTIDAD DE BORRACHINES *****************************************************************************
        int cant = 20;

        Thread[] consumers = new Thread[cant];
        for(int i = 0 ; i < cant ; i ++){
            consumers[i] = new Thread(new BeerConsumer("Borrachin "+ i + "",beerHouse,5000,3000));
            consumers[i].start();
        }
        beerProducer.start();
    }
}
