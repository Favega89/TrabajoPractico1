import java.util.Stack;

/**
 * Created by Yo on 19/3/2018.
 */
public class BeerHouse implements IBuyier,ISeller {

    private Stack<Beer> stock;
    private Beer product;

    public BeerHouse(Stack<Beer> stock) {
        this.stock = stock;
        product = new Beer();
    }

    @Override
    public synchronized void buyBeer(Beer b,String name) {
        while (fullStock()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        this.addBeer(b,name);
        notifyAll();
    }

    private boolean fullStock(){
        if (this.stock.size() < 100)
            return false;
        return true;
    }

    private void addBeer(Beer beer,String producer){
        // if(this.checkStockCapacity()) {
        this.stock.push(beer);
        System.out.println("Se compro cerveza a " + producer + ". El stock ahora es de " +
                this.stock.size() + ".");
        // }
    }

    @Override
    public synchronized Beer sellBeer() {
        Beer b = new Beer();
        while(!thereIsBeersOnStock()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        b = this.serveBeer();
        notifyAll();
        return b;
    }

    private boolean thereIsBeersOnStock(){
        if(this.stock.size() > 0)
            return true;
        return false;
    }

    private Beer serveBeer(){
        Beer product = null;
      //  if(this.checkStockCapacity2()){
            product = this.stock.pop();
            System.out.println("Se vendio cerveza, el stock ahora es de "
                    + this.stock.size());
      //  }
        return product;
    }
}
